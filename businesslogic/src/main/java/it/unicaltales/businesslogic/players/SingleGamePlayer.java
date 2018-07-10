/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.OnSpriteCollision;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyRendering;
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
	
	MyImage background;
	
	MyImage s;

	/**
	 * Event handler of sprites,
	 * it manages collisions, etc..
	 */
	SpriteEvents spritesEventHandler;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw
	 * @param hardwareEvents
	 */
	public SingleGamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
		background = new MyImage(0, 0, GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight(), new GlobalValues().getAssetPath("sky.png"));
		s = new MyImage(500, 503, GlobalValues.SIZE_WINDOW.getWidth()/8, GlobalValues.SIZE_WINDOW.getHeight()/8, new GlobalValues().getAssetPath("personaggio.png"));
		character = new GameCharacter(new GlobalValues().getAssetPath("personaggio.png"));
		putSprite("personaggio", character);
		putSprite("ippolito", s);
		putSprite("sfondo", background);
		
		spritesEventHandler = new SpriteEvents();
		
		
		MyRendering rendering = new MyRendering(new Position(10,10), new Size(50, 50), new GlobalValues().getResourcesPath() + "characterRendering");
		putSprite("personaggioAnimato", rendering);
	}

	@Override
	public void manageEvents() {
		character.handle(this.hardwareEvents);
		
		spriteEvents.collision(character, s, new OnSpriteCollision() {
			
			@Override
			public void onCollision() {
				System.out.println("collisione!");
			}
		});
		
		
		
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character
		 */
		character.update();
		
		s.setPosition(s.getPosition());
		s.setSize(GlobalValues.SIZE_WINDOW.getWidth()/8, GlobalValues.SIZE_WINDOW.getHeight()/8);
		
		background.setPosition(background.getPosition());
		background.setSize(GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight());;
	}

	
	
}
