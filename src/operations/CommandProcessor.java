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
			System.out.println("COPS present in response");
			Pattern p = Pattern.compile(".*\\+COPS:.*\"(.+)\"");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				String operator = m.group(1).trim();
				Window.setOperator(operator);
			}
			
		}
		
		if(response.indexOf("+CSQ") != -1) {

			Pattern p = Pattern.compile(".*\\+CSQ:\\s([0-9]{2},[0-9]{2}).*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			String[] signals = m.group(1).split(",");
			
			if (matchFound) {
				float signal = (Float.parseFloat(signals[0]) / 31) * 100;
				Window.setSignal((int)signal);
				System.out.println("Signal: " + signal);
			}
			
		}
		
	}
	
}
