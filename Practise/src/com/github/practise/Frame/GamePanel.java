package com.github.practise.Frame;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GamePanel extends Panel{
	
	private BufferedImage img = null;
	private int[] pixels;
	private Graphics g;
	
	public GamePanel(int width, int height){
		
		this.setSize(width, height);
		this.setLayout(null);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
	}
	
	public void update(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = pixels[i] + (int)(0.5 * i);
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
