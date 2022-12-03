package telran.shapes.test;
import telran.shapes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle (10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}

	@Test
	@Disabled
	void squareTest() {
		Square square = new Square(8);
		displayStrings(square.presentation(24));
		
		Square.setSymbol("#");
		square.setHeight(4);
		displayStrings(square.presentation(20));
		
		Square.setSymbol("$");
		square.setWidth(10);
		displayStrings(square.presentation(10));
		
		
	}
	
	@Test
	
	void leftTriangleTest() {
		
		SquareLeftTriangle squareLeftTriangle = new SquareLeftTriangle(10);
		assertEquals(10, squareLeftTriangle.getHeight());
		assertEquals(10, squareLeftTriangle.getWidth());
		displayStrings(squareLeftTriangle.presentation(40));
	}
	
	@Test
	
	void rightTriangleTest() {
		
		SquareRightTriangle.setSymbol("#");
		SquareRightTriangle squareRightTriangle = new SquareRightTriangle(5);		
		displayStrings(squareRightTriangle.presentation(10));
	}
	
	
	
	
	private void displayStrings(String strings[]) {
		for (String str: strings) {
			System.out.println(str);
		}
		
		
	}

}
