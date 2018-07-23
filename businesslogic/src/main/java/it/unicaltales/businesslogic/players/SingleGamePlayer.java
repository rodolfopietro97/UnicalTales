/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import it.unicaltales.businesslogic.bestscoresmanager.BestScoresManager;
import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyRendering;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.gameinfo.ScreenTipe;
import it.unicaltales.businesslogic.players.components.EnemiesManager;
import it.unicaltales.businesslogic.players.components.GameCharacter;
import it.unicaltales.businesslogic.players.components.GameEnemy;

/**
 * @author rodolfo 
 * This class represents a GamePlayer. (When you click play game)
 *
 */
public class SingleGamePlayer extends Player {

	/**
	 * Pause Text. We declare it here and not on putSprites because it will be
	 * draw only when we pause the game
	 */
	MyText pauseText;

	/**
	 * Lose Text. We declare it here and not with putSprites, because, it will be
	 * draw only when we loose the game
	 */
	MyText looseText;

	/**
	 * Manage all enemies
	 */
	EnemiesManager enemiesManager;

	/**
	 * Constructor with parameters
	 * 
	 * @param spriteDraw
	 * @param hardwareEvents
	 */
	public SingleGamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
		// enemies
		enemiesManager = new EnemiesManager();
		setEnemiesByDifficult();

		// character
		putSprite("personaggio", new GameCharacter(new GlobalValues().getResourcesPath() + "characterRendering"));

		// game's texts
		initGameTexts();
		
