package arrays2D;

public class Array2DSampler {

	private String[][] pic;
	
	public Array2DSampler() {
		
		pic = new String[10][20];
		print(pic);
	}

	private void print(String[][] pic2) {
		
		//create a standard for loop for a 2 dimensional array
		for (int row = 0; row < pic.length; row++) {
			//SPECIAL NOTE: these for loops get you test points!!!!!!!
			for (int col = 0; col < pic[row].length; col++) {
				System.out.print(pic[row][col]);
			}
			
			//line break
			System.out.println(" ");
		}
		
		//for each style:
		//for each row...
		for (String[] row: pic) {
			//for each column in that row...
			for (String col: row) {
				System.out.print(col);
			}
			
			//line break
			System.out.println(" ");
		}
	}

}
