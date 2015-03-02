package com.github.practise.entity.type;

import com.github.practise.frame.render.SpriteSheet;

public class EntityType {

	private static EntityType[] types = new EntityType[100];
	private static final SpriteSheet sheet = new SpriteSheet("entity.png", 40);
	
	public static final int entDim = 40;
	protected int[] pixels;
	
	static{
		types[0] = new HumanType(0);
		
		for(int i = 0; i < types.length; i++){
			if(i != 0)
				types[i] = new EntityType(i);
		}
	}
	
	public EntityType(int id){
		this.pixels = sheet.getPixels(id);
	}
	
	public int[] getPixels(){
		return pixels;
	}
	
	public static EntityType getEntityType(int id){
		return types[id];
	}
	
}
