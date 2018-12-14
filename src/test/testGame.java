package test;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import controller.AdvancedController;
import controller.BasicController;
import controller.Controller;
import model.Game;
import model.Maze;
import model.PacmanGame;
import model.SimpleGame;
import view.PanelPacmanGame;
import view.ViewCommande;
import view.ViewGame;


public class testGame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Maze m=new Maze("/home/nbedyouch/workspace/projetPacman/layout/bigSafeSearch.lay");
		Game g=new PacmanGame(100,m);
		Controller controller_game=new AdvancedController(g); 
	}
	
	public static Maze choosePacmanLayout() throws Exception {
		Maze m = new Maze("/home/nbedyouch/workspace/projetPacman/layout/bigSafeSearch.lay");
		
        JButton open = new JButton();
        JFileChooser mazeFileChooser = new JFileChooser(new java.io.File("/home/nbedyouch/workspace/projetPacman/layout"));
        mazeFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        Action details = mazeFileChooser.getActionMap().get("viewTypeDetails");
        details.actionPerformed(null);

		
        if (mazeFileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            try {
                 m = new Maze(mazeFileChooser.getSelectedFile().getAbsolutePath());
            } catch (Exception ex) {
            	ex.printStackTrace();
                Logger.getLogger(ViewGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return m;
    }

}
