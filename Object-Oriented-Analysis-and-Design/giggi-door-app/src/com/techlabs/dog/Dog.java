package com.techlabs.dog;

public class Dog {
	private boolean open;
	
	public Dog(){
		this.open = false;
	}
	
	public void open() {
		this.open = true;
		System.out.println("Open door");
	}
	
	public void close() {
		this.open = false;
		System.out.println("Close door");
	}
	
	public boolean isOpen() {
		return open;
	}
}
