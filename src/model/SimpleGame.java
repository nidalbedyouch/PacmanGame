package model;


public class SimpleGame extends Game{
	
	public SimpleGame(int maxTours){
		super(maxTours);
	}
	@Override
	public void initializeGame() {
		System.out.println("SimpleGame initialized");
		this.notifierObservateur();
	}

	@Override
	public void takeTurn() {
		System.out.println("Tour "+this.nbTours());
		this.notifierObservateur();
	}

	@Override
	public void gameOver() {
		System.out.println("SimpleGame is Over");
		this.notifierObservateur();
	}

	@Override
	public boolean islegalMove(Agent agent, AgentAction action) {
		// TODO Auto-generated method stub
		return true;
	}

}
