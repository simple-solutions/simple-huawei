package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class HuaweiWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuaweiWindow frame = new HuaweiWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HuaweiWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlMonitor = new JPanel();
		contentPane.add(pnlMonitor, BorderLayout.SOUTH);
		pnlMonitor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlMonitor.add(scrollPane);
		
		JTextArea txtAreaMonitor = new JTextArea();
		txtAreaMonitor.setRows(4);
		txtAreaMonitor.setText("Hello world");
		txtAreaMonitor.setWrapStyleWord(true);
		scrollPane.setViewportView(txtAreaMonitor);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabPhone = new JPanel();
		tabbedPane.addTab("Phone", null, tabPhone, null);
		
		JPanel tabSms = new JPanel();
		tabbedPane.addTab("SMS", null, tabSms, null);
		
		JPanel tabTcp = new JPanel();
		tabbedPane.addTab("TCP/UDP", null, tabTcp, null);
		
		JPanel pnlOptions = new JPanel();
		contentPane.add(pnlOptions, BorderLayout.EAST);
		pnlOptions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox cmbDevice = new JComboBox();
		pnlOptions.add(cmbDevice);
		
		JToggleButton btnConnect = new JToggleButton("Connect");
		pnlOptions.add(btnConnect);
	}

}
