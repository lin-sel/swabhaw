package com.techlabs.factory;

public class AudiFactory implements IAutoFactory{
	private static AudiFactory factory;
	
	private AudiFactory() {
		System.out.println("Audo Factory Object Created.");
	}
	
	public static IAutoFactory getInstance() {
		if(factory == null) {
			factory = new AudiFactory();
			return factory;
		}
		return factory;
	}
	@Override
	public IAutomobile make() {
		return new Audi();
	}

}
