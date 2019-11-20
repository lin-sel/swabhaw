package com.techlabs.dog.door.remote;

import com.techlabs.dog.Dog;

public class Remote {
	private Dog door;
	
	public Remote(Dog door) {
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
