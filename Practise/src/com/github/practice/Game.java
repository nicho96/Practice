package com.github.practice;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.practise.frame.GamePanel;
import com.github.practise.frame.render.SpriteSheet;

public class Game extends JFrame implements Runnable{
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	public static void main(String[] args){
		
		new Game();
		
	}
	
	private GamePanel p;
		
	public Game(){
		this.setBounds(10, 10, WIDTH, HEIGHT);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(p = new GamePanel(WIDTH, HEIGHT));
		
		this.start();
	}
	
	public void start(){
		p.init();
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		long past = System.currentTimeMillis();
		while(true){
			long current = System.currentTimeMillis();
			
			if(current - past > 30){
				p.render();
				past = current;
			}
				
		}
	}
	
}
