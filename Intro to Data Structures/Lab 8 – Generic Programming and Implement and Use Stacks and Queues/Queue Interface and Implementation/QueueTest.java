/**
 * Test program for Queues.
 * @author Robert Vargas
 *
 */
public class QueueTest {
	
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
		
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
		
		
		
		// Test 1: Populate linkedQueue with multiples of 5 from 5 to 50.
		printTestHeader("Enqueue linkedQueue with multiples of 5 from 5 to 50.");
		
		System.out.println("Is linkedQueue empty?: " + linkedQueue.isEmpty() + "\n");
		
		for ( int i = 1; i <= 10; i++ )
			linkedQueue.enqueue( i * 5 );
		
		System.out.println("Contents of linkedQueue from front to back:\n\t" + linkedQueue + "\n" );
		System.out.println("\t(isEmpty?: " + linkedQueue.isEmpty() + ")");
		System.out.println("\t(Size: " + linkedQueue.size() + ")");
		System.out.println("\t(Front element: " + linkedQueue.front() + ")\n");
		
		printTestEnd();
		
		
		
		// Test 2: Dequeue 3 elements from the queue and print in the order dequeued.
		printTestHeader("Dequeue 3 elements from the queue and print in the order dequeued.");
		
		System.out.print("Dequeued elements:\n\t");
		for ( int i = 0; i < 3; i++ )
			System.out.print( linkedQueue.dequeue() + " " );
		System.out.println("\n");
		
		System.out.println("Remaining elements in linkedQueue:\n\t" + linkedQueue + "\n");
		System.out.println("\t(isEmpty?: " + linkedQueue.isEmpty() + ")");
		System.out.println("\t(Size: " + linkedQueue.size() + ")");
		System.out.println("\t(Front element: " + linkedQueue.front() + ")\n");

		
		printTestEnd();

	}

}
