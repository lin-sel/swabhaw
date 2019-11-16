package com.techlabs.inventory.test;

import com.techlabs.guitar.Guitar;
import com.techlabs.inventory.Inventory;

public class InventoryTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// Inventory Object.
		Inventory inventory = new Inventory();
		String status;
		
		// Starting Application.
		if((status = inventory.init()) != null) {
			System.err.println(status);
		}
		
		// Adding Dummy Data.
		inventory.addGuitar("NMAP76TA","AlphaDuck",20019,"Standard","Rock","abcd","xyza");
		Guitar customerrequirement = new Guitar("NMAP76TA","AlphaDuck",20019,"Standard","Rock","abcd","xyza");
		
		// Filter Data.
		Guitar filterguitar = inventory.searchGuitar(customerrequirement);
		
		// Print Filter Guitar Data.
		printGuitar(filterguitar,inventory);
		
		// Closing Application.
		if((status = inventory.close()) != null) {
			System.err.println(status);
		}
	}

	public static void printGuitar(Guitar filterguitar, Inventory inventory) {
		if(filterguitar != null) {
			System.out.println("Here we Found Something for you.....");
			System.out.println("Serialnumber: "+filterguitar.getSerialNumber());
			System.out.println("Builder: "+filterguitar.getBuilder());
			System.out.println("Model: "+filterguitar.getModel());
			System.out.println("Type: "+filterguitar.getType());
			System.out.println("Topwood: "+filterguitar.getTopwood());
			System.out.println("Backwood: "+filterguitar.getBackwood());
			System.out.println("Price: "+filterguitar.getPrice());
		}
		else {
			System.out.println("Sorry No Match Found.");
		}
	}

}
