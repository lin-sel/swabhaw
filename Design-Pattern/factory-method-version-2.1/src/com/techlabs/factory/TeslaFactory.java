package com.techlabs.factory;

public class TeslaFactory implements IAutoFactory{
private static TeslaFactory factory;
	
	private TeslaFactory() {
		System.out.println("Audo Factory Object Created.");
	}
	
	public static IAutoFactory getInstance() {
		if(factory == null) {
			factory = new TeslaFactory();
			return factory;
		}
		return factory;
	}
	
	@Override
	public IAutomobile make() {
		return new Tesla();
	}

}
