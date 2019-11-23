package com.techlabs.bus.test;

import com.techlabs.bus.Bus;

public class NewInstance {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Bus cls = Bus.class.newInstance();
			System.out.println(cls.getColor());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

}
