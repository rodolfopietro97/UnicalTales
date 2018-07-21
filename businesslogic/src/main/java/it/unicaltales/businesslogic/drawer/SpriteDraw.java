/**
 * Drawer package
 */
package it.unicaltales.businesslogic.drawer;

import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * Class that draws a sprite
 */
public class SpriteDraw {
	/**
	 * Interface that say how to draw Sprites,
	 * It depends by the framework that we using
	 */
	Drawer howToDraw;
	
	/**
	 * Hover image,
	 * we use this image for example when
	 * we pass with the mouse over 
	 */
	MyImage hoverImage;

	/**
	 * SpriteDraw with or without parameters constructor
	 * @param howToDraw the images, dependently by the framework
	 */
	public SpriteDraw(Drawer howToDraw) {
		this.howToDraw = howToDraw;
		hoverImage = new MyImage(0, 0, 20,20, new GlobalValues().getAssetPath("hover.png"));
	}

	/**
	 * This function draws an Image on the screen
	 * @param image to draw
	 * @param drawerComponent used for framework. (For example awt used Graphics for drawing)
	 */
	public void drawImage(MyImage image, Object drawerComponent) {
		howToDraw.onDrawImage(image, drawerComponent);
	}
	
	public void drawImageHover(MyImage image, Object drawerComponent) {
		hoverImage.setPosition(image.getPosition());
		hoverImage.setSize(image.getSize());
		howToDraw.onDrawImage(hoverImage, drawerComponent);
	}
	
	/**
	 * This function draws Text on the screen
	 * @param text to draw
	 * @param drawerComponent used for framework. (For example awt used Graphics for drawing)
	 */
	public void drawText(MyText text, Object drawerComponent) {
		howToDraw.onDrawText(text, drawerComponent);
	}
	
}
