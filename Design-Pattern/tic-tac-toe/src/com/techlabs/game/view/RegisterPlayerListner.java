package com.techlabs.game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPlayerListner implements ActionListener{
	private PlayerRegistration playerregistration;
	public RegisterPlayerListner(PlayerRegistration playerRegistration) {
		this.playerregistration = playerRegistration;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.playerregistration.setVisible(false);
		this.playerregistration.setZone(new GameZone(this.playerregistration.getPlayeronename(),this.playerregistration.getPlayertwoname()));
		this.playerregistration.getZone().setVisible(true);
	}

}
