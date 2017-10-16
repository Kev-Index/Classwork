package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] suits; //instantiate an array
	private String[] values;
	
	public ArraysMain() {
		// TODO Auto-generated constructor stub
		
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = ""+(i+1);
		}
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
		
		//populate1ToN(testArray);
		//populate(testArray);
		//countOccurances(testArray,3,18);
		
		//swap(testArray, 0,1);
		//shuffle(testArray);
		
		//System.out.println(Arrays.toString(testArray));
	}

	//print every card in the deck
	private String[] printDeck() {
		// TODO Auto-generated method stub
		
		String[] deck = new String[52];
		int index = 0;
		
		for (int i = 0; i < values.length; i++)
		{
			for (int o = 0; o < suits.length; o++)
			{
				deck[index] = (values[i]+" of "+suits[o]);
				index++;
			}
		}
		return deck;
	}

	//swap all randomly
	private void shuffle(int[] arr) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < arr.length; i++)
		{
			swap(arr,i,(int) (Math.random()*arr.length));
		}
	}

	//Swaps elements at i and j
	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		
		int swapped = arr[i];
		arr[i] = arr[j];
		arr[j] = swapped;
	}

	//populate arr with numbers from 1 to arr.length in order
	private void populate1ToN(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (i+1);
		}
	}

	private void countOccurances(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		
		//why create an array with this length?
		int[] counter = new int[end - start + 1];
		//to make it parallel with the outcomes possible
		
		for (int value: arr) {
			//why value - start?
			counter[value - start]++;
			//to line up the value with its position parallel within array counter
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.println("The value "+(i+start)+" was rolled "+counter[i]+" times.");
		}
	}

	//This method populates arr with results from rolling 2 dice
	private void populate(int[] arr) {
		// TODO Auto-generated method stub
		
		//correct way:
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = diceRoll(3);
		}
		
		//incorrect way (does nothing): doesn't do anything to the main array
		/*for (int value: arr) {
		*	value = diceRoll(2);
		*}
		*/
	}

	public void arrayNotes() {
		//two ways to construct an array
		int[] firstWay = {0,1,2,3,4,5};
		//this way will only work with the declaration
		//will not work:
		//firstWay = {6,7,8,9,10};
		//the array firstWay cannot be assigned a value a second time
				
		String[] secondWay = new String[5];
		//this will create an array with no extra spaces within
		//secondWay[0] = 1;
		//you can go on like so, creating values at each index
		//secondWay[1] = 10;
				
		//TWO WAYS TO ITERATE THROUGH AN ARRAY
		for (int i = 0; i < secondWay.length; i++)
		{
			System.out.println("The #"+i+" element is "+secondWay[i]);
		}
				
		//"For each int in secondWay"
		for (String value: secondWay) {
			System.out.println("Element is "+value);
		}
		//NOTE: primitive arrays are automatically populated with 0s
		//Object arrays are not populated (null)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects. 
		 *In other words, changing an element of an array changes the reference,
		 *not the object.
		*/
	}
	
	//returns the result after rolling n number of dice
	public int diceRoll(int n) {
		int num = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++)
		{
			num = (int) (Math.random()*6)+1; //Math.random rounds down so you have to add 1 to go from 0->5 to 1->6
			sum += num; //tally up the total
		}
		
		return sum;
	}
}
