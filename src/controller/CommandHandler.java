package controller;


/**
 ******************************************************************************
 *                                CommandHandler.java                                *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 25 Jun 2012
 * 
 * (Description)
 */
public class CommandHandler extends java.util.ArrayList<Command> {
	
	public void send () {
		String sendData = this.get(this.size() - 1).getSendData();
		 
	}
	
}
