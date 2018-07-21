/**
 * 
 */
package it.unicaltales.businesslogic.players.components;

import java.util.ArrayList;

import it.unicaltales.businesslogic.eventhandlers.OnSpriteCollision;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;

/**
 * @author rodolfo
 * Class that manages enemies
 */
public class EnemiesManager {

	/**
	 * Lists of enemies of game
	 */
	private ArrayList<GameEnemy> enemies;

	
	public EnemiesManager() {
		enemies = new ArrayList<>();
	}
	
	/**
	 * Put all enemies in the list enemies
	 * @param allEnemies of the game
	 */
	public void putEemies(GameEnemy ... allEnemies) {
		for (GameEnemy gameEnemy : allEnemies) {
			enemies.add(gameEnemy);
		}
	}
	
	/**
	 * Handle all enemies
	 * @param spriteEvents of player
	 * @param character that we current use
	 * @param onCollision method used when there is a collision between one of enemies and character
	 */
	public void handle(SpriteEvents spriteEvents, GameCharacter character, OnSpriteCollision onCollision) {
		for (GameEnemy gameEnemy : enemies) {
			gameEnemy.handle();
			spriteEvents.collision(character, gameEnemy, onCollision);
		}
	}
	
	/**
	 * Update all enemies
	 */
	public void update() {
		for (GameEnemy gameEnemy : enemies) {
			gameEnemy.update();
		}
	}
	
	/**
	 * Set the start position of all enemies
	 */
	public void setStartPosition() {
		for (GameEnemy gameEnemy : enemies) {
			gameEnemy.setStartPosition();
		}
	}
	
}
