/**
 * 
 */
package unicaltales.businesslogic.draw;

import unicaltales.businesslogic.core.Sprite;

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
	 * This function draw an Sprite on the screen
	 * @param image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	public void drawImage(Sprite image, Object drawerComponent) {
		howToDraw.onDrawImage(image, drawerComponent);
	}
	
}
