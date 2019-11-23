package com.techlabs.line.test;

import java.util.ArrayList;

import com.techlabs.line.item.LineItem;

public class LineTest {

	public static void main(String[] args) {
		ArrayList itemlist = new ArrayList();
		itemlist.add(new LineItem(201,"Book",2000));
		itemlist.add("Nilesh");
		printDetails(itemlist);
	}

	private static void printDetails(ArrayList itemlist) {
		for(Object obj : itemlist) {
			LineItem item = (LineItem)obj;
			System.out.println("Product: "+item.getProductname()+"Cost: "+item.calculateItemCost());
		}
	}

}
