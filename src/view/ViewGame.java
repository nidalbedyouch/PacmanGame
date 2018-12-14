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
	public static JFrame frame;
	PanelPacmanGame labyrinth;
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
		labyrinth=new PanelPacmanGame(((PacmanGame) game).getMaze());
		frame.add(labyrinth);
        frame.setVisible(true);
        System.out.print("painted");
	}
	
	@Override
	public void actualiser() {
		labyrinth.m=((PacmanGame) game).getMaze();
		labyrinth.repaint();
		frame.setVisible(true);
	}
	
	
}
