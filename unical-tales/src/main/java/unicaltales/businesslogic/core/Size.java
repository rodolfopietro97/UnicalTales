package unicaltales.businesslogic.core;

/**
 * @author rodolfo
 * Class that rapresent a size
 */
public class Size {
	/**
	 * Width and Height of element
	 */
	private float width, height;

	
	/**
	 * Empty constructor
	 */
	public Size() {
		this.width = this.height = 0;
	}
	
	/**
	 * Constructor with parameters
	 * @param width of object
	 * @param height of object
	 */
	public Size(float width, float height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Setter And Getter 
	 */
	
	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
}
