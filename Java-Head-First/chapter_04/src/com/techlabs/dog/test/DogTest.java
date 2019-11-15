package com.techlabs.dog.test;

import com.techlabs.dog.Dog;

public class DogTest {

	public static void main(String[] args) {
		Dog one = new Dog();
		one.setSize(70);
		Dog two = new Dog();
		two.setSize(8);
		Dog three = new Dog();
		three.setSize(35);
		
		System.out.println(one.bark());
		System.out.println(two.bark());
		System.out.println(three.bark());
	}

}
