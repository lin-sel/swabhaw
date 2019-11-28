package com.techlabs.id.test;

public class SortChar {

	public static void main(String[] args) {
		char[] arr = {'d','S','B','a'};
		int[] out = new int[27];
		
		for(int i = 0; i < arr.length;i++) {
			char j = Character.toUpperCase(arr[i]);
			out[j-65] = arr[i];
		}
		
		for(int ch : out) {
			if(ch != 0) {
				System.out.println((char)ch);
			}
		}
	}

}
