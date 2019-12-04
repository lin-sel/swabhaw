package com.techlabs.bikeservice;

public class BasicInspection implements IBikeService{
	private final int cost = 200;
	private IBikeService service;
	
	public BasicInspection(IBikeService service) {
		this.service = service;
	}
	
	public BasicInspection() {
		this(null);
	}
	
	@Override
	public int getCost() {
		return cost + (service != null ? service.getCost() : 0);
	}

	@Override
	public void getDescription() {
		System.out.println("Basic Inspection @ "+this.cost);
		if(service != null )
			service.getDescription();
	}
	
}
