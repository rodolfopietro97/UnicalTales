/**
 * Package of swing/awt implementation 
 */
package it.unicaltales.swingawt;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * Main Frame of Swing and Awt 2d Simple Graphics implementation
 */
public class MainFrame extends JFrame{
	
	/**
	 * Empty Constructor
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(GlobalValues.WINDOW_TITLE);
		// get size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // screen size
		// if I set fullScreen
		if(GlobalValues.FULL_SCREEN) {
			// set size window as screen size
			GlobalValues.SIZE_WINDOW.setWidth((float) screenSize.getWidth());
			GlobalValues.SIZE_WINDOW.setHeight((float) screenSize.getHeight());
			// set window
			setSize(screenSize);
			setLocation(0, 0);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setUndecorated(true);
		}
		// if I don't set fullScreen
		else {
			int tempWindowWidth = (int) GlobalValues.SIZE_WINDOW.getWidth();
			int tempWindowHeight = (int) GlobalValues.SIZE_WINDOW.getHeight();
			setSize(tempWindowWidth, tempWindowHeight);
			// Put it in the centre
			setLocation((int) (screenSize.getWidth() - tempWindowWidth)/2, 
					    (int) (screenSize.getHeight() - tempWindowHeight)/2);
			setResizable(GlobalValues.RESIZABLE);
			setMinimumSize(new Dimension((int) GlobalValues.MIN_SIZE_WINDOW.getWidth(),(int) GlobalValues.MIN_SIZE_WINDOW.getHeight()));

		}

		/*
		 *  set game panel of the project
		 */
		MainPanel gamePanel = new MainPanel();
		gamePanel.setFocusable(true);
		setContentPane(gamePanel);
		
	}
	
	public static void main(String[] args) {
		GlobalValues.IMPLEMENTATION = GlobalValues.SWING_AWT_IMPLEMENTATION;
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
}