package com.techlabs.swing.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Hello");
	}

}
