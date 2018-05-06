package unicaltales.businesslogic.core.player;

import java.awt.Image;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.events.SpriteEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;
import unicaltales.businesslogic.gameinfo.ScreenTipe;

public class InitialScreenPlayer {
	/**
	 * Sprite Drawer part that depends by framework
	 */
	private SpriteDraw spriteDraw;

	/**
	 * HardwareEvents that depend bye framework 
	 */
	HardwareEvents hardwareEvents;
	
	/**
	 * Manage the Sprite Events
	 */
	SpriteEvents spriteEvents;
	
	/**
	 * Components of the Initial Screen
	 */
	/**
	 * Background image of game
	 */
	MyImage background;
	
	/**
	 * Play button (image and text)
	 */
	MyImage bottonePlay;
	MyImage bottoneExit;
	MyImage bottoneSettings;
	MyText playTesto;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw to use. For example Awt use Graphics
	 * @param hardwareEvents that depend by framwrork
	 */
	public InitialScreenPlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		
		this.spriteDraw = spriteDraw;
		this.hardwareEvents = hardwareEvents;
		
		background = new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				new GlobalValues().getResourcePath("logo.jpg"));
		bottonePlay = new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getResourcePath("button.png"));
		
		bottoneExit = new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight())/76,
				60,
				60,
				new GlobalValues().getResourcePath("exit.jpg"));
		
		bottoneSettings = new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 100,
				60,
				60,
				new GlobalValues().getResourcePath("impostazioni.png"));
		
		playTesto = new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				GlobalValues.SIZE_WINDOW.getHeight() - 115, 
				30, 
				"Play");
		
		spriteEvents = new SpriteEvents();
	}
	
	/**
	 * loop of initial screen
	 * @param drawerComponent to use for draw
	 */
	void loop(Object drawerComponent) {
		draw(drawerComponent);
		manageEvents();
	}
	
	/**
	 * Draw part of loop
	 * @param drawerComponent to use for draw
	 */
	void draw(Object drawerComponent) {
		this.spriteDraw.drawImage(background, drawerComponent);
		this.spriteDraw.drawImage(bottonePlay, drawerComponent);
		this.spriteDraw.drawText(playTesto, true, drawerComponent);
		this.spriteDraw.drawImage(bottoneExit, drawerComponent);
		this.spriteDraw.drawImage(bottoneSettings, drawerComponent);
	}
	
	/**
	 * Event part of loop
	 */
	void manageEvents() {
		if (spriteEvents.isClick(bottoneExit, hardwareEvents)) GlobalValues.EXIT_GAME = true;
		if (spriteEvents.isClick(bottoneSettings, hardwareEvents)) System.out.println("Hai cliccato le impostazioni!");
		if (spriteEvents.isClick(bottonePlay, hardwareEvents)) GlobalValues.SCREEN_TIPE = ScreenTipe.PLAY;
	}
	
	/**
	 * Function that refresh input on every iteration of loop
	 * @param hardwareEvents that we refresh every cycle of loop
	 */
	public void refreshInput(HardwareEvents hardwareEvents) {
		this.hardwareEvents = hardwareEvents;
	}

}
