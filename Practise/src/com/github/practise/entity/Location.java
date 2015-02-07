package com.github.practise.entity;

import com.github.practise.world.Tile;

public class Location {

	private int x;
	private int y;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return the X position the entity is at
	 */
	public int getX(){
		return x * Tile.tileDim;
	}
	
	/**
	 * 
	 * @return the Y position the entity is at
	 */
	public int getY(){
		return y * Tile.tileDim;
	}
	
	/**
	 * 
	 * @return the X tile position the entity is on
	 */
	public int getTileX(){
		return x;
	}
	
	/**
	 * 
	 * @return the Y tile position the entity is on
	 */
	public int getTileY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
}
