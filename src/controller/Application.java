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
	
	public void connectToPort (String portName) {
		try {
			this.serialInterface.connect(portName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeToPort (String message) {
		// TODO send to log function.
		this.serialInterface.write(message);
	}
	
	public String readFromPort () {
		// TODO send to log function.
		return this.serialInterface.getMostRecentRead();
	}
	
	public void close () {
		this.serialInterface.close();
	}
}
