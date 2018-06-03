/**
 * Package of game components
 */
package it.unicaltales.businesslogic.players.components;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * This class represent a game character.
 */
public class GameCharacter extends MyImage{
	
	/**
	 * Jump values
	 */
	float jumpY;
	boolean jump;
	
	/**
	 * Left and right
	 */
	boolean move;
	float x;
	
	
	/**
	 * Constructor with parameters
	 * @param characterPath of image of character
	 */
	public GameCharacter(String characterPath) {		
		super(new Position(0, 
						   GlobalValues.SIZE_WINDOW.getHeight() - GlobalValues.SIZE_WINDOW.getHeight()/9-30),
			  new Size(GlobalValues.SIZE_WINDOW.getWidth() / 10,
				       GlobalValues.SIZE_WINDOW.getHeight()/9), 
			  characterPath);
	
		x = getPosition().getX();
		
		jump = false;
		jumpY = 0;
	}
	
	/**
	 * Update the size and position of character
	 */
	public void update() {
		setSize(GlobalValues.SIZE_WINDOW.getWidth() / 10,
				  GlobalValues.SIZE_WINDOW.getHeight()/9);
		setPosition(x, GlobalValues.SIZE_WINDOW.getHeight() - GlobalValues.SIZE_WINDOW.getHeight()/9-30 - jumpY);
	}
	
	
	/**
	 * Jump Up
	 */
	private void jumpUp() {
		if(jumpY <= GlobalValues.SIZE_WINDOW.getHeight()/2) 
			jumpY+=GlobalValues.CHARACTER_SPEED;
		else {
			jump = false;
		}
	}
	
	/**
	 * Return Down after a jump
	 */
	private void returnDown() {
		if(jumpY >= 0) 
			jumpY-=GlobalValues.CHARACTER_SPEED;
	}
	
	
	/**
	 * Handle the events of character
	 */
	public void handle(HardwareEvents hardwareEvents) {
		if (hardwareEvents.isKeyPressed(MyKeys.LEFT)) {
			if(x >= 0) 
				x-=GlobalValues.CHARACTER_SPEED;
		}
		else if (hardwareEvents.isKeyPressed(MyKeys.RIGHT)) {
			if(x <= GlobalValues.SIZE_WINDOW.getWidth() - getSize().getWidth()) 
				x+=GlobalValues.CHARACTER_SPEED;
		}
		else if (hardwareEvents.isKeyPressed(MyKeys.UP)) {
			jump = true;
		}
		
		/*
		 * Handle the jump
		 */
		if(jump) jumpUp();
		if(jumpY != 0 && !jump) returnDown();
	}
}
