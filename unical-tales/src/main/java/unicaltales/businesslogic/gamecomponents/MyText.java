package unicaltales.businesslogic.gamecomponents;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.core.Size;
import unicaltales.businesslogic.core.Sprite;

public class MyText extends Sprite{
	/**
	 * Text that appear
	 */
	private String text;
	
	/*
	 * Font size
	 */
	private float fontSize;

	
	public MyText() {
		super();
		this.text = "";
		this.fontSize = 10;
	}

	/**
	 * Parameters Constructor
	 * @param x of the text
	 * @param y of the text
	 * @param fontSize of Text
	 * @param text of the text
	 */
	public MyText(float x, float y, float fontSize, String text) {
		super(x, y, 0, 0, "/");
		this.text = text;
		this.fontSize = fontSize;
	}

	/**
	 * Parameter Constructor
	 * @param position of the text
	 * @param size of the font
	 * @param text of text
	 */
	public MyText(Position position, float fontSize, String text) {
		super(position, new Size(), "/");
		this.text = text;
		this.fontSize = fontSize;
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

	/**
	 * @return the fontSize
	 */
	public float getFontSize() {
		return fontSize;
	}

	/**
	 * @param fontSize the fontSize to set
	 */
	public void setFontSize(float fontSize) {
		this.fontSize = fontSize;
	}
	
	
	
}
