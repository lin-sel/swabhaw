package com.techlabs.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.techlabs.eventlistner.HelloListner;
import com.techlabs.eventlistner.PrintListner;


public class EventFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton print;
	private JButton hello;
	
	public EventFrame(){
		createButton();
		initFrame();
	}

	private void createButton() {
		this.print = new JButton("Print");
		this.hello = new JButton("Hello");
		addEventListner();
		addButton();
	}
	
	private void addButton() {
		this.add(hello);
		this.add(print);
	}

	private void addEventListner() {
		this.hello.addActionListener(new HelloListner(this));
		this.print.addActionListener(new PrintListner());
	}
	
	private void initFrame() {
		this.setTitle("Notification");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setSize(1920, 1080);
	}
}
