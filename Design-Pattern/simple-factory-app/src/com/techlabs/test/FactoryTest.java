package com.techlabs.test;

import com.techlabs.factory.IAutomobile;
import com.techlabs.factory.AutoMobileType;
import com.techlabs.factory.AutomobileFactory;

public class FactoryTest {

	public static void main(String[] args) {
		AutomobileFactory automobile = AutomobileFactory.getInstance();
		IAutomobile car = automobile.make(AutoMobileType.AUDI);
		System.out.println(car.getClass());
		car.start();
	}

}
