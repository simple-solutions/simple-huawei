package view;

import gnu.io.CommPortIdentifier;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class HuaweiWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean logging;

	private final JPanel contentPane;
	private final JPanel phoneTab;
	private final JPanel pnlPhoneKeypad;
	private final JPanel pnlWrapper;
	private final JPanel pnlTabs;
	private final JPanel pnlButtonsContainer;
	private final JPanel smsTab;
	private final JPanel pnlPhoneActions;
	private final JLabel lblCharCount;
	private final JPanel tcpTab;
	private final JPanel pnlOptions;
	private final JPanel pnlControls;
	private final JPanel pnlMonitor;
	
	
	
	
	private final JButton phoneButton1;
	private final JButton phoneButton2;
	private final JButton phoneButton3;
	private final JButton phoneButton4;
	private final JButton phoneButton5;
	private final JButton phoneButton6;
	private final JButton phoneButton7;
	private final JButton phoneButton8;
	private final JButton phoneButton9;
	private final JButton phoneButton0;
	private final JButton btnDial;
	private final JButton btnEnd;
	private final JButton btnSendSms;
	private final JLabel lblSignal;
	private final JLabel lblOperator;
	private final JLabel lblCallStatus;
	private final JLabel lblSelectDevice;
	private final JLabel lblMonitor;
	private final JToggleButton tglLog;
	private final JToggleButton tglConnect;
	private final JTextArea txtAreaMonitor;
	private final JTextArea txtAreaSms;
	
	private final JScrollPane scrollPane_1;
	private final JTabbedPane tabbedPane;
	private final JTextField txtPhoneDisplay;
	
	private final JComboBox cmbDevice;
	
	
	private final JScrollPane scrollPane;
	private final JProgressBar prgSignal;
	
	public HuaweiWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HuaweiWindow.class.
				getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Huawei Interface");
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pnlWrapper = new JPanel();
		pnlWrapper.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnlTabs = new JPanel();
		pnlWrapper.add(pnlTabs);
		pnlTabs.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		pnlTabs.add(tabbedPane);
		
		phoneTab = new JPanel();
		tabbedPane.addTab("Phone", null, phoneTab, null);
		phoneTab.setLayout(null);
		
		pnlPhoneKeypad = new JPanel();
		pnlPhoneKeypad.setBackground(SystemColor.menu);
		pnlPhoneKeypad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, 
				null, null));
		pnlPhoneKeypad.setBounds(0, 0, 245, 187);
		phoneTab.add(pnlPhoneKeypad);
		pnlPhoneKeypad.setLayout(null);
		
		pnlButtonsContainer = new JPanel();
		pnlButtonsContainer.setBackground(SystemColor.control);
		pnlButtonsContainer.setBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null));
		pnlButtonsContainer.setBounds(39, 50, 174, 125);
		pnlPhoneKeypad.add(pnlButtonsContainer);
		pnlButtonsContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		phoneButton1 = new JButton("1");
		phoneButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "1");
			}
		});
		pnlButtonsContainer.add(phoneButton1);
		
		phoneButton2 = new JButton("2");
		phoneButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "2");
			}
		});
		pnlButtonsContainer.add(phoneButton2);
		
		phoneButton3 = new JButton("3");
		phoneButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "3");
			}
		});
		pnlButtonsContainer.add(phoneButton3);
		
		phoneButton4 = new JButton("4");
		phoneButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "4");
			}
			
		});
		pnlButtonsContainer.add(phoneButton4);
		
		phoneButton5 = new JButton("5");
		phoneButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "5");
			}
		});
		pnlButtonsContainer.add(phoneButton5);
		
		phoneButton6 = new JButton("6");
		phoneButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "6");
			}
		});
		pnlButtonsContainer.add(phoneButton6);
		
		phoneButton7 = new JButton("7");
		phoneButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "7");
			}
		});
		pnlButtonsContainer.add(phoneButton7);
		
		phoneButton8 = new JButton("8");
		phoneButton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "8");
			}
		});
		pnlButtonsContainer.add(phoneButton8);
		
		phoneButton9 = new JButton("9");
		phoneButton9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "9");
			}
		});
		pnlButtonsContainer.add(phoneButton9);
		
		phoneButton0 = new JButton("0");
		phoneButton0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "0");
			}
		});
		pnlButtonsContainer.add(phoneButton0);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
				
		pnlPhoneActions = new JPanel();
		pnlPhoneActions.setBounds(34, 213, 178, 35);
		phoneTab.add(pnlPhoneActions);
		
		btnDial = new JButton("Dial");
		
		btnDial.setIcon(new ImageIcon("/home/simple-developer/projects/" +
				"software/Huawei_GUI/img/call.png"));
		btnDial.setToolTipText("Dial a telephone number");
		pnlPhoneActions.add(btnDial);
		
		btnEnd = new JButton("End");
		btnEnd.setIcon(new ImageIcon("/home/simple-developer/projects/" +
				"software/Huawei_GUI/img/end.png"));
		btnEnd.setToolTipText("End the current call");
		btnEnd.setEnabled(false);
		pnlPhoneActions.add(btnEnd);
		
		btnDial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEnd.setEnabled(true);
				btnDial.setEnabled(false);
			}
		});
		btnEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEnd.setEnabled(false);
				btnDial.setEnabled(true);
			}
		});
		
		lblCallStatus = new JLabel("Waiting...");
		lblCallStatus.setForeground(new Color(128, 128, 128));
		lblCallStatus.setBounds(91, 199, 70, 15);
		phoneTab.add(lblCallStatus);
		
		txtPhoneDisplay = new JTextField();
		txtPhoneDisplay.setBounds(39, 12, 174, 27);
		pnlPhoneKeypad.add(txtPhoneDisplay);
		txtPhoneDisplay.setColumns(10);
		
		smsTab = new JPanel();
		tabbedPane.addTab("SMS", null, smsTab, null);
		smsTab.setLayout(null);
		
		lblCharCount = new JLabel("(160 characters left)");
		lblCharCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharCount.setForeground(new Color(128, 128, 128));
		lblCharCount.setBounds(12, 188, 220, 15);
		smsTab.add(lblCharCount);
				
		
		btnSendSms = new JButton("Send");
		btnSendSms.setIcon(new ImageIcon(HuaweiWindow.class.getResource
				("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnSendSms.setBounds(63, 215, 117, 25);
		smsTab.add(btnSendSms);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null));
		scrollPane_1.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 12, 220, 164);
		smsTab.add(scrollPane_1);
		
		txtAreaSms = new JTextArea();
		txtAreaSms.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String smsText = txtAreaSms.getText();
				int smsLength = smsText.length();
				if(smsLength > 160) {
					txtAreaSms.setText(smsText.substring(0, 159));
				} else {
					lblCharCount.setText("(" + (160 - smsLength) + 
							" characters left)");
				}
			}
		});
		scrollPane_1.setViewportView(txtAreaSms);
		
		tcpTab = new JPanel();
		tabbedPane.addTab("TCP/UDP", null, tcpTab, null);
		
		pnlOptions = new JPanel();
		pnlWrapper.add(pnlOptions);
		pnlOptions.setLayout(new GridLayout(2, 1, 0, 0));
		
		pnlControls = new JPanel();
		pnlControls.setBorder(new EtchedBorder(EtchedBorder.LOWERED, 
				null, null));
		pnlOptions.add(pnlControls);
		pnlControls.setLayout(null);
		
		cmbDevice = new JComboBox();
		cmbDevice.setModel(new DefaultComboBoxModel());
		cmbDevice.setBounds(12, 78, 225, 27);
		pnlControls.add(cmbDevice);
		
		tglLog = new JToggleButton("Log");
		tglLog.setIcon(new ImageIcon(HuaweiWindow.class.getResource
				("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		tglLog.setBounds(153, 104, 84, 28);
		pnlControls.add(tglLog);
		
		prgSignal = new JProgressBar();
		prgSignal.setForeground(new Color(102, 204, 0));
		prgSignal.setStringPainted(true);
		prgSignal.setBounds(62, 12, 175, 14);
		pnlControls.add(prgSignal);
		
		lblSignal = new JLabel("Signal:");
		lblSignal.setBounds(12, 12, 70, 15);
		pnlControls.add(lblSignal);
		
		lblOperator = new JLabel("Operator: None");
		lblOperator.setBounds(12, 30, 225, 15);
		pnlControls.add(lblOperator);
		
		tglConnect = new JToggleButton("Connect");
		tglConnect.setIcon(new ImageIcon(HuaweiWindow.class.getResource
				("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		tglConnect.setBounds(12, 104, 142, 28);
		pnlControls.add(tglConnect);
		
		lblSelectDevice = new JLabel("Select port:");
		lblSelectDevice.setBounds(12, 60, 105, 15);
		pnlControls.add(lblSelectDevice);
		
		pnlMonitor = new JPanel();
		pnlMonitor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, 
				null, null));
		pnlOptions.add(pnlMonitor);
		pnlMonitor.setLayout(null);
		
		lblMonitor = new JLabel("Monitor");
		lblMonitor.setBounds(101, 5, 70, 15);
		pnlMonitor.add(lblMonitor);
		
		txtAreaMonitor = new JTextArea();
		scrollPane = new JScrollPane(txtAreaMonitor);
		scrollPane.setSize(225, 117);
		scrollPane.setLocation(12, 27);
		pnlMonitor.add(scrollPane);
		txtAreaMonitor.setDropMode(DropMode.INSERT);
		
		txtAreaMonitor.setEditable(false);
		txtAreaMonitor.setBounds(12, 27, 183, 109);
		contentPane.add(pnlWrapper);
		
		
		/********************************************
		 *      CLICK ON THE CONNECT BUTTON         *
		 ********************************************/
		tglConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//If the connection button is down.
				if(tglConnect.isSelected()) {
					
					/********************************************
					 *            CONNECT TO THE PORT           *
					 ********************************************/
					try {
						//Get the name of the port from the combo box.
						String portName = (String)cmbDevice.getSelectedItem();
						
						/*
						 * CODE FOR CONNECTING TO THE PORT GOES HERE
						 */
						
						tabbedPane.setEnabled(true);
						//Enable all children of the initial tab
						Component[] com = pnlButtonsContainer.getComponents();
						for (int a = 0; a < com.length; a++) {
						     com[a].setEnabled(true);
						}
						txtPhoneDisplay.setEnabled(true);
						btnDial.setEnabled(true);
						lblSignal.setEnabled(true);
						lblOperator.setEnabled(true);
						prgSignal.setEnabled(true);
						
						tglConnect.setText("Disconnect");
						cmbDevice.setEnabled(false);

					} catch(Exception ex) {

						tglConnect.setSelected(false);
						//Display message about not being able to connect
					}
					
				} else {
					
					/********************************************
					 *         DISCONNECT FROM THE PORT         *
					 ********************************************/
					//If the button is already down, disconnect
					try {
						
						/*
						 * CODE FOR DISCONNECTING TO THE PORT GOES HERE
						 */
						
						//Disable the tab control
						tabbedPane.setEnabled(false);
						//Disable all children of the initial tab
						Component[] com = pnlButtonsContainer.getComponents();
						for (int a = 0; a < com.length; a++) {
						     com[a].setEnabled(false);
						}
						//Disable the rest of the components
						txtPhoneDisplay.setEnabled(false);
						btnDial.setEnabled(false);
						btnEnd.setEnabled(false);
						lblSignal.setEnabled(false);
						lblOperator.setEnabled(false);
						prgSignal.setEnabled(false);
						//Move back to initial tab
						tabbedPane.setSelectedIndex(0);
						
						//Reset the text on the button.
						tglConnect.setText("Connect");
						cmbDevice.setEnabled(true);
						
					} catch(Exception ex) {
						//Display successful disconnect message
					}
					
				}
				
			}
		});
		
		/********************************************
		 *         CLICK ON THE LOG BUTTON          *
		 ********************************************/
		tglLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglLog.isSelected()) {
					logging = false;
				} else {
					logging = true;
				}
			}
		});
		
		
		/*************************************
		 *   INITIAL DISABLE OF PHONE TAB    *
		 *************************************/
		//Disable all children of the initial tab
		Component[] com = pnlButtonsContainer.getComponents();
		for (int a = 0; a < com.length; a++) {
		     com[a].setEnabled(false);
		}
		txtPhoneDisplay.setEnabled(false);
		btnDial.setEnabled(false);
		btnEnd.setEnabled(false);
		lblSignal.setEnabled(false);
		lblOperator.setEnabled(false);
		prgSignal.setEnabled(false);
		
		
		/********************************************
		 *               SHUTDOWN HOOK              *
		 ********************************************/
		//On window exit, try to close the serial connection.
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
		    @Override
		    public void run()
		    {
		        try {
		        	//Only try to disconnect if the app is
		        	//currently connected.
		        	if(!tglConnect.isEnabled()) {
		        		
		        	}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});
		
		
		/********************************************
		 *            LIST AVAILABLE PORTS          *
		 ********************************************/
		java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
		ArrayList<String> devices = new ArrayList<String>();
		//Create the list of devices
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            devices.add(portIdentifier.getName());
        }
        //Then add them in reverse order to the combo box.
        for(int i = devices.size() - 1; i >= 0; i--) {
        	cmbDevice.addItem(devices.get(i));
        }

	}
	
	/********************************************************
	 ********************************************************
	 ********* E N D   O F   C O N S T R U C T O R **********
	 ********************************************************
	 ********************************************************/
	
	public void updateSignal (int signal) {
		prgSignal.setValue(signal);
	}
	
	public void writeToMonitor (String message) {
		if(logging) {
			//Write to file as well as monitor
		}
		txtAreaMonitor.setText(txtAreaMonitor.getText() + message);
	}

}
