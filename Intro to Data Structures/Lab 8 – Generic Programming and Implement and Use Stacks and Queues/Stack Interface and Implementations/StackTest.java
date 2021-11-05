/**
 * Test program for Stacks.
 * @author Robert Vargas
 *
 */
public class StackTest {

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
		
		LinkStack<Integer> intLinkStack = new LinkStack<Integer>();
		ArrayListStack<Integer> intArrayListStack = new ArrayListStack<Integer>();
		
		
		
		// Test 1: Populate both Integer stacks; intLinkStack with multiples of 1, intArrayListStack with multiples of 5.
		printTestHeader("Populate both Integer stacks; intLinkStack with multiples of 1, intArrayListStack with multiples of 5.");
		
		System.out.println("intLinkStack      isEmpty ? :\t" + intLinkStack.isEmpty() );
		System.out.println("intArrayListStack isEmpty ? :\t" + intArrayListStack.isEmpty() + "\n");

		for ( int i = 1; i <= 10; i++ ) {
			intLinkStack.push( i );
			intArrayListStack.push( i * 5 );
		}
		
		System.out.println("Multiples of 1 and 5 have been added to each stack respectively.\n");
		
		System.out.println("intLinkStack      isEmpty ? :\t" + intLinkStack.isEmpty() );
		System.out.println("intArrayListStack isEmpty ? :\t" + intArrayListStack.isEmpty() + "\n");
		
		System.out.println("intLinkStack contents (bottom to top):\n\n\t" + intLinkStack + "\n");
		System.out.println("\t(Size: " + intLinkStack.size() + ")");
		System.out.println("\t(Top element: " + intLinkStack.top() + ")\n");
		System.out.println("intArrayListStack contents (bottom to top):\n\n\t" + intArrayListStack + "\n");
		System.out.println("\t(Size: " + intArrayListStack.size() + ")");
		System.out.println("\t(Top element: " + intArrayListStack.top() + ")\n");
		
		printTestEnd();
		
		
		
		// Test 2: Pop each element off the stack and print the popped elements in popped order.
		printTestHeader("Pop each element off the stack and print the popped elements in popped order.");
		
		String intLinkStackPops = "";
		String intArrayListStackPops = "";
		while ( !intLinkStack.isEmpty() ) {
			intLinkStackPops += String.format( "%2d ", intLinkStack.pop() );
			intArrayListStackPops += String.format( "%2d ", intArrayListStack.pop() );
		}
		
		System.out.println("Pops from:\n\t"
				+ "intLinkStack:      " + intLinkStackPops + "\n\t"
				+ "intArrayListStack: " + intArrayListStackPops + "\n");
		
		System.out.println("\t(intLinkStack Size: " + intLinkStack.size() + ")");
		System.out.println("\t(intArrayListStack Size: " + intArrayListStack.size() + ")\n");

		printTestEnd();
		
		
		
	}

}
