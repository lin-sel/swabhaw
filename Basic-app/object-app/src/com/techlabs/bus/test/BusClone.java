package com.techlabs.bus.test;

import com.techlabs.bus.Bus;

public class BusClone {

	public static void main(String[] args) {
		Bus bu = new Bus();
		System.out.println(bu);
		try {
			Bus bu1 = (Bus) bu.clone();
			System.out.println(bu1);
		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
   }

}
