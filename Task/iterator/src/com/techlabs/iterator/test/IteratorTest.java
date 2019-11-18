package com.techlabs.iterator.test;

import com.techlabs.iterator.Itearator;

public class IteratorTest {

	public static void main(String[] args) {
		Itearator iterator = new Itearator();
		iterator.addData(11);
		iterator.addData(190);
		iterator.addData(9);
		iterator.addData(99);
		
		System.out.println(iterator.getlist());
	}

}
