package com.github.practise.frame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JPanel;

import com.github.practise.frame.render.RenderEngine;

public class GamePanel extends JPanel{
	
	private BufferedImage img = null;
	private int[] pixels;
	private Graphics g;
	
	private RenderEngine renderEngine;
	
	public GamePanel(int width, int height){
		
		this.setSize(width, height);
		this.setLayout(null);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		this.renderEngine = new RenderEngine(pixels);
		
	}

	public void init(){
		g = this.getGraphics();
	}
	
	private long last = 0;
	private int frames = 0;
	private int fps = 0;
	
	/**
	 * Tell the component to repaint, and also update frame rate
	 */
	public void render(){
		this.repaint();
		long current = System.currentTimeMillis();
		if(current - last >= 1000){
			last = current;
			fps = frames;
			frames = 0;
		}
		frames++;
	}
	
	public void paintComponent(Graphics g){
		renderEngine.render();
		g.drawImage(img, 0, 0, null);
		g.drawString("FPS: " + fps, 10, 10);
	}
	
}
