/**
 * 
 */
package unicaltales.businesslogic.core.player;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import unicaltales.businesslogic.core.Sprite;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.events.SpriteEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameguis.SettingsGui;
import unicaltales.businesslogic.gameinfo.GlobalValues;
import unicaltales.businesslogic.gameinfo.ScreenTipe;

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
	protected ArrayList<Sprite> sprites;
	
	
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
		 * Init members INdipendently by framework
		 */
		sprites = new ArrayList<>(10);
		spriteEvents = new SpriteEvents();
	}
	
	/**
	 * loop of initial screen
	 * @param drawerComponent to use for draw
	 */
	public void loop(Object drawerComponent) {
		draw(drawerComponent);
		manageEvents();
	}
	
	/**
	 * Draw part of loop
	 * @param drawerComponent to use for draw
	 */
	public void draw(Object drawerComponent) {
		for(Sprite s : sprites) {
			/*
			 * Disegna un' immagine
			 */
			if(s instanceof MyImage) this.spriteDraw.drawImage((MyImage) s, drawerComponent);
			/*
			 * Disegna un testo
			 */
			if(s instanceof MyText) this.spriteDraw.drawText((MyText) s, drawerComponent);

		}
	}
	
	/**
	 * Event part of loop
	 */
	public abstract void manageEvents();
	
	/**
	 * Function that refresh Hardware Events on every iteration of loop
	 * @param hardwareEvents that we refresh every cycle of loop
	 */
	public void refreshHardwareEvents(HardwareEvents hardwareEvents) {
		this.hardwareEvents = hardwareEvents;
	}

	
}
