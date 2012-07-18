/**
 ******************************************************************************
 *                                TcpClient.java                                *
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
public class TcpClient {
	/**
	 * @param serviceNumber
	 */
	public TcpClient(int serviceNumber) {
		super(serviceNumber);
	}
	
	private String address;
	public String sendData;
	private int port;
	

	public void configure (String address, int port) {
		this.port = port;
		this.address = address;

		//Connection type: GPRS
		Application.write("at^sics="+ this.serviceNumber +",contype,GPRS0");
		//Set the access point name
		Application.write("at^sics="+ this.serviceNumber +",apn,\"stream.co.uk\"");
		//Set the username
		Application.write("at^sics="+ this.serviceNumber +",user,\"streamip\"");
		//Set the password
		Application.write("at^sics="+ this.serviceNumber +",passwd,\"streamip\"");
		
		//Information about services
		Application.write("at^sics?");
		
		//Start the socket
		Application.write("at^siss="+ this.serviceNumber +",srvtype,socket");
		//TODO What is this line?
		Application.write("at^siss="+ this.serviceNumber +",conid,0");
		//Point the client towards an address and port
		Application.write("at^siss="+ this.serviceNumber +",address,\"sockudp://"+ this.address +":"+ this.port +"\"");
		
		//TODO Information about WHAT?
		Application.write("at^siss?");

		//Starts the service.
		Application.write("at^siso=0");
		
			
		
	}


	@Override
	public void send(String data) {
		// TODO Auto-generated method stub
		Application.write("at^sisw="+ serviceNumber +"," + data.length());
		this.sendData = data;
		//Now we have to wait for the line ^SISW: 0,10,0
	}
}
