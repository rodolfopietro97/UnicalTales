package unicaltales.businesslogic.events;

/**
 * @author rodolfo,
 * 		   Class that manage hardware events. This class depends by the
 *         framework. It is refresheed ciclically because every time we know if
 *         a key is pressed, if mouse is clicked, ... this class contains all
 *         events we need for game
 */
public class HardwareEvents {
	/**
	 * x and y of mouse (or touch if we will make android implementation)
	 */
	private float x, y;

	/**
	 * type of events of mouse
	 */
	private boolean click;

	/**
	 * type of keys (true: pressed, false: not pressed)
	 */
	private boolean left, right, up, down, esc, space;

	/**
	 * Empty constructor that initializze all to false and zero
	 */
	public HardwareEvents() {
		x = y = 0;
		reset();
	}

	/**
	 * Reset of hardware events. This is most important, if there isn't a reset for
	 * example key remain pressed for all time
	 */
	public void reset() {
		click =  left = right = up = down = esc = space = false;
	}

	/**
	 * @return the x of mouse/touch
	 */
	public float getInputX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set of mouse/touch
	 */
	public void setInputX(float x) {
		this.x = x;
	}

	/**
	 * @return the y of mouse/touch
	 */
	public float getInputY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set of mouse/touch
	 */
	public void setInputY(float y) {
		this.y = y;
	}

	/**
	 * @return the click of mouse/touch
	 */
	public boolean isClick() {
		return click;
	}

	/**
	 * Click the mouse
	 */
	public void click() {
		this.click = true;
	}

	/**
	 * @return the left
	 */
	public boolean isLeftPressed() {
		return left;
	}

	/**
	 * Press the key left
	 */
	public void pressLeft() {
		this.left = true;
	}

	/**
	 * @return if right is pressed
	 */
	public boolean isPressRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void pressRight() {
		this.right = true;
	}

	/**
	 * @return if up is pressed
	 */
	public boolean isPressUp() {
		return up;
	}

	/**
	 * press up key
	 */
	public void pressUp() {
		this.up = true;
	}

	/**
	 * @return if down is press
	 */
	public boolean isPressDown() {
		return down;
	}

	/**
	 * press down key
	 */
	public void pressDown() {
		this.down = true;
	}

	/**
	 * @return if esc is pressed
	 */
	public boolean isPressEsc() {
		return esc;
	}

	/**
	 * press esc key
	 */
	public void pressEsc() {
		this.esc = true;
	}

	/**
	 * @return if space is pressed
	 */
	public boolean isPressSpace() {
		return space;
	}

	/**
	 * press the space
	 */
	public void pressSpace() {
		this.space = true;
	}

}
