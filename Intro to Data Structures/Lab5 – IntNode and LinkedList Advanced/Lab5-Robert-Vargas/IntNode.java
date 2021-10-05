
/**
 * Implements IntNodes for a linked list along with advanced operations.
 * @author Robert Vargas
 *
 */
public class IntNode {
	
	private int value;
	private IntNode link;
	
	/**
	 * Default constructor for IntNode, setting the value to 0 and link to null.
	 */
	public IntNode() {
		
		this.value = 0;
		this.link = null;
		
	}
	
	/**
	 * IntNode constructor with specific data.
	 * @param _data The data to set to this new instance.
	 * @param _node The link to give to this new instance.
	 */
	public IntNode( int _data, IntNode _node ) {
		
		this.value = _data;
		this.link = _node;
		
	}
	
	/**
	 * Get the current IntNode's value.
	 * @return Current IntNode value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets a new value to the current IntNode.
	 * @param v The new value to set to the current IntNode.
	 */
	public void setValue( int v ) {
		value = v;
	}
	
	/**
	 * Get the current IntNode's linked IntNode pointer.
	 * @return Current IntNode's linked IntNode pointer.
	 */
	public IntNode getLink() {
		return link;
	}
	
	/**
	 * Sets a new IntNode pointer link to the current IntNode
	 * @param l The new IntNode object pointer
	 */
	public void setLink( IntNode l ) {
		link = l;
	}
	
	/**
	 * Adds a new node to the list immediately after the current node
	 * @param newData The data to set to this new IntNode
	 */
	public void addNodeAfterThis( int newData ) {
		
		IntNode oldLink = this.getLink();
		IntNode newNode = new IntNode( newData, oldLink );
		
		// link new node to current node
		this.setLink( newNode );
		
	}
	
	/**
	 * Removes the node immediately following the current IntNode
	 */
	public void removeNodeAfterThis() {
		
		// if a valid link is available, set to next link, else do nothing
		if ( this.getLink() != null )
			this.setLink( this.getLink().getLink() );
		
	}
	
	/**
	 * Count the number of nodes in the list starting from a given node head
	 * @param head The starting node head.
	 * @return The amount of nodes in the list from the given node head.
	 */
	public static int listLength( IntNode head ) {
		
		IntNode current = head;
		int count = 1;
		while ( (current = current.getLink()) != null )
			count++;
		
		return count;
		
	}
	
	/**
	 * Search the linked list starting from a given head for given data.
	 * @param head The starting IntNode head to start the search
	 * @param data The data that is being searched for
	 * @precondition The head is not null.
	 * @return True if value is found | False if not
	 */
	public static boolean search( IntNode head, int data ) {
		
		IntNode current = head;
		boolean found = false;
		
		// search until null or data is found
		while ( !found && current != null ) {
			if ( current.getValue() == data )
				found = true;
			current = current.getLink();
		}
		
		return found;
		
	}
	
	/**
	 * Finds the mth number away from the end, and returns it.
	 * @param header The starting node header
	 * @param m Which number from the end node to find.
	 * @return The mth number from the last node.
	 */
	public IntNode findMthToLast( IntNode header, int m ) {
		
		IntNode current = header;
		IntNode behind = header;
		
		// get the IntNode m, returning null if list is not long enough
		for ( int i = 0; i < m; i++ )
			if ( current.getLink() != null )
				current = current.getLink();
			else
				return null;
		
		// move both pointers up until the current reaches the end
		while ( current.getLink() != null ) {
			current = current.getLink();
			behind = behind.getLink();
		}
		
		return behind;
		
	}

	/**
	 * Converts the list from the current node, connected with arrows to the end
	 * @return Human-readable string
	 */
	public String toString() {
		
		IntNode current = this;
		String output = "" + current.getValue();
		while ( (current = current.getLink()) != null )
			output += "->" + current.getValue();
		
		return output;
		
	}
	
	/**
	 * Cycle through the linked list to see if it is cyclid.
	 * @param head The starting IntNode to search from.
	 * @precondition The head cannot be null.
	 * @return True if cyclical | False if null is found at the end
	 */
	public static boolean hasCycle( IntNode head ) {
		
		// ensure head is not null as by predicate
		if ( head == null )
			return false;
		
		IntNode current = head;
		
		// cycle through until null or if ( head object == current object )
		while ( ( current = current.getLink() ) != null )
			if ( current == head )
				return true;
		
		return false;
		
	}
	
	/**
	 * Changes a given node value at index i
	 * @precondition Head must not be null.
	 * @param head The starting IntNode.
	 * @param i The index of the IntNode that is to be given the new value.
	 * @param newValue The new value for IntNode at index i.
	 */
	public static void changeElement( IntNode head, int i, int newValue ) {
		
		// check if null
		if ( head == null )
			return;
		
		// special case if index is head
		if ( i == 0 )
			head.setValue( newValue );
		
		// cycle through the linked list until index is reached or null is reached
		IntNode current = head;
		int currentIndex = 1;
		while ( ( current = current.getLink() ) != null && currentIndex <= i ) {
			if ( currentIndex == i )
				current.setValue(newValue);
			currentIndex++;
		}
		
	}

