package com.techlabs.dog.door.remote.test;

import com.techlabs.dog.DogDoor;
import com.techlabs.dog.door.remote.BarkRecognizer;

public class BarkRecognizerTest {

	public static void main(String[] args) {
		DogDoor dog = new DogDoor();
		BarkRecognizer remote = new BarkRecognizer(dog);
		
		remote.open("Woof Woof!");
		System.out.println("Fido has gone outside.");
		System.out.println("Fido done everything.");
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) { }
		System.out.println("But Fido stuck outside..");
		System.out.println("Fido Start Barking again...");
		System.out.println("so, Todd grab the remote..");
		remote.open("Woof Woof!");
		System.out.println("Fido back inside.");
	}

}
