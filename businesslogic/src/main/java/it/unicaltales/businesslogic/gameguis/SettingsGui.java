package it.unicaltales.businesslogic.gameguis;

import java.net.URL;

import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Camillo
 * This class represents the graphic settings of the Settings Window
 */
public class SettingsGui extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsGui.fxml"));
        primaryStage.setTitle("Settings Gui");
        primaryStage.setMinWidth(GlobalValues.MIN_SIZE_WINDOW.getWidth());
        primaryStage.setMinHeight(GlobalValues.MIN_SIZE_WINDOW.getHeight());
        primaryStage.setWidth(GlobalValues.MIN_SIZE_WINDOW.getWidth());
        primaryStage.setHeight(GlobalValues.MIN_SIZE_WINDOW.getHeight());
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
