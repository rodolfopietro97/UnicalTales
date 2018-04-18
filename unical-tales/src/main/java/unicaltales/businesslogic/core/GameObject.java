package unicaltales.businesslogic.core;

/**
 * @author rodolfo
 * This class represent a tipical GameObject that has
 * Position, Size.
 */
public abstract class GameObject {
	
	Position position;
	Size size;
	
	
	/**
	 * Empty constructor
	 */
	public GameObject() {
		position = new Position();
		size = new Size();
	}
	
	
	/**
	 * @param position of object
	 * @param size of object
	 */
	public GameObject(Position position, Size size) {
		this.position = position;
		this.size = size;
	}
	
	
	/**
	 * Constructor with parameters
	 * @param x position of object
	 * @param y position of object
	 * @param width of object
	 * @param height of object
	 */
	public GameObject(float x, float y, float width, float height){
		this.position = new Position(x,y);
		this.size = new Size(width,height);
	}

	/**
	 * Setter And Getter 
	 */
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		this.size = size;
	}
	
	

}
