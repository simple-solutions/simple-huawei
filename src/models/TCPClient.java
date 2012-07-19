/**
 ******************************************************************************
 *                                TCPClient.java                              *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 18 Jul 2012
 * 
 * (Description)
 */
package models;

import java.util.ArrayList;

import operations.Application;

public class TCPClient extends InternetService {
	
	private static int serviceNumber;
	private static String address;
	private static int port;
	private static ArrayList<String> sendData = new ArrayList<String>();
	

	public static void configure (int serviceNo, String addr, int prt) {
		
		//Configure service number, port and address for this client.
		serviceNumber = serviceNo;
		address = addr;
		port = prt;

		//Connection type: GPRS
		Application.write("at^sics="+ serviceNumber +",contype,GPRS0");
		//Set the access point name
		Application.write("at^sics="+ serviceNumber +",apn,\"stream.co.uk\"");
		//Set the username
		Application.write("at^sics="+ serviceNumber +",user,\"streamip\"");
		//Set the password
		Application.write("at^sics="+ serviceNumber +",passwd,\"streamip\"");
		
		//Information about services
		Application.write("at^sics?");
		
		//Start the socket
		Application.write("at^siss="+ serviceNumber +",srvtype,socket");
		//TODO What is this line?
		Application.write("at^siss="+ serviceNumber +",conid,0");
		//Point the client towards an address and port
		Application.write("at^siss="+ serviceNumber +",address,\"sockudp://"+ 
				address +":"+ port +"\"");
		
		//TODO Information about WHAT?
		Application.write("at^siss?");

	}
	
	public static void send(String data) {
		
		Application.write("at^sisw="+ serviceNumber +"," + data.length());
		sendData.add(data);
		//Now we have to wait for the line ^SISW: 0,10,0
		//in the command processor.
		//

	}
	
	public static String getAvailableData () {
		//When we receive ^SISW: we can remove one item from
		//the waiting data buffer pass it to the command processor.
		return sendData.remove(0);
	}
	

}
