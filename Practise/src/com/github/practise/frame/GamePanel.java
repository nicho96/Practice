package com.github.practise.frame;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.github.practise.frame.render.SpriteSheet;

public class GamePanel extends Panel{
	
	private BufferedImage img = null;
	private int[] pixels;
	private Graphics g;
	
	private SpriteSheet worldSprite;
	
	public GamePanel(int width, int height){
		
		this.setSize(width, height);
		this.setLayout(null);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		worldSprite = new SpriteSheet("sprite.png", 50);
		
	}
	
	public void update(){
		int[] add = worldSprite.getPixels(44);
		int i = 0;
		for(int y = 0; y < 50; y++){
			for(int x = 0; x < 50; x++){
				pixels[img.getWidth() * y + x] = add[i];
				i++;
			}
		}
	}
	
	public void init(){
		g = this.getGraphics();
	}
	
	public void render(){
		update();
		g.drawImage(img, 0, 0, null);
	}
	
}
