package com.techlabs.set.test;

import java.util.Collections;
import java.util.TreeSet;

import com.techlabs.compare.CompareByName;
import com.techlabs.line.item.LineItem;

public class TreeSetTest{

	public static void main(String[] args) {
		TreeSet<LineItem> treeset = new TreeSet<LineItem>();
		LineItem item =  new LineItem(101,"Book7",350);
		treeset.add(new LineItem(109,"Book2",950));
		treeset.add(new LineItem(104,"Book8",250));
		treeset.add(new LineItem(105,"Book0",550));
		treeset.add(new LineItem(102,"Book5",850));
		treeset.add(new LineItem(103,"Book3",650));
		treeset.add(item);
		System.out.println(treeset.size());
		for(LineItem list : treeset) {
			System.out.println("Id: "+list.getId()+" Name: "+list.getProductname()+" "+list.getCost());
		}
	}
}
