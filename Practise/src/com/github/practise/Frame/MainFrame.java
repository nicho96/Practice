package com.github.practise.Frame;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame(){
		
		this.setBounds(10, 10, 500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new GamePanel(500, 500));
		
		
	}
	
}
