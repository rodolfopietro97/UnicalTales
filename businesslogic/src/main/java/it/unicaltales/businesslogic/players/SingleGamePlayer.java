/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.gamecomponents.GameCharacter;
import it.unicaltales.businesslogic.gamecomponents.Movements;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * This class rapresent a GamePlayer. (When you click play game)
 *
 */
public class SingleGamePlayer extends Player{
	
	/**
	 * Character of game 
	 */
	GameCharacter character;
	

	public SingleGamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
		character = new GameCharacter(new GlobalValues().getResourcePath("personaggio.png"));
		putSprite("personaggio", character);
		
	}

	@Override
	public void manageEvents() {
		if (hardwareEvents.isLeftPressed()) {
			character.move(Movements.LEFT);
		}
		else if(hardwareEvents.isPressRight()) {
			character.move(Movements.RIGHT);
		}
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character
		 */
		character.update();
	}

	
	
}
