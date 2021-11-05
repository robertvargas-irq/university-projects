/**
 * Testing program for IntNode.java
 * @author Robert Vargas
 *
 */
public class IntNodeAdvancedTest {
	
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
		// Test 1: Create two IntNodes and populate, one cyclic and one non-cyclic
		IntNode noCycleHead = new IntNode( 1, null );
		IntNode cyclicHead = new IntNode( 5, null );
		
		for ( int i = 2; i <= 15; i++ ) {
			noCycleHead.addNodeAfterThis( i );
			cyclicHead.addNodeAfterThis( i * 5 );
		}
		
		// print, then get the last node, and then set the link to the head
		System.out.println("noCycleHead:\n\t" + noCycleHead + "\n");
		System.out.println("cycleHead:\n\t" + cyclicHead + "\n");
		cyclicHead.findMthToLast(cyclicHead, 0).setLink(cyclicHead);
		
		System.out.println("noCycleHead is cyclid:\t" + IntNode.hasCycle(noCycleHead));
		System.out.println("cycleHead is cyclid:\t" + IntNode.hasCycle(cyclicHead));
		
		printTestEnd(1);
		
		
		
		//
		// Test 2: Change the 2nd, 4th, and 9th node of noCycleHead
		printTestHeader("Test 2: Change the 2nd, 4th, and 9th node of noCycleHead");
		
		System.out.println("noCycleHead original\n\t" + noCycleHead + "\n");
		System.out.println("2nd node will become 410\n4th node will become 910441\n9th node will become 115\n");
		IntNode.changeElement(noCycleHead, 1, 410);
		IntNode.changeElement(noCycleHead, 3, 910441);
		IntNode.changeElement(noCycleHead, 8, 115);
		System.out.println("noCycleHead after stated changes:\n\t" + noCycleHead);
		
		printTestEnd(2);
		
		
		
		//
		// Test 3: Separate even and odd, keeping the order of even and odd
		printTestHeader("Test 3: Separate even and odd, keeping the order of even and odd");
		
		IntNode evensAndOddsHead = new IntNode( 1, null );
		IntNode allEvensHead = new IntNode();
		IntNode allOddsHead = new IntNode( 1, null );
		
		for ( int i = 2; i <= 20; i++ ) {
			evensAndOddsHead.addNodeAfterThis(i);
			if ( i % 2 == 0 )
				allEvensHead.addNodeAfterThis(i);
			else
				allOddsHead.addNodeAfterThis(i);
		}
		
		System.out.println("evensAndOddsHead original:\n\t" + evensAndOddsHead + "\n");
		System.out.println("allEvensHead original:\n\t" + allEvensHead + "\n");
		System.out.println("allOddsHead original:\n\t" + allOddsHead + "\n");
		System.out.println("\n");
		
		IntNode.segregate_even_odd(evensAndOddsHead);
		IntNode.segregate_even_odd(allEvensHead);
		IntNode.segregate_even_odd(allOddsHead);
		
		System.out.println("evensAndOddsHead separated:\n\t" + evensAndOddsHead + "\n");
		System.out.println("allEvensHead separated:\n\t" + allEvensHead + "\n");
		System.out.println("allOddsHead separated:\n\t" + allOddsHead + "\n");

		printTestEnd(3);
		
		
		
		//
		// Test 4: Reverse the linked list from a given head
		printTestHeader("Test 4: Reverse the linked list from a given head");
		
		System.out.println("evensAndOddsHead reversed from node 2:\n\t"
				+ IntNode.reverse( evensAndOddsHead.getLink() ));
		System.out.println("evensAndOddsHead reverse from the beginning:\n\t"
				+ IntNode.reverse( evensAndOddsHead ));
		
		printTestEnd(4);
		
		
		
		//
		// Test 5: Swap out nodes with the last node
		printTestHeader("Test 5: Swap out nodes with the last node");
		
		System.out.println("allEvensHead original:\n\t" + allEvensHead + "\n");
		allEvensHead.swap();
		System.out.println("allEvensHead first node swapped with last:\n\t" + allEvensHead + "\n");
		allEvensHead.getLink().getLink().swap();
		System.out.println("allEvensHead third node swapped with last:\n\t" + allEvensHead + "\n");
		
		printTestEnd(5);
		
		
		
		//
		// Test 6: Shift allOddsHead from original 3, 5, 7, 10, and 28 times
		printTestHeader("Test 6: Shift allOddsHead from original 3, 5, 7, 10, and 28 times");
		
		int[] shifts = { 0, 3, 5, 7, 10, 28 };
		System.out.println("allOddsHead original:\n\t" + allOddsHead + "\n");
		for ( int i = 0; i < shifts.length; i++ )
			System.out.println("allOddsHead shifted left " + shifts[i] + " times:\n\t"
					+ IntNode.rotate(allOddsHead, shifts[i]) + "\n");
		
		printTestEnd(6);
		
	}

}
