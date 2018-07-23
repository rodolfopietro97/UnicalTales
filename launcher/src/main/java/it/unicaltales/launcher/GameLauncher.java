package it.unicaltales.launcher;

import java.lang.reflect.Method;

import it.unicaltales.businesslogic.bestscoresmanager.BestScoresManager;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.settingsmanager.SettingsFileReader;

/**
 * Main of game.
 * This class uses reflection to run
 * the different implementations
 */
public class GameLauncher 
{
    /**
     * main of the game
     * @param args of main
     */
    public static void main( String[] args )
    {

		// inizializza le globbalvalues (IMPOSTAZIONI)
    	new SettingsFileReader().setGlobalValues();
		// inizializza le globbalvalues (BESTSCORES)
    	new BestScoresManager().setGlobalValues();
    	
    	
    	// attiva il default launcher (per non avere problemi con l' asset path di libgdx)
    	// it actives the default launcher(to avoid problems with path's asset of libgdx)

    	GlobalValues.DEFAULT_LAUNCHER = true;
    	switch (GlobalValues.IMPLEMENTATION) {
			case GlobalValues.SWING_AWT_IMPLEMENTATION:
				runSwingAwt(args);
				break;
			case GlobalValues.JAVAFX_IMPLEMENTATION:
				runJavaFx(args);
				break;
			case GlobalValues.LIBGDX_IMPLEMENTATION:
				runLibGdx(args);
				break;
			default:
				runSwingAwt(args);
				break;
		}
    }

	/**
	 * run with swing/awt
	 * @param args of main
	 */
	private static void runSwingAwt(String[] args) {
		System.out.println("Running swingawt implementation");
		try {
			Class<?> swingawt = Class.forName("it.unicaltales.swingawt.MainFrame");
			Method mainSwingAwt = swingawt.getMethod("main", String[].class);
			mainSwingAwt.invoke(null, (Object) args);
		} catch (Exception e) {
			System.err.println("Impossibile avviare l' implementazione swint/awt");
		}
	}
	
	/**
	 * run with java fx
	 * @param args of main
	 */
	private static void runJavaFx(String[] args) {
		System.out.println("Running java fx implementation");
		try {
			Class<?> swingawt = Class.forName("it.unicaltales.javafx.MainFrame");
			Method mainSwingAwt = swingawt.getMethod("main", String[].class);
			mainSwingAwt.invoke(null, (Object) args);
		} catch (Exception e) {
			System.err.println("Impossibile avviare l' implementazione java fx");
		}
	}

	
	/**
	 * run with java libgdx
	 * @param args of main
	 */
	private static void runLibGdx(String[] args) {
		System.out.println("Running libgdx implementation");
		try {
			Class<?> swingawt = Class.forName("it.unicaltales.libgdx.java.LibGdxDesktop");
			Method mainSwingAwt = swingawt.getMethod("main", String[].class);
			mainSwingAwt.invoke(null, (Object) args);
		} catch (Exception e) {
			System.err.println("Impossibile avviare l' implementazione lib gdx");
		}
	}
    
}
