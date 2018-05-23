/**
 * 
 */
package unicaltales.businesslogic.core.player;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo This class Represent which player will be executed, indipendently of the
 *         framework. It use the business logic to make the principal Game
 */
public class PlayerManager {
	/**
	 * Sprite Drawer part that depends by framework
	 */
	private SpriteDraw spriteDraw;
	
	/**
	 * Player of initial screen
	 */
	private InitialScreenPlayer initialScreenPlayer;
	
	/**
	 * Hardware Events of player 
	 */
	HardwareEvents hardwareEvents;
	

	/**
	 * Empty Constructor
	 * @param spriteDraw that depend by framework we use
	 * @param hardwareEvents that depend by framwrork
	 */
	public PlayerManager(SpriteDraw spriteDraw , HardwareEvents hardwareEvents) {
		/*
		 * Set the sprite draw
		 */
		this.spriteDraw = spriteDraw;
		
		/*
		 * Set the hardware events
		 */
		this.hardwareEvents = hardwareEvents;
		
		/*
		 * Initializze the tipe of screen players
		 */
		initialScreenPlayer = new InitialScreenPlayer(this.spriteDraw, this.hardwareEvents);

	}

	/**
	 * Loop part of the game
	 * @param drawerComponent to use. For example Awt use Graphics
	 */
	public void loop(Object drawerComponent) {
		switch (GlobalValues.SCREEN_TIPE) {
		case INITIAL:
			initialScreenPlayer.loop(drawerComponent);
//			System.err.println(hardwareEvents.getInputX() + " " + hardwareEvents.getInputY() + " " + hardwareEvents.isClick());
			break;
		
		case PLAY:
			System.out.println("palyyy");
			break;

		default:
			break;
		}
	}
	
	/**
	 * Function that refresh input on every iteration of loop
	 * @param hardwareEvents that we refresh every cycle of loop
	 */
	public void refreshHardwareEvents(HardwareEvents hardwareEvents) {
		switch (GlobalValues.SCREEN_TIPE) {
		case INITIAL:
			initialScreenPlayer.refreshHardwareEvents(hardwareEvents);
			break;
		
		case PLAY:
			break;

		default:
			break;
		}
	}

}
