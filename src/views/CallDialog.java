/**
 ******************************************************************************
 *                              CallDialog.java                               *
 ******************************************************************************
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 5 Jul 2012
 * 
 * (Description)
 */
package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import operations.Application;

import models.Phone;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CallDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JLabel lblCallStatus;
	private static JLabel lblNumber;
	private static JPanel buttonPane;
	private static JButton btnAnswer;
	private static JButton btnEndCall;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Get the native look and feel class name
		String nativeLF = UIManager.getSystemLookAndFeelClassName();

		// Install the look and feel
		try {
		    UIManager.setLookAndFeel(nativeLF);
		} catch (InstantiationException e) {
		} catch (ClassNotFoundException e) {
		} catch (UnsupportedLookAndFeelException e) {
		} catch (IllegalAccessException e) {
		}
		
		try {
			CallDialog dialog = new CallDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CallDialog() {
		setTitle("Phone");
		setBounds(100, 100, 389, 159);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCallStatus = new JLabel("");
		lblCallStatus.setForeground(Color.GRAY);
		lblCallStatus.setBounds(129, 12, 115, 15);
		contentPanel.add(lblCallStatus);
		
		lblNumber = new JLabel();
		lblNumber.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setBounds(12, 26, 365, 55);
		contentPanel.add(lblNumber);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnAnswer = new JButton("Answer Call");
			btnAnswer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Phone.answer();
				}
			});
			btnAnswer.setActionCommand("Cancel");
			buttonPane.add(btnAnswer);
			{
				btnEndCall = new JButton("End Call");
				btnEndCall.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(Phone.isInCall()) {
							Phone.hangUp();
						}
						Application.callDialog.setVisible(false);
					}
				});
				btnEndCall.setActionCommand("Cancel");
				buttonPane.add(btnEndCall);
			}
		}
	}
	
	public static void incomingCall (String number) {
		lblCallStatus.setText("Incoming call.");
		lblNumber.setText(number);
		btnAnswer.setEnabled(true);
		btnEndCall.setEnabled(false);
	}
	
	public static void outgoingCall (String number) {
		lblCallStatus.setText("Outgoing call.");
		lblNumber.setText(number);
		btnAnswer.setEnabled(false);
		btnEndCall.setEnabled(true);
	}
	
	public static void answered () {
		lblCallStatus.setText("Call in progress.");
		btnAnswer.setEnabled(false);
		btnEndCall.setEnabled(true);
	}
	
	public static void ended () {
		lblCallStatus.setText("Call ended.");
		btnAnswer.setEnabled(false);
		btnEndCall.setEnabled(false);
	}
	
	
}
