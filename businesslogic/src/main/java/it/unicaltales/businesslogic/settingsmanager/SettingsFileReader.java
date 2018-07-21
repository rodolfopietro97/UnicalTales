package it.unicaltales.businesslogic.settingsmanager;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;

import it.unicaltales.businesslogic.gameinfo.DifficultType;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

public class SettingsFileReader {
	
	/**
	 * Settings file
	 */
	Path settingsFile;

	/**
	 * Values of settings files
	 */
	String[] values;
	
	/**
	 * No parameters constructor
	 */
	public SettingsFileReader() {
		values = new String[3];
		int count = 0;
		
		// non usiamo GlobalValues.getAssetPath(..) perchè ancora non abbbiamo scelto il framework da utilizzare!
		settingsFile = Paths.get(getClass().getClassLoader().getResource("settingsfile").getPath());
		try (BufferedReader reader = Files.newBufferedReader(settingsFile, Charset.forName("UTF-8"))) {
			String current = null;
			while ((current = reader.readLine()) != null) {
				values[count++] = current;
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Impossibile leggere il file delle impostazioni!");
		}
	}
	
	public void setGlobalValues() {
		// la prima opzione è il full screen
		setFullScreen();
		
		// la seconda opzione è la difficoltà
		setDifficult();
		
		// la terza opzione è il framerork
		setGameImplementation();
	}

	/**
	 * Set the game implementation
	 */
	private void setGameImplementation() {
		switch (values[2]) {
		case "SWINGAWT":
			GlobalValues.IMPLEMENTATION = GlobalValues.SWING_AWT_IMPLEMENTATION;
			break;
			
		case "JAVAFX":
			GlobalValues.IMPLEMENTATION = GlobalValues.JAVAFX_IMPLEMENTATION;
			break;
			
		case "LIBGDX":
			GlobalValues.IMPLEMENTATION = GlobalValues.LIBGDX_IMPLEMENTATION;
			break;

		default:
			GlobalValues.IMPLEMENTATION = GlobalValues.SWING_AWT_IMPLEMENTATION;
			break;
		}
	}

	/**
	 * Set the difficult
	 */
	private void setDifficult() {
		switch (values[1]) {
		case "EASY":
			GlobalValues.GAME_DIFFICULT = DifficultType.EASY;
			break;
			
		case "MEDIUM":
			GlobalValues.GAME_DIFFICULT = DifficultType.MEDIUM;
			break;
			
		case "HARD":
			GlobalValues.GAME_DIFFICULT = DifficultType.HARD;
			break;

		default:
			GlobalValues.GAME_DIFFICULT = DifficultType.EASY;
			break;
		}
	}

	/**
	 * Set if full screen or not
	 */
	private void setFullScreen() {
		switch (values[0]) {
		case "FULL_SCREEN_ON":
			GlobalValues.FULL_SCREEN = true;
			break;

		default:
			GlobalValues.FULL_SCREEN = false;
			break;
		}
	}

}
