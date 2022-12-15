package telran.shapes.test;

import telran.shapes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
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
	@Disabled
	void leftTriangleTest() {

		SquareLeftTriangle squareLeftTriangle = new SquareLeftTriangle(10);
		assertEquals(10, squareLeftTriangle.getHeight());
		assertEquals(10, squareLeftTriangle.getWidth());
		displayStrings(squareLeftTriangle.presentation(40));
	}

	@Test
	@Disabled
	void rightTriangleTest() {

		SquareRightTriangle.setSymbol("#");
		SquareRightTriangle squareRightTriangle = new SquareRightTriangle(5);
		displayStrings(squareRightTriangle.presentation(10));
	}

	@Test
	@Disabled
	void canvasTest() {
		Rectangle rectangle = new Rectangle(10, 8);
		Square square = new Square(12);
		SquareLeftTriangle squareLeftTriangle = new SquareLeftTriangle(10);
		SquareRightTriangle squareRightTriangle = new SquareRightTriangle(10);
		Shape[] shapes = {square, squareLeftTriangle, rectangle,   squareRightTriangle };
		Canvas canvas = new Canvas(8, 10, shapes);
		
		canvas.setDirection("row");
		canvas.setMargin(5);
		displayStrings(canvas.presentation(10));
		

		canvas.setDirection("column");
		canvas.setMargin(1);
		displayStrings(canvas.presentation(10));
	}

	private void displayStrings(String strings[]) {
		for (String str : strings) {
			System.out.println(str);
		}

	}
	
	Canvas canvas = new Canvas(10, 20,
			new Shape[] { new Rectangle(10, 3), new Square(10), new SquareLeftTriangle(10) });
	Shape[] shapes = { new Rectangle(10, 3), new Square(10), new SquareLeftTriangle(10), new SquareRightTriangle(10),
			canvas, new Square(10) };
	
	@Test
	@Disabled
	void canvasInRowTest() {
		Canvas canvas = new Canvas(10, 4, shapes);
		canvas.setMargin(3);
		displayStrings(canvas.presentation(2));

	}

	@Test
    @Disabled
	void canvasInColumnTest() {
		Canvas canvas = new Canvas(10, 4, shapes);
		canvas.setDirection("column");
		this.canvas.setDirection("column");
		canvas.setMargin(1);
		displayStrings(canvas.presentation(2));

	}

}
