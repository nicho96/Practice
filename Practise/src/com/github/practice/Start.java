package com.github.practice;

import java.util.Scanner;


public class Start implements Runnable{
		
	public static void main(String[] args){
		
		//new MainFrame();
				
		Thread t = new Thread(new Start());
		t.start();
		
		while(true){
			Scanner sc = new Scanner(System.in);
			String x = sc.nextLine();
			System.out.println(x.toLowerCase());
		}
	}
	
	public void method(){
		
	}

	@Override
	public void run() {
		int i = 0;
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i++);
		}
	}
	
}
