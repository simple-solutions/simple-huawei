/**
 ******************************************************************************
 *                              SpashScreen.java                              *
 ****************************************************************************** 
 * (Overview)
 * 
 *  @author simple-developer
 *  @since 13 Jul 2012
 * 
 * (Description)
 */
package views;

import javax.swing.JWindow;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

class SplashScreen extends JFrame{

	private static final long serialVersionUID = 1L;

		public SplashScreen() {
        	JWindow window = new JWindow();
        	JLabel image = new JLabel(new ImageIcon("model/Splash-screen2.png"));
        	image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	
            
            image.addMouseListener(new MouseAdapter() {
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
            
            
            
            
        	//window.getContentPane().setLayout(null);
        	
        	window.getContentPane().add(image);
        	
        	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	window.setBounds(screenSize.width / 2 - 250, screenSize.height / 2 - 150, 500, 300);
        	
        	
        	window.setVisible(true);
        	try {
        		Thread.sleep(5000);
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        	window.setVisible(false);
        	window.dispose();

        }
}
		