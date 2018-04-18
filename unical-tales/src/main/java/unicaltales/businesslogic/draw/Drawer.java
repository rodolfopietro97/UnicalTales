/**
 * 
 */
package unicaltales.businesslogic.draw;

import unicaltales.businesslogic.core.Sprite;

/**
 * @author rodolfo
 * This interface say "how to draw"
 *
 */
public interface Drawer {
	/**
	 * This is how to draw images
	 * @param s - Sprite of the image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	void onDrawImage(Sprite s, Object drawerComponent);
	
	/**
	 * This is how to draw images
	 * @param s - Sprite of the image to draw
	 * @param drawerComponent to used for the framework. (For example awt used Graphics for drawing)
	 */
	void onDrawText(Sprite s, Object drawerComponent);
}
