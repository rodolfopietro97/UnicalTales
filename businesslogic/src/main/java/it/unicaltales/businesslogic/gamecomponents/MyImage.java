/**
 * Package of game components
 */
package it.unicaltales.businesslogic.gamecomponents;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.core.Sprite;

/**
 * @author rodolfo
 * This class represent an image
 */
public class MyImage extends Sprite{

	/**
	 * Empty constructor
	 */
	public MyImage() {
		super();
	}

	/**
	 * Parameters Constructor
	 * @param x of the image
	 * @param y of the image
	 * @param width of the image
	 * @param height of the image
	 * @param path of the image
	 */
	public MyImage(float x, float y, float width, float height, String path) {
		super(x, y, width, height, path);
	}
	
	/**
	 * Constructor with parameters
	 * @param width of image
	 * @param height of image
	 * @param path of image
	 */
	public MyImage(Position position, Size size, String path) {
		super(position, size, path);
	}
	
}