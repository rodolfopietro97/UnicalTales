/**
 * 
 */
package it.unicaltales.businesslogic.gamecomponents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.core.Sprite;
import it.unicaltales.businesslogic.drawer.SpriteDraw;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * Class which we use for draw renderings.
 * The renderings are a series of images,
 * that simulated movement.
 * this class views all images in a path and draw
 * Sequentially it
 *
 */
public class MyRendering extends Sprite{

	/**
	 * list of images
	 */
	ArrayList<MyImage> images;
	
	/**
	 * It is the index of rendering to draw,
	 * it auto increments every call of getRenderingIndex
	 */
	int renderingIndex;
	
	/**
	 * Thread that manage animation of rendering
	 * (it is useful because it manage the delay
	 * of rendering)
	 */
	Thread animationThread;
	
	/**
	 * Init function of rendering. it init all
	 * parts useful of rendering
	 * @param x position of rendering
	 * @param y position of rendering
	 * @param width of rendering
	 * @param height of rendering
	 * @param path path of rendering
	 */
	private void init(float x, float y, float width, float height, String path) {
		images = new ArrayList<>();

		renderingIndex = 0;
		
		try {
			// trovo tutte le immagini png del rendering
			List<Path> files = Files.walk(Paths.get(path))
				 .filter(p -> p.toString().endsWith(".png"))
				 .distinct()
				 .collect(Collectors.toList());
			
			// aggiungo le immagini
			for (Path p : files) {
				if(GlobalValues.DEBUG) System.out.println(new GlobalValues().getAssetPath(p.getFileName().toString()).toString());
				images.add(new MyImage(new Position(x,y), new Size(width, height), new GlobalValues().getAssetPath(p.getFileName().toString()).toString()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			GlobalValues.EXIT_GAME=true;
		}
		
		// thread che gestisce il rendering 
		animationThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						if(renderingIndex < images.size()-1) renderingIndex++;
						else renderingIndex = 0;
						Thread.currentThread().sleep(GlobalValues.RENDERING_DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					
				}
			}
		});
		animationThread.start();
	}

	/**
	 * parameters constructor
	 * @param position of rendering
	 * @param size of rendering
	 * @param path of rendering (the folder)
	 */
	public MyRendering(Position position, Size size, String path) {
		super(position, size, path);
		init(position.getX(), position.getY(), size.getWidth(), size.getHeight(), path);
	}

	/**
	 * parameters constructor
	 * @param x position of rendering
	 * @param y position of rendering
	 * @param width of rendering
	 * @param height of rendering
	 * @param path path of rendering
	 */
	public MyRendering(float x, float y, float width, float height, String path) {
		super(x, y, width, height, path);
		init(x, y, width, height, path);
	}
	
	/**
	 * @return images of rendering
	 */
	public ArrayList<MyImage> getImages(){
		return images;
	}
	
	/**
	 * @return the current image of rendering
	 */
	public MyImage getCurrentImage() {
		return images.get(renderingIndex);
	}
	
	/**
	 * the loop of rendering
	 */
	public void loop(SpriteDraw spriteDraw, Object drawerComponent) {
		spriteDraw.drawImage(getCurrentImage(), drawerComponent);
	}

	/*
	 * Setters reimplemented
	 */
	
	/* (non-Javadoc)
	 * @see it.unicaltales.businesslogic.core.GameObject#setPosition(it.unicaltales.businesslogic.core.Position)
	 */
	@Override
	public void setPosition(Position position) {
		// TODO Auto-generated method stub
		super.setPosition(position);
		
		for (MyImage i : images) {
			i.setPosition(position);
		}
	}

	/* (non-Javadoc)
	 * @see it.unicaltales.businesslogic.core.GameObject#setPosition(float, float)
	 */
	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		super.setPosition(x, y);
		
		for (MyImage i : images) {
			i.setPosition(new Position(x, y));
		}
	}

	/* (non-Javadoc)
	 * @see it.unicaltales.businesslogic.core.GameObject#setSize(it.unicaltales.businesslogic.core.Size)
	 */
	@Override
	public void setSize(Size size) {
		// TODO Auto-generated method stub
		super.setSize(size);
		
		for (MyImage i : images) {
			i.setSize(size);
		}
	}

	/* (non-Javadoc)
	 * @see it.unicaltales.businesslogic.core.GameObject#setSize(float, float)
	 */
	@Override
	public void setSize(float w, float h) {
		// TODO Auto-generated method stub
		super.setSize(w, h);
		
		for (MyImage i : images) {
			i.setSize(new Size(w, h));
		}
	}
	
	
	
	
	
}
