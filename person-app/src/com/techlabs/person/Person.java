package com.techlabs.person;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private GenderOption genderoption;
	private float height;
	private float weight;
	
	public Person(String name, int age, GenderOption genderoption){
		this.name = name;
		this.age = age;
		this.genderoption = genderoption;
		
		setHeigth(173.736f);
		setWeight(60.00f);
	}
	
	public Person(String name, int age, GenderOption genderoption, float height, float weigth, float weight ){
		this.age = age;
		this.genderoption = genderoption;
		this.height = height;
		this.weight = weight;
		this.name = name;
	}

	private void setWeight(float weight) {
		this.weight = weight;
	}

	private void setHeigth(float height) {
		this.height = height;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public GenderOption getGender() {
		return this.genderoption;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public void personWorkout() {
		this.weight = this.weight - ((2*this.weight)/100);
	}
	
	public void personEat() {
		this.weight = this.weight + ((25*this.weight)/100);
	}
	
	public float personBMI() {
		return (float) (getWeight()/(getHeight()*getHeight()))*10000;
	}
	
	public String personBodyCategory() {
		
		if(personBMI() >= (float)25) {
			return "OverHealthy";
		}
		else if(personBMI() >= 18.5 && personBMI() <= 24.9) {
			return "Healthy";
		}
		
		return "Weak";
	}
}
