package model;


public class PacmanGame extends Game {
	Maze maze;
	public Maze getMaze() {
		return maze;
	}



	public void setMaze(Maze maze) {
		this.maze = maze;
	}



	public PacmanGame(int maxTours) {
		super(maxTours);
	}

	

	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean islegalMove(PacmanGame p, Maze m) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
