package unicaltales.businesslogic.gamecomponents;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.core.Size;
import unicaltales.businesslogic.core.Sprite;

public class MyText extends Sprite{
	/**
	 * Text that appear
	 */
	private String text;

	
	public MyText() {
		super();
		this.text = "";
	}

	/**
	 * Parameters Constructor
	 * @param x of the text
	 * @param y of the text
	 * @param width of the text
	 * @param height of the text
	 * @param path of the font 
	 * @param text of the text
	 */
	public MyText(float x, float y, float width, float height, String path, String text) {
		super(x, y, width, height, path);
		this.text = text;
	}

	/**
	 * Parameter Constructor
	 * @param position of the text
	 * @param size of the font
	 * @param path of the font
	 * @param text of text
	 */
	public MyText(Position position, Size size, String path, String text) {
		super(position, size, path);
		this.text = text;
	}
	
	/**
	 * Setter and Getter
	 */

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
