package operations;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import views.Window;

/**
 ******************************************************************************
 *							 +------------------+							  *
 *                           | SERIAL INTERFACE |                             *
 *                           +------------------+ 							  *
 ****************************************************************************** 
 * A class that provides an interface to serial port methods.
 * 
 * @author simple-developer
 * @since 28.06.2012
 * 
 * Overview
 * ----------------------------------------------------------------------------
 * This class will act as a sub-controller, accessed by our main controller, 
 * exposing methods and objects from the serial writer and reader objects. 
 * 
 * 
 * Reading
 * ----------------------------------------------------------------------------
 * There will be a reader which will pass messages to the command handler. This
 * reader is using SerialEvent listeners to detect when data arrives in the 
 * serial port.
 * 
 * TODO (In the future this method should be printing to the monitor pane 
 * within the interface and the log file if logging is enabled.) 
 * 
 * 
 * Writing
 * ----------------------------------------------------------------------------
 * The write method runs on a separate thread, which checks the waiting command
 * register inside the CommandHandler for commands. When it detects one, it is 
 * removed from that register and sent to the device.
 * 
 * Usage
 * ----------------------------------------------------------------------------
 * To write:
 * 		serialInterface.write("Example message goes here.");
 * 
 * To read:
 * 		serialInterface.read();
 * 
 ******************************************************************************
 */
public class SerialInterface {
	private static InputStream in;
	private static OutputStream out;
	private static SerialPort serialPort;
	private static CommPort commPort;
	
	//Connect to the port, with the port name passed as a string argument.
	public static void connect(String portName) throws Exception {
		
		System.out.println("Connecting to " + portName);
		Window.writeToMonitor("LOG: Attempting to connect to " + portName);
		
		//Create a port identifier from the port's name.
		CommPortIdentifier portId = CommPortIdentifier.
				getPortIdentifier(portName);
		//If the port is currently in use, flag an error.
		if (portId.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			//Open the port using SerialInterface as the application name.
			commPort = portId.open("SimpleHuawei",2000);
			//Cast the opened Id to a SerialPort object.
			serialPort = (SerialPort) commPort;
			//Port configuration options.
			serialPort.setSerialPortParams(
					115200,						//Baud rate.
					SerialPort.DATABITS_8,		//8 Data bits.
					SerialPort.STOPBITS_1, 		//1 Stop bit.
					SerialPort.PARITY_NONE);	//No parity.

			in = serialPort.getInputStream();
			out = serialPort.getOutputStream();
			
			//Start the writer on a new thread.
			(new Thread(new SerialWriter(out))).start();

			//Add the event listener to the serial port object.
			serialPort.addEventListener(new SerialReader(in));
			serialPort.notifyOnDataAvailable(true);
			
			Application.connected = true;
			Window.writeToMonitor("LOG: Successfully connected to " + portName);
			Application.deviceConfig();
			//Start a status requester.
			(new Thread(new StatusRequester("AT+CSQ;+COPS?", 60000))).start();
		}
	}
	
	public static void close () {
		//Close both streams.
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//Close the serial and communication ports.
		serialPort.close();
		commPort.close();
		
	}
	
	//Write to the serial port.
	public static void write (String message) {
		//Append a carriage return to each command so that it sends.
		CommandHandler.addCommand(message + "\r");
	}
	
	public static void write (char ch) {
		CommandHandler.addCommand(ch);
	}
	
	//Read from the serial port.
	public static String read () {
		return CommandHandler.getResponse();
	}

	/**
	 ******************************************************************************
	 *                                 SerialReader                               *
	 ******************************************************************************/
	public static class SerialReader implements SerialPortEventListener {
		
		//Handles the input coming from the serial port. A new line character is
		//treated as the end of a block in this example.
		@SuppressWarnings("unused")
		private byte[] buffer = new byte[1024];
		private InputStream in;
		
		public SerialReader(InputStream in) {
			this.in = in;
		}

