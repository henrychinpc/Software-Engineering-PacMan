package s3521723;

public class Monster extends Entity {
	
	/*
	// Code which we intended to implement but it's getting errors
	
	----- Connecting Monster in Game via server ------
		String host;
		int port;
			private boolean MonsterConnect(String host, int port) {
		
		Display.log("Monster", "Connecting...");

		try {
			Registry reg = LocateRegistry.getRegistry(host, port);
			server = (ServerInterface) reg.lookup("Server");
			server.connect(this, host, port, 0, true, "", "", "", "", "");
			return true;
		} catch (AccessException e) {
			System.err.println("Monster could not access server registry " + e.toString());
		} catch (RemoteException e) {
			System.err.println("Monster could not find the RMI register on the server" + e.toString());
		} catch (NotBoundException e) {
			System.err.println("Monster could not bind to the provided RMI address " + e.toString());
		}
		return false;
	}

	*/
	 
	public Monster(Board board) {
		this.board = board;
		this.gridLoc = (board.getHeight() * board.getWidth()) / 2;
		board.getTile(gridLoc).setMonster();
	}
	
	public void move(char direction) {
		 board.getTile(gridLoc).setPassable();
		 if (direction == 'D') {
			 if(this.gridLoc >= board.getWidth()*(board.getHeight() - 1) && this.gridLoc <= (board.getHeight()*board.getWidth()) - 1) {
			 		this.gridLoc = gridLoc - board.getLength();
			 		if(board.getTile(gridLoc).getPacman() == true) {
			 			for(int i = 0; i < board.pacmen.size(); i++) {
			 				if(board.getPacman(i).gridLoc == this.gridLoc) {
			 					board.getPacman(i).setAlive(false);
			 				}
			 			}
			 		}
			 	} else {
			 		this.gridLoc = gridLoc + board.getHeight();
			 		if(board.getTile(gridLoc).getPacman() == true) {
			 			for(int i = 0; i < board.pacmen.size(); i++) {
			 				if(board.getPacman(i).gridLoc == this.gridLoc) {
			 					board.getPacman(i).setAlive(false);
			 				}
			 			}
			 		}
			 		if(board.getTile(gridLoc).getWall() == true) {
			 			this.gridLoc = gridLoc - board.getHeight();
			 		}
			 	}

		 }
		 
		 else if (direction == 'U') {
			 if(this.gridLoc >= 0 && this.gridLoc <= board.getWidth() - 1) {
				 	this.gridLoc = gridLoc + board.getLength();
					 if(board.getTile(gridLoc).getPacman() == true) {
						 for(int i = 0; i < board.pacmen.size(); i++) {
				 				if(board.getPacman(i).gridLoc == this.gridLoc) {
				 					board.getPacman(i).setAlive(false);
				 				}
				 			}
					 }
				 } else {
					 this.gridLoc = this.gridLoc - board.getHeight();
					 if(board.getTile(gridLoc).getPacman() == true) {
						 for(int i = 0; i < board.pacmen.size(); i++) {
				 				if(board.getPacman(i).gridLoc == this.gridLoc) {
				 					board.getPacman(i).setAlive(false);
				 				}
				 			}
				 		}
					 if(board.getTile(gridLoc).getWall() == true) {
						 this.gridLoc = gridLoc + board.getHeight();
				 }
			 }
			 
		 }
		 
		 else if (direction == 'L') {
			 if(this.gridLoc % board.getWidth() == 0) {
				 this.gridLoc = gridLoc + (board.getWidth() - 1);
				 if(board.getTile(gridLoc).getPacman() == true) {
					 for(int i = 0; i < board.pacmen.size(); i++) {
			 				if(board.getPacman(i).gridLoc == this.gridLoc) {
			 					board.getPacman(i).setAlive(false);
			 				}
			 			}
				 }
			 } else {
				 this.gridLoc = this.gridLoc - 1;
				 if(board.getTile(gridLoc).getPacman() == true) {
			 			for(int i = 0; i < board.pacmen.size(); i++) {
			 				if(board.getPacman(i).gridLoc == this.gridLoc) {
			 					board.getPacman(i).setAlive(false);
			 				}
			 			}
			 		}
				 if(board.getTile(gridLoc).getWall() == true) {
					 this.gridLoc = this.gridLoc + 1;
				 }
			 }
		 }
		 
		 else if (direction == 'R') {
			 if((this.gridLoc - (board.getWidth() - 1)) % board.getWidth() == 0) {
				this.gridLoc = gridLoc - (board.getWidth() - 1);
			 	if(board.getTile(gridLoc).getPacman() == true) {
			 		for(int i = 0; i < board.pacmen.size(); i++) {
		 				if(board.getPacman(i).gridLoc == this.gridLoc) {
		 					board.getPacman(i).setAlive(false);
		 				}
		 			}
			 	}
			 } else {
				 this.gridLoc = gridLoc + 1;
				 if(board.getTile(gridLoc).getPacman() == true) {
					 for(int i = 0; i < board.pacmen.size(); i++) {
			 				if(board.getPacman(i).gridLoc == this.gridLoc) {
			 					board.getPacman(i).setAlive(false);
			 				}
			 			}
			 		}
				 if(board.getTile(gridLoc).getWall() == true) {
					 this.gridLoc = gridLoc - 1;
				 }
			 }
		 }
		 board.getTile(gridLoc).setMonster();
	 } 
	
	 /*
	 -------- Method To Calculate the Distance ---------
	 
	 private int x;
	 private int y;

	 public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getDistance(x,y){
		
		int xDistance = Math.abs(target.getX() - x);
		int yDistance = Math.abs(target.getY() - y);
		return xDistance + yDistance;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setCoordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Boolean equals(Coordinates[]){
		return (this.x == .getX()) && (this.y == otherCoords.getY());
	}

	public String toString(){
		return "(" + x + ", " + y + ")";
	}

 ------- Method to Kill Player from server ------------

    private void killPlayer(ClientInterface id) throws RemoteException {
		Display.log("Server", "Killing player " + id.name());

		synchronized (Server.id) {
			for (Object id : Server.id.keySet().toArray()) {
				if (Server.name.get(id).equals(name))
					Server.name.remove(id);
			}
		}

	 */
	
	
}
