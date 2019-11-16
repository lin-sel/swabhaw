package com.techlabs.contructor.case2;

public class Child extends Parent{
	public Child(int x) {
		super(x);
		System.out.println("Inside Child");
	}
	
	public Child() {
		super(100);
		System.out.println("Inside Child");
	}
	
	public int getParentdata() {
		return super.parentData();
	}
}
