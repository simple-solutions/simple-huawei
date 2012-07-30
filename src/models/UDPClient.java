/**
 ******************************************************************************
 *                                this.java                              *
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

public class UDPClient extends InternetService {
	
	private int serviceNumber;
	private String address;
	private int port;
	private ArrayList<String> sendData = new ArrayList<String>();
	private boolean configured = false;
	
	public void configure (int serviceNo, String addr, int prt) {
		
		//Configure service number, port and address for this client.
		this.serviceNumber = serviceNo;
		this.address = addr;
		this.port = prt;
		
		/*Application.write("at^siss="+ serviceNumber +",srvtype,socket;"+
				"^sics="+ serviceNumber +",contype,GPRS0;"+
				"^sics="+ serviceNumber +",apn,\"stream.co.uk\";"+
				"^sics="+ serviceNumber +",user,\"streamip\";"+
				"^sics="+ serviceNumber +",passwd,\"streamip\";"+
				"^siss="+ serviceNumber +",srvtype,socket;"+
				"^siss="+ serviceNumber +",conid,0;"+
				"^siss="+ serviceNumber +",address,\"SOCKTCP://"+ 
				address +":"+ port +"\"");*/
		
		Application.write("AT^SICS="+ this.serviceNumber +",CONTYPE,GPRS0;^SICS="+ 
				this.serviceNumber +
				",apn,\"o2.wyless.net\";"+
				"^sics="+ serviceNumber +",user,\"SSolutions\";"+
				"^sics="+ serviceNumber +",passwd,\"S1SL2\";"+
				"^siss="+ serviceNumber +",srvtype,socket;");
		
		Application.write("AT^SISS="+ this.serviceNumber +",SRVTYPE,SOCKET;^SISS="+ 
				this.serviceNumber +",CONID,0;^SISS="+
				this.serviceNumber +",ADDRESS,\"SOCKTCP://"+ 
				this.address +":"+ this.port +"\"");
		
		this.configured = true;
	}
	
	public void prepare(String data) {
		Application.write("at^sisw="+ serviceNumber +"," + data.length());
		this.sendData.add(data);
		//Now we have to wait for the line ^SISW: 0,10,0
		//in the command processor.

	}
	
	public void send () {
		//When we receive ^SISW: we can remove one item from
		//the waiting data buffer pass it to the command processor.
		System.out.println("Turning on TCP sending.");
		//We need to start TCP sending to remove \r
		Application.tcpSending = true;
		Application.write(this.sendData.remove(0));
		
	}


	/* Getters and Setters */
	public int getServiceNumber() {
		return this.serviceNumber;
	}

	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ArrayList<String> getSendData() {
		return this.sendData;
	}

	public void setSendData(ArrayList<String> sendData) {
		this.sendData = sendData;
	}

	public boolean isConfigured() {
		return this.configured;
	}

	public void setConfigured(boolean configured) {
		this.configured = configured;
	}
	
}
