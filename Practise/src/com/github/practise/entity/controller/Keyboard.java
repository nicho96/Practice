package com.github.practise.entity.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.practice.Game;
import com.github.practise.entity.Location;

public class Keyboard implements KeyListener{
	
	public final Key UP = new Key();
	public final Key LEFT = new Key();
	public final Key DOWN = new Key();
	public final Key RIGHT = new Key();

	
	public Keyboard(Game g){
		g.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'w')
			UP.isPressed = false;
		if(e.getKeyChar() == 'a')
			LEFT.isPressed = false;
		if(e.getKeyChar() == 's')
			DOWN.isPressed = false;
		if(e.getKeyChar() == 'd')
			RIGHT.isPressed = false;
	}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'w')
			UP.isPressed = true;
		if(e.getKeyChar() == 'a')
			LEFT.isPressed = true;
		if(e.getKeyChar() == 's')
			DOWN.isPressed = true;
		if(e.getKeyChar() == 'd')
			RIGHT.isPressed = true;
	}
	
	public class Key{
		
		public boolean isPressed;
		
		public Key(){
			this.isPressed = false;
		}
		
	}

}
