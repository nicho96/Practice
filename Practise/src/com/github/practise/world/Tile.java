package com.github.practise.world;

import com.github.practise.frame.render.SpriteSheet;

public class Tile {
		
	//Array of all tiles in the game
	private static Tile[] tiles = new Tile[100];
	
	public static int tileDim = 40;
	private static SpriteSheet tileSheet = new SpriteSheet("sprite.png", tileDim);
	
	private int id;
	private String name;
	private boolean isSolid;
	private int[] sprite;
	
	/**
	 * All we need to do is initialize any tile we make in this block. No more tile initialization required
	 */
	static{
		new WaterTile(0, "Water", false);
		for(int i = 1; i < 100; i++)
			new Tile(i, i + "", false);
	}
	
	/**
	 * 
	 * @param id Id of the tile. Must be same as sprite ID
	 * @param name the name of the tile
	 * @param isSolid whether or not the tile is solid
	 */
	public Tile(int id, String name, boolean isSolid){
		this.id = id;
		this.name = name;
		this.isSolid = isSolid;
		sprite = tileSheet.getPixels(id);
		registerTile(this);
	}
	
	/**
	 * 
	 * @return the ID of the tile
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * 
	 * @return the array (sprite) of pixels associated with this tile
	 */
	public int[] getPixels(){
		return sprite;
	}
	
	/**
	 * Register the tile into the array of tiles
	 * @param tile the tile you want to add
	 */
	public static void registerTile(Tile tile){
		if(tiles[tile.getID()] == null)
			tiles[tile.getID()] = tile;
	}
	
	/**
	 * 
	 * @param id the ID of the tile you want to get
	 * @return the tile if it has a valid ID
	 */
	public static Tile getTile(int id){
		Tile t = tiles[id];
		if(t == null)
			return tiles[0];
		return t;
	}
}
