package com.techlabs.dog.door.remote;

import com.techlabs.dog.DogDoor;

public class BarkRecognizer {
	private DogDoor door;
	
	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}
	
	public void open(String bark) {
		System.out.println("Recognizer hear bark "+bark);
		if(door.isOpen()) {
			door.close();
		}
		door.open();
	}
}
