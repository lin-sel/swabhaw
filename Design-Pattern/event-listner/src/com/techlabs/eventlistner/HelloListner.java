package com.techlabs.eventlistner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.techlabs.frame.EventFrame;

public class HelloListner implements ActionListener{
	private EventFrame frame;
	
	public HelloListner(EventFrame e){
		this.frame = e;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(frame, "Hello");
	}

	

}
