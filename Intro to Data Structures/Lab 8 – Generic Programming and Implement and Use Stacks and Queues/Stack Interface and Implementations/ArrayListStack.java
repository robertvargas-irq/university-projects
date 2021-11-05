import java.util.ArrayList;

/**
 * Implements StackInterface using an ArrayList
 * @author Robert Vargas
 *
 * @param <E> Generic type
 */
public class ArrayListStack<E> implements StackInterface<E> {

	ArrayList<E> data = new ArrayList<E>();
	
	@Override
	public void push(E data) {
		
		this.data.add( data );
		
	}

	@Override
	public E pop() {
		
		// if empty return null
		if ( this.data.isEmpty() )
			return null;
		
		// return the last element, and remove
		return this.data.remove( this.data.size() - 1 );
		
	}

	@Override
	public E top() {
		
		// if empty, return null
		if ( this.data.isEmpty() )
			return null;
		
		// return the last element
		return this.data.get( this.data.size() - 1 );
		
	}

	@Override
	public int size() {
		
		return this.data.size();
		
	}

	@Override
	public boolean isEmpty() {
		
		return this.data.isEmpty();
		
	}
	
	/**
	 * For debugging purposes only.
	 * Create a human-readable string of the stack contents from bottom to top
	 */
	public String toString() {
		
		// if empty return empty string
		if ( this.data.isEmpty() )
			return "";
		
		String s = "";
		for ( int i = 0; i < this.data.size(); i++ )
			s += this.data.get(i) + " ";
		
		return s;
		
	}

}
