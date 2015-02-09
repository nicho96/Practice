package com.github.practise.entity;

import com.github.practise.entity.controller.Keyboard;
import com.github.practise.world.Tile;
import com.github.practise.world.World;

public class Player extends Entity{

	private Keyboard keyboard;
	
	private World world;
	
	private int dir = 0;
	private int walkDistance;
	private boolean isWalking;
	private Location lookingAt;
	
	/**
	 * Creates an instance of the player. There should only ever be one player, if we do go multiplayer support the player call will extend a human entity class, and the human entity class will be the entity on any connected players. 
	 * @param loc the initial location of the player
	 * @param keyboard the controller for this player
	 */
	public Player(Location loc, Keyboard keyboard, World world){
		super(loc);
		this.keyboard = keyboard;
		this.world = world;
	}


	/**
	 * The "heart" of the player. This method is called whenever the game updates.
	 */
	public void tick() {
		move();
		if(keyboard.SPACE.isPressed)
			placeTile();
	}
	
	/**
	 * Move method which sets direction of motion, and updates the walk animation if needed
	 */
	private void move(){
		if(isWalking)
			updateWalk();
		else{
			if(keyboard.UP.isPressed) dir = 0;
			else if(keyboard.LEFT.isPressed) dir = 1;
			else if(keyboard.DOWN.isPressed) dir = 2;
			else if(keyboard.RIGHT.isPressed) dir = 3;
			
			int locX = loc.getTileX();
			int locY = loc.getTileY();

			if(dir == 0) locY--;
			else if(dir == 1) locX--;
			else if(dir == 2) locY++;
			else if(dir == 3) locX++;
			lookingAt = new Location(locX, locY);
			//System.out.println(dir);
			if(keyboard.W.isPressed){
			Tile t = world.getTile(locX, locY);
				if(t == null || t.isSolid())
					return;
				isWalking = true;
			}
		}
	}
	
	/**
	 * Handles movement between tiles
	 */
	private void updateWalk(){
		if(walkDistance < Tile.tileDim){
			walkDistance += 5;
		}else{
			isWalking = false;
			walkDistance = 0;
			loc = lookingAt;
		}
	}
	
	/**
	 * 
	 * @return the xShift of the player as they walk between tiles
	 */
	public int getXShift(){
		if(dir == 1)
			return walkDistance;
		if(dir == 3)
			return -walkDistance;
		return 0;
	}
	
	/**
	 * 
	 * @return the yShift of the player as they walk between tiles
	 */
	public int getYShift(){
		if(dir == 0)
			return walkDistance;
		if(dir == 2)
			return -walkDistance;
		return 0;
	}
	
	public Location getLookingLocation(){
		return lookingAt;
	}
	
	public void placeTile(){
		Tile t = world.getTile(lookingAt.getTileX(), lookingAt.getTileY());
		if(t != null)
			world.getMap()[lookingAt.getTileX()][lookingAt.getTileY()] = 12;
				
	}
	
	public World getWorld(){
		return world;
	}
	
}
