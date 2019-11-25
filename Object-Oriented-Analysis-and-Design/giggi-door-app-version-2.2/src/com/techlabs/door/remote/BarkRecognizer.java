package com.techlabs.door.remote;

import com.techlabs.dog.Bark;
import com.techlabs.dog.DogDoor;

public class BarkRecognizer {
	private DogDoor door;
	
	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}
	
	public void open(Bark bark) {
		System.out.println("Recognizer hear bark "+bark.getBarks());
		if(door.getBark().equal(bark)) {
			if(door.isOpen()) {
				door.close();
			}
			door.open();
		}
	}
}
