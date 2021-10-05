
public class IntNodeTest {
	
	/**
	 * Custom header for organizing test cases in the main method.
	 * @param header The text to display in the header.
	 */
	public static void printTestHeader( String header ) {
		System.out.println( header );
		System.out.println( "-".repeat( header.length() ) + "\n" );
	}
	
	/**
	 * Custom footer for organizing test cases and their ending in the main method.
	 * @param testNumber The number of the test that has finalized.
	 */
	public static void printTestEnd( int testNumber ) {
		System.out.println("\n\nEnd Test " + testNumber);
		System.out.println("===========\n\n\n");
	}

	public static void main(String[] args) {
		
		// begin tests for IntNode
		printTestHeader("Initiate Test Cases.");

		
		//
		// Test 1: Create a new IntNode with the default constructor, and print out its information.
		printTestHeader("Test 1: Create a new IntNode with the default constructor, and print out its information.");
		
		IntNode nodeHead1 = new IntNode();
		System.out.println("nodeHead1 data:");
		System.out.printf("\t" +
				"Value: %d%n\t" +
				"Link: %s%n",
				nodeHead1.getValue(),
				nodeHead1.getLink());
		
		printTestEnd(1);
		
		
		
		//
		// Test 2: Create a new IntNode with an OVERLOADED constructor, with value 5, and print out its information.
		printTestHeader("Test 2: Create a new IntNode with an OVERLOADED constructor, with value 5, and print out its information.");
		
		IntNode nodeHead2 = new IntNode( 5, null );
		System.out.println("nodeHead2 data:");
		System.out.printf("\t" +
				"Value: %d%n\t" +
				"Link: %s%n",
				nodeHead2.getValue(),
				nodeHead2.getLink());
		
		printTestEnd(2);
		
		
		
		//
		// Test 3: Create a new IntNode with value 10 and link to nodeHead2.
		printTestHeader("Test 3: Create a new IntNode with value 10 and link to nodeHead2.");
		
		IntNode extraNode1 = new IntNode( 10, nodeHead2 );
		System.out.println("extraNode1 data:");
		System.out.printf("\t" +
				"Value: %d%n\t" +
				"Link: %s%n",
				extraNode1.getValue(),
				extraNode1.getLink());
		
		printTestEnd(3);
		
		
		
		//
		// Test 4: Print toString() to show that nodeHead2 is now part of extraNode1.
		printTestHeader("Test 4: Print toString() to show that nodeHead2 is now part of extraNode1.");
		
		System.out.println( extraNode1.toString() );
		
		printTestEnd(4);
		
		
		
		//
		// Test 5: Change extraNode1 data, and add a node after it.
		printTestHeader("Test 5: Change extraNode1 data to 12, and add a node of value 20 after it.");
		
		extraNode1.setValue(12);
		System.out.println( extraNode1.toString() );
		extraNode1.addNodeAfterThis(20);
		System.out.println( extraNode1.toString() );
		
		printTestEnd(5);
		
		
		
		// Test 6: Populate extraNode1 with multiples of 5 from 0 to 50 directly after it.
		printTestHeader("Populate extraNode1 with multiples of 5 from 0 to 50 directly after it.");
		
		for ( int i = 0; i <= 10; i++ ) {
			extraNode1.addNodeAfterThis( i * 5 );
			System.out.println( extraNode1.toString() );
		}
		
		System.out.println("\nNew length of extraNode1: " + IntNode.listLength( extraNode1 ));
		
		printTestEnd(6);
		
		
		
		//
		// Test 7: Remove the node directly after extraNode1.
		printTestHeader("Test 7: Remove the node directly after extraNode1.");
		
		System.out.println( extraNode1.toString() );
		extraNode1.removeNodeAfterThis();
		System.out.println( extraNode1.toString() );
		
		printTestEnd(7);
		
		
		
		//
		// Test 8: Search for 5, 35, and 42 in extraNode1.
		printTestHeader("Test 8: Search for 5, 35, and 42 in extraNode1.");
		
		System.out.println(" 5 exists: " + IntNode.search( extraNode1, 5 ) );
		System.out.println("35 exists: " + IntNode.search( extraNode1, 35 ) );
		System.out.println("42 exists: " + IntNode.search( extraNode1, 42 ) );
		
		printTestEnd(8);
		
		
		
		//
		// Test 9: Find mth to last in extraNode1 - Find 3rd to last, then 6th to last.
		printTestHeader("Test 9: Find mth to last in extraNode1 - Find 3rd to last, then 6th to last.");
		
		System.out.println("extraNode1: " + extraNode1.toString());
		
		System.out.println("3rd to last: " + extraNode1.findMthToLast(extraNode1, 3).getValue());
		System.out.println("6th to last: " + extraNode1.findMthToLast(extraNode1, 6).getValue());
		
		printTestEnd(9);
		
	}

}
