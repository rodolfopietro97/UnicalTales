/**
 * 
 */
package unicaltales.graphics.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Time;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import unicaltales.businesslogic.core.GameObject;
import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.core.Sprite;
import unicaltales.businesslogic.core.player.Player;
import unicaltales.businesslogic.draw.Drawer;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * MainPanel of Swing and Awt 2d Simple Graphics implementation
 */
public class MainPanel extends JPanel {

	/**
	 * The Player that make the gme with business logic component's, indipendently by framework
	 */
	Player game;	
	/**
	 * Empty Constructor
	 * @throws InterruptedException - Se non funziona lo sleep
	 */
	public MainPanel() {
		// setto il background
		setBackground(new Color(129, 201, 246));
		
		game = new Player(new SpriteDraw(new Drawer() {
			
			@Override
			public void onDrawText(MyText text, Object drawerComponent, boolean centred) {
				if(drawerComponent instanceof Graphics) {
					Graphics g = (Graphics) drawerComponent;
					Font f = new Font("Dialog", Font.BOLD, (int) text.getFontSize());
					g.setFont(f);
					g.setColor(Color.BLACK);

					if(centred) {
					    FontMetrics fm = g.getFontMetrics();
					    int x = (int) ((GlobalValues.SIZE_WINDOW.getWidth() - fm.stringWidth(text.getText())) / 2);
					    int y = (int) (fm.getAscent() + (GlobalValues.SIZE_WINDOW.getHeight() - (fm.getAscent() + fm.getDescent())) / 2);						
						g.drawString(text.getText(), x, (int) text.getPosition().getY());

					}
					else {
						g.drawString(text.getText(), (int) text.getPosition().getX(), (int) text.getPosition().getY());
					}
				}				
			}
			
			@Override
			public void onDrawImage(MyImage image, Object drawerComponent) {
				if(drawerComponent instanceof Graphics) {
					Graphics g = (Graphics) drawerComponent;
					g.drawImage(Toolkit.getDefaultToolkit().getImage(image.getPath()), (int) image.getPosition().getX(), (int) image.getPosition().getY(), (int) image.getSize().getWidth(), (int) image.getSize().getHeight(), Color.BLACK, null);
				}				
			}
		}));
	}
	
	/**
	 * Principal refreshment of the Gameloop
	 */
	private void refresh() {
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			System.err.println("Impossibile eseguire il loop dle gioco!");
			e.printStackTrace();
			GlobalValues.EXIT_GAME = true; // STOPPA IL GIOCO
		}

		repaint();
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.loop(g);
		
		// Refreshment
		refresh();
	}
	
	

}
