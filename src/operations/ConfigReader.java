package operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import views.Window;

import models.Command;

public class ConfigReader {
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
		
		public static Command[] read () {
			commands = new ArrayList<String>();
			//Catch read exceptions
			try {
				//System.out.println(ConfigReader.class.getResource("/commandSet.config").getPath());
				
				File file = new File(ConfigReader.class.getProtectionDomain().getCodeSource().getLocation().getFile());          
	            String path = file.getParent() + File.separator + "commandSet.config";  
				
				//Create our input as a buffered reader aimed at our path
			    BufferedReader in = new BufferedReader(new FileReader(path));
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
				Window.writeToMonitor((e.getMessage()));
			}
			//Otherwise return our files contents.
			return _getStaticArray();
		}
		
		
	}