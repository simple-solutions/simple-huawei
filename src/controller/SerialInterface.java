package controller;

import gnu.io.*;
import java.io.*;

/**
 * A class that provides an interface to serial port methods.
 * 
 * @author simple-developer
 * @since 25.06.2012
 *  
 * Overview
 * ----------------------------------------------------------------------------
 * This class will act as a sub-controller, accessed by our main controller, 
 * exposing methods and objects from the serial writer and reader objects. 
 * 
 * 
 * Reading
 * ----------------------------------------------------------------------------
 * There will be a reader which will either print to System.out. As this class 
 * will be running on a separate thread to the main controller, it will be 
 * blocking whilst it waits for data. 
 * 
 * TODO (In the future this method should be printing to the monitor pane 
 * within the interface and the log file if logging is enabled.) 
 * 
 * 
 * Writing
 * ----------------------------------------------------------------------------
 * The write method should use a similar principle to the read, but without the 
 * blocking. 
 * 
 * It is linked to a SerialWriter object running on a separate thread and uses 
 * the write() method as provided by this object, taking a single String 
 * parameter which is the message that you want to write out.
 * 
 */
public class SerialInterface {
	
	public void connect(String portName) throws Exception {
		
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier(portName);
		
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			
			CommPort commPort = portIdentifier.open(
					this.getClass().getName(),
					2000
			);

			if (commPort instanceof SerialPort) {
				
				SerialPort serialPort = (SerialPort) commPort;
				
				//Set the serial port's parameters
				serialPort.setSerialPortParams(
						115200, 					//Baud rate
						SerialPort.DATABITS_8,		//8 Data Bits
						SerialPort.STOPBITS_1, 		//1 Stop Bit
						SerialPort.PARITY_NONE		//No parity
				);
				
				//Retrieve the I/O streams from the serialPort object.
				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();
				
				//Start the Reader & Writer on new threads.
				(new Thread(new SerialReader(in))).start();
				(new Thread(new SerialWriter(out))).start();

			} else {
				// TODO this device is not a serial port.
			}
		}
	}

}
