/**
 * Doubly Linked List implementation
 * @author Robert Vargas
 *
 */
public class DoublyLinkedListDummy {
	
	DIntNode head;
	DIntNode tail;
	
	/**
	 * Default constructor, linking the dummy head and tail together
	 */
	DoublyLinkedListDummy() {
		head = new DIntNode();
		tail = new DIntNode();
		head.setNext( tail );
		tail.setPrev( head );
	}
	
	/**
	 * Get the dummy Head of the DoublyLinkedList
	 * @return Dummy head of the DoublyLinkedList
	 */
	public DIntNode getHead() {
		return this.head;
	}
	
	/**
	 * Get the dummy Tail of the DoublyLinkedList
	 * @return Dummy Tail of the DoublyLinkedList
	 */
	public DIntNode getTail() {
		return this.tail;
	}
	
	/**
	 * Change the dummy Head of the DoublyLinkedList
	 * @param node The new Head reference for the DoublyLinkedList
	 * @precondition The node must not be null
	 */
	public void setHead( DIntNode node ) {
		this.head = node;
	}
	
	/**
	 * Change the dummy Tail of the DoublyLinkedList
	 * @param node The new Tail reference for the DoublyLinkedList
	 * @precondition The node must not be null
	 */
	public void setTail( DIntNode node ) {
		this.tail = node;
	}

	/**
	 * Add an element to the end of the DoublyLinkedList
	 * @param element The element to add at the end of the DoublyLinkedList
	 * @complexity O(1)
	 */
	public void addEnd( int element ) {
		
		// create new node, and link between old end node and tail
		DIntNode tail = this.getTail();
		DIntNode oldEnd = tail.getPrev();
		DIntNode add = new DIntNode( element, oldEnd, tail );

		// finally, link the old end node and tail to the new node
		tail.setPrev( add );
		oldEnd.setNext( add );
		
	}
	
	/**
	 * Remove the first real node head
	 * @complexity O(1)
	 */
	public void removeFromHead() {
		
		DIntNode head = this.getHead();

		// if the list is empty, return
		if ( head.getNext() == this.getTail() )
			return;
		
		// set to the link of the front node
		head.setNext( head.getNext().getNext() );
		
	}
	
	/**
	 * Convert the DoublyLinkedList into a human-readable string
	 * @return Human-readable string containing the data of the list
	 * @complexity O(n)
	 */
	public String toString() {
		
		DIntNode front = this.getHead().getNext();
		DIntNode back = this.getTail().getPrev();
		
		// if list is empty, return empty String
		if ( front == this.getTail() )
			return "\t(Forward) <Empty>\n\t(Backward) <Empty>";
		
		// loop through the list in both directions until tail is reached
		String forwardList = "\t(Forward) " + front.getData();
		String backwardList = "\t(Backward) " + back.getData();
		front = front.getNext();
		back = back.getPrev();
		
		// since the list is equal length front or back, only one loop is necessary
		while ( front != this.getTail() ) {
			
			forwardList += "<->" + front.getData();
			backwardList += "<->" + back.getData();
			
			front = front.getNext();
			back = back.getPrev();
			
		}
		
		return ( forwardList + "\n" + backwardList );
		
	}
	
	/**
	 * Count how many times an element appears in the DoublyLinkedList
	 * @param e
	 * @return
	 */
	public int countOccurrence( int e ) {
		
		DIntNode current = this.getHead().getNext();
		int count = 0;
		
		// if list is empty, return 0
		if ( current == this.getTail() )
			return 0;
		
		// iterate through the list and count occurrences
		while ( current != this.getTail() ) {
			if ( current.getData() == e )
				count++;
			current = current.getNext();
		}
		
		return count;
		
	}
	
	/**
	 * Remove all instances of a given element
	 * @param e The element to remove from the list
	 * @return True if element was found and removed | False if did not exist
	 * @complexity O(n)
	 */
	public boolean removeAll( int e ) {
		
		DIntNode current = this.getHead().getNext();
		DIntNode prev = this.getHead();
		boolean removed = false;
		
		// if the list is empty, return out with false
		if ( current == this.getTail() )
			return false;
		
		// if element is found in loop, sever links by jumping the bordering links over
		while ( current != this.getTail() ) {
			if ( current.getData() == e ) {
				removed = true;
				prev.setNext( current.getNext() );
				current.getNext().setPrev( prev );
			}
			// if element not found, increment prev
			else
				prev = prev.getNext();
			
			// go to next node
			current = current.getNext();
		}
		
		return removed;
		
	}
	
