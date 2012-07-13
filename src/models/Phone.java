/**
 ******************************************************************************
 *                              PhoneCall.java                                *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 5 Jul 2012
 * 
 * (Description)
 */
package models;

import operations.Application;
import views.CallDialog;

public class Phone {
	
	private static String number;
	private static String message;
	private static boolean inCall;
	
	public static boolean isInCall () {
		return inCall;
	}
	
	//Outgoing Call
	public static void dial (String newNumber) {
		number = newNumber;
		inCall = true;
		Application.busy = true;
		Application.write("ATD" + number + ";");
	}
	
	//Incoming call
	public static void answer () {
		if(inCall) {
			hangUp();
		}
		Application.busy = true;
		Application.write("ATA");
		CallDialog.answered();
		inCall = true;
	}
	
	//End the phone call with an ATH, set the busy status and inCall 
	//status to false.
	public static void hangUp () {
		Application.write("ATH");
		Application.busy = false;
		inCall = false;
	}
	
	public static void sendMessage() {
		Application.write(message);
		//Application.write(0x26);
		Application.busy = false;
	}
	
	public static void startSms (String number, String smsMessage) {
		Application.busy = true;
		message = smsMessage;
		Application.write("at+cmgs=\"" + number + "\"");
	}
}
