package com.techlabs.basic;

public class PassByValueTest {

	public static void main(String[] args) {
		int mark = 100;
		int[] arr = {10,20,30,40,50};
		mutateMarksToZero(mark);
		mutateMarksToZero(arr);
		System.out.println(mark);
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void mutateMarksToZero(int []arr1) {
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = 0;
		}
	}
	
	public static void mutateMarksToZero(int arr1) {
		arr1 = 0;
	}

}
