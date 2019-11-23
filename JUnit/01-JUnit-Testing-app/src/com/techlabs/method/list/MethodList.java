package com.techlabs.method.list;

import org.junit.jupiter.api.Test;

public class MethodList {
	
	@Test
	public int secondMaxValue(int[] list) {
		int max = Integer.MIN_VALUE;
		int secmax = Integer.MIN_VALUE;
		
		for(int element : list) {
			if(element > max) {
				secmax = max;
				max = element;
			}
			else if(element > secmax && element < max) {
				secmax = element;
			}
		}	
		return secmax;
	}
	
	@Test
	public boolean isEquallength(String string1, String string2) {
		if(string1.length() != string2.length()) {
			return false;
		}
		return true;
	}
	
	@Test
	public boolean test() {
		return false;
	}
}
