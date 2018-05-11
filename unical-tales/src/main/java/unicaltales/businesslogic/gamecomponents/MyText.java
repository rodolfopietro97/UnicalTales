package unicaltales.businesslogic.gamecomponents;

import unicaltales.businesslogic.core.Position;
import unicaltales.businesslogic.core.Size;
import unicaltales.businesslogic.core.Sprite;

public class MyText extends Sprite{
	/**
	 * Text that appear
	 */
	private String text;
	
	/**
	 * Font size
	 */
	private float fontSize;
	
	
	/**
	 * If the font is centred
	 */
	private boolean centred;

	
	public MyText() {
		super();
		this.text = "";
		this.fontSize = 10;
		this.centred = false;
	}

	/**
	 * Parameters Constructor
	 * @param x of the text
	 * @param y of the text
	 * @param fontSize of Text
	 * @param text of the text
	 * @param centred if the text is centred
	 */
	public MyText(float x, float y, float fontSize, String text, boolean centred) {
		super(x, y, 0, 0, "/");
		this.text = text;
		this.fontSize = fontSize;
		this.centred = centred;
	}

	/**
	 * Parameter Constructor
	 * @param position of the text
	 * @param size of the font
	 * @param text of text
	 * @param centred if the text is centred
	 */
	public MyText(Position position, float fontSize, String text, boolean centred) {
		super(position, new Size(), "/");
		this.text = text;
		this.fontSize = fontSize;
		this.centred = centred;
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

	/**
	 * @return the centred
	 */
	public boolean isCentred() {
		return centred;
	}

	/**
	 * @param centred the centred to set
	 */
	public void setCentred(boolean centred) {
		this.centred = centred;
	}
	
	
	
	
	
	
}
