/**
 * 
 */
package unicaltales.graphics.simple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.JFrame;

import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * Main Frame of Swing and Awt 2d Simple Graphics implementation
 */
public class MainFrame extends JFrame{
	
	/**
	 * Empty Constructor
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(GlobalValues.WINDOW_TITLE);
		// prendo le dimensioni dello schermo
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // screen size
		// se imposto fullscreen
		if(GlobalValues.FULL_SCREEN) {
			// setto la size window con le dimensioni dello schermo
			GlobalValues.SIZE_WINDOW.setWidth((float) screenSize.getWidth());
			GlobalValues.SIZE_WINDOW.setHeight((float) screenSize.getHeight());
			// setto la finestra
			setSize(screenSize);
			setLocation(0, 0);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setUndecorated(true);
		}
		// se non imposto fullscreen
		else {
			int tempWindowWidth = (int) GlobalValues.SIZE_WINDOW.getWidth();
			int tempWindowHeight = (int) GlobalValues.SIZE_WINDOW.getHeight();
			setSize(tempWindowWidth, tempWindowHeight);
			// la posiziono al centro
			setLocation((int) (screenSize.getWidth() - tempWindowWidth)/2, 
					    (int) (screenSize.getHeight() - tempWindowHeight)/2);
			setResizable(GlobalValues.RESIZABLE);
		}

		/*
		 * Setto il pannello di gioco del progetto.
		 */
		setContentPane(new MainPanel());
		
	}
}
