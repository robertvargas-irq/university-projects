// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 4
// Modified:   09/15/2021
// Purpose:    To disprove a given theorem by attempting to find a counter-
//             example, implementing two helper functions to evaluate the expression
//             with 9996 values of x from 3 to 9999. With the help of a function to build
//             an array of perfect squares, and a function to determine whether or not a
//             number is prime, the following theorem will be evaluated:
//             
//             "Every odd number x, such that x >= 3, can be written as the sum of a prime number and twice a square."

public class PA4 {
    
    // This function populates an array with perfect squares from 0 to the length
    //     of the given array, modifying the original array rather than returning a new one.
    // Parameter array: The array to populate with perfect squares
    // Returns void.
    public static void buildSquareArray( int[] array ) {
        
        // take array reference and populate with squares of array[]
        for ( int i = 0; i < array.length; i++ )
            array[i] = (int)(Math.pow( i, 2 ));        
        
    } // end buildSquareArray()
    
    
    // This function evaluates a given number to see if it is prime
    // Parameter value: The integer to test for prime
    // Return boolean: True if the inputted value is prime | False if not
    public static boolean isPrime( int value ) {
        
        // rule out 1 as a prime
        if ( value == 1 ) return false;
        
        // test divisibility by each factor up to the delimiter
        double delimiter = Math.sqrt(
                           ( value > 0 ) ? ( value ) : ( -value ) );
        
        int factors = 0;
        if ( value > 0 ) {
            
            // test original value against each factor up to the delimiter
            for ( int i = 1; i <= delimiter; i++ )
                if ( value % i == 0 )
                    factors += 2;
            
        }
        else {
            
            // test original negative value divided by positive factors
            for ( int i = 1; i <= delimiter; i++ )
                if ( value % i == 0 )
                    factors += 2;
            
            // test original negative value divided by negative factors
            for ( int i = 1; i <= delimiter; i++ )
                if ( value % -i == 0 )
                    factors += 2;
            
        } // end if-else tree
        
        
                
        // if more than two factors are found, return false, else return true
        if ( factors > 2 )
            return false;
        
        return true;
        
    } // end isPrime()
    
    public static void main( String[] args ) {
        
        // declare variables and flag, and populate perfectSquares[]
        boolean theoremHolds = true;
        int[] perfectSquares = new int[ 100 ];
        buildSquareArray( perfectSquares );
        int x = 2;
        int p, s;
        
        // test up to x = 9999, or until the theorem is disproven
        while ( x <= 9999 && theoremHolds ) {
            
            x++;
            
            // assume theorem does not hold
            theoremHolds = false;
            
            // check each possible combination of x and square up to (1/2) of x
            for ( int square = 0; square <= ( x / 2 ) && !theoremHolds; square++ )
                if ( isPrime(
                    x - ( 2 * perfectSquares[square] )
                )) theoremHolds = true;
            
        } // end while loop
        
        
        
        // state findings
        System.out.println("\nTheorem: \"Every odd number x, such that x >= 3, can be written as the sum of a prime number and twice a square.\"");
        if ( theoremHolds )
            System.out.println("\tNo counter-example was found for the given theorem.");
        else
            System.out.printf("\tA counter-example was found at ( x = %d ) for the above-stated theorem.%n", x );
        
    } // end main
} // end class