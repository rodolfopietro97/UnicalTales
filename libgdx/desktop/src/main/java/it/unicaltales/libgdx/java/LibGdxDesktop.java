package it.unicaltales.libgdx.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import it.unicaltales.businesslogic.gameinfo.GlobalValues;
import it.unicaltales.libgdx.core.LibGdx;

public class LibGdxDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//GlobalValues.IMPLEMENTATION = GlobalValues.;
		/**
		 * @see {
		 * 		config.fullscreen = GlobalValues.FULL_SCREEN;
		 *		config.resizable = GlobalValues.RESIZABLE;
		 * }
		 * 
		 * uncomment if you want a resizable window or a full screen winow.
		 * BUT with this implementation the game will be very slow
		 */
		config.resizable = false;
		
		config.title = GlobalValues.WINDOW_TITLE;
		config.width = (int) GlobalValues.SIZE_WINDOW.getWidth();
		config.height = (int) GlobalValues.SIZE_WINDOW.getHeight();
		new LwjglApplication(new LibGdx(), config);
	}
}
