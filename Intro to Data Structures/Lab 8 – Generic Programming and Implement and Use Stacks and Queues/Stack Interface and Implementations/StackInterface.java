/**
 * Generic Stack interface
 * @author Robert Vargas
 *
 * @param <E> Generic data type
 */
public interface StackInterface<E> {
	
	public void push( E data );
	public E pop();
	public E top();
	public int size();
	public boolean isEmpty();
	
}
