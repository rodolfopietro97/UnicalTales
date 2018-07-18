/**
 * Package of game components
 */
package it.unicaltales.businesslogic.gamecomponents;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.core.Sprite;

public class MyText extends Sprite{
	/**
	 * Text that appears
	 */
	private String text;
	
	/**
	 * Font size
	 */
	private float fontSize;
	
	
	/**
	 * If the font is centered
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
	 * @param centred if the text is centered
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
	 * @param centred if the text is centered
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
	 * @return the centered
	 */
	public boolean isCentred() {
		return centred;
	}

	/**
	 * @param centred the centered to set
	 */
	public void setCentred(boolean centred) {
		this.centred = centred;
	}
	
	
	
	
	
	
}
