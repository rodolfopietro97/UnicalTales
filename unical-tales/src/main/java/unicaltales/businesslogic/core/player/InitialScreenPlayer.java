package unicaltales.businesslogic.core.player;

import java.awt.Image;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;

public class InitialScreenPlayer {
	/**
	 * Sprite Drawer part that depends by framework
	 */
	private SpriteDraw spriteDraw;
	
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
	MyText playTesto;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw to use. For example Awt use Graphics
	 */
	public InitialScreenPlayer(SpriteDraw spriteDraw) {
		
		this.spriteDraw = spriteDraw;
		
		background = new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				new GlobalValues().getResource("logo.jpg"));
		bottonePlay = new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getResource("button.png"));
		playTesto = new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				GlobalValues.SIZE_WINDOW.getHeight() - 115, 
				30, 
				"Play");
	}
	
	void loop(Object drawerComponent) {
		this.spriteDraw.drawImage(background, drawerComponent);
		this.spriteDraw.drawImage(bottonePlay, drawerComponent);
		this.spriteDraw.drawText(playTesto, true, drawerComponent);
	}

}
