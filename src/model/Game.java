package model;

import java.util.ArrayList;
import java.util.List;


public abstract class Game implements Runnable,Sujet{
	private int nbTours;
	private int maxTours;
	private boolean isRunning;
	private boolean isOver;
	private Thread thread;
	private long sleepTime;
	
	private List<Observateur> observateurs = new ArrayList<>();
	
	public Game(int maxTours){
		this.maxTours=maxTours;
	}
	public void init(){
		this.nbTours=0;
		this.sleepTime=1000;
		this.isRunning=true;
		this.isOver=false;
		this.initializeGame();
		this.notifierObservateur();
	}
	
	public int nbTours(){
		return this.nbTours;
	}
	
	public void setnbTours(int n){
		this.nbTours=n;
	}
	
	public int maxTours(){
		return this.maxTours;
	}
	
	public void setmaxTours(int mxt){
		this.maxTours=mxt;
	}
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public void step(){
		if(this.nbTours<this.maxTours){
			this.nbTours++;
			takeTurn();
			try {
				Thread.sleep(getSleepTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			this.isOver=true;
			gameOver();
		}
		this.notifierObservateur();
	}
	
	public long getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	public void run(){
		while(this.isRunning && !this.isOver)
					this.step();
		gameOver();
		this.notifierObservateur();
	}
	
	public void stop(){
		this.isRunning=false;
		this.notifierObservateur();
	}
	
	public void launch(){
		this.isRunning=true;
		this.isOver=false;
		this.thread=new Thread(this);
		this.thread.start();
		this.notifierObservateur();
	}
	
	public void enregistrerObservateur(Observateur observateur){observateurs.add(observateur);}
	
	public void supprimerObservateur(Observateur observateur){observateurs.remove(observateur);}

	public void notifierObservateur() {
		for(int i = 0; i< observateurs.size(); i++) {
			Observateur observateur = observateurs.get(i);
			observateur.actualiser();
		}
	}
	
    
	public abstract void initializeGame();
	public abstract void takeTurn();
	public abstract void gameOver();
	public abstract boolean islegalMove(Agent agent,AgentAction action);
	
	
}
