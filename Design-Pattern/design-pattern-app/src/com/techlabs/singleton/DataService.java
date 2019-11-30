package com.techlabs.singleton;

public class DataService {
	private static DataService object = null;
	
	private DataService() {
		System.out.println("Object Created.");
	}
	
	public void doSomething(DataService singleton ) {
		System.out.println(singleton);
	}
	
	public static DataService getInstance() {
		if(object == null) {
			object = new DataService();
			return object;
		}
		return object;
	}
}
