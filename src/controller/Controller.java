package controller;

public interface Controller extends Runnable{

	public void setTime(int time);
	public void pause();
	public void restart();
	public void run();
	public void step();
}
