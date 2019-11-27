package com.techlabs.inventory.test;

import java.util.ArrayList;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Style;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;
import com.techlabs.instrument.Instrument;
import com.techlabs.inventory.Inventory;
import com.techlabs.mandolin.MandolinSpec;

public class InventoryTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// Inventory Object.
		Inventory inventory = new Inventory();

		// Adding Dummy Data.
		MandolinSpec mandolin = new MandolinSpec(Builder.FENDER, "XYZ", Type.ELECTRIC, Wood.BRAZILIAN_ROSEWOOD,
				Wood.CEDAR, Style.F);
		inventory.addInstrument("NS908DT5", 300, mandolin);
		MandolinSpec customerrequirement = new MandolinSpec(Builder.FENDER, "XYZ", Type.ELECTRIC,
				Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR, Style.F);

		// Filter Data.
		ArrayList<Instrument> filterguitar = inventory.searchInstrument(customerrequirement);

		// Print Filter Guitar Data.
		printMandolin(filterguitar, inventory);
	}

	public static void printMandolin(ArrayList<Instrument> filterguitar, Inventory inventory) {
		if (filterguitar.size() != 0) {
			System.out.println("Here we Found Something for you.....");
			for (int i = 0; i < filterguitar.size(); i++) {
				System.out.print(i + 1 + ".");
				System.out.println("\tSerialnumber: " + filterguitar.get(i).getSerialNumber());
				System.out.println("\tBuilder:      " + filterguitar.get(i).getInstrumentspec().getBuilder());
				System.out.println("\tModel:        " + filterguitar.get(i).getInstrumentspec().getModel());
				System.out.println("\tType:         " + filterguitar.get(i).getInstrumentspec().getType());
				System.out.println("\tTopwood:      " + filterguitar.get(i).getInstrumentspec().getTopwood());
				System.out.println("\tBackwood:     " + filterguitar.get(i).getInstrumentspec().getBackwood());
				System.out.println("\tPrice:        " + filterguitar.get(i).getPrice());
			}
		} else {
			System.out.println("Sorry No Match Found.");
		}
	}

}
