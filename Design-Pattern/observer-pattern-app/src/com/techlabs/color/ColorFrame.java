package com.techlabs.color;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorFrame extends JFrame{
	private JButton red;
	private JButton blue;
	
	public ColorFrame() {
		initFrame();
		initButton();
		this.getContentPane().setBackground(Color.GREEN);;
	}

	private void initButton() {
		this.blue = new JButton("Blue");
		this.red = new JButton("Red");
		this.blue.setName(Color.BLUE.toString());
		this.red.setName(Color.RED.toString());
		this.red.addActionListener(new ButtonListner(this));
		this.blue.addActionListener(new ButtonListner(this));
		this.blue.setBounds(50,100,95,30);
		this.red.setBounds(200,100,95,30); 
		this.add(blue);
		this.add(red);
	}
	
	
	
	private void initFrame() {
		this.setSize(1920, 1080);
		this.setLayout(null);
		this.setVisible(true);
	}
}
