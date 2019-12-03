package com.techlabs.game.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameZone extends JFrame{
	private String playerone ,playertwo;
	private static final long serialVersionUID = 1L;
	private JPanel displayPanel;
	private JPanel gridPanel;
	public GameZone(String playerone, String playertwo) throws HeadlessException {
		this.playerone = playerone;
		this.playertwo = playertwo;
		this.gridPanel = new JPanel();
		this.displayPanel = new JPanel();
		initFrame();
		gridPattern();
	}

	private void gridPattern() {
		createButtonGrid();
	}

	private void createButtonGrid() {
		int position = 0;
		JButton button;
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				button  = new JButton(Integer.toString(position));
//				button.setName();
				button.addActionListener(new userEventListner(this));
				this.gridPanel.add(button);
				position++;
			}
		}
	}

	private void initFrame() {
		this.setTitle("Game Zone");
		this.setSize(300, 600);
		this.displayPanel.setBounds(0, 0, 300, 300);
		this.displayPanel.setBackground(Color.BLUE);
		this.gridPanel.setBounds(0, 263, 300, 300);
		this.gridPanel.setLayout(new GridLayout(3,3));
		this.gridPanel.setBackground(Color.darkGray);
		this.add(displayPanel);
		this.add(gridPanel);
		this.setLayout(null);
		this.setVisible(true);
		this.displayPanel.add(new JLabel(this.playerone));
		this.displayPanel.add(new JLabel(this.playertwo));
	}
	
	
}
