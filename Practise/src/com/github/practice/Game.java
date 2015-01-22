package com.github.practice;

import javax.swing.JFrame;

import com.github.practise.Frame.GamePanel;

public class Game extends JFrame implements Runnable{
	
	public static void main(String[] args){
		
		new Game();
		
	}
	
	private GamePanel p;
		
	public Game(){
		this.setBounds(10, 10, 500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(p = new GamePanel(500, 500));
		
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
