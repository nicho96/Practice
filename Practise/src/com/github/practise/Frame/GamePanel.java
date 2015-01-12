package com.github.practise.Frame;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;

public class GamePanel extends Panel{
	
	BufferedImage img = null;
	
	public GamePanel(int width, int height){
		
		this.setSize(width, height);
		this.setLayout(null);
		
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
