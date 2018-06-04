/**
 * Package of event handlers
 */
package it.unicaltales.businesslogic.eventhandlers;

import it.unicaltales.businesslogic.core.Sprite;

/**
 * @author rodolfo
 * Class that manage SpriteEvents, such as collision between two Sprites
 */
public class SpriteEvents {
	
	/**
	 * Collision on x axis between two sprites
	 * @param s1 sprite 1
	 * @param s2 sprite 2
	 * @return if there is a x collision
	 */
	public boolean xCollision(Sprite s1, Sprite s2) {
		for (float i = s1.getPosition().getX(); i < s1.getPosition().getX() + s1.getSize().getWidth(); i++) {
			for (float j = s2.getPosition().getX(); j < s2.getPosition().getX() + s2.getSize().getWidth(); j++) {
				if(i==j) return true;
			}
		}
		return false;
	}
	
	/**
	 * Collision on y axis between two sprites
	 * @param s1 sprite 1
	 * @param s2 sprite 2
	 * @return if there is a y collision
	 */
	public boolean yCollision(Sprite s1, Sprite s2) {
		for (float i = s1.getPosition().getY(); i < s1.getPosition().getY() + s1.getSize().getHeight(); i++) {
			for (float j = s2.getPosition().getY(); j < s2.getPosition().getY() + s2.getSize().getHeight(); j++) {
				if(i==j) return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Collision between two sprites
	 * @param s1 sprite 1
	 * @param s2 sprite 2
	 * @param collision the function that say to us what do if there is a collision between sprites
	 * @return if there is a y collision
	 */
	public boolean collision(Sprite s1, Sprite s2, SpriteCollision collision) {
		if(xCollision(s1, s2) && yCollision(s1, s2)) {
			collision.onCollision();
			return true;
		}
		return false;
	}
	
	/**
	 * Verify if mouse is hover a sprite
	 * @param s the sprite
	 * @param h hardware events manager
	 * @return if the mouse is hover a sprite
	 */
	public boolean isHover(Sprite s, HardwareEvents h) {
		return h.getInputX() >= s.getPosition().getX() 
			&& h.getInputX() <= s.getPosition().getX() + s.getSize().getWidth()
			&& h.getInputY() >= s.getPosition().getY() 
					&& h.getInputY() <= s.getPosition().getY() + s.getSize().getHeight();
	}
	
	/**
	 * Verify if mouse/touch click a sprite
	 * @param s the sprite
	 * @param h hardware events manager
	 * @return if mouse/touch click a sprite
	 */
	public boolean isClick(Sprite s, HardwareEvents h) {
		return isHover(s, h) && h.isClick();
	}
}
