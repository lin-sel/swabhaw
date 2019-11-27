package com.techlabs.lsp.violence.test;

import com.techlabs.lsp.violence.Rectangle;
import com.techlabs.lsp.violence.Square;

public class LSPViolenceTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10,20);
		shouldNotChangeWidthifHeightChange(rectangle);
		Square square = new Square(20);
		shouldNotChangeWidthifHeightChange(square);
	}

	private static void shouldNotChangeWidthifHeightChange(Rectangle rectangle) {
		int width = rectangle.getWidth();
		rectangle.setHeight(30);
		if(width == rectangle.getWidth()) {
			System.out.println("Pass");
			return;
		}
		System.err.println("Fail");
	}
}
