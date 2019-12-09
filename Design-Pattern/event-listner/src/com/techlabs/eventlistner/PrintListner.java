package com.techlabs.eventlistner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintListner implements ActionListener{
	
	private class ThreadHandler implements Runnable{
		@Override
		public void run() {
			while(true) {
				System.out.println(java.time.LocalDateTime.now());
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Thread t = new Thread(new ThreadHandler());
		t.start();
	}

}
