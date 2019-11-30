package com.techlabs.test;

import com.techlabs.factory.AudiFactory;
import com.techlabs.factory.BMWFactory;
import com.techlabs.factory.IAutoFactory;
import com.techlabs.factory.IAutomobile;
import com.techlabs.factory.TeslaFactory;

public class FactoryTest {

	public static void main(String[] args) {
		IAutoFactory carfactory = TeslaFactory.getInstance();
		IAutomobile car = carfactory.make();
		car.start();
		IAutoFactory carfactory2 = AudiFactory.getInstance();
		IAutomobile car2 = carfactory2.make();
		car2.start();
		IAutoFactory carfactory3 = BMWFactory.getInstance();
		IAutomobile car3 = carfactory3.make();
		car3.start();
	}

}
