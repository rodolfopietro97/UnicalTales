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
 * This class manages size, position and movements of the enemy
 */
public class GameEnemy extends MyImage{

	/**
	 *  Left and right;
	 */
	float x;
	
	/**
	 * Random position of the enemy
	 */
	double v = Math.random();
	static float number = (float)(Math.random()*200);
	
	
	/**
	 * Constructor with parameters
	 * @param path
	 */
	public GameEnemy(String path) {		
			super(700, 
					number, 
					GlobalValues.SIZE_WINDOW.getWidth() / 10, 
					GlobalValues.SIZE_WINDOW.getHeight()/9, 
					path);
			
			x = getPosition().getX();
	}
	
	
	/**
	 * Let the enemy move
	 */
	public void move() {
		x-=GlobalValues.ENEMY_SPEED;
	}
	
	/**
	 * Update size and position of the enemy
	 */
	public void update() {
		setSize(GlobalValues.SIZE_WINDOW.getWidth() / 10,
				  GlobalValues.SIZE_WINDOW.getHeight()/9);
		setPosition(x, GlobalValues.SIZE_WINDOW.getHeight() - GlobalValues.SIZE_WINDOW.getHeight()/9-30);
	}
	
	
	
}
