package s3521723;

import java.util.*;

public class Board {
	public int width;
	public int height;
	public ArrayList<Tile> tile = new ArrayList<Tile>();
	public ArrayList<Pacman> pacmen = new ArrayList<Pacman>();
	public Monster monster;
	public char[][] grid;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new char[height][width];
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Tile getTile(int gridLoc) {
		return this.tile.get(gridLoc);
	}
	
	public int getLength() {
		int length = this.height * (this.width - 1);
		return length;
	}
	
	public Pacman getPacman(int gridLoc) {
		return this.pacmen.get(gridLoc);
	}
	
	public Monster getMonster() {
		return this.monster;
	}
	
	public void addTiles() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				tile.add(new Tile(i, j));
			}
		}
	}
	
	public void setWall(int[] tileNum) {
		for(int i = 0; i < tileNum.length; i++) {
			int num = tileNum[i];
			tile.get(num).setToWall();
			
		}
	}
	
	public void printTiles() {
		int index = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = tile.get(index++).getImage();
				System.out.print(grid[i][j] + " ");
			} System.out.println();
		} 
	}
}
