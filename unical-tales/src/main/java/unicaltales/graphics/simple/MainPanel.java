/**
 * 
 */
package unicaltales.graphics.simple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Time;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import unicaltales.businesslogic.core.Sprite;
import unicaltales.businesslogic.draw.Drawer;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * MainPanel of Swing and Awt 2d Simple Graphics implementation
 */
public class MainPanel extends JPanel {
	/**
	 * Sprite drawer component.
	 * It is initializzed dependently by the framework
	 */
	SpriteDraw spriteDraw;
	
	/**
	 * Empty Constructor
	 * @throws InterruptedException - Se non funziona lo sleep
	 */
	public MainPanel() {
		// setto il background
		setBackground(new Color(129, 201, 246));
		
		/*
		 * We create a SpriteDraw.
		 * It draw Sprites, dipendently by the interface we passed from argument
		 */
		spriteDraw = new SpriteDraw(new Drawer() {
			
			@Override
			public void onDrawText(Sprite s, Object drawerComponent) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrawImage(Sprite s, Object drawerComponent) {
				// TODO Auto-generated method stub
				if(drawerComponent instanceof Graphics) {
					Graphics g = (Graphics) drawerComponent;
					g.drawImage(Toolkit.getDefaultToolkit().getImage(s.getPath()), (int) s.getPosition().getX(), (int) s.getPosition().getY(), (int) s.getSize().getWidth(), (int) s.getSize().getHeight(), Color.BLACK, null);
				}
			}
		});
	}
	
	/**
	 * Principal loop of the game. with this function the game became asynchronous
	 * @throws InterruptedException - if there are problems with {@code Thread.sleep(long millis)} 
	 */
	private void loop() throws InterruptedException {
		Thread.sleep((long) 10);
		repaint();
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	int i=0;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics part
		//...
		MyImage prova = new MyImage(0, 0, GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight(), "/home/rodolfo/Scrivania/photo_2018-04-18_16-08-50.jpg");
		spriteDraw.drawImage(prova, g);

		// loop
		try {
			loop();
		} catch (InterruptedException e) {
			System.err.println("Impossibile eseguire il loop dle gioco!");
			e.printStackTrace();
			GlobalValues.EXIT_GAME = true; // STOPPA IL GIOCO
		}
	}
	
	

}
