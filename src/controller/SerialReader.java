package controller;

import java.io.*;

/**
 * Reads from a serial port.
 * ---------------------------------------------------------------
 * Code based on examples provided at: http://rxtx.qbang.org/wiki/
 * ---------------------------------------------------------------
 * Takes an input stream object and reads from it on a separate
 * thread. Prints the output to STDOUT.
 */
public class SerialReader implements Runnable {
	
	//The input stream that we will be reading from.
	InputStream in;
	
	//Construct the object from an InputStream.
	public SerialReader(InputStream in) {
		this.in = in;
	}
	
	//Implements the abstract run method.
	public void run() {
		//Stores our read bytes.
		byte[] buffer = new byte[1024];
		int len = -1;
		try {
			//Read until no more bytes are available.
			while ((len = this.in.read(buffer)) > -1) {
				//Create a string from the bytes and output it.
				System.out.print(new String(buffer, 0, len));
			}
		} catch (IOException e) {
			//If we hit an error, report it and terminate the thread.
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
}