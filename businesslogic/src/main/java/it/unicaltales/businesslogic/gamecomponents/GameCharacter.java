/**
 * Package of game components
 */
package it.unicaltales.businesslogic.gamecomponents;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * This class represent a game character.
 */
public class GameCharacter extends MyImage{
	
	public GameCharacter(String character) {
		super(new Position(0, GlobalValues.SIZE_WINDOW.getHeight() - GlobalValues.SIZE_WINDOW.getHeight()/9-30),
			  new Size(GlobalValues.SIZE_WINDOW.getWidth() / 10,
			  GlobalValues.SIZE_WINDOW.getHeight()/9), character);

	}
	
	public void move(Movements m) {
		switch (m) {
		case LEFT:
			this.setPosition(new Position(getPosition().getX() - 10, 
										  getPosition().getY()));
			break;
			
		case RIGHT:
			this.setPosition(new Position(getPosition().getX() + 10, 
										  getPosition().getY()));

		default:
			break;
		}
	}
	
	public void update() {
		setSize(GlobalValues.SIZE_WINDOW.getWidth() / 10,
				  GlobalValues.SIZE_WINDOW.getHeight()/9);
		setPosition(getPosition().getX(), GlobalValues.SIZE_WINDOW.getHeight() - GlobalValues.SIZE_WINDOW.getHeight()/9-30);
	}
}
