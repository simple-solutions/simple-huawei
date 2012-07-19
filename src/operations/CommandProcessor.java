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
import models.TCPClient;

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
				//Fire up the call dialog and show the incoming number.
				CallDialog.incomingCall(number);
				Application.callDialog.setVisible(true);
			}
		}
		
		//If the device is prompting for SMS sending, then send the message
		//currently stored in the phone.
		if(response.indexOf(">") != -1) {
			System.out.println("Here comes the prompt!");
			Phone.sendMessage();
		}
		
		//If the device requests a TCP write, get the available data from
		//the TCP client and write it to the device, it should be expecting
		//data of the length we are about to provide.
		if(response.indexOf("^SISW:") != -1) {
			Application.write(TCPClient.getAvailableData());
		}

		if(response.indexOf("^SISR:") != -1) {
			
		}
		
	}
	
}
