package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

import model.Game;
import model.Maze;
import model.Observateur;
import model.PacmanGame;


public class ViewGame implements Observateur{
	static JFrame frame;
	JLabel text;
	Game game;
	Controller controllerGame;
	
	
	public ViewGame(Controller controllerGame,Game game){
		this.game=game;
		game.enregistrerObservateur(this);
		//creation interface
		frame=new JFrame("Game");
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
		Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
		int x = (int) rect.getMaxX() - frame.getWidth();
		int y = 0;
		frame.setLocation(x, y);
      
		text=new JLabel("Current Turn : "+0,JLabel.CENTER);
		
			try {
				frame.add(new PanelPacmanGame(new Maze("/home/nbedyouch/workspace/projetPacman/layout/bigSafeSearch.lay")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.setVisible(true);
		
		
	}
	
	@Override
	public void actualiser() {
		text.setText("Turn : " + game.nbTours());
	}
	public static void choosePacmanLayout(Game game) {
        JButton open = new JButton();
        JFileChooser mazeFileChooser = new JFileChooser(new java.io.File("/home/nbedyouch/workspace/projetPacman/layout"));
        mazeFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        Action details = mazeFileChooser.getActionMap().get("viewTypeDetails");
        details.actionPerformed(null);
        if (mazeFileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            try {
                Maze m = new Maze(mazeFileChooser.getSelectedFile().getAbsolutePath());
                ((PacmanGame) game).setMaze(m);
				frame.add(new PanelPacmanGame(((PacmanGame) game).getMaze()));
                frame.setVisible(true);
                System.out.print("painted");
            } catch (Exception ex) {
            	ex.printStackTrace();
                Logger.getLogger(ViewGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
}
