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

public class Phone {
	
	private static String number;
	private static boolean inCall;
	
	public static boolean isInCall () {
		return inCall;
	}
	
	//Outgoing Call
	public static void dial (String newNumber) {
		number = newNumber;
		inCall = true;
		Application.write("ATD" + number + ";");
	}
	
	//Incoming call
	public static void answer () {
		if(inCall) {
			hangUp();
		}
		Application.write("ATA");
		inCall = true;
	}
	
	public static void hangUp () {
		Application.write("ATH");
		inCall = false;
	}
	
}
