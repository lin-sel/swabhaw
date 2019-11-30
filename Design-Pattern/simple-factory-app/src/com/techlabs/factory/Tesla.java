package com.techlabs.factory;

import com.techlabs.factory.IAutomobile;

class Tesla implements IAutomobile{

	@Override
	public void start() {
		System.out.println("Tesla Start.");		
	}

	@Override
	public void stop() {
		System.out.println("Tesla Stop.");
	}

}
