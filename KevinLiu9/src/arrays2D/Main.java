package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//int[] arr = {4,3,2,1,0};
		//changeNeighbors(arr,2);
		//System.out.println(Arrays.toString(arr));
	
		Array2DSampler test = new Array2DSampler();
	}

	//PRECONDITION: i>0 and i <arr.length
	//increases the element at i by 1
	//decreases the elements at i-1 and i+1, if they exist
	//AVOIDS ArrayIndexOutOfBoundsException
	//THIS IS SUCH A HEAVILY TESTED CONCEPT,
	//on every exam, you should always be in the habit checking for
	//ArrayIndexOutOfBoundsException
	public static void changeNeighbors(int[]arr, int i) {
		if ( i <= arr.length) {
			arr[i] += 1;
		}
		if (i >= 1) {
			arr[i-1] -= 1;
		}
		if ( i < arr.length) {
			arr[i+1] -= 1;
		}
	}
}
