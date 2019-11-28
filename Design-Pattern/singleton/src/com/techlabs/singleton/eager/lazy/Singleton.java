package com.techlabs.singleton.eager.lazy;

public class Singleton {
	
	// Creating Static Object. 
	private static Singleton singleton = new Singleton();
	
	// Create Default Constructor with private. 
	private Singleton() {
		
	}
	
	// return static instance.
	public static Singleton getInstance() {
		return singleton;
	}
}
