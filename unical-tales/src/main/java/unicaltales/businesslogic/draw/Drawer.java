/**
 * 
 */
package unicaltales.businesslogic.draw;

import unicaltales.businesslogic.core.Sprite;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;

/**
 * @author rodolfo
 * This interface say "how to draw"
 *
 */
public interface Drawer {
	/**
	 * This is how to draw images
	 * @param image - Sprite of the image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	void onDrawImage(MyImage image, Object drawerComponent);
	
	/**
	 * This is how to draw images
	 * @param text - Sprite of the image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	void onDrawText(MyText text, Object drawerComponent);
}
