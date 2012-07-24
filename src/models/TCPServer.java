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
	
	private int port;
	private boolean configured = false;
	
	public void configure (int serviceNo, int prt) {
		
		this.port = prt;
		this.serviceNumber = serviceNo;
		Application.write("AT^SISS="+ this.serviceNumber +
				",SRVTYPE,SOCKET;^SISS="+ 
				this.serviceNumber +",CONID,0;^SISS="+ 
				this.serviceNumber +",ADDRESS,\"SOCKTCP://listener:"+ 
				this.port +"\"");
		this.configured = true;
	}
	
	public boolean isConfigured () {
		return this.configured;
	}
}
