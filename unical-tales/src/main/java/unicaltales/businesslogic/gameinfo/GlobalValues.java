/**
 * 
 */
package unicaltales.businesslogic.gameinfo;

import unicaltales.businesslogic.core.Size;

/**
 * @author rodolfo
 * Class that contain static game information such as:
 * Window size, game API, scores, and global informations...
 */
public class GlobalValues {
	
	/**
	 * Size of game window
	 */
	public static Size SIZE_WINDOW = new Size(800, 600);
	
	/**
	 * Describe the game implementation of business logic.
	 * For example we know if is Swing/Awt Implementation, LibGDX Implementation, and others...
	 */
	public static int IMPLEMENTATION = 0; // Swing And Awt of Default
	public static final int SWING_AWT_IMPLEMENTATION = 0;
	public static final int LIBGDX_IMPLEMENTATION = 1;
	
	/**
	 * Window full screen enabled value
	 */
	public static final boolean FULL_SCREEN = false;
	
	/**
	 * Title of window game
	 */
	public static final String WINDOW_TITLE = "Unical Tales";
	
	/**
	 * Ci dice se il gioco è terminato o meno
	 */
	public static boolean EXIT_GAME = false;
	
	/**
	 * The type of Screen that "say us" in wich screen we are
	 */
	public static ScreenTipe SCREEN_TIPE = ScreenTipe.INITIAL;

}
