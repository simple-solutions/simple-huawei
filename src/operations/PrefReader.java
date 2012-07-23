package operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import views.Window;


public class PrefReader {
		
		/**
		 * PREFERENCE SETTINGS
		 * Phone number
		 * SMS phone number
		 * TCP port
		 * TCP address
		 */
		
		public static String[] read () {
			String [] preferences = new String[4];
			//Catch read exceptions
			try {
				
				File file = new File(PrefReader.class.getProtectionDomain().getCodeSource().getLocation().getFile());          
	            String path = file.getParent() + File.separator + ".pref";  
				
			    BufferedReader in = new BufferedReader(new FileReader(path));
			    String str;
			    int count = 0;
			    //While there are lines in the buffer, add them to our readData string.
			    while ((str = in.readLine()) != null) {
			    	preferences[count] = str;
			    	System.out.println(str);
			    }
			    //Close the stream
			    in.close();
			} catch (IOException e) {
				//If we had an exception return it.
				Window.writeToMonitor((e.getMessage()));
			}
			//Otherwise return our files contents.
			return preferences;
		}
		
		
	}