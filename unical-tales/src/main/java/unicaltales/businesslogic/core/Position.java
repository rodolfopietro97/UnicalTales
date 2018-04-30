package unicaltales.businesslogic.core;

/**
 * @author rodolfo
 * 
 */
public class Position {
	/**
	 * x and y of the Position
	 */
	private float x,y;

	/**
	 * Empty constructor
	 */
	public Position() {
		this.x = this.y = 0;
	}
	
	/**
	 * Constructor with parameters
	 * @param x position of object
	 * @param y position of object
	 */
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Setter and Getter
	 */

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
}
