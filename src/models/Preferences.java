/**
 ******************************************************************************
 *                                Preferences.java                                *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 23 Jul 2012
 * 
 * (Description)
 */
package models;

/**
 * @author simple-developer
 *
 */
public class Preferences {

	/**
	 * PREFERENCE SETTINGS
	 * Phone number
	 * SMS phone number
	 * TCP port
	 * TCP address
	 */
	
	private String phoneNumber;
	private String smsPhoneNumber;
	private int tcpPort;
	private int tcpAddress;
	
	/**
	 * @param phoneNumber
	 * @param smsPhoneNumber
	 * @param tcpPort
	 * @param tcpAddress
	 */
	public Preferences(String phoneNumber, String smsPhoneNumber, int tcpPort,
			int tcpAddress) {
		this.phoneNumber = phoneNumber;
		this.smsPhoneNumber = smsPhoneNumber;
		this.tcpPort = tcpPort;
		this.tcpAddress = tcpAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the smsPhoneNumber
	 */
	public String getSmsPhoneNumber() {
		return smsPhoneNumber;
	}

	/**
	 * @param smsPhoneNumber the smsPhoneNumber to set
	 */
	public void setSmsPhoneNumber(String smsPhoneNumber) {
		this.smsPhoneNumber = smsPhoneNumber;
	}

	/**
	 * @return the tcpPort
	 */
	public int getTcpPort() {
		return tcpPort;
	}

	/**
	 * @param tcpPort the tcpPort to set
	 */
	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}

	/**
	 * @return the tcpAddress
	 */
	public int getTcpAddress() {
		return tcpAddress;
	}

	/**
	 * @param tcpAddress the tcpAddress to set
	 */
	public void setTcpAddress(int tcpAddress) {
		this.tcpAddress = tcpAddress;
	}
	
	

	
}
