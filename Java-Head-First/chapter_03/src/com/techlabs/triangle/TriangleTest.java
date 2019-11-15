package com.techlabs.triangle;

public class TriangleTest {
	double area;
	int height;
	int length;
	public static void main(String[] args) {
		TriangleTest[] triangle = new TriangleTest[4];
		int x = 0;
		while(x < 4) {
			triangle[x] = new TriangleTest(); 
			triangle[x].height = (x + 1) * 2;
			triangle[x].length = (x + 4);
			triangle[x].setArea();
			System.out.print("triangle "+ x +", area");
			System.out.println(" = "+triangle[x].area);
			x = x + 1;
		}
		int y = x;
		x = 27;
		TriangleTest tS = triangle[2];
		triangle[2].area = 343;
		System.out.print("y = "+ y);
		System.out.println(", t5 area = "+ tS.area);
	}
	
	void setArea() {
		area = (height * length) / 2;
	}

}
