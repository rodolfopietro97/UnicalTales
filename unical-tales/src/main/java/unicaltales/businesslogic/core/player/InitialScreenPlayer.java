package unicaltales.businesslogic.core.player;

import java.awt.Image;

import javafx.stage.Stage;
import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.core.Size;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.events.SpriteEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameguis.SettingsGui;
import unicaltales.businesslogic.gameinfo.GlobalValues;
import unicaltales.businesslogic.gameinfo.ScreenTipe;

public class InitialScreenPlayer extends Player {
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
		super(spriteDraw, hardwareEvents);
		
		putSprite("background", new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				new GlobalValues().getResourcePath("logo.jpg")));
		
		putSprite("btnPlay", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getResourcePath("button.png")));
		
		putSprite("btnMultiplayer", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150 + 70, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getResourcePath("button.png")));
		
		putSprite("btnExit", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				15,
				60,
				60,
				new GlobalValues().getResourcePath("exit.jpg")));
		
		putSprite("btnSettings", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 75,
				60,
				60,
				new GlobalValues().getResourcePath("impostazioni.png")));
		
		putSprite("playText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119, 
				18, 
				"Single Player",
				true));
		
		putSprite("multiplayerText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119 + 70, 
				18, 
				"Multiplayer",
				true));
		
		
	}


	@Override
	public void manageEvents() {
		if (spriteEvents.isClick(getSprite("btnPlay"), hardwareEvents)) GlobalValues.SCREEN_TIPE = ScreenTipe.PLAY;
		if (spriteEvents.isClick(getSprite("btnExit"), hardwareEvents)) GlobalValues.EXIT_GAME = true;
		if (spriteEvents.isClick(getSprite("btnSettings"), hardwareEvents)) new SettingsGui().launch();
	}
	
	@Override
	public void onWindowsSizeChange() {
		getSprite("background").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight()));	
		
		getSprite("btnExit").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - 75), 15));
		
		getSprite("btnSettings").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 75));
		
		getSprite("btnPlay").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50));
		
		getSprite("btnPlay").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150));
		
		getSprite("btnMultiplayer").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50));
		
		getSprite("btnMultiplayer").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150 + 70));
		
		getSprite("playText").setPosition(new Position(GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119));
		
		getSprite("multiplayerText").setPosition(new Position(GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119 + 70));
			
	}
	


}
