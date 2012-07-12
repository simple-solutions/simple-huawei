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
	
	public StatusRequester (String command, int interval) {
		this.command = command;
		this.interval = interval;
	}
	
	public void run() {
		while(true) {
			try {
				if(Application.connected && !Application.busy) {
					Window.writeToMonitor("LOG: Status request.");
					Application.write(this.command);
				}
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