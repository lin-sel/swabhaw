package com.techlabs.calculate;

import org.junit.Test;

public class Calculator {
	
	@Test
	public int add(int para1, int para2) {
		if(para1 < 0 || para2 < 0) {
			throw new RuntimeException("Negative Number Not allowed");
		}
		return para1 + para2;
	}
}
