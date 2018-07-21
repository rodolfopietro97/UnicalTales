/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 *  This class represents which player will be executed, independently by the
 *  framework.
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
	 * Player of Single PlayScreen (
	 */
	private SingleGamePlayer singleGamePlayer;
	
	/**
	 * Hardware Events of player 
	 */
	HardwareEvents hardwareEvents;
	

	/**
	 * Empty Constructor
	 * @param spriteDraw that depends by framework we use
	 * @param hardwareEvents that depends by framework
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
		 * Initializze the initial screen
		 */
		initialScreenPlayer = new InitialScreenPlayer(this.spriteDraw, this.hardwareEvents);

		/*
		 * Initializze the single game player
		 */
		singleGamePlayer = new SingleGamePlayer(this.spriteDraw, this.hardwareEvents);
		
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
		
		case SINGLE_PLAYER:
			singleGamePlayer.loop(drawerComponent);
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
		
		case SINGLE_PLAYER:
			singleGamePlayer.refreshHardwareEvents(hardwareEvents);
			break;

		default:
			break;
		}
	}

}