		public void serialEvent(SerialPortEvent arg0) {
			
			byte[] buffer = new byte[1024];	//Hold port data in buffer
			int len = -1;					//Number of bytes read
			String responseStr = "";		//String to hold response
			
			System.out.println("Serial Event!");
			
			try {
				//While there are bytes available in the buffer.
				while ((len = this.in.read(buffer)) > -1) {
					//Get the command that we are currently processing the
					//response for.
					String currentCommand = CommandHandler.currentCommand();
					//Create a string from the buffer and append it to our 
					//response.
					responseStr += new String(buffer, 0, len);	
					//If the data doesn't start with the current command
					//we need to flag an unsolicited command response and 
					//break the loop.
					//--------------------------ELSE---------------------------
					//If it does start with the current command and has an OK 
					//or an ERROR break the loop and send it to the 
					//receivedData register.
					
					//TODO this is where it is all going wrong!
					if(!responseStr.startsWith(currentCommand)) {
						break;
					} else if (responseStr.indexOf("OK") != -1 || 
							responseStr.indexOf("ERROR") != -1 ) {
						break;
					}

				}
				//Log this response
				Window.writeToMonitor("READ: " + responseStr.trim());
				//Process the command
				CommandProcessor.process(responseStr);
				CommandHandler.receiveData(responseStr);
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 ******************************************************************************
	 *                                 SerialWriter                               *
	 ******************************************************************************/
	public static class SerialWriter implements Runnable {
		private OutputStream out;
		
		public SerialWriter(OutputStream out) {
			this.out = out;
		}

		public void run() {
			try {
				//Infinite loop to wait for commands.
				while(true) {
					if(CommandHandler.rawAvailable()) {
						this.out.write(CommandHandler.character);
						this.out.write('\r');
						CommandHandler.character = 0;
						CommandHandler.rawAvailable = false;
					}
					//If there are commands waiting.
					if(CommandHandler.availableCommands() > 0) {
						//Get the waiting command and move it into the sent 
						//register.
						String waitingCommand = CommandHandler.sendCommand();
						//Write the command into the output stream.
						this.out.write(waitingCommand.getBytes());
						// TODO REMOVE DEBUG
						System.out.println("Command: " + waitingCommand);
					}
					// TODO REMOVE DEBUG
					Thread.sleep(100);
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 ******************************************************************************
	 *                                CommandHandler                              *
	 ******************************************************************************/
	public static class CommandHandler {
		
		private static ArrayList<String> waitingCommands = new ArrayList<String>();
		private static ArrayList<String> sentCommands = new ArrayList<String>();
		private static ArrayList<String> receivedData = new ArrayList<String>();
		public static char character;
		private static boolean commandMode = false;
		private static boolean rawAvailable = false;
		
		public CommandHandler () {
			waitingCommands = new ArrayList<String>();
			sentCommands = new ArrayList<String>();
			receivedData = new ArrayList<String>();
		}
		
		//Check how many commands are waiting to be sent.
		public static int availableCommands () {
			return waitingCommands.size();
		}
		
		//Check how many commands are waiting to be sent.
		public static int availableReceived () {
			return receivedData.size();
		}
		
		//Get the command that is currently being processed.
		public static String currentCommand () {
			String current = sentCommands.get(sentCommands.size() - 1);
			//sentCommands.remove(0);
			return current;
		}
		
		//Checks the state of the commandMode flag.
		public static boolean isInCommandMode () {
			return commandMode;
		}
		
		//Checks the state of the commandMode flag.
		public static boolean rawAvailable() {
			return rawAvailable;
		}
		
		//Add a command to the waiting list.
		public static void addCommand (String command) {
			waitingCommands.add(command);
		}
		
		//Overload for raw data.
		public static void addCommand (char ch) {
			character = ch;
			rawAvailable = true;
		}
		
		//Get the response at the top of the received data register and remove 
		//it from the recievedData register.
		public static String getResponse () {
			String response;
			
			//Create a small delay that will ensure the command has arrived.
			int timeout = 2000, count = 0, interval = 10;
			
			while(availableReceived() <= 0 || count >= timeout) {
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				count += interval;
			}
			if(count >= timeout) {
				return "No data.";
			} else {
				response = receivedData.get(receivedData.size() - 1);
				receivedData.remove(receivedData.size() - 1);
				
				return response;
			}
		}
		
		//Add some data to the received register.
		public static void receiveData (String data) {
			receivedData.add(data);
		}
		
		//Removes and returns the first item in the commandStage and adds it to
		//sentCommands.
		public static String sendCommand() {
			commandMode = false;
			//Add the command to the sentCommands list.
			String currentCommand = waitingCommands.get(0);
			sentCommands.add(currentCommand);
			//Remove it from the register.
			waitingCommands.remove(0);
			return currentCommand;
		}
		
	}

}
