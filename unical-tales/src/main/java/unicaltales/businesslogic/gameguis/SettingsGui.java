package unicaltales.businesslogic.gameguis;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
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
		if (GlobalValues.IMPLEMENTATION == GlobalValues.JAVAFX_IMPLEMENTATION) {
			try {
				Stage temp = new Stage();
				Parent r = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsGui.fxml"));
				Scene s = new Scene(r);
				temp.setScene(s);
				temp.setTitle("Unical Tales Settings");
				temp.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
				temp.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
				temp.setFullScreen(GlobalValues.FULL_SCREEN);
				temp.setResizable(GlobalValues.RESIZABLE);
				temp.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else launch(null);
	}
}
