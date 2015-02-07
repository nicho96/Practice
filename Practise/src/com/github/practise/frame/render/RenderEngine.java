package com.github.practise.frame.render;

import java.io.IOException;

import com.github.practice.Game;
import com.github.practise.entity.Player;
import com.github.practise.file.WorldLoader;
import com.github.practise.world.Tile;
import com.github.practise.world.World;

public class RenderEngine {

	private int[][] worldSpriteSlots;
	private int[] pixels;
	
	private World world;
	private final Player player;
		
	/**
	 * 
	 * @param pixels the int array of pixels from a buffered image. All pixels are handled in this 1D array for speed, and cannot be overridden
	 */
	
	public RenderEngine(int[] pixels, final Player player){
		this.pixels = pixels;
		this.player = player;
		this.world = player.getWorld();
		this.worldSpriteSlots = world.getMap();
	}

	/**
	 * Handles the rendering of any tile and entity based in their position in their respective array.
	 * 
	 * Optimization may need to be done, but as it stands I can get 500FPS
	 */
	public void render(){
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
		int[][] loaded = getLoadedTiles(player.getLocation().getTileX(), player.getLocation().getTileY());	
		for(int x = 0; x < loaded.length; x++){
			for(int y = 0; y < loaded[0].length; y++){
				if(loaded[x][y] != -1)
				drawTile(x, y, loaded[x][y], player.getXShift(), player.getYShift());
			}
		}
	}
	
	/**
	 * Draw individual tiles to the screen
	 * @param x the X tile location
	 * @param y the Y tile location
	 * @param id the ID of the tile
	 */
	public void drawTile(int x, int y, int id, int xWalk, int yWalk){
		int xShift = x * Tile.tileDim;
		int yShift = y * Tile.tileDim;
		int[] tile = Tile.getTile(id).getPixels();
		int ind = 0;
		for(int i = 0; i < Tile.tileDim; i++){
			for(int o = 0; o < Tile.tileDim; o++){
				int index = xShift + xWalk + o + Game.WIDTH * ((i + yWalk) + yShift);
				if(index > 0 && index < pixels.length)
					pixels[index] = tile[ind++];
			}
		}
	}
	
	/**
	 * Get an array of loaded tiles
	 * 
	 * @param xShift the shift from where you want to collect tiles in the X
	 * @param yShift the shift from where you want to collect tiles in the y
	 * @return
	 */
	public int[][] getLoadedTiles(int xShift, int yShift){
		int sizeX = Game.WIDTH / Tile.tileDim;
		int sizeY = Game.HEIGHT / Tile.tileDim;
		int[][] loaded = new int[sizeX][sizeY];
		
		for(int i = 0; i < sizeX; i++){
			for(int o = 0; o < sizeY; o++){
				
				int x = xShift + i - sizeX / 2;
				int y = yShift + o - sizeY / 2;
				//A check to make sure pixels are within array bounds, should be an unecessary check in the future
				if(x >= 0 && y >= 0 && x < worldSpriteSlots.length && y < worldSpriteSlots[0].length)
					loaded[i][o] = worldSpriteSlots[x][y];
				
				//TODO REMOVE WHEN POSSIBLE FOR EFFICIENCY
				else
					loaded[i][o] = -1;
			}
		}
		
		return loaded;
	}
	
	
}
