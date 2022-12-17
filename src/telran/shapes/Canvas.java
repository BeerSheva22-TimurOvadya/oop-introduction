package telran.shapes;

import java.util.Arrays;

public class Canvas extends Shape {
	private String direction = "row";
	private Shape[] shapes;
	private int margin = 5;

	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}

	@Override
	public String[] presentation(int offset) {
		verificationDirection();		
		String[] res = new String[0];
		if (direction == "row") {
			res = horizontalPrint(offset);
		} else {
			for (Shape shape : shapes) {
				res = vertikalPrint(res, shape, offset);
			}
		}
		return res;
	}
	
	
	private void verificationDirection() {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof Canvas == true) {
				((Canvas)shapes[i]).setDirection(direction);
			}
		}
		
	}

	private String[] horizontalPrint(int offset) {
		shapes[0].setHeight(height);
		String[] res = shapes[0].presentation(offset);
		for (int i = 1; i < shapes.length; i++) {
			shapes[i].setHeight(height);
			String[] shapeLines = shapes[i].presentation(margin);
			for (int j = 0; j < height; j++) {
				res[j] = res[j] + shapeLines[j];
			}
		}
		return res;
	}

	private String[] vertikalPrint(String[] source, Shape shape, int offset) {
		shape.setWidth(this.getWidth());
		String[] shapePresent = shape.presentation(offset);
		int perim = source.length + shapePresent.length;
		String[] arrayInterval = new String[margin];
		Arrays.fill(arrayInterval, "");
		String[] res = Arrays.copyOf(source, perim + margin);		
		System.arraycopy(arrayInterval, 0, res, perim, margin);
		System.arraycopy(shapePresent, 0, res, source.length, shapePresent.length);		
		return res;
	}
	
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}
}