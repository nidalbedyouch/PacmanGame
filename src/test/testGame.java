package test;
import controller.AdvancedController;
import controller.BasicController;
import controller.Controller;
import model.Game;
import model.PacmanGame;
import model.SimpleGame;
import view.ViewCommande;
import view.ViewGame;


public class testGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g=new PacmanGame(100);
		Controller controller_game=new AdvancedController(g);
		ViewGame.choosePacmanLayout(g); 
	}

}
