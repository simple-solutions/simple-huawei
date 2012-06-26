package controller;

/**
 ******************************************************************************
 *                                  Init.java                                 *
 ****************************************************************************** 
 * Starts the application class.
 * 
 *  @author simple-developer
 *  @since 26 Jun 2012
 * 
 * Provides a static start point for the application class.
 */
public class Init {
	public static void main (String[] args) {
		Application app = new Application();
		app.connectToPort("/dev/ttyS0");
		app.writeToPort("at+csq");
		System.out.println("Read Data:" + app.readFromPort());
		app.close();
	}
}
