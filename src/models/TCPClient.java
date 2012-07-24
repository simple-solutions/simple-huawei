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
	private static boolean configured = false;
	private static boolean started = false;
	
	public static void configure (int serviceNo, String addr, int prt) {
		
		//Configure service number, port and address for this client.
		serviceNumber = serviceNo;
		address = addr;
		port = prt;
		
		/*Application.write("at^siss="+ serviceNumber +",srvtype,socket;"+
				"^sics="+ serviceNumber +",contype,GPRS0;"+
				"^sics="+ serviceNumber +",apn,\"stream.co.uk\";"+
				"^sics="+ serviceNumber +",user,\"streamip\";"+
				"^sics="+ serviceNumber +",passwd,\"streamip\";"+
				"^siss="+ serviceNumber +",srvtype,socket;"+
				"^siss="+ serviceNumber +",conid,0;"+
				"^siss="+ serviceNumber +",address,\"SOCKTCP://"+ 
				address +":"+ port +"\"");*/
		
		Application.write("AT^SICS="+ serviceNumber +",CONTYPE,GPRS0;^SICS="+ 
				serviceNumber +",APN,internetvpn");
		
		Application.write("AT^SISS="+ serviceNumber +",SRVTYPE,SOCKET;^SISS="+ 
				serviceNumber +",CONID,0;^SISS="+
				serviceNumber +",ADDRESS,\"SOCKTCP://"+ 
				address +":"+ port +"\"");
		
		configured = true;
	}
	
	public static void prepare(String data) {
		Application.write("at^sisw="+ serviceNumber +"," + data.length());
		sendData.add(data);
		//Now we have to wait for the line ^SISW: 0,10,0
		//in the command processor.

	}
	
	public static void send () {
		//When we receive ^SISW: we can remove one item from
		//the waiting data buffer pass it to the command processor.
		System.out.println("Turning on TCP sending.");
		//We need to start TCP sending to remove \r
		Application.tcpSending = true;
		Application.write(sendData.remove(0));
		
	}


	/* Getters and Setters */
	public static int getServiceNumber() {
		return serviceNumber;
	}

	public static void setServiceNumber(int serviceNumber) {
		TCPClient.serviceNumber = serviceNumber;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		TCPClient.address = address;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		TCPClient.port = port;
	}

	public static ArrayList<String> getSendData() {
		return sendData;
	}

	public static void setSendData(ArrayList<String> sendData) {
		TCPClient.sendData = sendData;
	}

	public static boolean isConfigured() {
		return configured;
	}

	public static void setConfigured(boolean configured) {
		TCPClient.configured = configured;
	}
	
	public static boolean isStarted() {
		return started;
	}

	public static void setStarted(boolean started) {
		TCPClient.started = started;
	}
}
