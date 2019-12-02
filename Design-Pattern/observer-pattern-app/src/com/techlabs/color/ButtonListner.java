package com.techlabs.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListner implements ActionListener{
	private ColorFrame frame;
	
	
	public ButtonListner(ColorFrame frame) {
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().setBackground(getcolor(e));
	}


	private Color getcolor(ActionEvent e) {
		String color = e.paramString().split(",")[1].split("=")[1].toString();
		if(color.equalsIgnoreCase("red")) {
			return Color.RED;
		}
		return Color.BLUE;
	}

}
