package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		
		// Creating Object of Rectangle Class
		Rectangle rec1 = new Rectangle();
		
		// Setting width and height
		rec1.setWidth(20);
		rec1.setHeight(5);
		rec1.setColor("Pink");
		System.out.println(rec1.areaCalculate());
		System.out.println(rec1.backgroundColor());
		
		// Setting width and height
		rec1.setWidth(50);
		rec1.setHeight(20);
		rec1.setColor("Green");
		System.out.println(rec1.areaCalculate());
		System.out.println(rec1.backgroundColor());
	}

}
