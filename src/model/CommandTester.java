/**
 ******************************************************************************
 *                                CommandTester.java                                *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 29 Jun 2012
 * 
 * (Description)
 */
package model;

/**
 * @author simple-developer
 *
 */
public class CommandTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Command comm = new Command("sms","????@ msg@","Sends an SMS with a number in the first template spot and a message in the second.");
		System.out.println(comm.template("01539431017,This is an SMS message"));
		
	}

}
