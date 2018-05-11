package unicaltales.main;

import unicaltales.businesslogic.gameinfo.GlobalValues;
import unicaltales.graphics.javafx.MainFrameFX;
import unicaltales.graphics.swingawt.MainFrame;

public class UnicalTalesMain {
	
	/**
	 * Main Method of game
	 */
	public static void main(String[] args) {
		switch (GlobalValues.IMPLEMENTATION) {
		case GlobalValues.SWING_AWT_IMPLEMENTATION:
			MainFrame swingAwtImplemtation = new MainFrame();
			swingAwtImplemtation.setVisible(true);
			break;

		case GlobalValues.JAVAFX_IMPLEMENTATION:
			MainFrameFX mainFrameFX = new MainFrameFX();
			mainFrameFX.launch();
			break;
			
		case GlobalValues.LIBGDX_IMPLEMENTATION:
			break;
			
		default:
			break;
		}
	}
}
