package com.techlabs.swing.frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListnerFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JButton button; 
	public ListnerFrame() {
		initFrame();
		initButton();
	}

	private void initButton() { 
		this.button = new JButton("Click Button");
		this.button.setBounds(50,100,95,30);  
		this.button.addActionListener(new HowdyListner());
		this.button.addActionListener(new HelloListner());
		this.add(button);
	}

	private void initFrame() {
		this.setTitle("Notification");
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1920, 1080);
	}
	
}
