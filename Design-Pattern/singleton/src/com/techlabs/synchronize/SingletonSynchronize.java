package com.techlabs.synchronize;

public class SingletonSynchronize {
	private static SingletonSynchronize singleton;
	
	private SingletonSynchronize() {
		System.out.println("Instance Creating");
	}
	
	public static synchronized SingletonSynchronize getInstance() {
		if(singleton == null) {
			singleton = new SingletonSynchronize();
			return singleton;
		}
		return singleton;
	}
}
