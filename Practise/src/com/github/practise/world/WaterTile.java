package com.github.practise.world;

import com.github.practise.entity.Entity;

public class WaterTile extends Tile{

	public WaterTile(int id, String name, boolean isSolid) {
		super(id, name, isSolid);
	}

	public void interact(Entity ent){
		System.out.println("INTERACT");
	}
	
}
