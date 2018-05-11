package unicaltales.businesslogic.gameguis;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unicaltales.businesslogic.gameinfo.GlobalValues;

public class SettingsGui extends Application {

	/**
	 * Root Panel of Settings GUI
	 */
	Parent root;
	
	/**
	 * Scene of Settings GUI
	 */
	Scene scene;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsGui.fxml"));
			scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Unical Tales Settings");
			primaryStage.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
			primaryStage.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
			primaryStage.setFullScreen(GlobalValues.FULL_SCREEN);
			primaryStage.setResizable(GlobalValues.RESIZABLE);
			primaryStage.show();
			
		} catch (IOException e) {
			System.out.println("Error on the initializzation of Settings Window");
			GlobalValues.EXIT_GAME = true;
			e.printStackTrace();
		}
		
	}

	/**
	 * Launch Settings GUI
	 */
	public void launch() {
		launch(null);
	}
}
