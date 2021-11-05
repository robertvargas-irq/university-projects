/**
 * Generic Singly-Linked Node
 * @author Robert Vargas
 *
 * @param <E> Generic type
 */
public class SNode<E> {
	private E data;
	private SNode<E> link;
	
	/**
	 * Default constructor sets data and link to null
	 */
	SNode() {
		this.data = null;
		this.link = null;
	}
	
	/**
	 * Overloaded constructor with the ability to instantiate data and link
	 * @param d The data to store in this node
	 * @param l The node to link to
	 */
	SNode( E d, SNode<E> l ) {
		this.data = d;
		this.link = l;
	}
	
	/**
	 * Get the data contained in this node
	 * @return The data contained in this node
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Set new data to the current node
	 * @param d The new data to set
	 */
	public void setData( E d ) {
		this.data = d;
	}
	
	/**
	 * Get the link of the current node
	 * @return The linked node
	 */
	public SNode<E> getLink() {
		return this.link;
	}
	
	/**
	 * Set link to new node
	 * @param l New link
	 */
	public void setLink( SNode<E> l ) {
		this.link = l;
	}
	
	public void addNodeAfterThis( E data ) {
		this.link = new SNode<E>( data, null );
	}
}
