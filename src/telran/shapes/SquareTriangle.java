package telran.shapes;

public class SquareTriangle extends Square {

	private boolean isLeftDiagonal;
	
	protected SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	public String[] presentation(int offset) {
		String res[] = new String[super.getWidth()];			
		int lastLine = super.getHeight() - 1;
		res[lastLine] = super.getLine(offset);
		
		if(isLeftDiagonal) {
			res[0] = " ".repeat(offset) + super.getSymbol();
		} else {
			res[0] = " ".repeat(offset + super.getWidth() - 1) + super.getSymbol();
		}
		
		for (int i = 1; i < lastLine; i++) {
			String end = super.getSymbol() +  super.getOffset(i - 1) + super.getSymbol();
			if (isLeftDiagonal) {				
				res[i] = super.getOffset(offset) + end ;
			} else {				
				res[i] = super.getOffset(offset + super.getWidth() - (i + 1)) + end;
			}			
		}
		return res;
	}	
}