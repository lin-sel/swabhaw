package com.techlabs.factory;

public class BMWFactory implements IAutoFactory{
	private static BMWFactory factory; 
	
	private BMWFactory() {
		System.out.println("BMWFactory Object Created.");
	}
	
	public static IAutoFactory getInstance() {
		if(factory == null) {
			factory = new BMWFactory();
			return factory;
		}
		return factory;
	}
	
	@Override
	public IAutomobile make() {
		return new BMW();
	}

}
