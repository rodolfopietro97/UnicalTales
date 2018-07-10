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
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * Class which we use for draw renderings.
 * The renderings are a series of images,
 * that simulated movement.
 * this class views all images ina path and draw
 * sequentialli it
 *
 */
public class MyRendering extends Sprite{

	/**
	 * list of images
	 */
	ArrayList<MyImage> images;

	/**
	 * parameters constructor
	 * @param position of rendering
	 * @param size of rendering
	 * @param path of rendering (the folder)
	 */
	public MyRendering(Position position, Size size, String path) {
		super(position, size, path);
		
		images = new ArrayList<>();

		try {
			// trovo tutte le immagini png del rendering
			List<Path> files = Files.walk(Paths.get(path))
				 .filter(p -> p.toString().endsWith(".png"))
				 .distinct()
				 .collect(Collectors.toList());
			
			// aggiungo le immagini
			for (Path p : files) {
				if(GlobalValues.DEBUG) System.out.println(new GlobalValues().getAssetPath(p.getFileName().toString()).toString());
				images.add(new MyImage(position, size, new GlobalValues().getAssetPath(p.getFileName().toString()).toString()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			GlobalValues.EXIT_GAME=true;
		}
		
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
		
		images = new ArrayList<>();
		
		try {
			// trovo tutte le immagini png del rendering
			List<Path> files = Files.walk(Paths.get(path))
					 //.filter(p -> p.toString().endsWith(".png"))
					 .distinct()
					 .collect(Collectors.toList());
			// aggiungo le immagini
			for (Path p : files) {
				if(GlobalValues.DEBUG) System.out.println(new GlobalValues().getAssetPath(p.getFileName().toString()).toString());
				images.add(new MyImage(new Position(x, y), new Size(width, height), new GlobalValues().getAssetPath(p.getFileName().toString()).toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			GlobalValues.EXIT_GAME=true;
		}
	}
	
	/**
	 * @return images of rendering
	 */
	public ArrayList<MyImage> getImages(){
		return images;
	}
	
	
	
	
}
