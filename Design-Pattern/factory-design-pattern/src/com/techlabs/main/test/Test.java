package com.techlabs.main.test;

import com.techlabs.factory.design.OperatingSystem;
import com.techlabs.phone.OS;

public class Test {

	public static void main(String[] args) {
		OperatingSystem osf = new OperatingSystem();
		OS obj = osf.getInstance("android");
		obj.spec();
		OS obj1 = osf.getInstance("ios");
		obj1.spec();
		OS obj3 = osf.getInstance("jhsfla");
		obj3.spec();
	}

}
