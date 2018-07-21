/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 *  This class represents which player will be executed, independently by the
 *  framework.
 */
public class PlayerManager {
	AudioInputStream audio;
	Clip clip;
	
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
		
		if(GlobalValues.SOUND_ON) loopColonnaSonora();
		
		
	}

	/**
	 * Loop the principal sound of the game
	 */
	private void loopColonnaSonora() {
		try {
			audio = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("loopSound.wav"));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.err.println("Impossibile avviare la colonna sonora");
		}
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
