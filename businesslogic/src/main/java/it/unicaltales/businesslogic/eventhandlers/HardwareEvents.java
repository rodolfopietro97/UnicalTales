/**
 * Package of event handlers
 */
package it.unicaltales.businesslogic.eventhandlers;

/**
 * @author rodolfo,
 * 		   Class that manages hardware events. This class depends by the
 *         framework. It is refreshed cyclically because every time we know if
 *         a key is pressed, if mouse is clicked, ..., this class contains every
 *         events we need for game
 *         
 * justPressed and pressed are different!        
 * 
 * 
 */
public class HardwareEvents {
	/**
	 * x and y of mouse (or touch if we will make android implementation)
	 */
	private float x, y;

	/**
	 * type of mouse's events
	 */
	private boolean click;

	/**
	 * type of keys PRESSED (true: pressed, false: not pressed)
	 */
	private boolean left, right, up, down, esc, space;
	
	/**
	 * type of keys JUST PRESSED (true: pressed, false: not pressed)
	 */
	private boolean justLeft, justRight, justUp, justDown, justEsc, justSpace;

	/**
	 * Empty constructor that initialize everything to false and zero
	 */
	public HardwareEvents() {
		x = y = 0;
		left = right = up = down = esc = space = false;
		resetHardwareEvents();
	}

	/**
	 * Reset of hardwareEvents. This is important if there isn't a reset, for
	 * example when a key remains pressed all time
	 * 
	 * THIS FUNCTION IS MOST IMPORTANT FOR justPress and click 
	 */
	public void resetHardwareEvents() {
		click = false;
		justLeft = justRight = justUp = justDown = justEsc = justSpace = false;
	}
	
	/**
	 * function that say if a key is pressed
	 * @param key to see if is pressed
	 * @return if key is pressed
	 */
	public boolean isKeyPressed(MyKeys key) {
		switch (key) {
			case LEFT: return left;
			case RIGHT: return right;
			case UP: return up;
			case DOWN: return down;
			case SPACE: return space;
			case ESC: return esc;
			default: return false;
		}
	}
	
	/**
	 * function that say if a key is pressed
	 * @param key to see if is pressed
	 * @return if key is pressed
	 */
	public boolean isJustKeyPressed(MyKeys key) {
		switch (key) {
			case LEFT: return justLeft;
			case RIGHT: return justRight;
			case UP: return justUp;
			case DOWN: return justDown;
			case SPACE: return justSpace;
			case ESC: return justEsc;
			default: return false;
		}
	}
	
	/**
	 * Press a key
	 * @param key to press
	 */
	public void pressKey(MyKeys key) {
		switch (key) {
			case LEFT: 
				left = true;
				break;
				
			case RIGHT: 
				right = true;
				break;
				
			case UP: 
				up = true;
				break;
				
			case DOWN: 
				down = true;
				break;
				
			case SPACE: 
				space = true;
				break;
				
			case ESC: 
				esc = true;
				break;
				
			default:
				break;
		}
	}
	
	
	/**
	 * Release a key
	 * 
	 * this function does not exists only for justKeys. In fact, justKeys,
	 * where handled by resetHardwareEvents()
	 * @param key to release
	 */
	public void relaseKey(MyKeys key) {
		switch (key) {
			case LEFT: 
				left = false;
				break;
				
			case RIGHT: 
				right = false;
				break;
				
			case UP: 
				up = false;
				break;
				
			case DOWN: 
				down = false;
				break;
				
			case SPACE: 
				space = false;
				break;
				
			case ESC: 
				esc = false;
				break;
				
			default:
				break;
		}
	}
	
	
	/**
	 * Just Press a key
	 * @param key to press
	 */
	public void justPressKey(MyKeys key) {
		switch (key) {
			case LEFT: 
				justLeft = true;
				break;
				
			case RIGHT: 
				justRight = true;
				break;
				
			case UP: 
				justUp = true;
				break;
				
			case DOWN: 
				justDown = true;
				break;
				
			case SPACE: 
				justSpace = true;
				break;
				
			case ESC: 
				justEsc = true;
				break;
				
			default:
				break;
		}
	}

	/**
	 * @return the x of mouse/touch
	 */
	public float getInputX() {
		return x;
	}

	/**
	 * @param x the x to set of mouse/touch
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
	 * @param y the y to set of mouse/touch
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
	 * Mouse's click
	 */
	public void click() {
		this.click = true;
	}
}