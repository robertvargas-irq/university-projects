/**
 * Implements IntNodes for a linked list.
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
	
}
