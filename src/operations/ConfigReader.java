package operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
				//Create our input as a buffered reader aimed at our path
				String config = ConfigReader.class.getResource("/commandSet.config").getPath().replaceFirst("!", "");
			    BufferedReader in = new BufferedReader(new FileReader(config));
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

		/**
		 * @param string
		 * @return
		 */
		private static char[] getResource(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}