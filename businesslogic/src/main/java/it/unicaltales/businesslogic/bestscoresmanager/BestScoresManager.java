package it.unicaltales.businesslogic.bestscoresmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * "Bridge" class between GlobalValues
 * and bestscores.txt file
 */
public class BestScoresManager {
	/**
	 * Settings file
	 */
	Path scoreFile;

	
	public BestScoresManager() {
		scoreFile = Paths.get(new GlobalValues().BEST_SCORE_PATH);
	}
	
	/**
	 * Read method that set the best scores
	 * of global values by the reading of
	 * file
	 */
	public void setGlobalValues() {
		try (BufferedReader reader = Files.newBufferedReader(scoreFile, Charset.forName("UTF-8"))) {
			GlobalValues.BEST_SCORE = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (Exception e) {
			System.err.println("Impossibile leggere il file delle best scores!");
		}
	}
	
	/**
	 * Write method that set the best scores
	 * of the file by the reading of 
	 * GlobalValues
	 */
	public void setBestScoreFile() {
		try (BufferedWriter writer = Files.newBufferedWriter(scoreFile, Charset.forName("UTF-8"))){
			writer.write(GlobalValues.BEST_SCORE + "");
			writer.close();
		} catch (Exception e) {
			System.out.println("Impossibile scrivere sul file delle best score");
		}
	}
}
