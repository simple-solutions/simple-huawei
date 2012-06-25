package controller;

import sun.misc.Regexp;

/**
 ******************************************************************************
 *                                Command.java                                *
 ****************************************************************************** 
 * A class that holds the message and expected response template for a command.
 * 
 *  @author simple-developer
 *  @since 25 Jun 2012
 * 
 * TODO (Description)
 */

public class Command {
	private final String sendData;
	private final String respRegexStr;
	
	public Command (String sendData, String regexStr) {
		this.sendData = sendData;
		this.respRegexStr = regexStr;
	}
	
	public String getSendData () {
		return this.sendData;
	}
	
	public boolean validateResponse (String responseStr) {
		return responseStr.matches(this.respRegexStr);
	}
}
