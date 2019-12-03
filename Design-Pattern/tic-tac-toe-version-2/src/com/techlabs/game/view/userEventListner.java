package com.techlabs.game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userEventListner implements ActionListener{
	private ViewController game;
	
	public userEventListner(ViewController game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.getButtonManager().buttonSetting(e);
		game.getButtonManager().setMassage(game.getRunner().playStart(Integer.parseInt(e.getActionCommand())));
	}

}
