package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class RectangleArrayTest {
	
	public static void printRectangleDetails(Rectangle[]rectangles) {
		for(Rectangle rectangle : rectangles) {
			System.out.println("------------------Rectangle---------------- ");
			System.out.println("Width: "+rectangle.getWidth()+" Height: "+rectangle.getheight());
			System.out.println("Area of Rectangle: "+rectangle.areaCalculate());
			System.out.println("Background Color Of Rectangle: "+rectangle.getColor());
		}
	}
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();
		Rectangle rec2 = new Rectangle();
		Rectangle rec3 = new Rectangle();
		
		rec1.setHeight(12);
		rec1.setWidth(12);
		rec1.setColor("Pink");
		
		rec2.setHeight(11);
		rec2.setWidth(11);
		rec2.setColor("Green");
		
		rec3.setHeight(10);
		rec3.setWidth(10);
		rec3.setColor("Grey");
		
		Rectangle[] arr = {rec1, rec2, rec3};
		
		printRectangleDetails(arr);
	}

}
