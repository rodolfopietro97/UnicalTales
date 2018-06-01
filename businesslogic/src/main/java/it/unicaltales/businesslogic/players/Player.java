/**
 * Player package
 */
package it.unicaltales.businesslogic.players;


import java.util.HashMap;

import it.unicaltales.businesslogic.core.Sprite;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.SpriteEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * General definition of a Player, which will be implemented by differents players.
 */
public abstract class Player {
	/**
	 * Sprite Drawer part that depends by framework
	 */
	protected SpriteDraw spriteDraw;

	/**
	 * HardwareEvents that depend bye framework 
	 */
	protected HardwareEvents hardwareEvents;
	
	/**
	 * Manage the Sprite Events
	 */
	protected SpriteEvents spriteEvents;
	
	/**
	 * Maps of Sprites that will be used by Player derivates class
	 */
	private HashMap<String, Sprite> spriteMap;
	
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw to use. For example Awt use Graphics
	 * @param hardwareEvents that depend by framwrork
	 */
	public Player(SpriteDraw spriteDraw , HardwareEvents hardwareEvents) {
		/*
		 * Init members dipendently framework
		 */
		this.spriteDraw = spriteDraw;
		this.hardwareEvents = hardwareEvents;
		
		/*
		 * Init members Indipendently by framework
		 */
		spriteMap = new HashMap<String, Sprite>();
		
		spriteEvents = new SpriteEvents();
		
	}
	
	/**
	 * loop of initial screen
	 * @param drawerComponent to use for draw
	 */
	public void loop(Object drawerComponent) {
		draw(drawerComponent);
		manageEvents();
		if(GlobalValues.RESIZABLE) onWindowsSizeChange();
	}
	
	/**
	 * Draw part of loop
	 * @param drawerComponent to use for draw
	 */
	public void draw(Object drawerComponent) {
		
		for(String s : spriteMap.keySet()) {
			/*
			 * Draw a image sprite
			 */
			if(spriteMap.get(s) instanceof MyImage) spriteDraw.drawImage((MyImage) spriteMap.get(s), drawerComponent);
			/*
			 * Draw s text sprite
			 */
			if(spriteMap.get(s) instanceof MyText) spriteDraw.drawText((MyText) spriteMap.get(s), drawerComponent);
		}
	}
	
	/**
	 * Event Handler part of loop
	 */
	public abstract void manageEvents();
	
	/**
	 * Function that refresh Hardware Events on every iteration of loop
	 * @param hardwareEvents that we refresh every cycle of loop
	 */
	public void refreshHardwareEvents(HardwareEvents hardwareEvents) {
		this.hardwareEvents = hardwareEvents;
	}
	
	/**
	 * Put a Sprite in the spriteMap
	 * @param name of sprite
	 * @param s to put
	 */
	protected void putSprite(String name, Sprite s) {
		spriteMap.put(name, s);
	}
	
	/**
	 * Get a Sprite from the spriteMap
	 * @param name of the sprite to get
	 * @return the sprite
	 */
	protected Sprite getSprite(String name) {
		return spriteMap.get(name);
	}
	
	/**
	 * What to do on Resize Window Event
	 */
	public abstract void onWindowsSizeChange();

	
}