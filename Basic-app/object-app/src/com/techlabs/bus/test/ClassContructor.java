package com.techlabs.bus.test;

import java.lang.reflect.InvocationTargetException;

import com.techlabs.bus.Bus;

public class ClassContructor {

	public static void main(String[] args) {
		try {
			Bus bus = Bus.class.getDeclaredConstructor().newInstance();
			System.out.println(bus.getColor());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
