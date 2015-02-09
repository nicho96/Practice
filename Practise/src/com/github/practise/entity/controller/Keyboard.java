package com.github.practise.entity.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.practice.Game;
import com.github.practise.entity.Location;

public class Keyboard implements KeyListener{
	
	public final Key W = new Key();
	public final Key UP = new Key();
	public final Key LEFT = new Key();
	public final Key DOWN = new Key();
	public final Key RIGHT = new Key();
	public final Key SPACE = new Key();

	
	public Keyboard(Game g){
		g.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38)
			UP.isPressed = true;
		if(e.getKeyCode() == 37)
			LEFT.isPressed = true;
		if(e.getKeyCode() == 40)
			DOWN.isPressed = true;
		if(e.getKeyCode() == 39)
			RIGHT.isPressed = true;
		if(e.getKeyCode() == 87)
			W.isPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			SPACE.isPressed = true;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 38)
			UP.isPressed = false;
		if(e.getKeyCode() == 37)
			LEFT.isPressed = false;
		if(e.getKeyCode() == 40)
			DOWN.isPressed = false;
		if(e.getKeyCode() == 39)
			RIGHT.isPressed = false;
		if(e.getKeyCode() == 87)
			W.isPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			SPACE.isPressed = false;
	}

	public void keyTyped(KeyEvent e) {
	
	}
	
	public class Key{
		
		public boolean isPressed;
		
		public Key(){
			this.isPressed = false;
		}
		
	}

}
