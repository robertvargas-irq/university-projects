import java.util.*;

public class search {
    
    /**
     * Perform binary search for a given array of integers.
     * @param A The array to search.
     * @param e The key to be found.
     * @return Index of found element | -1 if not found.
     */
    public static int binarySearch( int[] A, int e ) {

        int start = 0;
        int end = A.length - 1;
        int middle = A.length / 2 + 1;

        while( start >= 0 && end < A.length ) {

            // if e is found, return index
            if ( e == A[middle] )
                return middle;
            
            // if start and end are equal, then that means it was not found
            if ( start == end )
                return -1;
            

            
            // if e < current data, go left
            if ( e < A[middle] ) {

                end = middle;
                middle = ( start + middle ) / 2;

            }
            // if e > current data, go right
            else {

                start = middle + 1;
                middle = ( middle + end ) / 2 + 1;

            }

        }

        return -1;

    }
    
    /**
     * Overloaded binarySearch to search a List of integers.
     * @param A The array to search.
     * @param e The key to be found.
     * @return Index of found element | -1 if not found.
     */
    public static int binarySearch( List<Integer> A, int e ) {

        int start = 0;
        int end = A.size() - 1;
        int middle = A.size() / 2 + 1;

        while( start >= 0 && end < A.size() ) {

            // if e is found, return index
            if ( e == A.get(middle) )
                return middle;
            
            // if start and end are equal, then that means it was not found
            if ( start == end )
                return -1;
            

            
            // if e < current data, go left
            if ( e < A.get(middle) ) {

                end = middle;
                middle = ( start + middle ) / 2;

            }
            // if e > current data, go right
            else {

                start = middle + 1;
                middle = ( middle + end ) / 2 + 1;

            }

        }

        return -1;

    }

    /**
     * Find the K nearest numbers of a given target in an array of integers
     * @param A The ArrayList of integers.
     * @param k The amount of closest numbers wanted.
     * @param target The target number to search around.
     * @return List of the K nearest to a given target.
     * @complexity
     * O(n) as the loop goes through the entire array in both directions once by utilizing an
     * offset value to expand outward from the given target.
     */
    public static ArrayList<Integer> findKNearest( ArrayList<Integer> A, int k, int target ) {

        ArrayList<Integer> closest = new ArrayList<Integer>();
        if ( A.size() <= k ) return new ArrayList<Integer>( A );

        int leftPointer = binarySearch( A, target );
        int rightPointer = leftPointer;
        int offset = 0;
        
        // while closest answers are less than k requested
        while ( closest.size() < k ) {
            
            // begin searching left and right
            leftPointer = binarySearch( A, target - offset );
            rightPointer = binarySearch( A, target + offset );
            
            // if found, add to array
            if ( leftPointer >= 0 ) closest.add( 0, A.get( leftPointer ) );
            if ( rightPointer >= 0 && closest.size() < k ) closest.add( A.get( rightPointer ) );

            offset++;

            System.out.println( closest );

        }

        return closest;

    }

    public static void main( String[] args ) {

        //
        // Testing for findKNearest()
        //

        int[] test1 = { 11, 13, 14, 17, 20, 23, 27 };
        int[] test2 = { 12, 13, 14, 15, 16, 17 };
        int[] test3 = { 12, 13, 14, 15, 16, 17 };
        int[] test4 = { 12, 13, 14, 15 };

        int[] test1Input = { 4, 15 };
        int[] test2Input = { 3, 11 };
        int[] test3Input = { 2, 18 };
        int[] test4Input = { 4, 18 };

        int[][] testArrays = { test1, test2, test3, test4 };
        int[][] testInput = { test1Input, test2Input, test3Input, test4Input };

        // test each test input
        for ( int i = 0; i < testArrays.length; i++ ) {
            
            ArrayList<Integer> input = new ArrayList<Integer>();
            for ( int val : testArrays[i] )
                input.add( val );
            

            // print results
            System.out.printf("Input: %s, k = %2d, target = %2d%n", input, testInput[i][0], testInput[i][1] );
            System.out.println("Output: " + findKNearest( input, testInput[i][0], testInput[i][1] ) );
            System.out.println("\n\n");

        }


        //
        // Testing for binarySearch
        //

        // populate array with random numbers from 20 to 50.
        int[] array = new int[10];
        HashSet<Integer> uniqueValues = new HashSet<Integer>();
        for ( int i = 0; i < array.length; i++ ) {
            
            int randomNum = (int)( Math.random() * ( 50 - 20 + 1 ) + 20 );
            while ( uniqueValues.contains( randomNum ) )
                randomNum = (int)( Math.random() * ( 50 - 20 + 1 ) + 20 );
            
            array[i] = randomNum;
            uniqueValues.add( randomNum );
        }
        Arrays.sort( array );
        
        // begin user input to test against array
        System.out.println("Please input keys to search against the following array. Input -1 when done.");
        System.out.println( Arrays.toString( array ) + "\n" );
        
        int desired = 0;
        Scanner scan = new Scanner( System.in );
        System.out.print("Search term: ");
        while ( ( desired = scan.nextInt() ) != -1 )
            System.out.print("Found index: " + binarySearch( array, desired ) + "\n\nSearch term: ");
        System.out.println("Done!");

        scan.close();

    }

}