	/**
	 * Truncates the list at the given index position, only returning the values after the index
	 * @param i The truncation point
	 * @precondition i must not be less than 0, and must not be greater than the list length
	 * @return DoublyLinkedListDummy with only the nodes after the given index i
	 */
	public DoublyLinkedListDummy truncate( int i ) {
		
		DIntNode current = this.getHead().getNext();
		
		// if empty, return out of the method
		if ( current == this.getTail() )
			return this;
		
		// if i < 0, throw error
		if ( i < 0 )
			throw new IllegalArgumentException("The index cannot be less than zero!");
		
		// cycle through the list until the given i is reached
		for ( int index = 0; index < i; index++ )
			if ( current != this.getTail() )
				current = current.getNext();
			else
				throw new IllegalArgumentException("The index cannot be greater than the length of the list!\n"
						+ i + " > " + "length: " + index );
		
		// copy the list data to a new DoublyLinkedListDummy
		DoublyLinkedListDummy copy = new DoublyLinkedListDummy();
		while ( current != this.getTail() ) {
			copy.addEnd( current.getData() );
			current = current.getNext();
		}
		
		return copy;
		
	}
	
	/**
	 * Absorb a different DoublyLinkedList, then clear the list that was absorbed
	 * @param target The DoublyLinkedList to absorb
	 * @complexity O(n)
	 */
	public void absorb( DoublyLinkedListDummy target ) {
		
		// if target list is empty or null, return out
		if ( target == null || target.getHead().getNext() == target.getTail() )
			return;
		
		DIntNode tCurrent = target.getHead().getNext();

		// iterate through the target list and add elements
		while ( tCurrent != target.getTail() ) {
			this.addEnd( tCurrent.getData() );
			tCurrent = tCurrent.getNext();
		}
		
		// empty target completely
		target.getHead().setNext( target.getTail() );
		target.getTail().setPrev( target.getHead() );
		
	}
	
	
	
	/**
	 * Custom header for organizing test cases in the main method.
	 * @param header The text to display in the header.
	 */
	public static void printTestHeader( int test, String header ) {
		System.out.printf("Test %3d: %s%n", test, header );
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
		
		// Test 1: Create two empty lists with dummy head and tail.
		printTestHeader( 1, "Create two empty lists with dummy head and tail.");
		
		DoublyLinkedListDummy list1 = new DoublyLinkedListDummy();
		DoublyLinkedListDummy list2 = new DoublyLinkedListDummy();
		
		System.out.println("list1:\n" + list1 + "\n");
		System.out.println("list2:\n" + list2 + "\n");
		
		printTestEnd(1);

		
		
		// Test 2: Populate list1 with values from 1 to 10 twice, and list2 with multiples of 5 once.
		printTestHeader( 2, "Populate list1 with values from 1 to 10 twice, and list2 with multiples of 5 once.");
		for ( int i = 0; i < 10; i++ ) {
			list1.addEnd( i + 1 );
			list2.addEnd( i * 5 );
		}
		for ( int i = 0; i < 10; i++ )
			list1.addEnd( i + 1 );
		
		printTestEnd(2);
		
		
		
		// Test 3: Count occurrence of 2's, 11's, and 15's in list1.
		printTestHeader( 3, "Count occurrence of 2's, 11's, and 15's in list1.");
		
		System.out.println("Number of 2's: " + list1.countOccurrence(2) );
		System.out.println("Number of 11's: " + list1.countOccurrence(11) );
		System.out.println("Number of 15's: " + list1.countOccurrence(15) );

		printTestEnd(3);
		
		
		
		// Test 4: Remove all instances of 2 in list1.
		printTestHeader( 4, "Remove all instances of 2 in list1.");
		
		System.out.println("list1 before removal:\n" + list1 + "\n");
		list1.removeAll(2);
		System.out.println("list1 after all 2's removed:\n" + list1 + "\n");
		
		printTestEnd(4);
		
		
		
		// Test 5: Truncate list1 at position 3.
		printTestHeader( 5, "Truncate list1 at position 3.");
		
		System.out.println("list1 before truncation:\n" + list1 + "\n");
		System.out.println("list1 truncated at position 3 (original not modified):\n" + list1.truncate(3) + "\n");
		
		printTestEnd(5);
		
		
		
		// Test 6: list1 will absorb list2.
		printTestHeader( 6, "list1 will absorb list2.");
		
		System.out.println("list1 before absorption:\n" + list1 + "\n");
		System.out.println("list2 before absorption:\n" + list2 + "\n");
		
		list1.absorb( list2 );
		System.out.println("list1 has now absorbed list2.\n");

		System.out.println("list1 after absorption:\n" + list1 + "\n");
		System.out.println("list2 after absorption:\n" + list2 + "\n");
		
		printTestEnd(6);
		
		
		
		// Test 7: Remove the first element of list1.
		printTestHeader( 7, "Remove the first element of list1.");
		
		System.out.println("list1 before first element is removed:\n" + list1 + "\n");
		
		list1.removeFromHead();
		
		System.out.println("list1 after first element is removed:\n" + list1 + "\n");
		
		printTestEnd(7);
		
	}

}
