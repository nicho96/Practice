package com.github.practise.frame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JPanel;

import com.github.practice.Game;
import com.github.practise.entity.Player;
import com.github.practise.frame.render.RenderEngine;
import com.github.practise.world.Tile;

public class GamePanel extends JPanel{
	
	private BufferedImage img = null;
	private int[] pixels;
	
	private Player player;
	private RenderEngine renderEngine;
	
	public GamePanel(int width, int height, final Player player){
		
		this.setSize(width, height);
		this.setLayout(null);
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		this.renderEngine = new RenderEngine(pixels, this.player = player);
		
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
		g.fillRect(Game.WIDTH / 2, Game.HEIGHT / 2 - 20, 40, 40);
		
		int xShift = player.getLocation().getTileX() - player.getLookingLocation().getTileX();
		int yShift = player.getLocation().getTileY() - player.getLookingLocation().getTileY();
		
		g.fillRect(Game.WIDTH / 2 - xShift * 40 + 10, Game.HEIGHT / 2 - yShift * 40 - 10, 20, 20);
		g.drawString("FPS: " + fps, 10, 10);
		g.drawString("Pos: " + player.getLocation().getTileX() + "   " + player.getLocation().getTileY(), 10, 30);
	}
	
}
