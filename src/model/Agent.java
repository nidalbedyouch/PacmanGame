package model;

public class Agent{
	public enum Type{
		Pacman,Fantome;
	} 
	
	private	Type type;
	private PositionAgent positionInit;
	private PositionAgent position;
	
	public Agent(Type t,PositionAgent p) {
		type=t;
		positionInit=p;
		position=p;
	}
	
	public PositionAgent getPostionAgent(){
		return position;
	}
	
	public void setPostionAgent(PositionAgent p){
		position.setDir(p.getDir());
		position.setX(p.getX());
		position.setY(p.getY());
	}
	
	public void resetPosition(){
		setPostionAgent(positionInit);
	}
	
	
}
