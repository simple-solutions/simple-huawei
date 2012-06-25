package controller;

import java.io.*;

/**
 * A class for writing to an output stream created from a serial port.
 * 
 * Code based on examples provided at: http://rxtx.qbang.org/wiki/
 * 
 * Takes an output stream object and writes to it on a separate
 * thread.
 */
public class SerialWriter implements Runnable {
	
	//The output stream that we will be writing to.
	OutputStream out;
	
	//Construct our object with an OutputStream.
	//created from a serial port.
	public SerialWriter(OutputStream out) {
		this.out = out;
	}
	
	//Implements the abstract run method.
	public void run() {
		try {
			int c = 0;
			while ((c = System.in.read()) > -1) {
				this.out.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}