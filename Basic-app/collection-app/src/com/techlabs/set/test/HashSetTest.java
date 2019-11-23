package com.techlabs.set.test;

import java.util.HashSet;
import java.util.Set;

import com.techlabs.line.item.LineItem;

public class HashSetTest {

	public static void main(String[] args) {
		Set<LineItem> set = new HashSet<>();
		LineItem item = new LineItem(101,"Book",2000);
		LineItem item1 = new LineItem(101,"Book",2000);
		set.add(item);
		set.add(item);
		set.add(item1);
		System.out.println(set.size());
		printlist(set);
	}

	private static void printlist(Set<LineItem> set) {
		for(LineItem item : set) {
			System.out.println(item.getId());
		}
	}
	
	
}
