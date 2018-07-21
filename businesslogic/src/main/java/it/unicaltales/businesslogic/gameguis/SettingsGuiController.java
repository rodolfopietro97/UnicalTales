package it.unicaltales.businesslogic.gameguis;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

/**
 * @author Camillo
 * This class manages the answers to the actions in the Settings Window
 */
public class SettingsGuiController implements Initializable {
	
	public void enableFullScreen() {
		System.out.println("Hai abilitato il full screen (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void disableFullScreen() {
		System.out.println("Hai disabilitato il full screen (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void difficultEasy() {
		System.out.println("Hai messo in difficoltà easy (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	
	public void difficultMedium() {
		System.out.println("Hai messo in difficoltà medium (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	
	public void difficultHard() {
		System.out.println("Hai messo in difficoltà hard (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useSwingAwt() {
		System.out.println("Hai messo come framework predefinito Swing/Awt (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useJavaFx() {
		System.out.println("Hai messo come framework predefinito JavaFx (Le modifiche saranno visibili al prossimo avvio)");
	}
	
	public void useLibGdx() {
		System.out.println("Hai messo come framework predefinito LibGdx (Le modifiche saranno visibili al prossimo avvio)");
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
	}

}
