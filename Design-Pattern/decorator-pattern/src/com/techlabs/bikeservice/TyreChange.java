package com.techlabs.bikeservice;

public class TyreChange implements IBikeService{
	private final int cost = 600;
	private IBikeService service;
	
	public TyreChange(IBikeService service) {
		this.service = service;
	}
	
	public TyreChange() {
		this(null);
	}
	
	@Override
	public int getCost() {
		return cost + (service != null ? service.getCost() : 0);
	}

	@Override
	public void getDescription() {
		System.out.println("Tyre Change @ "+this.cost);
		if(service != null )
			service.getDescription();
	}
	
}
