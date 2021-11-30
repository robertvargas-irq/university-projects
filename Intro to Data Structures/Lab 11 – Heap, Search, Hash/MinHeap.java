import java.util.*;
public class MinHeap {
    
    private List<Integer> data;

    public MinHeap() {
        this.data = new ArrayList<Integer>();
    }

    public MinHeap( int firstData ) {
        this.data = new ArrayList<Integer>();
        this.data.add( firstData );
    }

    public List<Integer> getData() {
        return this.data;
    }

    public void reheapUpward( int pos ) {

        // base case
        if ( pos <= 0 )
            return;
        
        // recursive step
        int parentPos = (int)Math.floor( ( pos - 1 ) / 2.0 );
        if ( this.data.get( pos ) < this.data.get( parentPos ) ) {
            Collections.swap( this.data, pos, parentPos );
            reheapUpward( parentPos );
            return;
        }

        return;

    }

    public void reheapDownward( int pos ) {

        // variables
        int current = this.data.get( pos );
        int leftChildIndex = 2 * pos + 1;
        int rightChildIndex = 2 * pos + 2;

        // base case 1
        if ( leftChildIndex >= this.data.size() && rightChildIndex >= this.data.size() )
            return;
        
        if ( leftChildIndex >= this.data.size() ) {
            if ( this.data.get( rightChildIndex ) < current ) {
                Collections.swap( this.data, pos, rightChildIndex );
                reheapDownward( rightChildIndex );
            }
            return;
        }
        else if ( rightChildIndex >= this.data.size() ) {
            if ( this.data.get( leftChildIndex ) < current ) {
                Collections.swap( this.data, pos, leftChildIndex );
                reheapDownward( leftChildIndex );
            }
            return;
        }

        
        int leftChild = this.data.get( leftChildIndex );
        int rightChild = this.data.get( rightChildIndex );

        // base case 2
        if ( current <= leftChild && current <= rightChild )
            return;

        // begin reheapification

        // if out-of-place is greater than both children, find greater
        if ( current > leftChild && current > rightChild ) {

            // if the left is less than right go left
            if ( leftChild < rightChild ) {
                Collections.swap( this.data, pos, leftChildIndex );
                reheapDownward( leftChildIndex );
            }
            // if the right is less than left go right
            else {
                Collections.swap( this.data, pos, rightChildIndex );
                reheapDownward( rightChildIndex );
            }
            
            return;

        }
        // if out-of-place is greater than one child only, go to the lesser one
        else {
            
            // if left is less than current go left
            if ( current > leftChild ) {
                Collections.swap( this.data, pos, leftChildIndex );
                reheapDownward( leftChildIndex );
            }
            // if right is greater than current go right
            else {
                Collections.swap( this.data, pos, rightChildIndex );
                reheapDownward( rightChildIndex );
            }

            return;
            
        }

    }

    public void add( int e ) {

        // add then reheap upward
        this.data.add( e );
        this.reheapUpward( this.data.size() - 1 );

    }

    public int remove() {

        // error checks
        if ( this.data.size() < 1 )
            return -1;
        
        // remove top
        int topData = this.data.get(0);
        int lastIndex = this.data.size() - 1;
        this.data.set( 0, this.data.get( lastIndex ) );
        this.data.remove( lastIndex );
        
        // reheap if more than one element is remaining
        if ( this.data.size() > 1 )
            this.reheapDownward( 0 );

        return topData;

    }

    public int top() {

        if ( this.data.size() < 1 )
            return -1;
        
        return this.data.get(0);

    }

    public static void main( String[] args ) {
        
        MinHeap heap = new MinHeap();

        Scanner scan = new Scanner( System.in );
        System.out.println("Input your desired elements line-by-line. Input -1 to stop and begin removing.");

        int nextInt = 0;
        while ( nextInt != -1 ) {

            nextInt = scan.nextInt();

            if ( nextInt == -1 ) break;
            heap.add( nextInt );
            System.out.printf("Top: %3d %s%n", heap.top(), heap.getData() );

        }
        System.out.println("= = = = = =\nDone! All your data has been recorded, beginning removal...\n\n");

        // while not empty remove and print
        ArrayList<Integer> heapSortedArray = new ArrayList<Integer>();
        while ( heap.getData().size() > 0 ) {
            int topValue = heap.remove();
            heapSortedArray.add( topValue );
            System.out.println("Removed top! Value: " + topValue );
            System.out.println( heap.getData() );
            System.out.println();
        }

        System.out.println("Heap-sorted ascending: " + heapSortedArray );
        System.out.println("Done!");

        scan.close();


    }

}
