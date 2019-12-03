package com.techlabs.game.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PlayerRegistration extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JTextField playeronename;
	private JTextField playertwoname;
	
	public PlayerRegistration(){
		initFrame();
		initButton();
		initTextField();
		buttonEventListner();
	}
	
	public ViewController getZone() {
		return zone;
	}

	public void setZone(ViewController zone) {
		this.zone = zone;
	}

	private ViewController zone;
	
	public String getPlayeronename() {
		return playeronename.getText();
	}

	public String getPlayertwoname() {
		return playertwoname.getText();
	}
	
	private void initTextField() {
		this.playeronename = new JTextField("Player One Name");
		this.playertwoname = new JTextField("Player Two Name");
		this.playeronename.setBounds(50, 200, 200, 30);
		this.playertwoname.setBounds(50, 260, 200, 30);
		this.playeronename.setBackground(Color.cyan);
		this.playertwoname.setBackground(Color.CYAN);
		this.add(this.playeronename);
		this.add(this.playertwoname);
	}

	private void initButton() {
		this.button = new JButton("Start");
		this.button.setBounds(100, 380, 100,30);
		this.add(button);
	}

	private void initFrame() {
		this.setTitle("Player Registration");
		this.setSize(300, 600);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	private void buttonEventListner() {
		this.button.addActionListener(new RegisterPlayerListner(this));
	}	
}
