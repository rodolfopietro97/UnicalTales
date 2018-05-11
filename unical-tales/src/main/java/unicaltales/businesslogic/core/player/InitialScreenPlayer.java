package unicaltales.businesslogic.core.player;

import java.awt.Image;

import javafx.stage.Stage;
import unicaltales.businesslogic.core.Position;
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
		
		// 0 -> logo
		super.sprites.add(new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				new GlobalValues().getResourcePath("logo.jpg")));
		
		// 1 -> play
		super.sprites.add(new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getResourcePath("button.png")));
		
		// 2 -> exit
		super.sprites.add(new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight())/76,
				60,
				60,
				new GlobalValues().getResourcePath("exit.jpg")));
		
		// 3 -> settings
		super.sprites.add(new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 100,
				60,
				60,
				new GlobalValues().getResourcePath("impostazioni.png")));
		
		super.sprites.add(new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				GlobalValues.SIZE_WINDOW.getHeight() - 115, 
				30, 
				"Play",
				true));
	}

	/* (non-Javadoc)
	 * @see unicaltales.businesslogic.core.player.Player#manageEvents()
	 */
	@Override
	public void manageEvents() {

		if (spriteEvents.isClick(super.sprites.get(1), hardwareEvents)) GlobalValues.SCREEN_TIPE = ScreenTipe.PLAY;
		if (spriteEvents.isClick(super.sprites.get(2), hardwareEvents)) GlobalValues.EXIT_GAME = true;
		if (spriteEvents.isClick(super.sprites.get(3), hardwareEvents)) new SettingsGui().launch();

	}
	


}
