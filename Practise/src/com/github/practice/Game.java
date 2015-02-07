package com.github.practice;

import java.io.IOException;

import javax.swing.JFrame;

import com.github.practise.entity.Location;
import com.github.practise.entity.Player;
import com.github.practise.entity.controller.Keyboard;
import com.github.practise.file.WorldLoader;
import com.github.practise.frame.GamePanel;

public class Game extends JFrame implements Runnable{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private final Player player;
	
	private boolean lockedFPS = false;
	
	public static void main(String[] args){
		
		new Game();
		/*try {
			WorldLoader.generateMapFromText("map.txt", "map.bin");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}
	
	private GamePanel p;
		
	/**
	 * An object of the game. This constructor prepares the frame, initializes the game panel,
	 * creates the player, starts the secondary thread (which runs game updates).
	 */
	public Game(){
		this.setBounds(10, 10, WIDTH + 16, HEIGHT + 39);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		player = new Player(new Location(0, 0), new Keyboard(this));
		
		this.add(p = new GamePanel(WIDTH, HEIGHT, player));
		this.start();
	}
	
	/**
	 * Start the game safely (may need to trigger some booleans here for pausing
	 */
	public void start(){
		new Thread(this).start();
	}
	
	/**
	 * Secondary thread which runs game updates
	 */
	public void run() {
		long past = System.currentTimeMillis();
		while(true){
			long current = System.currentTimeMillis();
			if(current - past > 30){
				past = current;
				player.tick();
				p.render();
			}
		}
	}
	
}
