package com.techlabs.inventory.test;

import java.util.ArrayList;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;
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
		inventory.addGuitar("NMAP76TA",Builder.OLSON,20019,"Standard",Type.ACOUSTIC,Wood.ALDER,Wood.INDIAN_ROSEWOOD);
		Guitar customerrequirement = new Guitar("NMAP76TA",Builder.FENDER,20019,"Standard",Type.ELECTRIC,Wood.ALDER,Wood.INDIAN_ROSEWOOD);
		
		// Filter Data.
		ArrayList<Guitar> filterguitar = inventory.searchGuitar(customerrequirement);
		
		// Print Filter Guitar Data.
		printGuitar(filterguitar,inventory);
		
		// Closing Application.
		if((status = inventory.close()) != null) {
			System.err.println(status);
		}
	}

	public static void printGuitar(ArrayList<Guitar> filterguitar, Inventory inventory) {
		if(filterguitar.size() != 0) {
			System.out.println("Here we Found Something for you.....");
			for(int i = 0; i < filterguitar.size(); i++) {
				System.out.print(i+1+".");
				System.out.println("\tSerialnumber: "+filterguitar.get(i).getSerialNumber());
				System.out.println("\tBuilder:      "+filterguitar.get(i).getBuilder());
				System.out.println("\tModel:        "+filterguitar.get(i).getModel());
				System.out.println("\tType:         "+filterguitar.get(i).getType());
				System.out.println("\tTopwood:      "+filterguitar.get(i).getTopwood());
				System.out.println("\tBackwood:     "+filterguitar.get(i).getBackwood());
				System.out.println("\tPrice:        "+filterguitar.get(i).getPrice());
			}
		}
		else {
			System.out.println("Sorry No Match Found.");
		}
	}

}
