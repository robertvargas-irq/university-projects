
public class LinkedQueue<E> implements QueueInterface<E> {

	SNode<E> front;
	SNode<E> rear;
	int elements;
	
	public LinkedQueue() {
		this.front = null;
		this.rear = null;
		elements = 0;
	}
	
	@Override
	public void enqueue(E data) {
		
		// if empty, set front and rear to new data
		if ( this.front == null ) {
			this.front = new SNode<E>( data, null );
			this.rear = this.front;
		}
		// if not empty, add to rear
		else {
			this.rear.setLink( new SNode<E>( data, null ) );
			this.rear = this.rear.getLink();
			
		}
		
	}

	@Override
	public E dequeue() {
		
		// if empty do nothing
		if ( this.front == null )
			return null;
		
		E dequeuedData = this.front.getData();
		
		// if front and rear equal, set both to null
		if ( this.front == this.rear ) {
			this.front = null;
			this.rear = null;
		}
		// if more than one, dequeue front
		else {
			this.front = this.front.getLink();
		}
		
		return dequeuedData;
		
	}

	@Override
	public E front() {
		
		return this.front.getData();
		
	}

	@Override
	public int size() {
		
		int count = 0;
		
		// if empty return 0
		if ( this.front == null )
			return 0;
		// if front and rear are the same, return 1
		else if ( this.front == this.rear )
			return 1;
		// else count
		else
			for ( SNode<E> current = this.front; current != null; current = current.getLink() )
				count++;
		
		return count;
	}

	@Override
	public boolean isEmpty() {
		
		if ( this.front == null )
			return true;
		
		return false;
	}
	
	/**
	 * For debugging purposes only.
	 * Produces a human-readable string with all the elements from front to back.
	 */
	public String toString() {
		
		if ( this.front == null )
			return "";
		
		String s = "";
		
		for ( SNode<E> current = this.front; current != null; current = current.getLink() )
			s += current.getData() + " ";
		
		return s;
		
	}
	
}
