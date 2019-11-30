package com.techlabs.factory;

public class TeslaFactory implements IAutoFactory{

	@Override
	public IAutomobile make() {
		return new Tesla();
	}

}
