package s3521723;

public class Tile {
	
	private int yAxis;
	private int xAxis;
	private boolean isWall;
	private boolean isPacman;
	private boolean isMonster;
	private char image;
	Board board;
	Pacman pacman;
	
	public Tile(int x, int y) {
		this.xAxis = x;
		this.yAxis = y;
		this.isWall = false;
		this.isPacman = false;
		this.isMonster = false;
		this.image = 'D';
	}
	
	public void setPacman() {
		this.image = 'P';
		this.isPacman = true;
	}
	
	public boolean getPacman() {
		return isPacman;
	}
	
	public void setMonster() {
		this.image = 'M';
		this.isMonster = true;
	}
	
	public boolean getMonster() {
		return isMonster;
	}
	
	public int getYAxis() {
		return yAxis;
	}
	
	public int getXAxis() {
		return xAxis;
	}
	
	
	public boolean getWall() {
		return isWall;
	}
	
	public char getImage() {
		return image;
	}
	
	public void setYAxis(int y) {
		yAxis = y;
	}
	
	public void setXAxis(int x) {
		yAxis = x;
	}
	
	public void setToWall() {
		isWall = true;
		image = 'W';
	}
	
	public void setPassable() {
		isWall = false;
		isPacman = false;
		image = 'D';
	}
	
}
