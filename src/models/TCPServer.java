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
public class TCPServer extends InternetService {
	
	private static int port;
	private static boolean configured = false;
	
	public static void configure (int serviceNo, int prt) {
		
		port = prt;
		serviceNumber = serviceNo;
		Application.write("AT^SISS="+ serviceNumber +",SRVTYPE,SOCKET;^SISS="+ serviceNumber +",CONID,0;^SISS="+ serviceNumber +",ADDRESS,\"SOCKTCP://listener:"+ port +"\"");
		configured = true;
	}
	
	public static boolean isConfigured () {
		return configured;
	}
}
