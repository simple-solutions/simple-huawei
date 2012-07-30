package models;

import java.util.ArrayList;

import operations.Application;

/**
 ******************************************************************************
 *							 +------------------+							  *
 *                           |   TCP HANDLER    |                             *
 *                           +------------------+ 							  *
 ****************************************************************************** 
 * A class that wraps up both the clients and the server involved in a TCP
 * connection.
 * 
 * @author simple-developer
 * @since 28.06.2012
 * 
 * Overview
 * ----------------------------------------------------------------------------
 * This class will configure and start a TCP server.
 * 
 * 
 * Reading
 * ----------------------------------------------------------------------------
 * 
 * 
 * Writing
 * ----------------------------------------------------------------------------
 * 
 * Usage
 * ----------------------------------------------------------------------------
 * 
 ******************************************************************************
 */

public class UDPHandler {
	
	private static TCPClient client;
	private static TCPServer server;
	private static ArrayList<String> sendData = new ArrayList<String>();
	private static int currentSocket = 0;
	public static boolean writing = false;
	public static boolean reading = false;
	
	public static void init () {
		client = new TCPClient();
		server = new TCPServer();
	}
	
	public static void configure (String address, int port) {
		
		System.out.println("PORT: " + port);
		client.configure(0, address, port);
		server.configure(1, port);
	}

	public static boolean isConfigured () {
		return client.isConfigured() && server.isConfigured();
	}
	
	public static boolean isStarted () {
		return server.isStarted();
		//return client.isStarted();
	}
	
	public static void start () {
		if(isConfigured()) {
			System.out.println("Starting server");
			server.start();
			//client.start();
		} else {
			System.out.println("Not configured.");
		}
	}
	
	public static void stop () {
		//client.stop();
		server.stop();
	}
	
	public static void write (String data) {
		if(isStarted()) {
			writing = true;
			Application.write("AT^SISW="+ currentSocket +"," + data.length());
			sendData.add(data);
		} else {
			System.out.println("TCPServer is not started.");
		}
	}
	
	public static void read () {
		Application.write("AT^SISR="+ currentSocket +"," + 1024);
	}
	
	public static void confirmClientWrite () {
		//When we receive ^SISW: we can remove one item from
		//the waiting data buffer pass it to the command processor.
		System.out.println("Turning on TCP sending.");
		//We need to start TCP sending to remove \r
		Application.tcpSending = true;
		System.out.println(sendData.size());
		Application.write(sendData.remove(0));
		Application.sleep(500);
		System.out.println("Turning off TCP sending.");
		Application.tcpSending = false;
		writing = false;
	}

	/**
	 * @return the recentSocket
	 */
	public static int getCurrentSocket() {
		return currentSocket;
	}

	/**
	 * @param recentSocket the recentSocket to set
	 */
	public static void setCurrentSocket(int recentSocket) {
		System.out.println("NEW SOCKET: " + recentSocket);
		UDPHandler.currentSocket = recentSocket;
		
		Application.sleep(500);
		
		//Open our new socket
		Application.write("AT^SISO=" + currentSocket);
	}
	
}
