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
	
	private static TCPClient client;
	private static TCPServer server;
	
	public static void configure (String address, int port) {
		System.out.println("PORT: " + port);
		client.configure(0, address, port);
		server.configure(1, port);
	}
	
	public static boolean isConfigured () {
		return client.isConfigured() && server.isConfigured();
	}
	
	public static boolean isStarted () {
		System.out.println(client.isStarted() + ":" + server.isStarted());
		return client.isStarted() && server.isStarted();
	}
	
	public static void start () {
		if(isConfigured()) {
			System.out.println("Starting client");
			client.start();
			System.out.println("Starting server");
			server.start();
		} else {
			System.out.println("Not configured.");
		}
	}
	
	public static void stop () {
		client.stop();
		server.stop();
	}
	
	public static void write (String data) {
		if(isStarted()) {
			client.prepare(data);
		}
	}
	
	public static void confirmClientWrite () {
		client.send();
	}
	
}
