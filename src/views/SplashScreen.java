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

import javax.swing.*;

class SplashScreen extends JFrame{

	private static final long serialVersionUID = 1L;

		public SplashScreen() {
        	JWindow window = new JWindow();
        	JLabel image = null;
        	
        	image = new JLabel(new ImageIcon(getClass().getResource("/Splash-screen2.png")));

        	image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		