package controller;
/**
 ******************************************************************************
 *                                APPLICATION                                 *
 ****************************************************************************** 
 * Provides interaction between the model and the view.
 * 
 *  @author simple-developer
 *  @since 25.06.2012
 * 
 * This is the main class that will control the other aspects of application.
 */

/**
 * An application
 * @author simple-developer
 *
 */
public class Application {
	private SerialInterface serialInterface;
	
	public Application () {
		this.serialInterface = new SerialInterface();
				
	}
	
	public void phoneCall (String number) {
		this.serialInterface.write("AT phone home" + number);
	}
	
	public void sendSms (String number, String message) {
		if(message.length() < 160) {
			this.serialInterface.write("AT sms" + number + message);
		}
	}
}
