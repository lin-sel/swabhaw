package com.techlabs.person.test;

import com.techlabs.person.GenderOption;
import com.techlabs.person.Person;

public class PersonTest {

public static void main(String[] args) {
		
		Person person = new Person("Alex",21,GenderOption.MALE);
		System.out.println("Before Eating Person Details....");
		printPersonDetails(person);
		System.out.println("After Eating Person Details....");
		person.personEat();
		printPersonDetails(person);
		System.out.println("Before Workout Person Details....");
		printPersonDetails(person);
		System.out.println("After Workout Person Details....");
		person.personWorkout();
		printPersonDetails(person);
	}
	
	public static void printPersonDetails(Person person) {
		System.out.println("Name: "+person.getName());
		System.out.println("Age: "+person.getAge());
		System.out.println("Height: "+person.getHeight());
		System.out.println("Weight: "+person.getWeight());
		System.out.println("Gender: "+person.getGender());
		System.out.println("BMI: "+person.personBMI());
		System.out.println("Body Category: "+person.personBodyCategory());
	}

}
