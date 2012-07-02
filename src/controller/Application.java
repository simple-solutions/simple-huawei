package controller;
/**
 ******************************************************************************
 *                                APPLICATION                                 *
 ****************************************************************************** 
 * Provides interaction between the model and the view.
 * 
 *  @author simple-developer
 *  @since 25.06.2012
 * at+cops?
 * This is the main class that will control the other aspects of application.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import view.HuaweiWindow;


public class Application {
	public SerialInterface serialInterface;
	
	public Application () {
		this.serialInterface = new SerialInterface();
		
		HuaweiWindow frame = new HuaweiWindow(this);
		frame.setVisible(true);
		
		ConfigReader cf = new ConfigReader();
		try {
			cf.setup();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//this.serialInterface.write("at+csq");
		//System.out.println(this.serialInterface.read());
	}
	
	public void phoneCall (String number) {
		//this.serialInterface.write("AT phone home" + number);
	}
	
	public void sendSms (String number, String message) {
		if(message.length() < 160) {
			//this.serialInterface.write("AT sms" + number + message);
		}
	}
	
	public static class ConfigReader {
		private static ArrayList<String> commands;
		
		private static String[] _getStaticArray () {
			String[] staticCommands = new String[commands.size()];
			for(int i = 0; i < commands.size(); i++) {
				staticCommands[i] = commands.get(i);
			}
			return staticCommands;
		}
		
		public static String[] setup () throws FileNotFoundException {
			commands = new ArrayList<String>();
			//Catch read exceptions
			try {
				//Create our input as a buffered reader aimed at our path
			    BufferedReader in = new BufferedReader(new FileReader("model/commandSet.config"));
			    String str;
			    //While there are lines in the buffer, add them to our readData string.
			    while ((str = in.readLine()) != null) {
			    	if(str.matches("^[^#\\s].*")) {
			    		commands.add(str);
			    		System.out.println(str);
			    		//HuaweiWindow.lstCommands.
			    	}
			    }
			    //Close the stream
			    in.close();
			} catch (IOException e) {
				//If we had an exception return it.
				System.out.println(e.getMessage());
			}
			//Otherwise return our files contents.
			return _getStaticArray();
		}
		
		
	}
}
