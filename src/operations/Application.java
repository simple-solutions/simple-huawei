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
import views.Window;
import operations.ConfigReader;

public class Application {
	
	public static Command[] commands;
	
	public static void main (String[] args) {
		Window mainWindow = new Window();
		mainWindow.setVisible(true);
		
		listCommands();
		listDevices();
	}
	
	public static void write (String message) {
		SerialInterface.write(message);
	}
	
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
		@SuppressWarnings("unchecked")
		java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
		ArrayList<String> devices = new ArrayList<String>();
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
	}
        
}
