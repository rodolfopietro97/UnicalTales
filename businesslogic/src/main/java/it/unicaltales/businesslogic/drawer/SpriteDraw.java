/**
 * Drawer package
 */
package it.unicaltales.businesslogic.drawer;

import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

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
		if(GlobalValues.DEBUG) {
			MyText temp = new MyText(image.getPosition().getX(), image.getPosition().getY()-30, 10, "" , true);
			temp.setText("X:" + image.getPosition().getX() + " Y:" + image.getPosition().getY() + "\nW:" + image.getSize().getWidth() + " H:" + image.getSize().getHeight());
			drawText(temp, drawerComponent);
		}
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
