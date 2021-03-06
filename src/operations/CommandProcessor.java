package operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Phone;
import models.TCPHandler;

import views.CallDialog;
import views.Window;

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


public class CommandProcessor {
	
	private static boolean deviceConnected = false;
	
	/**
	 * Accept an incoming message and perform actions depending on it's 
	 */
	public static void process(String response) {
		
		if(deviceConnected == true) {
			//Extract the service profile.
			Pattern p = Pattern.compile("\\d, \\d, (\\d)");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				String serviceNoStr = m.group(1).trim();
				int serviceNo = Integer.parseInt(serviceNoStr);
				TCPHandler.setCurrentSocket(serviceNo);
			}
			deviceConnected = false;
		}
		
		//If we are dealing with a COPS response
		if(response.indexOf("+COPS") != -1) {
			//Extract the operator name with regex.
			Pattern p = Pattern.compile(".*\\+COPS:.*\"(.+)\"");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				String operator = m.group(1).trim();
				//Set the operator label in the window.
				Window.setOperator(operator);
			}
			
			if(Application.busy) {
				Application.busy = false;
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
			Phone.sendMessage();
		}
		
		//If the device requests a TCP write, get the available data from
		//the TCP client and write it to the device, it should be expecting
		//data of the length we are about to provide.
		if((response.indexOf("^SISW:") != -1 && TCPHandler.writing)) {
			System.out.println("Confirm write");
			TCPHandler.confirmClientWrite();
		}

		if(response.indexOf("^SISR:") != -1){
			
			Pattern p = Pattern.compile(".*\\^SISR:\\s+\"([0-9]*)\".*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if(matchFound) {
				String serviceNumber = m.group(1);
				//Request a read of 1024 bytes.
				Application.write("AT^SISR="+ serviceNumber +",1024");
			}
	
		}
		
		if(response.indexOf("^SIS:") != -1){
			deviceConnected = true;
			//Extract the service profile.
			Pattern p = Pattern.compile(".*^SIS: \\d, \\d, (\\d).*");
			Matcher m = p.matcher(response);
			boolean matchFound = m.find();
			
			if (matchFound) {
				String serviceNoStr = m.group(1).trim();
				int serviceNo = Integer.parseInt(serviceNoStr);
				TCPHandler.setCurrentSocket(serviceNo);
				deviceConnected = false;
			}
			
		}
		
		if(response.indexOf("^SISR:") != -1){
			if(TCPHandler.reading) {
				TCPHandler.reading = false;
			} else {
				TCPHandler.reading = true;
				TCPHandler.read();			
			}
			//Extract the service profile.
		}
		
	}
	
}
