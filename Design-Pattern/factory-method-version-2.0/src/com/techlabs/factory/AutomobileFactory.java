package com.techlabs.factory;

public class AutomobileFactory {
	private static AutomobileFactory factory;
	
	private AutomobileFactory() {
		System.out.println("FActory Object Created.");
	}
	public static AutomobileFactory getInstance() {
		if(factory == null) {
			factory = new AutomobileFactory();
			return factory;
		}
		return factory;
	}
	
	public IAutomobile make(AutoMobileType type) {
		if(type == AutoMobileType.AUDI) {
			return new Audi();
		}
		else if(type == AutoMobileType.BMW) {
			return new BMW();
		}
		else if(type == AutoMobileType.TESLA){
			return new Tesla();
		}
		return null;
	}
}
