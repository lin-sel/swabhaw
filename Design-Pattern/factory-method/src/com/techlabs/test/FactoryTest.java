package com.techlabs.test;

import com.techlabs.factory.IAutoFactory;
import com.techlabs.factory.IAutomobile;
import com.techlabs.factory.TeslaFactory;

public class FactoryTest {

	public static void main(String[] args) {
		IAutoFactory carfactory = new TeslaFactory();
		IAutomobile car = carfactory.make();
		car.start();
	}

}
