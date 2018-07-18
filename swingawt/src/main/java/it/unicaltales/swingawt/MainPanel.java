/**
 * Package of swing/awt implementation 
 */
package it.unicaltales.swingawt;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.unicaltales.businesslogic.drawer.Drawer;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.drawer.utils.ImagesManager;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.players.PlayerManager;
import javafx.scene.input.KeyCode;

/**
 * @author rodolfo MainPanel of Swing and Awt 2d Simple Graphics implementation
 */
public class MainPanel extends JPanel {

	/**
	 * The Player that make the game with business logic component's, independently
	 * by framework
	 */
	PlayerManager playerScreenManager;

	/**
	 * HardwareEvents that we Change in runtime with MouseListener, MouseMotionListener and
	 * KeyListener
	 */
	HardwareEvents hardwareEvents;
	
	/**
	 * Store the images to draw. It is very useful,
	 * in fact in howToDraw if we make a new Texture
	 * every time, the program will be very slow
	 */
	private ImagesManager imagesToDraw;

	/**
	 * Empty Constructor
	 */
	public MainPanel() {
		GlobalValues.CHARACTER_SPEED+=4; // In swing, for a better delay, we always increment speed by 4(experimental value) 
		
		// set background
		setBackground(Color.WHITE);

		// initialize hardwer events
		hardwareEvents = new HardwareEvents();
		imagesToDraw = new ImagesManager();
		
		playerScreenManager = new PlayerManager(new SpriteDraw(new Drawer() {

			@Override
			public void onDrawText(MyText text, Object drawerComponent) {
				if (drawerComponent instanceof Graphics) {
					Graphics g = (Graphics) drawerComponent;
					Font f = new Font("Dialog", Font.BOLD, (int) text.getFontSize());
					g.setFont(f);
					g.setColor(Color.BLACK);

					if (text.isCentred()) {
						FontMetrics fm = g.getFontMetrics();
						int x = (int) ((GlobalValues.SIZE_WINDOW.getWidth() - fm.stringWidth(text.getText())) / 2);
						int y = (int) (fm.getAscent()
								+ (GlobalValues.SIZE_WINDOW.getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
						g.drawString(text.getText(), x, (int) text.getPosition().getY());

					} else {
						g.drawString(text.getText(), (int) text.getPosition().getX(), (int) text.getPosition().getY());
					}
				}
			}

			@Override
			public void onDrawImage(MyImage image, Object drawerComponent) {
				if (drawerComponent instanceof Graphics) {
					Graphics g = (Graphics) drawerComponent;
					if(!imagesToDraw.exist(image.getPath())) imagesToDraw.putImage(image.getPath(), Toolkit.getDefaultToolkit().getImage(image.getPath()));
					g.drawImage((Image) imagesToDraw.getImage(image.getPath()), 
							(int) image.getPosition().getX(),
							(int) image.getPosition().getY(), (int) image.getSize().getWidth(),
							(int) image.getSize().getHeight(), Color.BLACK, null);
				}
			}
		}), hardwareEvents);

		
		/*
		 * tells what to do to hardwareEvents (MOUSE NOT MOVING)
		 */
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				hardwareEvents.click();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		/*
		 * tells what to do to hardwareEvents (MOUSE MOVING)
		 */
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hardwareEvents.setInputX(e.getX());
				hardwareEvents.setInputY(e.getY());
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});

		/*
		 *tells what to do to hardwareEvents (KEYBORD)
		 */
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				/*
				 * for key pressed
				 */
				if(hardwareEvents.isKeyPressed(MyKeys.ESC) && e.getKeyCode() == KeyEvent.VK_ESCAPE) hardwareEvents.relaseKey(MyKeys.ESC);
				if(hardwareEvents.isKeyPressed(MyKeys.LEFT) && e.getKeyCode() == KeyEvent.VK_LEFT) hardwareEvents.relaseKey(MyKeys.LEFT);
				if(hardwareEvents.isKeyPressed(MyKeys.RIGHT) && e.getKeyCode() == KeyEvent.VK_RIGHT) hardwareEvents.relaseKey(MyKeys.RIGHT);
				if(hardwareEvents.isKeyPressed(MyKeys.DOWN) && e.getKeyCode() == KeyEvent.VK_DOWN) hardwareEvents.relaseKey(MyKeys.DOWN);
				if(hardwareEvents.isKeyPressed(MyKeys.UP) && e.getKeyCode() == KeyEvent.VK_UP) hardwareEvents.relaseKey(MyKeys.UP);
				if(hardwareEvents.isKeyPressed(MyKeys.SPACE) && e.getKeyCode() == KeyEvent.VK_SPACE) hardwareEvents.relaseKey(MyKeys.SPACE);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					hardwareEvents.pressKey(MyKeys.ESC);
					hardwareEvents.justPressKey(MyKeys.ESC);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					hardwareEvents.pressKey(MyKeys.LEFT);
					hardwareEvents.justPressKey(MyKeys.LEFT);
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					hardwareEvents.pressKey(MyKeys.RIGHT);
					hardwareEvents.justPressKey(MyKeys.RIGHT);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					hardwareEvents.pressKey(MyKeys.DOWN);
					hardwareEvents.justPressKey(MyKeys.DOWN);
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					hardwareEvents.pressKey(MyKeys.UP);
					hardwareEvents.justPressKey(MyKeys.UP);
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					hardwareEvents.pressKey(MyKeys.SPACE);
					hardwareEvents.justPressKey(MyKeys.SPACE);
				}
			}
		});
	}

	/**
	 * Principal refreshment of the Gameloop
	 */
	private void refresh() {
		/*
		 * runs the sleep
		 */
		try {
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			System.err.println("Impossibile eseguire il loop dle gioco!");
			e.printStackTrace();
			GlobalValues.EXIT_GAME = true; // STOPPA IL GIOCO
		}

		/*
		 * runs the repaint
		 */
		repaint();
		
		/*
		 * Refresh the just pressed keys and click
		 */	
		hardwareEvents.resetHardwareEvents();
		
		/*
		 * Refreshing of globalvalues
		 */
		if(GlobalValues.RESIZABLE) {
			GlobalValues.SIZE_WINDOW.setWidth((int)getWidth());
			GlobalValues.SIZE_WINDOW.setHeight((int)getHeight());
		}
	}
	
	/**
	 * Paint component of Panel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(!GlobalValues.EXIT_GAME) {
			playerScreenManager.loop(g);
			playerScreenManager.refreshHardwareEvents(hardwareEvents);
		}
		else System.exit(0);

		// Refreshment
		refresh();
	}

}
