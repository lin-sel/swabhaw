package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();
		rec1.width = 20;
		rec1.height= 5;
		System.out.println(rec1.areaCalculate());
		rec1.width = 50;
		rec1.height= 20;
		System.out.println(rec1.areaCalculate());
	}

}
