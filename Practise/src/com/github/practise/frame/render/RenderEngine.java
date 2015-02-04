package com.github.practise.frame.render;

import java.io.IOException;

import com.github.practice.Game;
import com.github.practise.file.WorldLoader;
import com.github.practise.frame.GamePanel;
import com.github.practise.world.Tile;

public class RenderEngine {

	private int[][] worldSpriteSlots = {{2, 2, 2, 2}, {1, 2, 2, 2}, {10, 2, 2, 2}, {1, 2, 2, 2}};	
	private int[] pixels;
		
	/**
	 * 
	 * @param pixels the int array of pixels from a buffered image. All pixels are handled in this 1D array for speed, and cannot be overridden
	 */
	
	public RenderEngine(int[] pixels){
		this.pixels = pixels;
		worldSpriteSlots = new int[Game.WIDTH / Tile.tileDim][Game.HEIGHT / Tile.tileDim];
		try {
			worldSpriteSlots = WorldLoader.loadMap("test.bin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Handles the rendering of any tile and entity based in their position in their respective array.
	 * 
	 * Optimization may need to be done, but as it stands I can get 500FPS
	 */
	public void render(){
		int maxX = Game.WIDTH / Tile.tileDim;
		int maxY = Game.HEIGHT / Tile.tileDim;
		
		if(worldSpriteSlots.length < maxX)
			maxX = worldSpriteSlots.length;
		
		if(worldSpriteSlots[0].length < maxY)
			maxY = worldSpriteSlots[0].length;
			
		for(int x = 0; x < maxX; x++){
			for(int y = 0; y < maxY; y++){
				
				int id = worldSpriteSlots[x][y];
				int[] sprite = Tile.getTile(id).getPixels();
				
				int xShift = y * Game.WIDTH * Tile.tileDim;
				int yShift = x * Tile.tileDim;
				
				int ind = 0;
				for(int i = 0; i < Tile.tileDim; i++){
					for(int o = 0; o < Tile.tileDim; o++){
						pixels[xShift + yShift + i * Game.WIDTH + o] = sprite[ind];
						ind++;
					}
				}
				
			}
		}
	}
}
