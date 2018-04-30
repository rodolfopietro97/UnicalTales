/**
 * 
 */
package unicaltales.businesslogic.core.player;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo This class Represent the player indipendently of the
 *         framework. It use the business logic to make the principal Game
 */
public class Player {
	/**
	 * Sprite Drawer part that depends by framework
	 */
	private SpriteDraw spriteDraw;
	
	/**
	 * Player of initial screen
	 */
	private InitialScreenPlayer initialScreenPlayer;
	

	/**
	 * Empty Constructor
	 * @param spriteDraw that depend by framework we use
	 */
	public Player(SpriteDraw spriteDraw) {
		/*
		 * Set the sprite draw
		 */
		this.spriteDraw = spriteDraw;
		
		/*
		 * Initializze the tipe of screen players
		 */
		initialScreenPlayer = new InitialScreenPlayer(this.spriteDraw);
		

	}

	/**
	 * Loop part of the game
	 * @param drawerComponent to use. For example Awt use Graphics
	 */
	public void loop(Object drawerComponent) {
		switch (GlobalValues.SCREEN_TIPE) {
		case INITIAL:
			initialScreenPlayer.loop(drawerComponent);
			break;
		
		case PLAY:
			break;

		default:
			break;
		}
	}

}
