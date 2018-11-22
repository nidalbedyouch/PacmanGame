package model;

public class Agent implements AgentAction {
	public enum Type{
		Pacman,Fantome;
	} 
	
	private	Type type;
	private PositionAgent position;
	
	private Agent(Type t,PositionAgent p) {
		type=t;
		position=p;
	}
	public void left_action() {
		position.setDir(Maze.WEST);
	}
	public void right_action() {
		position.setDir(Maze.EAST);
	}
	public void up_action() {
		position.setDir(Maze.NORTH);
	}
	public void down_action() {
		position.setDir(Maze.SOUTH);
	}
	
	
}
