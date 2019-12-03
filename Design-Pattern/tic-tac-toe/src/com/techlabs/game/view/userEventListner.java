package com.techlabs.game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userEventListner implements ActionListener{
	private GameZone game;
	
	public userEventListner(GameZone game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

}
