/**
 * Generic Queue interface
 * @author Robert Vargas
 *
 */
public interface QueueInterface<E> {
	
	public void enqueue( E data );
	public E dequeue();
	public E front();
	public int size();
	public boolean isEmpty();
	
}
