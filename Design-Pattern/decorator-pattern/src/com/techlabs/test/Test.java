package com.techlabs.test;

import com.techlabs.bikeservice.BasicInspection;
import com.techlabs.bikeservice.IBikeService;
import com.techlabs.bikeservice.OilChange;
import com.techlabs.bikeservice.TyreChange;

public class Test {

	public static void main(String[] args) {
		IBikeService service = new BasicInspection(new OilChange(new TyreChange()));
		System.out.println("Total Cost: "+service.getCost());
		service.getDescription();
	}

}
