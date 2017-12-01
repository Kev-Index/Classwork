package algorithms;

public class RecursionExercises {
	public static void main(String[] args){
		 long value = 18;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
		 }

		 public static long countPrimeFactors(long value, int testPrime) {
		 
			 if (value < testPrime) {
				 return 0;
			 }
			 if (value % testPrime == 0) {
				 return 1 + countPrimeFactors(value/testPrime, testPrime);
			 } else {
				 return countPrimeFactors(value, testPrime+1);
			 }
		 }

		 public static long factorial(long value) {
		 
			 if (value <= 1) {
				 return value;
				 
			 }
			 else {
				 return value * factorial(value-1);
			 }
		 }
}
