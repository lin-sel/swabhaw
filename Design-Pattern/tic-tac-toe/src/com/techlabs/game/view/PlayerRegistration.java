package com.techlabs.game.view;

import java.awt.FlowLayout;

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
	
	public GameZone getZone() {
		return zone;
	}

	public void setZone(GameZone zone) {
		this.zone = zone;
	}

	private GameZone zone;
	
	public String getPlayeronename() {
		return playeronename.getText();
	}

	public String getPlayertwoname() {
		return playertwoname.getText();
	}
	
	private void initTextField() {
		this.playeronename = new JTextField("Player One Name", 10);
		this.playertwoname = new JTextField("Player Two Name", 10);
		this.add(playeronename);
		this.add(playertwoname);
	}

	private void initButton() {
		this.button = new JButton("Register");
		this.setBounds(50, 100, 100, 300);
		this.add(button);
	}

	private void initFrame() {
		this.setTitle("Player Registration");
		this.setSize(500, 600);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
	}
	
	private void buttonEventListner() {
		this.button.addActionListener(new RegisterPlayerListner(this));
	}	
}
