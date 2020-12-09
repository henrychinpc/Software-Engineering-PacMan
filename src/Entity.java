package s3521723;

public class Entity {
	public char direction;
	Board board;
	public int gridLoc;
	 
	 public char getDirection() {
		 return direction;
	 }

	 public void setDirection(char direction) {
		 this.direction = direction;
	 }
	 
	 public void move(char dir) {
		 //to be overridden by Monster and Pacman
	 }
	 
}
