/**
 ******************************************************************************
 *                            StatusRequester.java                            *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 11 Jul 2012
 * 
 * Sends a status request command to the device at a interval
 * defined in the constructor.
 */
package operations;

import views.Window;

public class StatusRequester implements Runnable {
	private String command;
	private int interval;
	
	//Make a status request with the command at the interval time.
	public StatusRequester (String command, int interval) {
		this.command = command;
		this.interval = interval;
	}
	
	public void run() {
		//Keep going while the app is connected.
		while(true) {
			try {
				//If we are connected to a device and the app not busy.
				if(Application.connected && !Application.busy) {
					//Let the user know that this command is a status request.
					Window.writeToMonitor("LOG: Status request.");
					//Write our command.
					Application.write(this.command);
				}
				//Sleep until our next interval.
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(!Application.connected) {
				break;
			}
		}
	}
	
}