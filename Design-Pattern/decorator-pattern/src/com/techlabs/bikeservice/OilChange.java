package com.techlabs.bikeservice;

public class OilChange implements IBikeService{
	private final int cost = 500;
	private IBikeService service;
	
	public OilChange(IBikeService service) {
		this.service = service;
	}
	
	public OilChange() {
		this(null);
	}
	
	@Override
	public int getCost() {
		return cost + (service != null ? service.getCost() : 0);
	}

	@Override
	public void getDescription() {
		System.out.println("Oil Change @ "+this.cost);
		if(service != null )
			service.getDescription();
	}
	
}
