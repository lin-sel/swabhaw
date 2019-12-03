package com.techlabs.game.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.techlabs.gameconsole.GameConsole;

public class ViewController extends JFrame{
	private String playerone ,playertwo;
	private static final long serialVersionUID = 1L;
	private JTextField label;
	private JPanel displayPanel;
	private JPanel gridPanel;
	private GameRunner runner;
	private IViewManager buttonmanager;
	private JButton button[];

	public ViewController(String playerone, String playertwo) throws HeadlessException {
		this.playerone = playerone;
		this.playertwo = playertwo;
		this.gridPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.buttonmanager = new ViewManager(this);
		this.runner = new GameRunner(this.playerone, this.playertwo, 3);
		this.label = new JTextField(this.playerone+" Turn:");
		initFrame();
		gridPattern();
		playerTurn();
	}
	
	public JTextField getLabel() {
		return label;
	}
	
	public GameRunner getRunner() {
		return runner;
	}

	public void setRunner(GameRunner runner) {
		this.runner = runner;
	}
	
	private void gridPattern() {
		createButtonGrid();
	}

	public String getPlayerone() {
		return playerone;
	}

	public void setPlayerone(String playerone) {
		this.playerone = playerone;
	}

	public String getPlayertwo() {
		return playertwo;
	}

	public void setPlayertwo(String playertwo) {
		this.playertwo = playertwo;
	}

	private void createButtonGrid() {
		int position = 0;
		this.button = new JButton[9];
		JButton buttons;
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				buttons  = new JButton(Integer.toString(position));
				buttons.addActionListener(new userEventListner(this.buttonmanager));
				this.gridPanel.add(buttons);
				this.button[position] = buttons;
				position++;
			}
		}
	}

	public JButton[] getButton() {
		return button;
	}

	public JPanel getDisplayPanel() {
		return displayPanel;
	}

	public IViewManager getButtonManager() {
		return buttonmanager;
	}
	
	private void initFrame() {
		this.setTitle("Game Zone");
		this.setSize(300, 600);
		this.displayPanel.setBounds(0, 0, 300, 300);
		this.gridPanel.setBounds(0, 263, 300, 300);
		this.gridPanel.setLayout(new GridLayout(3,3));
		this.gridPanel.setBackground(Color.darkGray);
		this.add(displayPanel);
		this.add(gridPanel);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void playerTurn() {
		label.setBackground(Color.GRAY);
		label.setBounds(50,100, 200,30);  
		this.getDisplayPanel().add(label);
	}
	
}
