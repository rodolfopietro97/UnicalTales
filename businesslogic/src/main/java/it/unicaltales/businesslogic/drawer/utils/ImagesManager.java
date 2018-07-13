package it.unicaltales.businesslogic.drawer.utils;

import java.util.HashMap;

/**
 * @author rodolfo
 * Class that manage images.
 * With this class we don't need to reallocate a new image in
 * every call of draw!
 * @see {we can see it's utility in the howToDraw part}
 */
public class ImagesManager {
	
	/**
	 * Map which associate path and relative images.
	 * the path is a primary key!
	 */
	private HashMap<String, Object> images;
	
	/**
	 * Empty Constructor
	 */
	public ImagesManager() {
		images = new HashMap<String, Object>();
	}
	
	/**
	 * Put an image in the path
	 * @param path of image
	 * @param image to put
	 */
	public void putImage(String path, Object image) {
		images.put(path, image);
	}
	
	/**
	 * Get an image at the path path
	 * @param path of image
	 * @return image at the path
	 */
	public Object getImage(String path) {
		return images.get(path);
	}
	
	/**
	 * Say if the image exist in the map
	 * @param path of image
	 * @return true if the image exist, false if not
	 */
	public boolean exist(String path) {
		for(String i : images.keySet()) {
			if(i.equals(path)) return true;
		}
		return false;
	}
	

}
