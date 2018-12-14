package model;

public class AgentAction {
	
	private PositionAgent position;
	private int  direction;
	
	public AgentAction(int d){
		assert d < 0 && d >4;
		this.direction=direction;
	}
	
	public PositionAgent getPosition(){
		switch(direction){
			case Maze.NORTH :
					up_action();
					break;
			case Maze.EAST:
					right_action();
					break;
			case Maze.WEST :
					left_action();
					break;
					
			case Maze.SOUTH : 
					down_action(); 
					break;
		
		}
		return position;
	}
	
	public void left_action(){
		position.setDir(Maze.WEST);
		position.setX(-1);
		position.setY(0);
	}
	
	public void right_action() {
		position.setDir(Maze.EAST);
		position.setX(1);
		position.setY(0);
	}
	
	public void up_action() {
		position.setDir(Maze.NORTH);
		position.setX(0);
		position.setY(-1);
	}
	
	public void down_action() {
		position.setDir(Maze.SOUTH);
		position.setX(0);
		position.setY(1);
	}
	
}
