package com.techlabs.array.test;

public class ArrayTest {

	public static void main(String[] args) {
		String [] islandlist = new String[4];
		int []index = new int[4];
		islandlist[0] = "Bermuda";
		islandlist[1] = "Fiji";
		islandlist[2] = "Azores";
		islandlist[3] = "Cuzumel";
		index[0] = 1;
		index[1] = 3;
		index[2] = 0;
		index[3] = 2;
		int y = 0;
		int ref;
		while(y < 4) {
			ref = index[y];
			System.out.print("island = ");
			System.out.println(islandlist[ref]);
			y = y + 1;
		}
	}

}