	/**
	 * Separate evens and odds in a linked list, while preserving order, evens first then odds
	 * @param head The IntNode to start ordering from.
	 */
	public static void segregate_even_odd( IntNode head ) {
		
		// check to ensure head is not null
		if ( head == null )
			return;
		
		java.util.ArrayList<Integer> odd = new java.util.ArrayList<Integer>();
		java.util.ArrayList<Integer> even = new java.util.ArrayList<Integer>();
		IntNode current = head;
		
		// get head value
		if ( head.getValue() % 2 == 0 )
			even.add( head.getValue() );
		else
			odd.add( head.getValue() );
		
		// cycle through until null, adding number to even or odd respectively.
		while( ( current = current.getLink() ) != null )
			if ( current.getValue() % 2 == 0 )
				even.add( current.getValue() );
			else
				odd.add( current.getValue() );
		
		// if all odd or all even, do not change, return
		if ( odd.size() < 1 || even.size() < 1 ) return;
		
		// set the first value, then populate the new node head
		head.setValue( even.get(0) );
		current = head;
		for ( int i = 0; i < even.size(); i++ ) {
			current.setValue( even.get(i) );
			current = current.getLink();
		}
		
		// add all odd numbers
		for ( int i = 0; i < odd.size(); i++ ) {
			current.setValue( odd.get(i) );
			current = current.getLink();
		}
		
	}
	
	/**
	 * Take a linked list and reverse it, returning a new linked list in reverse
	 * @param head The starting IntNode to begin reversing to the end
	 * @return New IntNode head with a linked list that is in reverse order from the head
	 */
	public static IntNode reverse( IntNode head ) {
		
		// ensure head is not null
		if ( head == null )
			return null;
		
		// create new node with a dummy head called reverse
		IntNode reverse = new IntNode();
		IntNode current = head;
		
		// add first node after dummy to start the backwards adding process, then fill
		while ( current != null ) {
			reverse.addNodeAfterThis( current.getValue() );
			current = current.getLink();
		}
		
		// remove dummy head and return
		reverse = reverse.getLink();
		return reverse;
		
	}
	
	
	/**
	 * Swap the current IntNode with the last IntNode in the list
	 */
	public void swap() {
		
		// if the current is the last link in the node, return
		if ( listLength(this) < 2 )
			return;
		
		// else, find last node and swap
		IntNode lastNode = findMthToLast( this, 0 );
		int currentValue = this.getValue();
		this.setValue( lastNode.getValue() );
		lastNode.setValue( currentValue );
		
	}
	
	/**
	 * Rotate the given IntNode head k amount of times counter-clockwise.
	 * @precondition head must not be null.
	 * @param head The IntNode head to start rotating k times from
	 * @param k How many times to rotate counter-clockwise
	 * @return New IntNode head with the original head IntNode rotated counter-clockwise
	 * k amount of times.
	 */
	public static IntNode rotate( IntNode head, int k ) {
		
		if ( head == null )
			return null;
		if ( IntNode.listLength( head ) <= 1 )
			return new IntNode( head.getValue(), null );
		
		// loop through until index lands at K
		int newStartIndex = 0;
		int listLength = IntNode.listLength( head );
		for ( int index = 1; index < k + 1; index++ ) {
			
			// go back to the beginning of the loop if list length is reached
			if ( newStartIndex == listLength - 1 )
				newStartIndex = 0;
			else
				newStartIndex++;
			
		}
		
		// store values before K to add at the end of the list
		IntNode originalCurrent = head;
		int[] valuesBeforeK = new int[ newStartIndex ];
		for ( int i = 0; i < newStartIndex; i++ ) {
			valuesBeforeK[i] = originalCurrent.getValue();
			originalCurrent = originalCurrent.getLink();
		}
		
		// create a dummy head for rotatedHead and a current cursor for rotatedHead
		IntNode rotatedHead = new IntNode();
		IntNode rotatedHeadCurrent = rotatedHead;
		
		// shift current to the final node and add values to rotatedHead
		while ( originalCurrent != null ) {
			rotatedHeadCurrent.addNodeAfterThis( originalCurrent.getValue() );
			rotatedHeadCurrent = rotatedHeadCurrent.getLink();
			originalCurrent = originalCurrent.getLink();
		}
		
		// append valuesBeforeK[] at the end of the list; these values are from the beginning
		for ( int i = 0; i < valuesBeforeK.length; i++ ) {
			rotatedHeadCurrent.addNodeAfterThis( valuesBeforeK[i] );
			rotatedHeadCurrent = rotatedHeadCurrent.getLink();
		}
		
		
		// remove dummy head and return the new rotatedHead linked list
		rotatedHead = rotatedHead.getLink();
		return rotatedHead;
			
		
	}
	
	
}
