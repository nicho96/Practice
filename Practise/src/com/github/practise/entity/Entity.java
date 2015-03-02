package com.github.practise.entity;

import java.util.ArrayList;

import com.github.practise.world.Tile;
import com.github.practise.world.World;

public abstract class Entity {
	
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private int id;
	
	protected World world;
	protected Location lookingAt;
	protected boolean isWalking;
	protected int walkDistance;
	protected int dir;

	
	public static ArrayList<Entity> getEntities(){
		return entities;
	}
	
	protected Location loc;
	
	public Entity(int id, Location loc, World world){
		this.id = id;
		this.loc = loc;
		this.world = world;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public Location getLookingLocation(){
		return lookingAt;
	}
	
	protected void move(){
		if(isWalking)
			updateWalk();
		else{
			Tile t = world.getTile(lookingAt.getTileX(), lookingAt.getTileY());
			if(t == null || t.isSolid())
				return;
			isWalking = true;
		}
	}
	
	
	
	/**
	 * Handles movement between tiles
	 */
	protected void updateWalk(){
		if(walkDistance < Tile.tileDim){
			walkDistance += 5;
		}else{
			isWalking = false;
			walkDistance = 0;
			loc = lookingAt;
		}
	}
	
	
	
	public void tick(){
		move();
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getDirection(){
		return dir;
	}
	
	public boolean isWalking(){
		return isWalking;
	}
	
	public static void spawnEntity(Entity ent){
		entities.add(ent);
	}
}
