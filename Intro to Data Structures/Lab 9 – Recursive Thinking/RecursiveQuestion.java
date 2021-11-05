import java.util.*;

/**
 * Solve given recursive problems.
 * @author Robert Vargas
 *
 */
public class RecursiveQuestion {
	
	/**
	 * Convert a String into an integer.
	 * @param n The String that will be converted to an integer primative type.
	 * @precondition The String must contain only digits.
	 * @postcondition The given String will be converted into an integer primative type.
	 * @throws IllegalArgumentException if any non-digit is in the String.
	 * @return The integer equivalent of the given String.
	 */
	public static int convert( String n ) {
		
		// error case
		if ( !Character.isDigit( n.charAt(0) ) )
			throw new IllegalArgumentException("String must be all numerical values.");
		
		// base cases
		if ( n.length() == 0 )
			return 0;
		if ( n.length() == 1 )
			return n.charAt(0) - '0';
		
		// recursive step
		return ( n.charAt(0) - '0' ) * (int)Math.pow( 10, n.length() - 1 )
				+ convert( n.substring(1) );
	}
	
	/**
	 * Calculate the kth Fibonacci number using binary recursion.
	 * @param k The kth term to reach.
	 * @return The kth term of the Fibonacci sequence.
	 */
	public static int FibBinaryRecursive( int k ) {
		
		// base cases
		if ( k <= 0 )
			return 0;
		if ( k == 1 )
			return 1;
		
		// recursive steps
		return FibBinaryRecursive( k - 1 ) + FibBinaryRecursive( k - 2 );
		
	}
	

	/**
	 * Solve the Towers of Hanoi problem.
	 * @param a The towers.
	 * @param n The smallest disk on the source.
	 * @param source The source peg of the disk.
	 * @param spare The spare, empty peg.
	 * @param target The target peg.
	 * @return Next configuration | Prints permutations as it goes.
	 */
	public static void towersOfHanoi( int n, int source, int spare, int target ) {
		
		// base case
		if ( n == 0 )
			return;
		
		// moves n-1 amount of rings from the source to the spare
		towersOfHanoi( n - 1, source, target, spare );
		
		// calls out the move that must be made once those are moved out of the way
		System.out.println("Move 1 ring from " + source + " to " + target + ".\n");
		
		// moves the remaining spares over to the target by following the same steps
		towersOfHanoi( n - 1, spare, source, target );
		
	}
	
	/**
	 * Permutate all possible combinations of a given integer array.
	 * @param a The Integer array to permutate.
	 * @param prefix Where to start permutating from.
	 */
	public static void permute( int[] a, int prefix ) {
		
		// base case
		if ( a.length == prefix ) {
			System.out.println( Arrays.toString(a) );
			return;
		}
		
		// recursive step
		for ( int i = prefix; i < a.length; i++ ) {
			int temp = a[i];
			a[i] = a[prefix];
			a[prefix] = temp;
			
			permute( a, prefix + 1 );
			
			temp = a[i];
			a[i] = a[prefix];
			a[prefix] = temp;
		}
		
	}
	
	/**
	 * Reverse the order of elements in a Character array within given bounds.
	 * @param a The character array to modify.
	 * @param start The beginning index to start reversing.
	 * @param end The end index to finish reversing at.
	 */
	public static void reverse( char[] a, int start, int end ) {
		
		// base case
		if ( start >= end )
			return;
		
		// recursive step
		char temp = a[start];
		a[start] = a[end];
		a[end] = temp;
		
		reverse( a, start + 1, end - 1 );
		
	}
	
	/**
	 * O(log(n)) method to calculate the power of a function recursively.
	 * @param x The number to raise to a power.
	 * @param n The power.
	 * @return x to the power of n.
	 */
	public static double pow( double x, int n ) {
		
		// error case
		if ( x == 0 && n <= 0 )
			throw new IllegalArgumentException("x is zero and n=" + n);
		
		// base case
		if ( n == 0 )
			return 1;
		else if ( n == 1 )
			return x;
		else if ( n > 0 ) {
			
			double result = pow( x, n / 2 );
			
			// check if even or odd and compute
			if ( n % 2 == 0 )
				return result * result;
			else
				return x * result * result;
			
		}
		// if x is nonzero, and n is negative
		else
			return 1 / pow( x, -n );
	}
	
	
	/*
	 * METHODS TO DO TESTS IN MAIN
	 */
	
	
	private static int testNumber = 1;
	
