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
import it.unicaltales.businesslogic.players.components.GameEnemy;

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
	
	GameEnemy enemy;
	
	MyRendering rendering;
	

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

		character = new GameCharacter(new GlobalValues().getAssetPath("personaggio.png"));
		
		
		enemy = new GameEnemy(new GlobalValues().getAssetPath("enemy.png"));
	
		putSprite("personaggio", character);
		putSprite("nemico", enemy);
		putSprite("sfondo", background);
		
		spritesEventHandler = new SpriteEvents();
		
		
		rendering = new MyRendering(new Position(300,300), new Size(50, 50), new GlobalValues().getResourcesPath() + "characterRendering");
		putSprite("personaggioAnimato", rendering);
	}

	@Override
	public void manageEvents() {
		character.handle(this.hardwareEvents);
		
		spriteEvents.collision(character, enemy, new OnSpriteCollision() {
			
			@Override
			public void onCollision() {
				System.out.println("collisione!");
			}
		});
		
		spriteEvents.collision(character, rendering, new OnSpriteCollision() {
			
			@Override
			public void onCollision() {
				// TODO Auto-generated method stub
				System.out.println("Collisione con il rendering!");
			}
		});
		
		
		
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character
		 */
		character.update();
		
		enemy.setPosition(enemy.getPosition());
		enemy.setSize(GlobalValues.SIZE_WINDOW.getWidth()/8, GlobalValues.SIZE_WINDOW.getHeight()/8);
		
		background.setPosition(background.getPosition());
		background.setSize(GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight());;
	}

	
	
}
