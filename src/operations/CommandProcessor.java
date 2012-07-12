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

import models.Phone;

import views.CallDialog;
import views.Window;


public class CommandProcessor {
	
	/**
	 * Accept an incoming message and perform actions depending on it's 
	 */
	public static void process(String response) {
		
		//If we are dealing with a COPS response
		if(response.indexOf("+COPS") != -1) {
			System.out.println("COPS present in response");
			//Extract the operator name with regex.
			Pattern p = Pattern.compile(".*\\+COPS:.*\"(.+)\"");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				String operator = m.group(1).trim();
				//Set the operator label in the window.
				Window.setOperator(operator);
			}
		}
		
		//If we are dealing with a CSQ response
		if(response.indexOf("+CSQ") != -1) {
			//Extract the signal strength with regex.
			Pattern p = Pattern.compile(".*\\+CSQ:\\s([0-9]{2},[0-9]{2}).*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			String[] signals = m.group(1).split(",");
			
			if (matchFound) {
				//Get the signal as a percentage.
				float signal = (Float.parseFloat(signals[0]) / 31) * 100;
				//Set the signal bar in the window.
				Window.setSignal((int)signal);
			}
		}
		
		//If we are dealing with a CLIP response
		if(response.indexOf("+CLIP") != -1) {
			//Extract the phone number with regex.
			Pattern p = Pattern.compile(".*\\+CLIP:\\s+\"([0-9]*)\".*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			System.out.println(matchFound);
			if(matchFound) {
				String number = m.group(1);
				//TODO Fire up the call dialog and show the incoming number.
				CallDialog.incomingCall(number);
				Application.callDialog.setVisible(true);
			}
		}
		
		if(response.startsWith(">")) {
			Phone.sendMessage();
		}

		
	}
	
}
