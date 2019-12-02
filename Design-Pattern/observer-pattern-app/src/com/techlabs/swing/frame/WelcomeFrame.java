package com.techlabs.swing.frame;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WelcomeFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField tx = new JTextField();
	
	public WelcomeFrame(String title){
		this.setTitle(title);
		this.setSize(1920, 1080);
		this.setLayout(null);  
	    this.setVisible(true);   
	}
	
	public void addMessage(String message) {
		tx.setText(message);
		tx.setBounds(50,100, 200,30); 
		tx.setAlignmentX(CENTER_ALIGNMENT);
		tx.setAlignmentY(CENTER_ALIGNMENT);
		this.add(tx);
	}
}
