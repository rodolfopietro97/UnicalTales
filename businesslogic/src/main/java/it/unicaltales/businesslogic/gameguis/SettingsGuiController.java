package it.unicaltales.businesslogic.gameguis;

import java.net.URL;
import java.util.ResourceBundle;

import it.unicaltales.businesslogic.gameinfo.DifficultType;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.settingsmanager.SettingsFileWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * @author Camillo
 * This class manages the answers to the actions in the Settings Window
 */
public class SettingsGuiController implements Initializable {
	
	/**
	 * Settings Files writer instance
	 */
	SettingsFileWriter writer;
	
	@FXML
	private Text lblStatus;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//lblStatus = (Label) resources.getObject("lblStatus");
		writer = new SettingsFileWriter();
	}

	public void enableFullScreen() {
		writer.setFullScreen(true);
		lblStatus.setText("Hai abilitato il full screen (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void disableFullScreen() {
		writer.setFullScreen(false);
		lblStatus.setText("Hai disabilitato il full screen (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void difficultEasy() {
		writer.setDifficult(DifficultType.EASY);
		lblStatus.setText("Hai messo in difficoltà easy (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	
	public void difficultMedium() {
		writer.setDifficult(DifficultType.MEDIUM);
		lblStatus.setText("Hai messo in difficoltà medium (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	
	public void difficultHard() {
		writer.setDifficult(DifficultType.HARD);
		lblStatus.setText("Hai messo in difficoltà hard (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useSwingAwt() {
		writer.setImplementation(GlobalValues.SWING_AWT_IMPLEMENTATION);
		lblStatus.setText("Hai messo come framework predefinito Swing/Awt (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useJavaFx() {
		writer.setImplementation(GlobalValues.JAVAFX_IMPLEMENTATION);
		lblStatus.setText("Hai messo come framework predefinito JavaFx (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useLibGdx() {
		writer.setImplementation(GlobalValues.LIBGDX_IMPLEMENTATION);
		lblStatus.setText("Hai messo come framework predefinito LibGdx (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void apply() {
		writer.updateSettingsFile();
		lblStatus.setText("Modifiche effettuate");
		GlobalValues.EXIT_GAME = true;
	}
	
}
