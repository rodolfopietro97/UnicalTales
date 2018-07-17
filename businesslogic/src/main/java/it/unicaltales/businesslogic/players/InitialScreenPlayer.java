/**
 * Player package
 */
package it.unicaltales.businesslogic.players;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.ws.Response;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameguis.SettingsGui;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.gameinfo.ScreenTipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class InitialScreenPlayer extends Player {
	/**
	 * Background image of game
	 */
	MyImage background;
	
	/**
	 * Play button (image and text)
	 */
	MyImage bottonePlay;
	MyImage bottoneExit;
	MyImage bottoneSettings;
	MyText playTesto;
	
	/**
	 * Constructor with parameters
	 * @param spriteDraw to use. For example Awt use Graphics
	 * @param hardwareEvents that depend by framwrork
	 */
	public InitialScreenPlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
		putSprite("background", new MyImage(
				0, 
				0, 
				GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight(),
				new GlobalValues().getAssetPath("logo.jpg")));
		
		putSprite("btnPlay", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getAssetPath("button.png")));
		
		putSprite("btnMultiplayer", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150 + 70, 
				GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50,
				new GlobalValues().getAssetPath("button.png")));
		
		putSprite("btnExit", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				15,
				60,
				60,
				new GlobalValues().getAssetPath("exit.jpg")));
		
		putSprite("btnSettings", new MyImage(
				(GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 75,
				60,
				60,
				new GlobalValues().getAssetPath("impostazioni.png")));
		
		putSprite("playText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119, 
				18, 
				"Single Player",
				true));
		
		putSprite("multiplayerText", new MyText(
				GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119 + 70, 
				18, 
				"Multiplayer",
				true));
		
		
	}


	@Override
	public void manageEvents() {
		if (spriteEvents.isClick(getSprite("btnPlay"), hardwareEvents)) GlobalValues.SCREEN_TIPE = ScreenTipe.SINGLE_PLAYER;
		if (spriteEvents.isClick(getSprite("btnExit"), hardwareEvents)) GlobalValues.EXIT_GAME = true;
		if (spriteEvents.isClick(getSprite("btnSettings"), hardwareEvents)) showSettingsWindow();

		drawHover((MyImage) getSprite("btnPlay"));
		drawHover((MyImage) getSprite("btnExit"));
		drawHover((MyImage) getSprite("btnSettings"));
	}


	/**
	 * Show the settings windows with the refleciton
	 */
	private void showSettingsWindow() {
		if (GlobalValues.IMPLEMENTATION != GlobalValues.JAVAFX_IMPLEMENTATION) { // con reflection
			try {
				Class<?> settingGuis = Class.forName("it.unicaltales.businesslogic.gameguis.SettingsGui");
				Method mainSettingsGui = settingGuis.getMethod("main", String[].class);
				String[] args = null;
				mainSettingsGui.invoke(null, (Object) args);
			} catch (Exception e) {
				System.err.println("Impossibile avviare le impostazioni oppure le impostazioni sono appena state chiuse");
			}
		}
		else { // senza reflection
			try {
				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsGui.fxml"));
				Stage primaryStage = new Stage();
		        primaryStage.setTitle("Settings Gui");
		        primaryStage.setMinWidth(GlobalValues.MIN_SIZE_WINDOW.getWidth());
		        primaryStage.setMinHeight(GlobalValues.MIN_SIZE_WINDOW.getHeight());
		        primaryStage.setWidth(GlobalValues.MIN_SIZE_WINDOW.getWidth());
		        primaryStage.setHeight(GlobalValues.MIN_SIZE_WINDOW.getHeight());
		        primaryStage.setResizable(false);
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
			} catch (IOException e) {
				System.err.println("Impossibile avviare le impostazioni oppure le impostazioni sono appena state chiuse");
			}

		}
	}
	
	@Override
	public void onWindowsSizeChange() {
		getSprite("background").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth(), 
				GlobalValues.SIZE_WINDOW.getHeight()));	
		
		getSprite("btnExit").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - 75), 15));
		
		getSprite("btnSettings").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - 75),
				(GlobalValues.SIZE_WINDOW.getHeight()) - 75));
		
		getSprite("btnPlay").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50));
		
		getSprite("btnPlay").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150));
		
		getSprite("btnMultiplayer").setSize(new Size(GlobalValues.SIZE_WINDOW.getWidth() /4, 
				50));
		
		getSprite("btnMultiplayer").setPosition(new Position((GlobalValues.SIZE_WINDOW.getWidth() - GlobalValues.SIZE_WINDOW.getWidth()/4)/2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 150 + 70));
		
		getSprite("playText").setPosition(new Position(GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119));
		
		getSprite("multiplayerText").setPosition(new Position(GlobalValues.SIZE_WINDOW.getWidth() /2, 
				GlobalValues.SIZE_WINDOW.getHeight() - 119 + 70));
			
	}
	
	
	


}
