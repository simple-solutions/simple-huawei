package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import events.InterfaceEvents;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent; 

import models.TCPClient;

import operations.Application;
import operations.SerialInterface;


public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static boolean logging;
	private static DefaultListModel cmdList;
	private int commandIndex = 0;
	
	private static JPanel contentPane;
	private static JPanel phoneTab;
	private static JPanel pnlPhoneKeypad;
	private static JPanel pnlWrapper;
	private static JPanel pnlTabs;
	private static JPanel pnlButtonsContainer;
	private static JPanel smsTab;
	private static JPanel pnlPhoneActions;
	private static JLabel lblCharCount;
	private static JPanel tcpTab;
	private static JPanel pnlOptions;
	private static JPanel pnlControls;
	private static JPanel pnlMonitor;
	private static JButton phoneButton1;
	private static JButton phoneButton2;
	private static JButton phoneButton3;
	private static JButton phoneButton4;
	private final JButton phoneButton5;
	private final JButton phoneButton6;
	private final JButton phoneButton7;
	private static JButton phoneButton8;
	private static JButton phoneButton9;
	private static JButton phoneButton0;
	private static JButton btnDial;
	private static JButton btnEnd;
	private static JButton btnSendSms;
	private static JButton btnNewButton;
	private static JLabel lblSignal;
	private static JLabel lblOperator;
	private static JLabel lblCallStatus;
	private static JLabel lblSelectDevice;
	private static JLabel lblMonitor;
	private static JLabel lblCmdDesc;
	private static JLabel lblCommandPreview;
	private static JToggleButton tglLog;
	private static JToggleButton tglConnect;
	private static JTextArea txtAreaMonitor;
	private static JTextArea txtAreaSms;
	private static JScrollPane scrollPane_1;
	private static JTabbedPane tabbedPane;
	private static JTextField txtPhoneDisplay;
	private static JComboBox cmbDevice;
	private static JScrollPane scrollPane;
	private static JProgressBar prgSignal;
	private static JPanel cmdTab;
	public static JList lstCommands;
	private JTextField txtCommandVariables;
	private JTextField txtSmsNumber;
	private JComboBox cmbProtocol;
	private JTextField txtTcpAddress;
	private JTextField txtTcpPort;
	private JTextArea txtTcpMessage;
	private JLabel lblInstructionsQuick;
	
	
	public Window() {
		
		// Get the native look and feel class name
		String nativeLF = UIManager.getSystemLookAndFeelClassName();
		
		@SuppressWarnings("unused")
		SplashScreen sw = new SplashScreen();
		
		// Install the look and feel
		try {
		    UIManager.setLookAndFeel(nativeLF);
		} catch (InstantiationException e) {
		} catch (ClassNotFoundException e) {
		} catch (UnsupportedLookAndFeelException e) {
		} catch (IllegalAccessException e) {
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.
				getResource("/com/sun/java/swing/plaf/windows/icons/" +
						"Computer.gif")));
		setTitle("Huawei Interface");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pnlWrapper = new JPanel();
		pnlWrapper.setLayout(new GridLayout(0, 1, 0, 0));
		
		if(Application.OS_NAME.indexOf("Windows") != -1) {
			
		}
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		pnlOptions = new JPanel();
		pnlWrapper.add(pnlOptions);
		pnlOptions.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnlTabs = new JPanel();
		pnlOptions.add(pnlTabs);
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
		pnlPhoneKeypad.setBounds(0, 0, 245, 198);
		phoneTab.add(pnlPhoneKeypad);
		pnlPhoneKeypad.setLayout(null);
		
		pnlButtonsContainer = new JPanel();
		pnlButtonsContainer.setBackground(SystemColor.control);
		pnlButtonsContainer.setBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null));
		pnlButtonsContainer.setBounds(49, 44, 151, 148);
		pnlPhoneKeypad.add(pnlButtonsContainer);
		pnlButtonsContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		phoneButton1 = new JButton("  1  ");
		phoneButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "1");
			}
		});
		pnlButtonsContainer.add(phoneButton1);
		
		phoneButton2 = new JButton("  2  ");
		phoneButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "2");
			}
		});
		pnlButtonsContainer.add(phoneButton2);
		
		phoneButton3 = new JButton("  3  ");
		phoneButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "3");
			}
		});
		pnlButtonsContainer.add(phoneButton3);
		
		phoneButton4 = new JButton("  4  ");
		phoneButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "4");
			}
			
		});
		pnlButtonsContainer.add(phoneButton4);
		
		phoneButton5 = new JButton("  5  ");
		phoneButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "5");
			}
		});
		pnlButtonsContainer.add(phoneButton5);
		
		phoneButton6 = new JButton("  6  ");
		phoneButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "6");
			}
		});
		pnlButtonsContainer.add(phoneButton6);
		
		phoneButton7 = new JButton("  7  ");
		phoneButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "7");
			}
		});
		pnlButtonsContainer.add(phoneButton7);
		
		phoneButton8 = new JButton("  8  ");
		phoneButton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "8");
			}
		});
		pnlButtonsContainer.add(phoneButton8);
		
		phoneButton9 = new JButton("  9  ");
		phoneButton9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "9");
			}
		});
		pnlButtonsContainer.add(phoneButton9);
		
		phoneButton0 = new JButton("  0  ");
		phoneButton0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "0");
			}
		});
		
		JButton phoneButtonStar = new JButton("   *  ");
		phoneButtonStar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "*");
			}
		});
		pnlButtonsContainer.add(phoneButtonStar);
		pnlButtonsContainer.add(phoneButton0);
		
		JButton phoneButtonHash = new JButton("  #  ");
		phoneButtonHash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneDisplay.setText(txtPhoneDisplay.getText() + "#");
			}
		});
		pnlButtonsContainer.add(phoneButtonHash);
		
		pnlPhoneActions = new JPanel();
		pnlPhoneActions.setBounds(29, 192, 178, 35);
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
						/* MAKE THE CALL */
						InterfaceEvents.dial(txtPhoneDisplay.getText());
					}
				});
				btnEnd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnEnd.setEnabled(false);
						btnDial.setEnabled(true);
						/* END THE CALL */
						InterfaceEvents.hang();
					}
				});
				
				txtPhoneDisplay = new JTextField();
				txtPhoneDisplay.setBounds(49, 12, 151, 27);
				pnlPhoneKeypad.add(txtPhoneDisplay);
				txtPhoneDisplay.setColumns(10);
				
				smsTab = new JPanel();
				tabbedPane.addTab("SMS", null, smsTab, null);
				smsTab.setLayout(null);
				
				lblCharCount = new JLabel("(160 characters left)");
				lblCharCount.setHorizontalAlignment(SwingConstants.CENTER);
				lblCharCount.setForeground(new Color(128, 128, 128));
				lblCharCount.setBounds(12, 189, 220, 15);
				smsTab.add(lblCharCount);
				
		
		btnSendSms = new JButton("Send");
		btnSendSms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceEvents.sendSms(txtSmsNumber.getText(),txtAreaSms.getText());
			}
		});
		btnSendSms.setIcon(new ImageIcon(Window.class.getResource
				("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnSendSms.setBounds(63, 206, 117, 25);
		smsTab.add(btnSendSms);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null));
		scrollPane_1.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 56, 220, 121);
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
		
		txtSmsNumber = new JTextField();
		txtSmsNumber.setBounds(73, 24, 157, 28);
		smsTab.add(txtSmsNumber);
		txtSmsNumber.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.GRAY);
		lblPhone.setBounds(12, 32, 66, 15);
		smsTab.add(lblPhone);
		
		tcpTab = new JPanel();
		tabbedPane.addTab("TCP/UDP", null, tcpTab, null);
		tcpTab.setLayout(null);
		
		cmbProtocol = new JComboBox();
		cmbProtocol.setModel(new DefaultComboBoxModel(new String[] {"TCP", "UDP"}));
		cmbProtocol.setBounds(87, 7, 145, 28);
		tcpTab.add(cmbProtocol);
		
		JLabel lblProtocol = new JLabel("Protocol: ");
		lblProtocol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProtocol.setBounds(12, 12, 75, 18);
		tcpTab.add(lblProtocol);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setViewportBorder(new EtchedBorder(
						EtchedBorder.LOWERED, null, null));
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(12, 134, 220, 70);
		tcpTab.add(scrollPane_3);
		
		txtTcpMessage = new JTextArea();
		scrollPane_3.setViewportView(txtTcpMessage);
		
		//scrollPane_3.setViewportView();
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(12, 42, 70, 18);
		tcpTab.add(lblAddress);
		
		JLabel lblPort = new JLabel("Port: ");
		lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPort.setBounds(12, 72, 70, 18);
		tcpTab.add(lblPort);
		
		txtTcpAddress = new JTextField();
		txtTcpAddress.setBounds(87, 37, 145, 28);
		tcpTab.add(txtTcpAddress);
		txtTcpAddress.setColumns(10);
		
		txtTcpPort = new JTextField();
		txtTcpPort.setColumns(10);
		txtTcpPort.setBounds(87, 67, 145, 28);
		tcpTab.add(txtTcpPort);
		
		JButton btnTcpSend = new JButton("Send");
		btnTcpSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = txtTcpMessage.getText();
				InterfaceEvents.sendTcpMessage(message);
			}
		});
		btnTcpSend.setIcon(new ImageIcon(Window.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnTcpSend.setBounds(75, 212, 96, 30);
		tcpTab.add(btnTcpSend);
		
		JToggleButton tglClient = new JToggleButton("TCP Client");
		tglClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String address =  txtTcpAddress.getText();
				String portStr = txtTcpPort.getText();
				System.out.println("THIS PORT (str): " + portStr);
				int port = 0;
				try {
					port = Integer.parseInt(txtTcpPort.getText());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println("THIS PORT: " + portStr);
				InterfaceEvents.toggleTCPHandler(address, port);
			}
		});
		tglClient.setBounds(12, 102, 96, 30);
		tcpTab.add(tglClient);
		
		JToggleButton tglServer = new JToggleButton("TCP Server");
		tglClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tglServer.setBounds(111, 102, 121, 30);
		tcpTab.add(tglServer);
		//Disable all children of the initial tab
		Component[] com = pnlButtonsContainer.getComponents();
		txtPhoneDisplay.setEnabled(false);
		btnDial.setEnabled(false);
		btnEnd.setEnabled(false);
		
		lblCallStatus = new JLabel("Waiting...");
		lblCallStatus.setBounds(86, 227, 70, 15);
		phoneTab.add(lblCallStatus);
		lblCallStatus.setForeground(new Color(128, 128, 128));
		
		cmdTab = new JPanel();
		tabbedPane.addTab("Command", null, cmdTab, null);
		cmdTab.setLayout(null);
		
		
		cmdList = new DefaultListModel();
		lstCommands = new JList(cmdList);
		lstCommands.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lstCommands.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				commandIndex = arg0.getFirstIndex();
				System.out.println(commandIndex);
				InterfaceEvents.getCommandPreview(commandIndex, 
						txtCommandVariables.getText());
				
			}
		});
		lstCommands.setBounds(12, 6, 221, 172);

		JScrollPane scrollPane_2 = new JScrollPane(lstCommands);
		scrollPane_2.setBounds(12, 6, 221, 82);
		cmdTab.add(scrollPane_2);
		

		
		lblCmdDesc = new JLabel("No command set.");
		lblCmdDesc.setForeground(Color.GRAY);
		lblCmdDesc.setVerticalAlignment(SwingConstants.TOP);
		lblCmdDesc.setBounds(12, 172, 221, 59);
		cmdTab.add(lblCmdDesc);
		
		btnNewButton = new JButton("Send Command");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceEvents.sendCommand(commandIndex, Application.commands[commandIndex].template(txtCommandVariables.getText()));
			}
		});
		
		btnNewButton.setBounds(12, 138, 221, 25);
		cmdTab.add(btnNewButton);
		
		txtCommandVariables = new JTextField();
		txtCommandVariables.setBounds(12, 110, 221, 27);
		cmdTab.add(txtCommandVariables);
		txtCommandVariables.setColumns(10);
		
		lblCommandPreview = new JLabel("Command preview...");
		lblCommandPreview.setBounds(12, 92, 214, 15);
		cmdTab.add(lblCommandPreview);
		
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
		tglLog.setIcon(new ImageIcon(Window.class.getResource
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
		tglConnect.setIcon(new ImageIcon(Window.class.getResource
				("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		tglConnect.setBounds(12, 104, 142, 28);
		pnlControls.add(tglConnect);
		
		lblSelectDevice = new JLabel("Select port:");
		lblSelectDevice.setBounds(12, 60, 105, 15);
		pnlControls.add(lblSelectDevice);
		tglConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//If the connection button is down.
				if(tglConnect.isSelected()) {
					
					String portName = (String)cmbDevice.getSelectedItem();
					events.InterfaceEvents.connect(portName);
					
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
					
				} else {
					
					/********************************************
					 *         DISCONNECT FROM THE PORT         *
					 ********************************************/
					//If the button is already down, disconnect
					try {
						
						/*
						 * CODE FOR DISCONNECTING TO THE PORT GOES HERE
						 */
						events.InterfaceEvents.close();
						
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
		lblSignal.setEnabled(false);
		lblOperator.setEnabled(false);
		prgSignal.setEnabled(false);
		
		lblInstructionsQuick = new JLabel("Instructions & Quick Start");
		lblInstructionsQuick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstructionsQuick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
    	            java.net.URI uri = new java.net.URI("http://simple-solutions.github.com/SimpleHuawei");
					desktop.browse( uri );
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		lblInstructionsQuick.setForeground(UIManager.getColor("MenuItem.selectionBackground"));
		lblInstructionsQuick.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblInstructionsQuick.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructionsQuick.setBounds(12, 144, 225, 18);
		pnlControls.add(lblInstructionsQuick);
		
		pnlMonitor = new JPanel();
		pnlWrapper.add(pnlMonitor);
		pnlMonitor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, 
				null, null));
		pnlMonitor.setLayout(null);
		
		lblMonitor = new JLabel("Monitor");
		lblMonitor.setBounds(220, 12, 70, 15);
		pnlMonitor.add(lblMonitor);
		
		txtAreaMonitor = new JTextArea();
		txtAreaMonitor.setFont(new Font("Monospaced", Font.PLAIN, 10));
		scrollPane = new JScrollPane(txtAreaMonitor);
		scrollPane.setSize(476, 281);
		scrollPane.setLocation(12, 27);
		pnlMonitor.add(scrollPane);
		txtAreaMonitor.setDropMode(DropMode.INSERT);
		
		txtAreaMonitor.setEditable(false);
		txtAreaMonitor.setBounds(12, 27, 183, 109);
		contentPane.add(pnlWrapper);
		
		
		/********************************************
		 *      CLICK ON THE CONNECT BUTTON         *
		 ********************************************/
		
		/********************************************
		 *         CLICK ON THE LOG BUTTON          *
		 ********************************************/
		
		
		/*************************************
		 *   INITIAL DISABLE OF PHONE TAB    *
		 *************************************/
		for (int a = 0; a < com.length; a++) {
		     com[a].setEnabled(false);
		}
		
		
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
		        		SerialInterface.close();
		        		TCPClient.stop();
		        	}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});

	}
	
	/********************************************************
	 ********************************************************
	 ********* E N D   O F   C O N S T R U C T O R **********
	 ********************************************************
	 ********************************************************/
	
	public static void setCommandDescription (String description) {
		lblCmdDesc.setText("<html><p>" + description + "</p></html>");
	}
	
	public static void setCommandPreview (String preview) {
		lblCommandPreview.setText("<html><p>"+ preview +"</p></html>");
	}
	
	public static void listCommand(String command) {
		cmdList.addElement(command);
	}
	
	public static void listDevice(String device) {
        cmbDevice.addItem(device);
	}
	
	public static void setSignal (int signal) {
		prgSignal.setValue(signal);
	}
	
	public static void setOperator (String operator) {
		lblOperator.setText("Operator: " + operator);
	}
	
	public static void writeToMonitor (String message) {
		if(logging) {
			//Write to file as well as monitor
		}
		txtAreaMonitor.setText(txtAreaMonitor.getText() + message + "\n");
	}
}
