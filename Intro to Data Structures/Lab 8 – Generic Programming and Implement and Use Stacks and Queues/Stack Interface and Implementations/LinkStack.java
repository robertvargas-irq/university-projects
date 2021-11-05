/**
 * Implements StackInterface using a SinglyLinkedList
 * @author Robert Vargas
 *
 * @param <E> Generic data type
 */
public class LinkStack<E> implements StackInterface<E> {
	
	private SNode<E> top;
	
	@Override
	public void push( E data ) {
		
		// add new node to the stack
		this.top = new SNode<E>( data, this.top );
		
	}

	@Override
	public E pop() {
		
		// check for empty list
		if ( this.top == null )
			return null;
		
		// cache data then set top to the top's link
		E popped = this.top.getData();
		this.top = this.top.getLink();
		
		return popped;
		
	}

	@Override
	public E top() {
		
		// if empty, return null
		if ( this.top == null )
			return null;
		
		return this.top.getData();
		
	}

	@Override
	public int size() {
		
		// if empty, return 0
		if ( this.top == null )
			return 0;
		
		// count nodes until null
		int count = 0;
		for ( SNode<E> current = this.top; current != null; current = current.getLink() )
			count++;
		
		return count;
	}

	@Override
	public boolean isEmpty() {
		
		if ( this.top == null )
			return true;
		
		return false;
		
	}
	
	/**
	 * For debugging purposes only.
	 * Create a human-readable string of the stack contents from bottom to top
	 */
	public String toString() {
		
		if ( this.isEmpty() )
			return "";
		
		String s = "";
		for ( SNode<E> current = this.top; current != null; current = current.getLink() )
			s = current.getData() + " " + s;
		
		return s;
	}
	
	
	
}
