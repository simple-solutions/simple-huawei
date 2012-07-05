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

import operations.Application;
import operations.SerialInterface;
import views.Window;

public class InterfaceEvents {
	
	public static void connect (String portName) {
		
		try {
			Window.writeToMonitor("LOG: Attempting to connect to " + portName);
			SerialInterface.connect(portName);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	public static void getCommandDescription (int index) {
		String description = Application.commands[index].getDescription();
		Window.setCommandDescription(description);
	}
}
