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
	
	protected int serviceNumber;
	protected boolean started;
	
	public void start () {
		//Starts the service.
		Application.write("at^siso=" + this.serviceNumber);
		System.out.println("Service " + this.serviceNumber + " is started.");
		started = true;
	}
	
	public void stop () {
		Application.write("AT^SISC=" + this.serviceNumber);
		System.out.println("Service " + this.serviceNumber + " is stopped.");
		started = false;
	}
	
	public boolean isStarted () {
		System.out.println("Service " + this.serviceNumber + " is started: " + started);
		return false;
		//return started;
	}
	
}
