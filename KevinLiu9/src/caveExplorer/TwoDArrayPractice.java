package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		
		for (String[] row: pic) { //for every string array row
			for (int col = 0; col < row.length; col++) {
				row[col] = " ";
			}
		}
		//drawHorizontalLine(pic, 2);
		//drawVerticalLine(pic, 3);
		//drawSlot(pic, 4, 6);
		drawBox (pic, 2, 4);
		
		print(pic);
	}

	/**
	 * A box looks like this:
	 * 	___
	 * 	|*|
	 * 	|_|
	 * The '*' marks the coordinates of the box (it is not drawn)
	 * Avoid an AIOOBE, but any portion of the Box
	 * that fits on the canvas should be drawn
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawBox(String[][] pic, int row, int col) {
		drawSlot(pic, row, col);
		drawSlot(pic, row+1, col);
		drawAt("_", pic, row-1, col);
		
		for (int i = col-1; i <= row+1; i++) {
			drawAt("_", pic, i, col);
		}
		
	}

	private static void drawAt(String string, String[][] pic, int row, int col) {
		//always check the row before the column
		//because the row must exist before a column can exist in it
		
		if (row >= 0&& row < pic.length && col >= 0 && col < pic[row].length) {
			pic[row][col] = string;
		}
		
	}

	/**
	 * A slot looks like this:
	 * 		| |
	 * The coordinates of the slot are where the space
	 * between the two vertical lines is found. In other words, 
	 * there is a vertical line to the left of (i,j) and a vertical
	 * line to the right of (i,j)
	 * CATCH: NO ArrayIndexOutOfBoundsExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int row, int col) {
		if (row >= 0 && row < pic.length) {
			if (col > 0) {
				pic[row][col-1] = "|";
			}	
			if (col < pic[row].length-1) {
				pic[row][col+1] = "|";
			}
			
		}
		
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for (int i = 0; i < pic.length; i++) {
			pic[i][col] = "|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for (int i = 0; i < pic[row].length; i++) {
			pic[row][i] = "-";
		}
		
	}

	/**
	 * write a method that prints every string in the pic,
	 * not separated by arrays and no brackets
	 * @param pic
	 */
	private static void print(String[][] pic) {
		for (String[] row: pic) { //use for each when you don't care about the index
			for (String col: row) {
				System.out.print(col);
			}
			System.out.println("");
		}
		
	}

}
