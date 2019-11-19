package com.techlabs.dog.door.remote.test;

import com.techlabs.dog.Dog;
import com.techlabs.dog.door.remote.Remote;

public class RemoteTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Remote remote = new Remote(dog);
		
		System.out.println("Fido barks to go to out.");
		remote.pressButton();
		System.out.println("Fido has gone outside.");
		System.out.println("Fido done everything.");
		System.out.println("Fido back inside.");
	}

}
