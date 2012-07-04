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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import model.Command;

import view.HuaweiWindow;


public class Application {
	public static SerialInterface serialInterface;
	
	public static void setup () {
		serialInterface = new SerialInterface();
		
		HuaweiWindow frame = new HuaweiWindow();
		frame.setVisible(true);
		
		try {
			ConfigReader.setup();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//this.serialInterface.write("at+csq");
		//System.out.println(this.serialInterface.read());
	}
	
	public static void phoneCall (String number) {
		//this.serialInterface.write("AT phone home" + number);
	}
	
	public static void sendSms (String number, String message) {
		if(message.length() < 160) {
			//this.serialInterface.write("AT sms" + number + message);
		}
	}
	
	public static class ConfigReader {
		private static ArrayList<String> commands;
		
		private static Command[] _getStaticArray () {
			//Create a new static array the same size as our arrayList
			Command[] staticCommands = new Command[commands.size()];
			//Add all items to the static array
			for(int i = 0; i < commands.size(); i++) {
				String[] components = commands.get(i).split("\\|");
				staticCommands[i] = new Command(components[0], components[1], components[2]);
			}
			return staticCommands;
		}
		
		public static Command[] setup () throws FileNotFoundException {
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
