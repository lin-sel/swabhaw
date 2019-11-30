package com.techlabs.factory;

import com.techlabs.factory.IAutomobile;

class Audi implements IAutomobile{

	@Override
	public void start() {
		System.out.println("Audi Start.");
	}

	@Override
	public void stop() {
		System.out.println("Audi Stop.");
	}
	
}
