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
	MyImage bottonePlay;
	
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
				"/home/rodolfo/Scrivania/photo_2018-04-18_16-08-50.jpg");
		bottonePlay = new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				"/home/rodolfo/Scrivania/photo_2018-04-18_16-08-50.jpg");
		//testo = new MyText(new Position(25, 25), 30, "weeeee");
	}
	
	void loop(Object drawerComponent) {
		this.spriteDraw.drawImage(background, drawerComponent);
		//spriteDraw.drawText(testo, drawerComponent);
	}

}
