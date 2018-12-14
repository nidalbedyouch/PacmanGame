package model;

import java.util.ArrayList;



public class PacmanGame extends Game {
	private Maze maze;
	private ArrayList<Agent> pacmans=new ArrayList<Agent>();
	private ArrayList<Agent> ghosts=new ArrayList<Agent>();
	private ArrayList<PositionAgent> pacmanPositions;
	private ArrayList<PositionAgent> ghostPositions;
	int nbFood=0;
	
	public PacmanGame(int maxTours,Maze maze) {
		super(maxTours);
		this.maze=maze;
		setPacmanPositions(new ArrayList<PositionAgent>());
		setGhostPositions(new ArrayList<PositionAgent>());
		init();
	}
	
	
	@Override
	public void initializeGame() {
		pacmans.clear();
		
		for(PositionAgent p : this.maze.getPacman_start()){
			pacmans.add(AgentFactory.createPacman(p));
		}
		ghosts.clear();
		for(PositionAgent p : this.maze.getGhosts_start()){
			ghosts.add(AgentFactory.createGhost(p));
		}
		
		for(int i=0;i<this.maze.getSizeX();i++){
			for(int j=0;j<this.maze.getSizeY();j++){
				if(this.maze.isFood(i, j) || this.maze.isCapsule(i, j))
						this.nbFood += 1;
			}
		}
		
		updateGame();
		this.notifierObservateur();
	}

	public void updateGame(){
		
	}

	public Maze getMaze() {
		return maze;
	}


	public void setMaze(Maze maze) {
		this.maze = maze;
		initializeGame();
		this.notifierObservateur();
	}


	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean islegalMove(Agent agent, AgentAction action) {
		return !maze.isWall(agent.getPostionAgent().getX()+action.getPosition().getX(),agent.getPostionAgent().getY()+action.getPosition().getY());
	}

	public void moveAgent(Agent agent, AgentAction action){
		if(islegalMove(agent,action)){
			agent.setPostionAgent(new PositionAgent(agent.getPostionAgent().getX()+action.getPosition().getX(),
											agent.getPostionAgent().getY()+action.getPosition().getY(),action.getPosition().getDir()));
		}
	}


	public ArrayList<PositionAgent> getPacmanPositions() {
		return pacmanPositions;
	}


	public void setPacmanPositions(ArrayList<PositionAgent> pacmanPositions) {
		this.pacmanPositions = pacmanPositions;
	}


	public ArrayList<PositionAgent> getGhostPositions() {
		return ghostPositions;
	}


	public void setGhostPositions(ArrayList<PositionAgent> ghostPositions) {
		this.ghostPositions = ghostPositions;
	}


	
	
	
	
	
}
