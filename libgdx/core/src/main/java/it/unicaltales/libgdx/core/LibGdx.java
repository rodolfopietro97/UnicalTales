package it.unicaltales.libgdx.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import it.unicaltales.businesslogic.drawer.Drawer;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.drawer.utils.ImagesManager;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.gamecomponents.MyImage;
import it.unicaltales.businesslogic.gamecomponents.MyText;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.businesslogic.players.PlayerManager;

import org.omg.CORBA.FREE_MEM;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class LibGdx implements ApplicationListener {
	/**
	 * Drawer component
	 */
	SpriteBatch batch;
	
	/**
	 * Hardware Events Manager
	 */
	private HardwareEvents hardwareEvents;
	
	/**
	 * Player Manager of Game
	 */
	private PlayerManager playerScreenManager;
	
	/**
	 * Store the images to draw. It is very useful,
	 * in fact in howToDraw if we make a new Texture
	 * every time, the program will be very slowly
	 */
	private ImagesManager imagesToDraw;


	@Override
	public void create () {
		batch = new SpriteBatch();
		hardwareEvents = new HardwareEvents();
		imagesToDraw = new ImagesManager();
		
		playerScreenManager = new PlayerManager(new SpriteDraw(new Drawer() {
			
			@Override
			public void onDrawText(MyText text, Object drawerComponent) {
				SpriteBatch g = (SpriteBatch) drawerComponent;
				BitmapFont temp = new BitmapFont();
				temp.draw((SpriteBatch) drawerComponent, text.getText(), text.getPosition().getX(), GlobalValues.SIZE_WINDOW.getHeight() - text.getPosition().getY()); 
				
			}
			
			@Override
			public void onDrawImage(MyImage image, Object drawerComponent) {
				SpriteBatch g = (SpriteBatch) drawerComponent;
				if(!imagesToDraw.exist(image.getPath())) imagesToDraw.putImage(image.getPath(), new Texture(Gdx.files.internal(image.getPath())));
				g.draw((Texture) imagesToDraw.getImage(image.getPath()), 
					   image.getPosition().getX(), 
					   GlobalValues.SIZE_WINDOW.getHeight() - image.getPosition().getY() - image.getSize().getHeight(), 
					   image.getSize().getWidth(), 
					   image.getSize().getHeight());
				
			}
		}), hardwareEvents);
		
	}

	@Override
	public void resize (int width, int height) {
		if (GlobalValues.RESIZABLE) {
			GlobalValues.SIZE_WINDOW.setWidth(width);
			GlobalValues.SIZE_WINDOW.setHeight(height);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		/*
		 * On exit event
		 */
		if(!GlobalValues.EXIT_GAME) {
			batch.begin();
			playerScreenManager.loop(this.batch);
			batch.end();
			playerScreenManager.refreshHardwareEvents(hardwareEvents);
		}
		else Gdx.app.exit();

		hardwareEvents.resetHardwareEvents();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
