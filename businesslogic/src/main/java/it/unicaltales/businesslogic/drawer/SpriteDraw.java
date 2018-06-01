/**
 * Drawer package
 */
package it.unicaltales.businesslogic.drawer;

import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;

/**
 * @author rodolfo
 * Class that drive a sprite
 */
public class SpriteDraw {
	/**
	 * Interface that say how to draw Sprites,
	 * It depends by the framework that we using
	 */
	Drawer howToDraw;

	/**
	 * Sprite draw parametized constructor
	 * @param howToDraw the images, dipendently by the framework
	 */
	public SpriteDraw(Drawer howToDraw) {
		this.howToDraw = howToDraw;
	}

	/**
	 * This function draw an Image on the screen
	 * @param image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	public void drawImage(MyImage image, Object drawerComponent) {
		howToDraw.onDrawImage(image, drawerComponent);
	}
	
	/**
	 * This function draw Text on the screen
	 * @param text to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	public void drawText(MyText text, Object drawerComponent) {
		howToDraw.onDrawText(text, drawerComponent);
	}
	
}
