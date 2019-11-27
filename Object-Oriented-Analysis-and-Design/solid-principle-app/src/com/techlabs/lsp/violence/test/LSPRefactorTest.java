package com.techlabs.lsp.violence.test;

import com.techlabs.lsp.refactor.Rectangle;
import com.techlabs.lsp.refactor.Polygon;
import com.techlabs.lsp.refactor.Square;

public class LSPRefactorTest {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10,20);
		areaPrint(rectangle);
		Square square = new Square(20);
		areaPrint(square);
	}

	private static void areaPrint(Polygon polygon) {
		int area = polygon.calculateArea();
		System.out.println(area);
	}
}
