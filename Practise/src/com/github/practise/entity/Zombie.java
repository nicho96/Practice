package com.github.practise.entity;

import com.github.practise.world.World;

public class Zombie extends Entity{

	public Zombie(int id, Location loc, World world){
		super(id, loc, world);
	}

	public void tick() {
		if(!isWalking){
			int x = loc.getTileX();
			int y = loc.getTileY();
			
			dir = (int)(Math.random() * 4);
			if(dir == 0) x++;
			else if(dir == 1) x--;
			else if(dir == 2) y++;
			else if(dir == 3) y--;
			lookingAt = new Location(x, y);
		}
		move();
	}
	
}