	/**
	 * Custom header for organizing test cases in the main method.
	 * @param header The text to display in the header.
	 */
	public static void printTestHeader( String header ) {
		System.out.printf("Test %03d: %s%n", testNumber, header );
		System.out.println( "-".repeat( header.length() + 10 ) + "\n" );
	}

	/**
	 * Custom footer for organizing test cases and their ending in the main method.
	 * @param testNumber The number of the test that has finalized.
	 */
	public static void printTestEnd() {
		System.out.println("\n\nEnd Test " + testNumber);
		System.out.println("===========\n\n\n");
		testNumber++;
	}

	public static void main(String[] args) {
		
		// Test convert("1234") to an integer recursively, then add 1.
		printTestHeader("Test convert(\"1234\") to an integer recursively, then add 1.");
		
		int convertedValue = convert("1234");
		System.out.println("1234 as an integer: " + convertedValue);
		System.out.println("1234 as an integer plus 1: " + ( convertedValue + 1 ) );
		
		printTestEnd();
		
		
		
		// Test Fibonacci numbers from k=0 to k=15.
		printTestHeader("Test Fibonacci numbers from k=0 to k=15.");
		
		for ( int i = 0; i <= 15; i++ )
			System.out.printf("Fibonacci of [%2d] -> [%4d]%n", i, FibBinaryRecursive(i));
		
		printTestEnd();
		
		
		
		// Test Hanoi Tower solver with values 2, 3, 4, and 5.
		printTestHeader("Test Hanoi tower solver with values 2, 3, 4, and 5.");
		
		for ( int i = 2; i <= 5; i++ ) {
			System.out.println("SOLVING FOR [" + i + "] DISKS.\n");
			towersOfHanoi( i, 1, 2, 3 );
			System.out.println("- - - - - END SOLUTION - - - - -\n");
		}
		
		printTestEnd();
		
		
		
		// Permute arrays of size 1, 2, 5, and 10, with values from 1 up to that length in each.
		printTestHeader("Permute arrays of size 1, 2, 5, and 10, with values from 1 up to that length in each.");
		
		int[] permuteTestCases = { 1, 2, 5, 10 };//, 10 };
		for ( int i = 0; i < permuteTestCases.length; i++ ) {
			
			// STOP processing before doing the permutations for 10 as it is far too big
			if ( permuteTestCases[i] == 10 ) {
				Scanner scan = new Scanner( System.in );
				System.out.println("WARNING: Permutations of an array length 10 is massive, and will completely " +
						"override the console. Please press [ENTER] to continue when you are ready.");
				while( !scan.nextLine().isEmpty() );
				scan.close();
			}
			System.out.println("Permuting array of SIZE: " + i + "\n");
			
			// do permutations for the given array length
			int[] values = new int[ permuteTestCases[i] ];
			for ( int j = 1; j <= permuteTestCases[i]; j++ )
				values[ j - 1 ] = j;
			permute( values, 0 );
			
			System.out.println("\n- - - - - END PERMUTATIONS FOR " + permuteTestCases[i] + " - - - - -\n");
			
		}
		
		
		
		// Reverse a character array of size 10 from index 3 to index 7.
		printTestHeader("Reverse a character array of size 10 from index 3 to index 7.");
		
		char[] charArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		
		// do reverse
		System.out.println("                              v           v");
		System.out.println("charArray original: " + Arrays.toString( charArray ) );
		reverse( charArray, 3, 7 );
		System.out.println("charArray  swapped: " + Arrays.toString( charArray ) );
		System.out.println("                              ^           ^");
		
		printTestEnd();
		
		
		
		// Test the rewritten pow() method that now works in O(n log(n)).
		printTestHeader("Test the rewritten pow() method that now works in O(n log(n)).");
		
		for ( int i = 1; i <= 5; i++ ) {
			for ( int j = 1; j <= 5; j++ )
				System.out.printf( "%d^(%d) = [%5d]%n", i, j, (int)pow( i, j ) );
			System.out.println();
		}
		
		printTestEnd();

	}

}
