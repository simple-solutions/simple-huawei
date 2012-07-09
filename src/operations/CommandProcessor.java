/**
 ******************************************************************************
 *                           CommandProcessor.java                            *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 6 Jul 2012
 * 
 * (Description)
 */
package operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import views.Window;


public class CommandProcessor {
	
	/**
	 * Accept an incoming message and perform actions depending on it's 
	 */
	public static void process(String response) {
		
		if(response.indexOf("+COPS") != -1) {
			
			Pattern p = Pattern.compile(".*\"(.+)\"");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				System.out.println(m.group(1));
			}
			
		}
		
		if(response.indexOf("+CSQ") != -1) {

			Pattern p = Pattern.compile(".*([0-9]{2},[0-9]{2}).*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			String[] signals = m.group(1).split(",");
			
			if (matchFound) {
				Window.updateSignal(Integer.parseInt(signals[0]));
			}
			
		}
		
	}
	
}
