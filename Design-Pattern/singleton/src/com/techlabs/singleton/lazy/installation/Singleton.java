package com.techlabs.singleton.lazy.installation;

public class Singleton {
	private static Singleton singleton;
	
	private Singleton() {
		System.out.println("Instance Create");
	}
	
	public Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
			return singleton;
		}
		return singleton;
	}
}
