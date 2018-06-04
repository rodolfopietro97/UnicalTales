/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.players.components.GameCharacter;

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
	
	MyImage s;

	SpriteEvents ev;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw
	 * @param hardwareEvents
	 */
	public SingleGamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		s = new MyImage(500, 300, GlobalValues.SIZE_WINDOW.getWidth()/8, GlobalValues.SIZE_WINDOW.getHeight()/8, new GlobalValues().getResourcePath("personaggio.png"));
		character = new GameCharacter(new GlobalValues().getResourcePath("personaggio.png"));
		putSprite("personaggio", character);
		putSprite("ippolito", s);
		
		
		ev = new SpriteEvents();
	}

	@Override
	public void manageEvents() {
		character.handle(this.hardwareEvents);
		
		if( ev.yCollision(s, character)) {
			System.err.println("weeee");
		}
		
		
		
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character
		 */
		character.update();
		
		s.setPosition(s.getPosition());
		s.setSize(GlobalValues.SIZE_WINDOW.getWidth()/8, GlobalValues.SIZE_WINDOW.getHeight()/8);
		
	}

	
	
}
