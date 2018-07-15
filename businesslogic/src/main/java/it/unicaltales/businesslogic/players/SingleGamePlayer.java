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
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.eventhandlers.OnSpriteCollision;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyRendering;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.gameinfo.ScreenTipe;
import it.unicaltales.businesslogic.players.components.GameCharacter;
import it.unicaltales.businesslogic.players.components.GameEnemy;

/**
 * @author rodolfo
 * This class rapresent a GamePlayer. (When you click play game)
 *
 */
public class SingleGamePlayer extends Player{
	
	/**
	 * Pause Text.
	 * We declare it here and not with
	 * putSprites, because, it will be draw
	 * only when we pause the game
	 */
	MyText pauseText;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw
	 * @param hardwareEvents
	 */
	public SingleGamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
		putSprite("personaggio", new GameCharacter(new GlobalValues().getResourcesPath() + "characterRendering"));
		putSprite("nemico", new GameEnemy(new GlobalValues().getAssetPath("enemy.png")));
		putSprite("score", new MyText(30, 30, 10, "Scores: ", false));

		putSprite("pauseText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() -200, 
				30, 
				10, 
				"Press SPACE to pause",
				false));
		
		putSprite("escText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() -200, 
				60, 
				10, 
				"Press ESCAPE to exit",
				false));
		
		pauseText = new MyText(GlobalValues.SIZE_WINDOW.getWidth()/2, 
							   GlobalValues.SIZE_WINDOW.getHeight()/2, 
							   20, 
							   "PAUSE", 
							   true);


	}

	@Override
	public void manageEvents() {
		if (!GlobalValues.PAUSE_GAME) {
			((GameCharacter) getSprite("personaggio")).handle(this.hardwareEvents);
			((GameEnemy) getSprite("nemico")).handle();

			spriteEvents.collision(getSprite("personaggio"), getSprite("nemico"), new OnSpriteCollision() {

				@Override
				public void onCollision() {
					// TODO Auto-generated method stub
					System.err.println("Collisione!");
				}
			});

			GlobalValues.CHARACTER_SPEED = (int) (getSprite("personaggio").getSize().getHeight() / 30)
					+ GlobalValues.DIFFICULT_FACTOR;
			GlobalValues.ENEMY_SPEED = (int) (getSprite("nemico").getSize().getWidth() / 45)
					+ GlobalValues.DIFFICULT_FACTOR;

			((MyText) getSprite("score")).setText("Scores: " + GlobalValues.SCORES);

		}
		else {
			spriteDraw.drawText(pauseText, super.drawerComponent);
		}
		if(GlobalValues.IMPLEMENTATION != GlobalValues.LIBGDX_IMPLEMENTATION) {
				if(hardwareEvents.isJustKeyPressed(MyKeys.SPACE)) pauseGame();
				if(hardwareEvents.isJustKeyPressed(MyKeys.ESC)) exitGame();
		}
		else {
			if(hardwareEvents.isKeyPressed(MyKeys.SPACE)) pauseGame();
			if(hardwareEvents.isKeyPressed(MyKeys.ESC)) exitGame();
		}
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character and enemies
		 */
		((GameCharacter) getSprite("personaggio")).update();
		((GameEnemy) getSprite("nemico")).update();
		
		getSprite("pauseText").setPosition(GlobalValues.SIZE_WINDOW.getWidth() -200, 30);
		getSprite("escText").setPosition(GlobalValues.SIZE_WINDOW.getWidth() -200, 60);
	}
	
	/**
	 * Pause the game
	 */
	void pauseGame() {
		if(!GlobalValues.PAUSE_GAME) GlobalValues.PAUSE_GAME = true;
		else GlobalValues.PAUSE_GAME = false;
	}
	
	/**
	 * Exit game
	 */
	void exitGame() {
		((GameCharacter) getSprite("personaggio")).stopRendering();
		System.gc();
		GlobalValues.SCORES = 0;
		GlobalValues.SCREEN_TIPE = ScreenTipe.INITIAL;
	}

	
	
}
