/**
 ******************************************************************************
 *                                TcpServer.java                                *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 18 Jul 2012
 * 
 * (Description)
 */
package models;

import operations.Application;

/**
 * @author simple-developer
 *
 */
public class TcpServer {
	private static int port;
	private static int service;
	
	public static void config (int service, int prt) {
		port = prt;
		
		Application.write("AT^SICS=1,CONTYPE,GPRS0");
		Application.write("AT^SICS=,APN,internetvpn");

		Application.write("AT^SISS=1,SRVTYPE,SOCKET");
		Application.write("AT^SISS=1,CONID,0");
		Application.write("AT^SISS=1,ADDRESS,\"SOCKTCP://listener:"+ port +"\"");
		
		Application.write("AT^SISO=1");

		Application.write("AT&W");
		
		
	}
}
