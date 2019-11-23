package com.techlabs.set.test;

import java.util.TreeSet;

import com.techlabs.compare.CompareByCost;
import com.techlabs.compare.CompareById;
import com.techlabs.compare.CompareByName;
import com.techlabs.line.item.LineItem;

public class TreeSetWithComparator {

	public static void main(String[] args) {
		TreeSet<LineItem> treeset = new TreeSet<LineItem>(new CompareByCost());
//		TreeSet<LineItem> treeset = new TreeSet<LineItem>(new CompareByCost());
//		TreeSet<LineItem> treeset = new TreeSet<LineItem>(new CompareById());
		LineItem item =  new LineItem(101,"Book7",350);
		treeset.add(new LineItem(109,"Book2",950));
		treeset.add(new LineItem(104,"Book8",250));
		treeset.add(new LineItem(105,"Book0",550));
		treeset.add(new LineItem(102,"Book5",850));
		treeset.add(new LineItem(103,"Book3",650));
		treeset.add(item);
		for(LineItem list : treeset) {
			System.out.println("Id: "+list.getId()+" Name: "+list.getProductname()+" "+list.getCost());
		}
	}

}
