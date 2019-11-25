package com.techlabs.door.remote;

import com.techlabs.dog.DogDoor;

public class Remote {
	private DogDoor door;
	
	public Remote(DogDoor door) {
		this.door = door;
	}
	
	public void pressButton() {
		System.out.println("Pressing Remote Control Button...");
		if(door.isOpen()) {
			door.close();
		}
		else {
			door.open();
		}
	}
}
