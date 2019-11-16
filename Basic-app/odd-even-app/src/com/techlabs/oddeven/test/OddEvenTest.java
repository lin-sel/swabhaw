package com.techlabs.oddeven.test;

import java.util.ArrayList;

import com.techlabs.oddeven.OddEven;

public class OddEvenTest {

	public static void main(String[] args) {
		ArrayList<Integer> number = new ArrayList<Integer>();
		OddEven oe = new OddEven();
		number = oe.getEvenNumber(51, 100);
		
		number.forEach((n) -> printNumber(n));
		number = oe.getOddNumber(50, 100);
		System.out.println();
		number.forEach((n) -> printNumber(n));
	}


	public static void printNumber(int num) {
		System.out.print(num+" ");
	}

}