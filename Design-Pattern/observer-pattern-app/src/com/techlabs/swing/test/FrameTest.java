package com.techlabs.swing.test;

import com.techlabs.swing.frame.WelcomeFrame;

public class FrameTest {

	public static void main(String[] args) {
		WelcomeFrame layout = new WelcomeFrame("Welcome Frame");
		layout.addMessage("Welcome Visitor");
	}

}
