package com.techlabs.door.remote.test;

import com.techlabs.dog.Bark;
import com.techlabs.dog.DogDoor;
import com.techlabs.door.remote.BarkRecognizer;

public class BarkRecognizerTest {

	public static void main(String[] args) {
		DogDoor dog = new DogDoor(new Bark("Woof Woof"));
		BarkRecognizer remote = new BarkRecognizer(dog);
		
		remote.open(new Bark("Woof Woof"));
		System.out.println("Fido has gone outside.");
		System.out.println("Fido done everything.");
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) { }
		System.out.println("But Fido stuck outside..");
		System.out.println("Fido Start Barking again...");
		remote.open(new Bark("hello!"));
		System.out.println("Fido back inside.");
	}

}
