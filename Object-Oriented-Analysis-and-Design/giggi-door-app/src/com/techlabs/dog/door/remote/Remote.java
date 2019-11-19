package com.techlabs.dog.door.remote;

import java.util.Timer;
import java.util.TimerTask;

import com.techlabs.dog.Dog;

public class Remote {
	private Dog door;
	final Timer timer;
	
	public Remote(Dog door, Timer timer) {
		this.door = door;
		this.timer = timer;
	}
	
	public void pressButton() {
		System.out.println("Pressing Remote Control Button...");
		if(door.isOpen()) {
			door.close();
		}
		else {
			door.open();
		}
		
		// Automatic door Close.
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				door.close();
				timer.cancel();
			}
		},5000);
	}
}
