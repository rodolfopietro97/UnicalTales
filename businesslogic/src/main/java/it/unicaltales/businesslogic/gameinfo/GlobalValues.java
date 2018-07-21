/**
 * Package of game informations
 */
package it.unicaltales.businesslogic.gameinfo;

import java.io.Serializable;

import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.settingsmanager.SettingsFileReader;

/**
 * @author rodolfo
 * Class that contain static game information such as:
 * Window size, game API, scores, and global informations...
 */
public class GlobalValues implements Serializable {
	
	/**
	 * Path of settings file
	 */
	//public static String SETTINGS_FILES_PATH = "/home/rodolfo/settingsfile";
	//public String SETTINGS_FILES_PATH = getClass().getClassLoader().getResource("settingsfile").getPath();
	public String SETTINGS_FILES_PATH = System.getProperty("user.home") + "/settingsfile";

	
	/**
	 * Size of game window
	 */
	public static Size SIZE_WINDOW = new Size(800, 600);
	
	/**
	 * Minimum size of game window
	 */
	public static Size MIN_SIZE_WINDOW = new Size(600, 480);
	
	/**
	 * Describe the game implementation of business logic.
	 * For example we know if is Swing/Awt Implementation, LibGDX Implementation, and others...
	 */
	public static int IMPLEMENTATION = 1; // Swing And Awt of Default
	public static final int SWING_AWT_IMPLEMENTATION = 0;
	public static final int JAVAFX_IMPLEMENTATION = 1;
	public static final int LIBGDX_IMPLEMENTATION = 2;
	
	/**
	 * Window full screen enabled value
	 */
	public static boolean FULL_SCREEN = false;
	
	/**
	 * If we want a resizable window
	 */
	public static final boolean RESIZABLE = true;
	
	/**
	 * Title of window game
	 */
	public static final String WINDOW_TITLE = "Unical Tales";
	
	/**
	 * Ci dice se il gioco è terminato o meno
	 */
	public static boolean EXIT_GAME = false;
	
	/**
	 * The type of Screen that "told us" in which screen we are
	 */
	public static ScreenTipe SCREEN_TIPE = ScreenTipe.INITIAL;
	
	/**
	 * Speed of Character
	 */
	//public static int CHARACTER_SPEED = 3; (DEFAULT)
	public static int CHARACTER_SPEED = 1;
	
	/**
	 * Speed of the enemy
	 */
	public static int ENEMY_SPEED = 1;
	
	/**
	 * Factor of difficult (the acceleration
	 * of character speed and enemy speed)
	 */
	public static int DIFFICULT_FACTOR = 0;
	
	/**
	 * Scores of player
	 */
	public static int SCORES = 0;
	
	/**
	 * Pause of game
	 */
	public static boolean PAUSE_GAME = false;

	/**
	 * Loose of game
	 */
	public static boolean LOOSE_GAME = false;
	
	
	/**
	 * This function get the path of resources of a file
	 * @param asset in which find the complete path
	 * @return the complete path of sprite
	 */
	public String getAssetPath(String asset) {
		if (GlobalValues.IMPLEMENTATION == SWING_AWT_IMPLEMENTATION) {
			return getClass().getClassLoader().getResource(asset).getPath();	
		}
		else if(GlobalValues.IMPLEMENTATION == JAVAFX_IMPLEMENTATION) {
			return asset;
		}
		return asset;
	}
	
	/**
	 * The delay of a rendering
	 */
	public static final long RENDERING_DELAY = 100;
	
	/**
	 * Difficult of game
	 */
	public static DifficultType GAME_DIFFICULT = DifficultType.MEDIUM;
	
	/**
	 * This function get the path of resources 
	 * @return the resource path dependently by framework
	 */
	public String getResourcesPath() {
		if (GlobalValues.IMPLEMENTATION == LIBGDX_IMPLEMENTATION) {
			if(DEFAULT_LAUNCHER) return "../businesslogic/src/main/imagesResources/";
			else return "../../businesslogic/src/main/imagesResources/";	
		}
		else if(GlobalValues.IMPLEMENTATION == SWING_AWT_IMPLEMENTATION) {
			return "../businesslogic/src/main/nonInterlaccedImagesResources/";
		}
		return "../businesslogic/src/main/imagesResources/";
	}
	
	/**
	 * This value told to us, if we re running the application with de default
	 * launcher project, or we are running the project in different
	 * singular mode. It is automatically setted by {@code GameLauncher}
	 * @see it is useful for libgdx implementation. Because
	 * Libgdx desktop implemmentation have a different folder
	 * level, and if we launche it with reflection the asset path change
	 */
	public static boolean DEFAULT_LAUNCHER = false;


}