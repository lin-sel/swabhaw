package com.techlabs.list.test;

import java.util.ArrayList;

import com.techlabs.list.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new List();
		list.addValue(10);
		list.addValue(12);
		list.addValue(14);
		list.addValue(16);
		
		ArrayList<Integer> arraylist = new ArrayList<>();
		arraylist = list.getAllData();
		for(Integer data:arraylist) {
			System.out.println(data);
		}
	}

}
