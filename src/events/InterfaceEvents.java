/**
 ******************************************************************************
 *                                InterfaceEvents.java                        *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 5 Jul 2012
 * 
 * (Description)
 */
package events;

import models.*;
import operations.Application;
import operations.SerialInterface;
import views.Window;

public class InterfaceEvents {
	
	public static void connect (String portName) {
		
		try {
			SerialInterface.connect(portName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void sendSms(String number, String message) {
		Phone.startSms(number, message);
	}
	
	public static void dial (String number) {
		Phone.dial(number);
	}
	
	public static void hang () {
		Phone.hangUp();
	}
	
	public static void close () {
		SerialInterface.close();
	}
	
	public static void sendTcpMessage (String message) {
		
		TCPClient.prepare(message);
      	
	}
	
	public static void toggleTCPHandler (String address, 
			int port) {
		
		if(TCPHandler.isStarted()) {
			TCPHandler.stop();
		} else {
			if(!TCPHandler.isConfigured()) {
				TCPHandler.configure(address, port);
			}
			TCPHandler.start();
		}
	}
	
	public static void toggleTCPServer () {
		
	}
	
	public static void toggleUDPClient () {
		
	}
	
	public static void toggleUDPServer () {
		
	}
	
	//Get the description and the templated version of the command
	//and show it in the interface.
	public static void getCommandPreview (int index, String templateString) {
		Command command = Application.commands[index];
		Window.setCommandDescription(command.getDescription());
		Window.setCommandPreview(command.template(templateString));
	}
	
	public static void sendCommand (int index, String command) {
		Application.write(command);
	}
}
