package it.unicaltales.libgdx.html;

import it.unicaltales.libgdx.core.LibGdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class LibGdxHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new LibGdx();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
