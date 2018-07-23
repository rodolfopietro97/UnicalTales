package it.unicaltales.businesslogic.settingsmanager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.unicaltales.businesslogic.gameinfo.DifficultType;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

public class SettingsFileWriter {
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
	public SettingsFileWriter() {
		values = new SettingsFileReader().getCurrentvalues(); // per non vare parametri null
		
		settingsFile = Paths.get(new GlobalValues().SETTINGS_FILES_PATH);
	}
	
	/**
	 * Set full screen 
	 * @param fullScreen or not
	 */
	public void setFullScreen(boolean fullScreen) {
		if(fullScreen) {
			values[0] = "FULL_SCREEN_ON";
		}
		else {
			values[0] = "FULL_SCREEN_OFF";
		}
	}
	
	/**
	 * Set Difficult 
	 * @param difficult of game
	 */
	public void setDifficult(DifficultType difficult) {
		switch (difficult) {
		case EASY:
			values[1] = "EASY";
			break;
			
		case MEDIUM:
			values[1] = "MEDIUM";
			break;
			
		case HARD:
			values[1] = "HARD";
			break;
			
		default:
			values[1] = "EASY";
			break;
		}
	}
	
	
	/**
	 * Set Implementation
	 * @param implementation of game
	 */
	public void setImplementation(int implementation) {
		switch (implementation) {
		case GlobalValues.SWING_AWT_IMPLEMENTATION:
			values[2] = "SWINGAWT";
			break;
			
		case GlobalValues.JAVAFX_IMPLEMENTATION:
			values[2] = "JAVAFX";
			break;
			
		case GlobalValues.LIBGDX_IMPLEMENTATION:
			values[2] = "LIBGDX";
			break;
			
		default:
			values[2] = "SWINGAWT";
			break;
		}
	}
	
	/**
	 * Set Audio on or off
	 * @param audio true or false
	 */
	public void setAudio(Boolean audio) {
		if(audio) {
			values[3] = "AUDIO_ON";
		}
		else {
			values[3] = "AUDIO_OFF";
		}
	}
	
	
	/**
	 * Set modify to GlobalValues
	 */
	public void updateSettingsFile() {
		try (BufferedWriter writer = Files.newBufferedWriter(settingsFile, Charset.forName("UTF-8"))){
			for (int i = 0; i < values.length; i++) {
				writer.write(values[i] + "\n");
			}
		} catch (Exception e) {
			System.out.println("Impossibile scrivere sul file delle impostazioni");
		}

	}
}
