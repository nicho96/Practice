package com.github.practise.frame.render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private int[] spriteData;
	private int spriteDim;
	private int tileDim;
		
	/**
	 * Create an instance of a sprite sheet for a specific file. Any world tiles should be added to it
	 * 
	 * An IO exception may be caught, in which case the program terminates as there would be issues with rendering
	 * @param url The source of the sprite sheet file
	 * @param tileDim the dimension of a tile (currently 40)
	 */
	public SpriteSheet(String url, int tileDim){
		this.tileDim = tileDim;
		try {
			loadSpriteData(url);
		} catch (IOException e) {
			System.out.println("Error: Failed to load sprite sheet - " + e.getMessage());
			System.exit(-1);
		}
		
		this.spriteDim = (int) Math.sqrt(spriteData.length / tileDim / tileDim);	
		System.out.println("Loaded sprite sheet: " + url);
				
	}
	
	/**
	 * 
	 * @param url The source of the sprite sheet file
	 * @throws IOException if the file is not available, an IO exception is thrown
	 */
	private void loadSpriteData(String url) throws IOException{
		BufferedImage img = ImageIO.read(new File("res",  url));
		spriteData = new int[img.getWidth() * img.getHeight()];
		int i = 0;
		for(int x = 0; x < img.getWidth(); x++){
			for(int y = 0; y < img.getHeight(); y++){
				spriteData[i] = img.getRGB(y, x);
				i++;	
			}
		}

	}
	
	/**
	 * 
	 * @param id the id (0 - max) of the sprite slot you want to get
	 * @return byte array of the pixels at that sprite slot
	 */
	public int[] getPixels(int id){
		int[] ret = new int[tileDim * tileDim];
		
		int i = id % spriteDim;
		int yShift = tileDim * tileDim * spriteDim * (id / spriteDim);
		
		for(int y = 0; y < tileDim; y++){
			for(int x = 0; x < tileDim; x++){
				ret[y * tileDim + x] = spriteData[yShift + tileDim * (i + y  * spriteDim) + x]; 
			}
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @return the dimension of a tile
	 */
	public int getTileDim(){
		return tileDim;
	}
	
}
