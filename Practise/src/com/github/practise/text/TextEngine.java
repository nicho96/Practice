package com.github.practise.text;

import java.util.ArrayList;

import com.github.practise.frame.render.SpriteSheet;

public class TextEngine {

	private static SpriteSheet font = new SpriteSheet("text.png", 20);

	private static ArrayList<TextBox> textBuffer = new ArrayList<TextBox>();
	
	public enum Letter{
		A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7),I(8),J(9),K(10),L(11),M(12),N(13),O(14),P(15),Q(16),R(17),S(18),T(19),U(20),V(21),W(22),X(23),Y(24),Z(25);
		
		private int[] pixels;
		Letter(int id){
			this.pixels = font.getPixels(id);
		}
		
		
		
		public int[] getLetter(){
			return pixels;
		}
		
	}
	
	public static void tickCurrentBox(){
		if(textBuffer.size() > 0){
			textBuffer.get(0).countDown();
			if(textBuffer.get(0).isTimeUp())
				textBuffer.remove(0);
		}
	}
	
	public static void addTextBox(TextBox box){
		textBuffer.add(box);
	}
	
	public TextBox getTextBox(){
		if(textBuffer.size() > 0)
			return textBuffer.get(0);
		return null;
	}
}
