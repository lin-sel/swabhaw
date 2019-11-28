package com.techlabs.singleton.doubles.checking;

public class Singleton {
private static Singleton singleton;
	
	private Singleton() {
		System.out.println("Instance Creating");
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized(Singleton.class){
				if(singleton == null) {
					singleton = new Singleton();
					return singleton;
				}
			}
		}
		return singleton;
	}
}
