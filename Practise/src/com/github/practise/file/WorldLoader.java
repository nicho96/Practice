package com.github.practise.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WorldLoader {

	
	/**
	 * 
	 * @param url the name of the map you want to load
	 * @return a map loaded with the IDs of tiles
	 * @throws IOException If file is not found or stream is not available
	 */
	public static int[][] loadMap(String url) throws IOException{
		DataInputStream stream = new DataInputStream(new FileInputStream(new File("world", url)));
		
		int width = stream.readInt();
		int height = stream.readInt();
		
		int[][] map = new int[width][height];
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				map[x][y] = stream.readInt();
			}
		}
		stream.close();
		
		return map;
	}
	
	/**
	 * 
	 * @param url The location of the file you want to save to
	 * @param map The int[][] map containing ids of sprites
	 * @throws IOException If the file is not found or the strream is not available
	 */
	public static void saveMap(String url, int[][] map) throws IOException{
		File f = new File("world", url);
		if(!f.exists())
			f.createNewFile();
		
		DataOutputStream stream = new DataOutputStream(new FileOutputStream(f));
		int width = map.length;
		int height = map[0].length;
		
		stream.writeInt(width);
		stream.writeInt(height);
				
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				stream.writeInt(map[x][y]);
			}
		}
		stream.close();
	}
	
	public static void generateMapFromText(String in, String out) throws IOException{
		File f = new File("map.txt");		
		int[][] map = new int[11][11];
		
		if(f.exists()){
			Scanner sc = new Scanner(f);
			
			String line = "";
			int y = 0;
			while(sc.hasNextLine()){
				line = sc.nextLine();
				String[] cont = line.split(",");
				for(int x = 0; x < cont.length; x++){
					System.out.println(x + "\t" + y);
					map[x][y] = Integer.parseInt(cont[x]);
				}
				y++;
			}
			sc.close();
		}
		saveMap(out, map);
	}
	
}
