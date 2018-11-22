package test;
import controller.AdvancedController;
import controller.BasicController;
import controller.Controller;
import model.SimpleGame;
import view.ViewCommande;
import view.ViewGame;


public class testGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGame game=new SimpleGame(40);
		Controller controller_game=new AdvancedController(game);
	}

}
