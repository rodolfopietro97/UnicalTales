/**
 * package of java fx graphics implementation
 */
package it.unicaltales.javafx;



import javafx.scene.canvas.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import it.unicaltales.businesslogic.drawer.Drawer;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.drawer.utils.ImagesManager;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.players.PlayerManager;



public class MainFrame extends Application{

	/**
	 * Canvas component that we used to draw
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
	
	/**
	 * Scene of the game
	 */
	Scene scene;
	
	/**
	 * Store the images to draw. It is very useful,
	 * in fact in howToDraw if we make a new Texture
	 * every time, the program will be very slow
	 */
	private ImagesManager imagesToDraw;
	
	
	@Override
	public void init() throws Exception {
		super.init();
		
		gameCanvas = new Canvas(GlobalValues.SIZE_WINDOW.getWidth(), GlobalValues.SIZE_WINDOW.getHeight());
		gameCanvas.setStyle("-fx-margin: 0px;");
		g = gameCanvas.getGraphicsContext2D();
		imagesToDraw = new ImagesManager();

		
		hardwareEvents = new HardwareEvents();
		
		playerScreenManager = new PlayerManager(new SpriteDraw(new Drawer() {
			
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
			
			public void onDrawImage(MyImage image, Object drawerComponent) {
				if(drawerComponent instanceof GraphicsContext) {
					GraphicsContext g = (GraphicsContext) drawerComponent;
					if(!imagesToDraw.exist(image.getPath())) imagesToDraw.putImage(image.getPath(), new Image(image.getPath()));
					g.drawImage((Image) imagesToDraw.getImage(image.getPath()), 
							image.getPosition().getX(), 
							image.getPosition().getY(),
							image.getSize().getWidth(),
							image.getSize().getHeight());
				}
				
			}
		}), hardwareEvents);
		
	}


	@Override
	public void start(final Stage primaryStage) throws Exception {

	    StackPane root = new StackPane();
	    scene = new Scene( root );
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(GlobalValues.FULL_SCREEN);
		primaryStage.setTitle(GlobalValues.WINDOW_TITLE);
		primaryStage.setMinWidth(GlobalValues.MIN_SIZE_WINDOW.getWidth());
		primaryStage.setMinHeight(GlobalValues.MIN_SIZE_WINDOW.getHeight());
		primaryStage.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
		primaryStage.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
		primaryStage.setResizable(GlobalValues.RESIZABLE);
		root.getChildren().add(gameCanvas);
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				updateDraw();
	    		/*
	    		 * Refreshing of globalvalues
	    		 */
	    		if(GlobalValues.RESIZABLE) {
	    			GlobalValues.SIZE_WINDOW.setWidth((float) primaryStage.getWidth());
	    			GlobalValues.SIZE_WINDOW.setHeight((float) primaryStage.getHeight());
	    			gameCanvas.setWidth(GlobalValues.SIZE_WINDOW.getWidth());
	    			gameCanvas.setHeight(GlobalValues.SIZE_WINDOW.getHeight());
	    		}
	    		
	    		if(!GlobalValues.EXIT_GAME) {
	    			playerScreenManager.loop(g);
	    			playerScreenManager.refreshHardwareEvents(hardwareEvents);
	    		}
	    		else System.exit(0);

	    		/*
	    		 * Refresh the just pressed keys and click
	    		 */
				hardwareEvents.resetHardwareEvents();	
				
			}
		}.start();
		

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent e) {
				/*
				 * for key pressed
				 */
				if(hardwareEvents.isKeyPressed(MyKeys.ESC) && e.getCode() == KeyCode.ESCAPE) hardwareEvents.relaseKey(MyKeys.ESC);
				if(hardwareEvents.isKeyPressed(MyKeys.LEFT) && e.getCode() == KeyCode.LEFT) hardwareEvents.relaseKey(MyKeys.LEFT);
				if(hardwareEvents.isKeyPressed(MyKeys.RIGHT) && e.getCode() == KeyCode.RIGHT) hardwareEvents.relaseKey(MyKeys.RIGHT);
				if(hardwareEvents.isKeyPressed(MyKeys.DOWN) && e.getCode() == KeyCode.DOWN) hardwareEvents.relaseKey(MyKeys.DOWN);
				if(hardwareEvents.isKeyPressed(MyKeys.UP) && e.getCode() == KeyCode.UP) hardwareEvents.relaseKey(MyKeys.UP);
				if(hardwareEvents.isKeyPressed(MyKeys.SPACE) && e.getCode() == KeyCode.SPACE) hardwareEvents.relaseKey(MyKeys.SPACE);	
			}
		});
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.ESCAPE) {
					hardwareEvents.pressKey(MyKeys.ESC);
					hardwareEvents.justPressKey(MyKeys.ESC);
				}
				if(e.getCode() == KeyCode.LEFT) {
					hardwareEvents.pressKey(MyKeys.LEFT);
					hardwareEvents.justPressKey(MyKeys.LEFT);
				}
				if(e.getCode() == KeyCode.RIGHT) {
					hardwareEvents.pressKey(MyKeys.RIGHT);
					hardwareEvents.justPressKey(MyKeys.RIGHT);
				}
				if(e.getCode() == KeyCode.DOWN) {
					hardwareEvents.pressKey(MyKeys.DOWN);
					hardwareEvents.justPressKey(MyKeys.DOWN);
				}
				if(e.getCode() == KeyCode.UP) {
					hardwareEvents.pressKey(MyKeys.UP);
					hardwareEvents.justPressKey(MyKeys.UP);
				}
				if(e.getCode() == KeyCode.SPACE) {
					hardwareEvents.pressKey(MyKeys.SPACE);
					hardwareEvents.justPressKey(MyKeys.SPACE);
				}
			}
		});
				
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent e) {
				hardwareEvents.click();
			}
		});
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent e) {
				hardwareEvents.setInputX((float)e.getX());
				hardwareEvents.setInputY((float)e.getY());
			}
		});
		
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

	
	/**
	 * Reset draw
	 */
	public void updateDraw() {
		/*
		 * Redraw part
		 */
		g.clearRect(0, 0, 0, 0);
		g.setFill(Color.WHITE);
		g.fillRect(0,0,
				GlobalValues.SIZE_WINDOW.getWidth(),
				GlobalValues.SIZE_WINDOW.getHeight());
	}
	
	
	public static void main(String[] args) {
		GlobalValues.IMPLEMENTATION = GlobalValues.JAVAFX_IMPLEMENTATION;
		
		MainFrame mainFrame = new MainFrame();
		launch(args);
	}
	
	
}