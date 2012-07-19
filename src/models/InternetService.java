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
	
	public static void start () {
		//Starts the service.
		Application.write("at^siso=" + serviceNumber);	
	}
	
	public static void stop () {
		Application.write("AT^SISC=" + serviceNumber);
	}
	
}
