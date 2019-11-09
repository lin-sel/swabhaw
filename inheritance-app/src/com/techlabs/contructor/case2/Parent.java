package com.techlabs.contructor.case2;

public class Parent {
	private int parentdata;
	
	public Parent(int data) {
		System.out.println("Inside Parent");
		this.parentdata = data;
	}
	
	public int parentData() {
		return this.parentdata;
	}
}
