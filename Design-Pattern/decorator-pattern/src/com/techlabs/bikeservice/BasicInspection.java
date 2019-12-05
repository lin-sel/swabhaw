package com.techlabs.bikeservice;

public class BasicInspection implements IBikeService{
	private final int cost = 200;
	
	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public void getDescription() {
		System.out.println("Basic Inspection @ "+this.cost);
	}
	
}
