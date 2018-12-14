package controller;

import java.io.File;

public interface Controller extends Runnable{

	public void setTime(int time);
	public void pause();
	public void restart();
	public void run();
	public void step();
	public void changeMaze(File choiceLayout);
}
