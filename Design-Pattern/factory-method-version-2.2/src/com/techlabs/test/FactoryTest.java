package com.techlabs.test;

import com.techlabs.factory.IAutoFactory;
import com.techlabs.factory.IAutomobile;

public class FactoryTest {

	public static void main(String[] args) {
		InstanceCreator instancecreator = new InstanceCreator(new FileParser());
		IAutoFactory classobject= instancecreator.getClassInstance();
		IAutomobile object = classobject.make();
		object.start();
		object.stop();
	}

}
