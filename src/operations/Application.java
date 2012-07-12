/**
 ******************************************************************************
 *                                Application.java                            *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 5 Jul 2012
 * 
 * (Description)
 */
package operations;

import java.util.ArrayList;

import gnu.io.CommPortIdentifier;

import models.Command;
import views.CallDialog;
import views.Window;
import operations.ConfigReader;

public class Application {
	
	public static boolean connected;
	public static boolean logging;
	public static boolean busy;
	public static Command[] commands;
	public static CallDialog callDialog = new CallDialog();
	public static Window window = new Window();
	
	public static void main (String[] args) {
		window.setVisible(true);
		//Lists the current command set and the available devices in window.
		listCommands();
		listDevices();
	}
	
	/******************************
	 *         W R I T E          *
	 ******************************/
	public static void write (String message) {
		if(connected) {
			SerialInterface.write(message);
			Window.writeToMonitor("WRITE: " + message);
		}
	}
	
	/******************************
	 *           R E A D          *
	 ******************************/
	public static String read () {
		return SerialInterface.read();
	}
	
	public static void listCommands () {
		
		commands = ConfigReader.read();
		for(int i = 0; i < commands.length; i++) {
			Window.listCommand(commands[i].getName());
		}
		
	}
	
	public static void listDevices () {
		
		ArrayList<String> devices = new ArrayList<String>();
		
		@SuppressWarnings("unchecked")
		java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier
			.getPortIdentifiers();
		
		
		//Create the list of devices
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            devices.add(portIdentifier.getName());
        }
        
        //Then add them in reverse order to the combo box.
        for(int i = devices.size() - 1; i >= 0; i--) {
        	Window.listDevice(devices.get(i));
        }
        
	}
	
	public static void deviceConfig () {
		//Turn on incoming call information
		SerialInterface.write("AT+CLIP=1");
		//Send an escape key to stop current mode.
		SerialInterface.write("0x1b");
	}
        
}
