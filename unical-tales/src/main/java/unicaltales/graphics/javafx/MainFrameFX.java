package unicaltales.graphics.javafx;

import java.awt.Canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unicaltales.businesslogic.gameinfo.GlobalValues;

public class MainFrameFX extends Application{

	/**
	 * Canvas component which we used to draw
	 */
	private Canvas gameCanvas;
	
	@Override
	public void init() throws Exception {
		super.init();
		
		gameCanvas = new Canvas();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(new Group()));
		primaryStage.setFullScreen(GlobalValues.FULL_SCREEN);
		primaryStage.setTitle("Unical Tales");
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		
	}


	@Override
	public void stop() throws Exception {
		super.stop();
	}
	
	/**
	 * Launch Settings GUI
	 */
	public void launch() {
		launch(null);
	}

	
	
}
