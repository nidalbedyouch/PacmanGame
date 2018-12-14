package controller;

import java.io.File;

import model.Game;
import model.Maze;
import model.PacmanGame;
import view.ViewCommande;
import view.ViewGame;

public class AdvancedController implements Controller {

	private Game game;
	private ViewCommande viewCommande;
	private ViewGame viewGame;

	public AdvancedController(Game game){
		this.game=game;
		this.viewCommande= new ViewCommande(this,game);
		this.viewGame=new ViewGame(this,game);
		this.viewCommande.switchBtnRun(true);
		this.viewCommande.switchBtnStep(false);
		this.viewCommande.switchBtnPause(false);
		this.viewCommande.switchBtnRestart(false);
	}
	
	@Override
	public void setTime(int time) {
		game.setSleepTime(time);
	}
	@Override
	public void run() {
		game.launch();
		this.viewCommande.switchBtnRun(false);
		this.viewCommande.switchBtnStep(true);
		this.viewCommande.switchBtnPause(true);
		this.viewCommande.switchBtnRestart(true);
		
	}
	@Override
	public void pause() {
		game.stop();
		this.viewCommande.switchBtnRestart(true);
		this.viewCommande.switchBtnRun(false);
		this.viewCommande.switchBtnPause(false);
		this.viewCommande.switchBtnStep(false);
	}

	@Override
	public void restart() {
		game.init();
		this.viewCommande.switchBtnRun(false);
		this.viewCommande.switchBtnStep(true);
		this.viewCommande.switchBtnPause(true);
		this.viewCommande.switchBtnRestart(false);
	}

	

	@Override
	public void step() {
		game.step();
		this.viewCommande.switchBtnRun(false);
		this.viewCommande.switchBtnStep(true);
		this.viewCommande.switchBtnPause(true);
		this.viewCommande.switchBtnRestart(true);
		if(game.nbTours() >= game.maxTours())
			this.viewCommande.switchBtnStep(false);
	}

	@Override
	public void changeMaze(File choiceLayout) {
		 try {
		    	((PacmanGame)game).setMaze(new Maze(choiceLayout.toString()));
		    	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	
	
}
