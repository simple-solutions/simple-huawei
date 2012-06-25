package controller;

import gnu.io.*;
import java.io.*;
import java.util.ArrayList;

/**
 ******************************************************************************
 *                             SERIAL INTERFACE                               *
 ****************************************************************************** 
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
 * It is linked to a SerialWriter object and uses the write() method as 
 * provided by this object, taking a single String parameter which is the 
 * message that you want to write out.
 * 
 ******************************************************************************
 */

public class SerialInterface {
	SerialPort serialPort;
	SerialReader reader;
	SerialWriter writer;			
	ArrayList<String> readData;
	
	public void connect(String portName) throws Exception {
		
		//Create an identifier from our port's name.
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier(portName);
		
		//Check whether the port is currently in use.
		if (portIdentifier.isCurrentlyOwned()) {
			// TODO Port is in use message
		} else {
			//Open this port with SerialInterface as the owner's name and a 
			//2000ms timeout.
			CommPort commPort = portIdentifier.open(this.getClass().getName(),
					2000);

			if (commPort instanceof SerialPort) {
				
				this.serialPort = (SerialPort) commPort;
				
				//Set the serial port's parameters
				this.serialPort.setSerialPortParams(
						115200, 					//Baud rate
						SerialPort.DATABITS_8,		//8 Data Bits
						SerialPort.STOPBITS_1, 		//1 Stop Bit
						SerialPort.PARITY_NONE		//No parity
				);
				
				//Retrieve the I/O streams from the serialPort object.
				InputStream in = this.serialPort.getInputStream();
				OutputStream out = this.serialPort.getOutputStream();
				//Create read & write objects from those streams
				this.reader = new SerialReader(in, this);
				this.writer = new SerialWriter(out);
				
			} else {
				// TODO this device is not a serial port.
			}
		}
	}
	
	public void write (String message) {
		this.writer.write(message);
	}
	
	public void storeReadData (String message) {
		//Pushes the message onto a list.
		this.readData.add(message);
	}
	
	public String getMostRecentRead () {
		//Return the most recently read item.
		return this.readData.get(this.readData.size() - 1);
	}
	
	public void close () {
		//Close our serial port to free it from our process.
		this.serialPort.close();
	}
	
}
