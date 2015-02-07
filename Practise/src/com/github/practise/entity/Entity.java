package com.github.practise.entity;

import java.util.ArrayList;

public abstract class Entity {
	
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public static ArrayList<Entity> getEntities(){
		return entities;
	}
	
	protected Location loc;
	
	public Entity(Location loc){
		this.loc = loc;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public abstract void tick();
	
	protected static void registerEntity(){
		
	}
}
