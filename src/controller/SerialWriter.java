package controller;

import java.io.*;

/**
 ******************************************************************************
 *                               SERIAL WRITER                                *
 ****************************************************************************** 
 * A class for writing to an output stream created from a serial port.
 * ----------------------------------------------------------------------------
 * Code based on examples provided at: http://rxtx.qbang.org/wiki/
 * ----------------------------------------------------------------------------
 * Uses an OutputStream to send data to a serial port.
 * 
 ******************************************************************************
 */
public class SerialWriter {
	
	//The output stream that we will be writing to.
	OutputStream out;
	
	//Construct our object with an OutputStream created from a 
	//serial port.
	public SerialWriter(OutputStream out) {
		this.out = out;
	}
	
	//A method used to write strings into the OutputStream.
	public void write(String message) {
		try {
			//Convert the message to be written to the output.
			this.out.write(message.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}