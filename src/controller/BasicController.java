package controller;

import view.ViewCommande;
import view.ViewGame;
import model.Game;

public class BasicController implements Controller {
	private Game game;
	private ViewCommande view;
	private ViewGame viewGame;
	
	public BasicController(Game game){
		this.game=game;
		this.view= new ViewCommande(this,game);
		this.viewGame=new ViewGame(this,game);
	}
	
	@Override
	public void setTime(int time) {
		game.setSleepTime(time);
	}

	@Override
	public void pause() {
		game.stop();
		
	}

	@Override
	public void restart() {
		game.init();
	}

	@Override
	public void run() {
		game.launch();
	}

	@Override
	public void step() {
		game.step();
		
	}

}
