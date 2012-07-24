/**
 ******************************************************************************
 *                               TCPHandler.java                              *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 24 Jul 2012
 * 
 * (Description)
 */
package models;


public class TCPHandler {

	public static void configure (String address, int port) {
		System.out.println("PORT: " + port);
		TCPClient.configure(0, address, port);
		TCPServer.configure(1, port);
	}
	
	public static boolean isConfigured () {
		return TCPClient.isConfigured() && TCPServer.isConfigured();
	}
	
	public static boolean isStarted () {
		return TCPClient.isStarted() && TCPServer.isStarted();
	}
	
	public static void start () {
		if(isConfigured()) {
			System.out.println("Starting client");
			TCPClient.start();
			System.out.println("Starting server");
			TCPServer.start();
		} else {
			System.out.println("Not configured.");
		}
	}
	
	public static void stop () {
		TCPClient.stop();
		TCPServer.stop();
	}
	
	public static void write (String data) {
		if(isStarted()) {
			TCPClient.prepare(data);
		}
	}
	
}
