package view;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

import model.Game;
import model.Observateur;


public class ViewGame implements Observateur{
	JFrame frame;
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
		frame.add(text);
		frame.setVisible(true);
	}
	
	@Override
	public void actualiser() {
		text.setText("Turn : " + game.nbTours());
	}
	
	
}
