package s3521723;

public class Player {
	private String id;
	private String name;
	public Pacman pac;

	public Player(String id, String name) {
		this.id = id;
		this.name = name;
		this.pac = null;
	}

	public void movePacman(char direction) {
		pac.move(direction);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void choosePacman(Pacman pac) throws PacmanException {
		if (this.pac != null) {
			throw new PacmanException("Already chosen a pacman.");
		} else {
			if (pac.getAvailability() == "Available") {
				this.pac = pac;
				pac.setAvailability("Chosen");
				pac.placePacman();
			} else if (pac.getAvailability() == "Chosen") {
				throw new PacmanException("Pacman already chosen.");
			}
		}
	}
	
	public boolean checkPacman() {
		if(this.pac.getAlive() == false) {
			return false;
		} return true;
	}

}
