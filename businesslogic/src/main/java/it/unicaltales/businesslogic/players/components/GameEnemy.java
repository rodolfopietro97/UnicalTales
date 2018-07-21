package it.unicaltales.businesslogic.players.components;

import it.unicaltales.businesslogic.gamecomponents.MyImage;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author Camillo
 * This class manages an enemy
 */
public class GameEnemy extends MyImage{	
	/**
	 * x-axis and y-axis of enemy (they are generated in runtime)
	 */
	private int xEnemy, yEnemy;
	
	/**
	 * Start position type of enemy
	 */
	StartEnemyAlignment startAlignment;
	
	/**
	 * If the enemy is in loop 
	 * 
	 * if it is true, the enemy moves in x-axis
	 * else the enemy will be regenerated
	 */
	private boolean loop;
	
	/**
	 * Constructor with parameters
	 * @param path of enemy
	 */
	public GameEnemy(String path) {
		super(0, 
			  0, 
			  GlobalValues.SIZE_WINDOW.getWidth() / 10, 
			  GlobalValues.SIZE_WINDOW.getHeight()/9, 
			  path);
		xEnemy = 0;
		yEnemy = 0;
		loop = false;
	}
	
	private void setInitialAligment() {
		if(Math.random() * 100  <= 50) startAlignment = StartEnemyAlignment.LEFT;
		else startAlignment = StartEnemyAlignment.RIGHT;
	}
	
	/**
	 * set the initial x position of enemy
	 */
	private void setInitialXEnemy() {
		setInitialAligment();
		if(startAlignment == StartEnemyAlignment.LEFT) xEnemy = 0; // starts from left
		else xEnemy = (int) (GlobalValues.SIZE_WINDOW.getWidth() - getSize().getWidth()); // starts from right
	}
	
	/**
	 * set the initial y position of enemy
	 */
	private void setInitialYEnemy() {
		// generation interval [0;max]
		yEnemy = (int) (Math.random() * (GlobalValues.SIZE_WINDOW.getHeight() - // total highness (max)
										getSize().getHeight())); // enemy's highness
	}
	
	/**
	 * Set the start position of enemy
	 */
	public void setStartPosition() {
		setInitialXEnemy();
		setInitialYEnemy();
		loop = true;
	}
	
	/**
	 * Main loop of enemy
	 */
	public void handle() {
		if (!GlobalValues.PAUSE_GAME || !GlobalValues.LOOSE_GAME) {
			if (!loop) {
				setStartPosition();
			} else {
				// it it starts from left
				if (startAlignment == StartEnemyAlignment.LEFT) {
					loopLeft();
				}
				// if it starts from right
				else {
					loopRight();
				}
			}
			setPosition(xEnemy, yEnemy);
		}
	}
	
	/**
	 * Loop left method of character
	 */
	private void loopLeft() {
		if(xEnemy < GlobalValues.SIZE_WINDOW.getWidth() - getSize().getHeight()) xEnemy += GlobalValues.ENEMY_SPEED;
		else {
			GlobalValues.SCORES++; // increases score
			loop = false; // regenerates
		}
	}
	
	/**
	 * Loop right method of character
	 */
	private void loopRight() {
		if(xEnemy > 0) xEnemy -= GlobalValues.ENEMY_SPEED;
		else {
			GlobalValues.SCORES++; // increases score
			loop = false; // regenerates
		}
	}
	
	/**
	 * Update the size and position of enemy
	 */
	public void update() {
		setSize(GlobalValues.SIZE_WINDOW.getWidth() / 10,
				GlobalValues.SIZE_WINDOW.getHeight()/9);
		setPosition(xEnemy, 
					yEnemy);
	}
	
	
	
}
