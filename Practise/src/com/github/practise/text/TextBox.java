package com.github.practise.text;

import com.github.practise.text.TextEngine.Letter;

public class TextBox {

	private int[] pixels;
	private int width;
	private int height;
	
	private int locX;
	private int locY;
	
	private int time;
	
	public TextBox(String message, int maxWidth, int locX, int locY, int time){
		width = maxWidth;
		height = (int)Math.ceil(message.length() / (double)maxWidth);
		
		this.locX = locX;
		this.locY = locY;
		
		this.time = time;
		
		int i = 0;
		Letter[][] msg = new Letter[width][height];
		outerloop:
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(i >= message.length())
					break outerloop;
				msg[x][y] = Letter.valueOf(Character.toUpperCase(message.charAt(i++)) + "");
			}
		}
		pixels = new int[width * 20 * height * 20];
		
		outerloop:
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				
				int ind = 0;
				if(msg[x][y] == null)
					break outerloop;
				int[] pix = msg[x][y].getLetter();
				for(int w = 0; w < 20; w++)
					for(int z = 0; z < 20; z++)
						pixels[width * y * 20 * 20 + w * width * 20 + x * 20 + z] = pix[ind ++];
				
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getLocX(){
		return locX;
	}
	
	public int getLocY(){
		return locY;
	}
	
	public void countDown(){
		time --;
	}
	
	public boolean isTimeUp(){
		return time <= 0;
	}
	
	public int[] getPixels(){
		return pixels;
	}
	
}
