/**
 * 
 */
package unicaltales.businesslogic.core;

/**
 * @author Camillo
 * Sprite model.
 */

public abstract class Sprite extends GameObject{
	/**
	 * path of the sprite
	 */
	private String path;

	/**
	 * empty constructor
	 */
	public Sprite() {
		super();
		this.path = "";
	}

	/**
	 * Parameters Constructor
	 * @param x of the Sprite
	 * @param y of the Sprite
	 * @param width of the Sprite
	 * @param height of the Sprite
	 * @param path of the Sprite
	 */
	public Sprite(float x, float y, float width, float height, String path) {
		super(x, y, width, height);
		this.path = path;
	}

	/**
	 * Parameter Constructor
	 * @param position of the Sprite
	 * @param size of the Sprite
	 * @param path of the Sprite
	 */
	public Sprite(Position position, Size size, String path) {
		super(position, size);
		this.path = path;
	}
	
	/**
	 * Setter and Getter
	 */

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}
