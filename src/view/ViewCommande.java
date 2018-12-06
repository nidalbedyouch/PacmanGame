package view;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

import model.Game;
import model.Observateur;

public class ViewCommande implements Observateur{
	private JFrame frame;
	private JPanel buttonPanel,bottomPanel,mainPanel,sliderPanel;
	private JButton btnRestart,btnRun,btnStep,btnPause;
	private JSlider slider;
	private JLabel sliderLabel,turnLabel;
	private Controller controller_game;
	private Game game;
	
	public ViewCommande(Controller controller,Game game){
		//s'enregistrer en observateur
		game.enregistrerObservateur(this);
		
		this.game=game;
		this.controller_game=controller;
		//creation interface
		frame=new JFrame("Commande");
		frame.setTitle("Commande");
		frame.setSize(new Dimension(700, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.toFront();
		//create buttons and icons
		Icon icon_restart=new ImageIcon("icones/icon_restart.png");
		this.btnRestart=new JButton(icon_restart);
		Icon icon_pause=new ImageIcon("icones/icon_pause.png");
		this.btnPause=new JButton(icon_pause);
		Icon icon_run=new ImageIcon("icones/icon_run.png");
		this.btnRun=new JButton(icon_run);
		Icon icon_step=new ImageIcon("icones/icon_step.png");
		this.btnStep=new JButton(icon_step);
		//create main panel
		mainPanel=new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));
		
		//create button panel
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		buttonPanel.add(btnRestart);
		buttonPanel.add(btnPause);
		buttonPanel.add(btnRun);
		buttonPanel.add(btnStep);
	
		
		//create bottom panel
		bottomPanel=new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
		
		//create slider panel
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new GridLayout(2,1));
		
		//create slider
		slider=new JSlider(JSlider.HORIZONTAL,0,10,2);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		//create sliderLabel
		sliderLabel=new JLabel("Number of turns per second",JLabel.CENTER);
		sliderLabel.setBounds(50,100, 100,30);
		
		sliderPanel.add(sliderLabel);
		sliderPanel.add(slider);
		
		//create turnLabel
		turnLabel=new JLabel("Turn : "+game.nbTours(),JLabel.CENTER);
		turnLabel.setBounds(100,100, 100,30);
		
		bottomPanel.add(sliderPanel);
		bottomPanel.add(turnLabel,"push ,align center");
		
		//accrocher le tout
		mainPanel.add(buttonPanel);
		mainPanel.add(bottomPanel);
		
		
		//ajouter les listener 
		btnRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evenement){
				controller_game.restart();
			}
		});
		
		btnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evenement){
				controller_game.run();
			}
		});
		
		btnStep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evenement){
				controller_game.step();
			}
		});
		
		btnPause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evenement){
				controller_game.pause();
			}
		});
		
		slider.addChangeListener(new ChangeListener (){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				controller_game.setTime(1000/slider.getValue());
			}
		});
		
		
		frame.add(mainPanel);
		frame.setVisible(true);
	}

	public void switchBtnRestart(boolean bool){
		btnRestart.setEnabled(bool);
	}
	
	public void switchBtnRun(boolean bool){
		btnRun.setEnabled(bool);
	}
	
	public void switchBtnStep(boolean bool){
		btnStep.setEnabled(bool);
	}
	
	public void switchBtnPause(boolean bool){
		btnPause.setEnabled(bool);
	}
	
	@Override
	public void actualiser() {
	
		turnLabel.setText("Turn : " + game.nbTours());
		
	}
	
}
