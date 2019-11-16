package com.techlabs.arraylist.test;

import java.util.ArrayList;

import com.techlabs.arraylist.imp.ArrayListImplement;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayListImplement arraylis = new ArrayListImplement();
		ArrayList<String> arraylist = new ArrayList<>();
		arraylis.addData("11");
		arraylis.addData("12");
		arraylist.add("90");
		arraylist.add("80");
		arraylis.addAllDataAtPosition(2, arraylist);
	}
}
