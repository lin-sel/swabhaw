package com.techlabs.dog.door.remote.test;

import com.techlabs.dog.Dog;
import com.techlabs.dog.door.remote.Remote;

public class RemoteTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Remote remote = new Remote(dog);
		
		remote.pressButton();
		System.out.println("Fido has gone outside.");
		System.out.println("Fido done everything.");
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) { }
		System.out.println("But Fido stuck outside..");
		System.out.println("Fido Start Barking again...");
		System.out.println("so, Todd grab the remote..");
		remote.pressButton();
		System.out.println("Fido back inside.");
	}

}
