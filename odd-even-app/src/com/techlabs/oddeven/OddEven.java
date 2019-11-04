package com.techlabs.oddeven;

import java.util.ArrayList;

public class OddEven {
	
	// Print Even Number.
	public ArrayList<Integer> getEvenNumber(int minrange, int maxrange) {
		System.out.println();
		System.out.println("Even");
		int num;
		ArrayList<Integer> evenumber = new ArrayList<>();
		for(int min = minrange; min <= maxrange; min+=2) {
			num = checkNumber(min,0);
			if(num <= maxrange)
				evenumber.add(num);
		}
		
		return evenumber;
	}
	
	// Print Odd Number.
	public ArrayList<Integer> getOddNumber(int minrange, int maxrange) {
		System.out.println();
		System.out.println("Odd");
		int num;
		ArrayList<Integer> oddnumber = new ArrayList<>();
		for(int min = minrange; min <= maxrange; min+=2) {
			num = checkNumber(min,1);
			if(num <= maxrange)
				oddnumber.add(num);
		}
		return oddnumber;
	}
	
	// Check Number Even or Odd.
	private static int checkNumber(int num,int flag) {
		if(num%2==0 && flag == 0) {
			return num;
		}
		else if(num%2 != 0 && flag == 1){
			return num;
		}
		
		return num+1;
	}
	
}
