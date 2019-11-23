package com.techlabs.dog;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	private boolean open;
	private Timer timer;
	
	public DogDoor(){
		this.open = false;
	}
	
	private Timer createObject() {
		return new Timer();
	}
	
	public void open() {
		this.open = true;
		System.out.println("Open door");
		timer = createObject();
		// Automatic door Close.
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		},5000);
	}
	
	public void close() {
		this.open = false;
		System.out.println("Close door");
	}
	
	public boolean isOpen() {
		return open;
	}
}
