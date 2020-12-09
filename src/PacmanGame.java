package s3521723;
import java.util.*;

public class PacmanGame {
	Board board;
	ArrayList<Player> players = new ArrayList<Player>();
	Scanner scan = new Scanner(System.in);
	
	public void createBoard(int width, int height) {
		board = new Board(width, height);
		board.addTiles();
		int[] walls = {0,1,2,3,4,6,7,8,9,10,11,21,22,24,25,26,28,29,30,32,33,35,36,37,39,
			40,41,43,44,46,47,48,50,51,52,54,66,68,69,70,72,73,74,76,77,79,80,81,83,84,
			85,87,88,90,91,92,94,96,98,99,109,110,111,112,113,114,116,117,118,119,120};
		board.setWall(walls);
	}
	
	public void showBoard() {
		board.printTiles();
	}
	
	public void addPlayers(String id, String name) {
			players.add(new Player(id, name));
	}
	
	public void addPacman() {
		board.pacmen.add(new Pacman("YELLOW", board));
		board.pacmen.add(new Pacman("WHITE", board));
		board.pacmen.add(new Pacman("RED", board));
		board.pacmen.add(new Pacman("GREEN", board));
	}
	
	public void showMainMenu() throws PacmanException {
		System.out.println("***WELCOME TO PACMAN***");
		System.out.println("1) Start Game\n2) Show Score\n3) Exit");
		while (true) {
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				runGame();
				break;
			case 2:
				showScore();
				break;
			case 3:
				System.out.println("Thank you for playing!");
				break;
			default:
				System.out.println("Invalid input!");
			} break;
		}
	}
	
	public void showPlayerMenu() throws PacmanException {
		System.out.println("***PLAYER MENU***");
		while(true) {
			System.out.println("Enter your ID: (Eg. 001)");
			String id = scan.next();
			System.out.println("Enter your name: ");
			String name = scan.next();
			this.addPlayers(id, name);
			if(players.size() == 4) {
				this.showPacmanMenu();
			}
			System.out.println("Any other players? Y/N");
			char answer = scan.next().toUpperCase().charAt(0);
			if(answer == 'N') {
				this.showPacmanMenu();
				break;
			} else if (answer != 'N' && answer != 'Y') {
				System.out.println("Incorrect input!");
				break;
			}
		}
	}
	
	public void showPacmanMenu() throws PacmanException {
		this.addPacman();
		System.out.println("***SELECT PACMAN***");
		System.out.println("1) Yellow\n2) White\n3) Red\n4) Green");
		for(int i = 0; i < players.size(); i++) {
			System.out.println("Enter your choice: (Player " + players.get(i).getName() + ")");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				players.get(i).choosePacman(board.getPacman(0));
				break;
			case 2:
				players.get(i).choosePacman(board.getPacman(1));
				break;
			case 3:
				players.get(i).choosePacman(board.getPacman(2));
				break;
			case 4:
				players.get(i).choosePacman(board.getPacman(3));
				break;
			}
		}
		this.playGame();
	}
	
	public void showScore() throws PacmanException {
		System.out.println("***HIGH SCORE***");
	    for(int i = 0; i < players.size(); i++) {
	    	System.out.println(players.get(i).getId() + " " + players.get(i).getName() + " : " + players.get(i).score.getScore());
	    } System.out.println("Click any key to exit.");
	    String any = scan.next();
	    showMainMenu();
	}
	
	public void playGame() throws PacmanException {
		char dir = 'A';
		while (dir != 'E') {
			for(int i = 0; i < players.size(); i++) {
			this.showBoard();
			System.out.println("Enter your direction (D/U/L/R): (Player " + players.get(i).getName() + ")");
			dir = scan.next().toUpperCase().charAt(0);
			players.get(i).movePacman(dir);
			} 
		} showMainMenu();
	}
	
	public void runGame() throws PacmanException {
		this.createBoard(11, 11);
		this.showPlayerMenu();
	}
	
}