		// update the speeds
		updateSpeeds();
	}

	/**
	 * Init the main texts of the game
	 */
	private void initGameTexts() {
		putSprite("score", new MyText(30, 30, 10, "Scores: ", false));
		putSprite("best-score", new MyText(50, 50, 10, "Best Score: ", false));

		putSprite("pauseText",
				new MyText(GlobalValues.SIZE_WINDOW.getWidth() - 200, 30, 10, "Press SPACE to pause", false));

		putSprite("escText",
				new MyText(GlobalValues.SIZE_WINDOW.getWidth() - 200, 60, 10, "Press ESCAPE to exit", false));

		pauseText = new MyText(GlobalValues.SIZE_WINDOW.getWidth() / 2, GlobalValues.SIZE_WINDOW.getHeight() / 2, 20,
				"PAUSE", true);

		looseText = new MyText(GlobalValues.SIZE_WINDOW.getWidth() / 2, GlobalValues.SIZE_WINDOW.getHeight() / 2, 20,
				"YOU LOST! (press SPACE to continue)", true);

	}

	/**
	 * Set the number of enemies dependently by game difficult
	 */
	private void setEnemiesByDifficult() {
		switch (GlobalValues.GAME_DIFFICULT) {
		case EASY:
			GlobalValues.DIFFICULT_FACTOR = 0;
			putSprite("nemico", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Greco.png")));
			putSprite("nemico2", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Scalzo.png")));
			enemiesManager.putEemies((GameEnemy) getSprite("nemico"), (GameEnemy) getSprite("nemico2"));
			break;

		case MEDIUM:
			GlobalValues.DIFFICULT_FACTOR = 1;
			putSprite("nemico", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Greco.png")));
			putSprite("nemico2", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Scalzo.png")));
			enemiesManager.putEemies((GameEnemy) getSprite("nemico"), (GameEnemy) getSprite("nemico2"));
			break;

		case HARD:
			GlobalValues.DIFFICULT_FACTOR = 2;
			putSprite("nemico", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Greco.png")));
			putSprite("nemico2", new GameEnemy(new GlobalValues().getAssetPathOfNonInterlaccedFile("Scalzo.png")));
			enemiesManager.putEemies((GameEnemy) getSprite("nemico"), (GameEnemy) getSprite("nemico2"));
			/*
			 * uncomment if you want an 'impossible game with more enemies'
			 */
//			putSprite("nemico", new GameEnemy(new GlobalValues().getAssetPath("Greco.png")));
//			putSprite("nemico2", new GameEnemy(new GlobalValues().getAssetPath("Scalzo.png")));
//			putSprite("nemico3", new GameEnemy(new GlobalValues().getAssetPath("Greco.png")));
//			putSprite("nemico4", new GameEnemy(new GlobalValues().getAssetPath("Scalzo.png")));
//			putSprite("nemico5", new GameEnemy(new GlobalValues().getAssetPath("Greco.png")));
//			putSprite("nemico6", new GameEnemy(new GlobalValues().getAssetPath("Scalzo.png")));
//			enemiesManager.putEemies((GameEnemy) getSprite("nemico"), (GameEnemy) getSprite("nemico2"),
//					(GameEnemy) getSprite("nemico3"), (GameEnemy) getSprite("nemico4"),
//					(GameEnemy) getSprite("nemico5"), (GameEnemy) getSprite("nemico6"));
			break;
		}
	}

	@Override
	public void manageEvents() {
		if (!GlobalValues.LOOSE_GAME) {
			if (!GlobalValues.PAUSE_GAME) {
				((GameCharacter) getSprite("personaggio")).handle(this.hardwareEvents);

				enemiesManager.handle(spriteEvents, (GameCharacter) getSprite("personaggio"), () -> looseGame());

				updateSpeeds();
				updateScores();

			} else {
				drawGameInPause();
			}
			if (GlobalValues.IMPLEMENTATION != GlobalValues.LIBGDX_IMPLEMENTATION) {
				if (hardwareEvents.isJustKeyPressed(MyKeys.SPACE))
					pauseGame();
				if (hardwareEvents.isJustKeyPressed(MyKeys.ESC))
					exitGame();
			} else {
				if (hardwareEvents.isKeyPressed(MyKeys.SPACE))
					pauseGame();
				if (hardwareEvents.isKeyPressed(MyKeys.ESC))
					exitGame();
			}
		} else {
			spriteDraw.drawText(looseText, super.drawerComponent);
			if (GlobalValues.IMPLEMENTATION != GlobalValues.LIBGDX_IMPLEMENTATION) {
				if (hardwareEvents.isJustKeyPressed(MyKeys.SPACE))
					resetGame();
			} else {
				if (hardwareEvents.isKeyPressed(MyKeys.SPACE))
					resetGame();
			}
		}
	}

	/**
	 * Draw the pause screen
	 */
	private void drawGameInPause() {
		spriteDraw.drawText(pauseText, super.drawerComponent);
	}

	/**
	 * Update the scores text of game in every iteration
	 */
	private void updateScores() {
		((MyText) getSprite("score")).setText("Scores: " + GlobalValues.SCORES);
		((MyText) getSprite("best-score")).setText("Best Score: " + GlobalValues.BEST_SCORE);
	}

	/**
	 * Update the speed of characters and enemies are useful for the game
	 * 
	 * @see {the speeds are experimentally dependently by framework }
	 */
	private void updateSpeeds() {
		if(GlobalValues.IMPLEMENTATION != GlobalValues.LIBGDX_IMPLEMENTATION) {
			GlobalValues.CHARACTER_SPEED = (int) (GlobalValues.SIZE_WINDOW.getWidth() / (GlobalValues.SIZE_WINDOW.getWidth()/2)) + GlobalValues.DIFFICULT_FACTOR;
			GlobalValues.ENEMY_SPEED = (int) (GlobalValues.SIZE_WINDOW.getWidth() / (GlobalValues.SIZE_WINDOW.getWidth())) + GlobalValues.DIFFICULT_FACTOR;
		}
		else {
			GlobalValues.CHARACTER_SPEED = (int) (GlobalValues.SIZE_WINDOW.getWidth() / (GlobalValues.SIZE_WINDOW.getWidth()/2)) + GlobalValues.DIFFICULT_FACTOR +10;
			GlobalValues.ENEMY_SPEED = (int) (GlobalValues.SIZE_WINDOW.getWidth() / (GlobalValues.SIZE_WINDOW.getWidth())) + GlobalValues.DIFFICULT_FACTOR +10;
		}
	}

	@Override
	public void onWindowsSizeChange() {
		/*
		 * Update size and position of character and enemies
		 */
		((GameCharacter) getSprite("personaggio")).update();
		enemiesManager.update();

		/*
		 * Update the text
		 */
		getSprite("pauseText").setPosition(GlobalValues.SIZE_WINDOW.getWidth() - 200, 30);
		getSprite("escText").setPosition(GlobalValues.SIZE_WINDOW.getWidth() - 200, 60);
		pauseText.setPosition(GlobalValues.SIZE_WINDOW.getWidth() / 2, GlobalValues.SIZE_WINDOW.getHeight() / 2);
		looseText.setPosition(GlobalValues.SIZE_WINDOW.getWidth() / 2, GlobalValues.SIZE_WINDOW.getHeight() / 2);
		
		/*
		 * Update the speeds of character and
		 * enemies
		 */
		updateSpeeds();
	}

	/**
	 * Pause the game
	 */
	void pauseGame() {
		if (!GlobalValues.PAUSE_GAME)
			GlobalValues.PAUSE_GAME = true;
		else
			GlobalValues.PAUSE_GAME = false;
	}

	/**
	 * Exit game
	 */
	void exitGame() {
		resetGame();
		((GameCharacter) getSprite("personaggio")).stopRendering();
		System.gc();
		GlobalValues.SCREEN_TIPE = ScreenTipe.INITIAL;
	}

	/**
	 * Reset game
	 */
	void resetGame() {
		((GameCharacter) getSprite("personaggio")).resetPosition();
		GlobalValues.SCORES = 0;
		GlobalValues.LOOSE_GAME = false;
		enemiesManager.setStartPosition();
	}

	/**
	 * When we loose the game
	 */
	void looseGame() {
		if(GlobalValues.SCORES > GlobalValues.BEST_SCORE) {
			GlobalValues.BEST_SCORE = GlobalValues.SCORES;
			new BestScoresManager().setBestScoreFile();
		}
		if (!GlobalValues.LOOSE_GAME)
			GlobalValues.LOOSE_GAME = true;
	}

}
