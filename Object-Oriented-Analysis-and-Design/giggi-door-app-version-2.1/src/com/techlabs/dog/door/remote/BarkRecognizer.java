package com.techlabs.dog.door.remote;

import com.techlabs.dog.Dog;

public class BarkRecognizer {
	private Dog door;
	
	public BarkRecognizer(Dog door) {
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
