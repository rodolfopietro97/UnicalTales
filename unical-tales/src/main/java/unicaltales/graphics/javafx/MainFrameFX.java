package unicaltales.graphics.javafx;

import javafx.scene.canvas.*;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import unicaltales.businesslogic.core.player.PlayerManager;
import unicaltales.businesslogic.draw.Drawer;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gamecomponents.MyText;
import unicaltales.businesslogic.gameinfo.GlobalValues;

public class MainFrameFX extends Application{

	/**
	 * Canvas component which we used to draw
	 */
	private Canvas gameCanvas;
	
	/**
	 * Graphics context of game
	 */
	private GraphicsContext g;
	
	/**
	 * Hardware Events Manager
	 */
	private HardwareEvents hardwareEvents;
	
	/**
	 * Player Manager of Game
	 */
	private PlayerManager playerScreenManager;
	
	
	@Override
	public void init() throws Exception {
		super.init();
		
		gameCanvas = new Canvas(GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight());
		gameCanvas.setStyle("-fx-margin: 0px;");
		g = gameCanvas.getGraphicsContext2D();
		
		hardwareEvents = new HardwareEvents();
		playerScreenManager = new PlayerManager(new SpriteDraw(new Drawer() {
			
			@Override
			public void onDrawText(MyText text, Object drawerComponent) {

				if(drawerComponent instanceof GraphicsContext) {
					GraphicsContext g = (GraphicsContext) drawerComponent;
		            g.setFill( Color.BLACK );
					Font f = new Font("Dialog",  (int) text.getFontSize());
					if(text.isCentred()) g.setTextAlign(TextAlignment.CENTER);
					g.setFont(f);
					g.fillText(text.getText(), text.getPosition().getX(), text.getPosition().getY());
				}
			}
			
			@Override
			public void onDrawImage(MyImage image, Object drawerComponent) {
				if(drawerComponent instanceof GraphicsContext) {
					GraphicsContext g = (GraphicsContext) drawerComponent;
					g.drawImage(new Image(image.getPath()), 
							image.getPosition().getX(), 
							image.getPosition().getY(),
							image.getSize().getWidth(),
							image.getSize().getHeight());
				}
			}
		}), hardwareEvents);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {

	    StackPane root = new StackPane();
	    Scene scene = new Scene( root );
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(GlobalValues.FULL_SCREEN);
		primaryStage.setTitle(GlobalValues.WINDOW_TITLE);
		primaryStage.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
		primaryStage.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
		primaryStage.setResizable(GlobalValues.RESIZABLE);
		root.getChildren().add(gameCanvas);
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				g.clearRect(0, 0, 0, 0);
				g.setFill( new Color(1, 1, 1, 1) );
	            
	    		/*
	    		 * Refreeshing delle globalvalues
	    		 */
	    		if(GlobalValues.RESIZABLE) {
	    			GlobalValues.SIZE_WINDOW.setWidth((float) primaryStage.getWidth());
	    			GlobalValues.SIZE_WINDOW.setHeight((float) primaryStage.getHeight());
	    			gameCanvas.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
	    			gameCanvas.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
	    		}
	    		
				playerScreenManager.loop(g);
				playerScreenManager.refreshHardwareEvents(hardwareEvents);
			}
		}.start();

		
		primaryStage.show();
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
