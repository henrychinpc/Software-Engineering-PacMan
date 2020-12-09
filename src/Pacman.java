package s3521723;

public class Pacman extends Entity {
 private boolean isAlive = true;
 private String colour;
 private String availability;

 public Pacman(String colour, Board board) {
	 if(colour == "YELLOW") {
		 this.colour = colour;
		 this.availability = "Available";
		 this.board = board;
	 }
	 
	 if(colour == "WHITE") {
		 this.colour = colour;
		 this.availability = "Available";
		 this.board = board;
	 }
	 
	 if(colour == "RED") {
		 this.colour = colour;
		 this.availability = "Available";
		 this.board = board;
	 }
	 
	 if(colour == "GREEN") {
		 this.colour = colour;
		 this.availability = "Available";
		 this.board = board;
	 }
 }
 
 public void placePacman() {
		 if(colour == "YELLOW") {
			 this.gridLoc = board.height + 1;
			 board.getTile(gridLoc).setPacman();
		 }
		 
		 if(colour == "WHITE") {
			 this.gridLoc = (board.height - 1) * (board.width - 1);
			 board.getTile(gridLoc).setPacman();
		 }
		 
		 if(colour == "RED") {
			 this.gridLoc = (board.height * 2) - 2;
			 board.getTile(gridLoc).setPacman();
		 }
		 
		 if(colour == "GREEN") {
			 this.gridLoc = (board.height * board.width) - (board.width + 2);
			 board.getTile(gridLoc).setPacman();
		 }
 }
 
 public String getColour() {
	 return colour;
 }
 
 public String getAvailability() {
	 return availability;
 }
 
 public void setColour(String colour) {
	 this.colour = colour;
 }
 
 public void setAvailability(String availability) {
	 this.availability = availability;
 }
 
 public boolean getAlive() {
	 return isAlive;
 }
 
 public void setAlive(boolean life) {
	 this.isAlive = life;
 }
 
 @Override
 public void move(char direction) {
	 board.getTile(gridLoc).setPassable();
	 if (direction == 'D') {
		 if(this.gridLoc >= board.getWidth()*(board.getHeight() - 1) && this.gridLoc <= (board.getHeight()*board.getWidth()) - 1) {
		 		this.gridLoc = gridLoc - board.getLength();
		 		if(board.getTile(gridLoc).getWall() == true || board.getTile(gridLoc).getPacman() == true) {
		 			gridLoc = gridLoc + board.getLength();
		 		}
		 	} else {
		 		this.gridLoc = gridLoc + board.getHeight();
		 		if(board.getTile(gridLoc).getWall() == true || board.getTile(gridLoc).getPacman() == true) {
		 			this.gridLoc = gridLoc - board.getHeight();
		 		}
		 	}

	 }
	 
	 else if (direction == 'U') {
		 if(this.gridLoc >= 0 && this.gridLoc <= board.getWidth() - 1) {
			 	this.gridLoc = gridLoc + board.getLength();
				 if(board.getTile(gridLoc).getPacman() == true) {
					 gridLoc = gridLoc - board.getLength();
				 }
			 } else {
				 this.gridLoc = this.gridLoc - board.getHeight();
				 if(board.getTile(gridLoc).getWall() == true || board.getTile(gridLoc).getPacman() == true) {
					 this.gridLoc = gridLoc + board.getHeight();
			 }
		 }
		 
	 }
	 
	 else if (direction == 'L') {
		 if(this.gridLoc % board.getWidth() == 0) {
			 this.gridLoc = gridLoc + (board.getWidth() - 1);
			 if(board.getTile(gridLoc).getPacman() == true) {
				 gridLoc = gridLoc - (board.getWidth() - 1);
			 }
		 } else {
			 this.gridLoc = this.gridLoc - 1;
			 if(board.getTile(gridLoc).getWall() == true || board.getTile(gridLoc).getPacman() == true) {
				 this.gridLoc = this.gridLoc + 1;
			 }
		 }
	 }
	 
	 else if (direction == 'R') {
		 if((this.gridLoc - (board.getWidth() - 1)) % board.getWidth() == 0) {
			this.gridLoc = gridLoc - (board.getWidth() - 1);
		 	if(board.getTile(gridLoc).getPacman() == true) {
		 		gridLoc = gridLoc + (board.getWidth() - 1);
		 	}
		 } else {
			 this.gridLoc = gridLoc + 1;
			 if(board.getTile(gridLoc).getWall() == true || board.getTile(gridLoc).getPacman() == true) {
				 this.gridLoc = gridLoc - 1;
			 }
		 }
	 }
	 board.getTile(gridLoc).setPacman();
 }
 

}
