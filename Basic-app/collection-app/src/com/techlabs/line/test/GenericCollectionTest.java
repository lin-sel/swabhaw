package com.techlabs.line.test;

import java.util.ArrayList;

import com.techlabs.line.item.LineItem;

public class GenericCollectionTest {

	public static void main(String[] args) {
		ArrayList<LineItem> itemlist = new ArrayList<>();
		itemlist.add(new LineItem(201,"Book",2000));
//		itemlist.add("Nilesh");
		printDetails(itemlist);
	}

	private static void printDetails(ArrayList<LineItem> itemlist) {
		for(LineItem obj : itemlist) {
			System.out.println("Product: "+obj.getProductname()+"Cost: "+obj.calculateItemCost());
		}
	}

}
