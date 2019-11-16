package com.techlabs.contructor.case2.test;

import com.techlabs.contructor.case2.Child;

public class Case2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child1 = new Child(300);
		System.out.println(child1.getParentdata());
		Child child2 = new Child();
		System.out.println(child2.getParentdata());
	}

}
