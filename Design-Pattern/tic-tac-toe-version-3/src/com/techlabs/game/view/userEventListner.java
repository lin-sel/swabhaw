package com.techlabs.game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userEventListner implements ActionListener{
	private IViewManager game;
	
	public userEventListner(IViewManager game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.buttonSetting(e);
		game.setMassage(Integer.parseInt(e.getActionCommand()));
	}

}
