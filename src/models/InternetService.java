/**
 ******************************************************************************
 *                             InternetService.java                           *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 19 Jul 2012
 * 
 * (Description)
 */
package models;

import operations.Application;

/**
 * @author simple-developer
 *
 */
public abstract class InternetService {
	
	protected static int serviceNumber;
	protected static boolean started;
	
	public static void start () {
		//Starts the service.
		Application.write("at^siso=" + serviceNumber);
		System.out.println("Service " + serviceNumber + " is started.");
		started = true;
	}
	
	public static void stop () {
		Application.write("AT^SISC=" + serviceNumber);
		System.out.println("Service " + serviceNumber + " is stopped.");
		started = false;
	}
	
	public static boolean isStarted () {
		return started;
	}
	
}
