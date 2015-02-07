package com.github.practise.world;

import java.io.IOException;

import com.github.practise.file.WorldLoader;

public class World {

	private int[][] map;
	
	public World(String url, String name){
		try {
			map = WorldLoader.loadMap(url);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public int[][] getMap(){
		return map;
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || x >= map.length || y < 0 || y >= map[0].length)
			return null;
		return Tile.getTile(map[x][y]);
	}
	
}
