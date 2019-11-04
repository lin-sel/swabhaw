package com.techlabs.oddeven;

public class OddEven {
	public void printOddEven(int minrange, int maxrange) {
		System.out.println("Even"+" "+"Odd");
		for(int min = minrange; min <= maxrange; min+=2) {
			if(min%2 == 0) {
				System.out.println(min+"  "+min+1);
			}
			else {
				System.out.println(min+1+"  "+min);
			}
		}
	}
}
