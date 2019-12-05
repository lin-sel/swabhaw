package com.techlabs.test;

import com.techlabs.bikeservice.*;

public class Test {

	public static void main(String[] args) {
		IBikeService service = new OilChange(new TyreChange(new BasicInspection()));
		System.out.println("Total Cost: "+service.getCost());
		service.getDescription();
	}

}
