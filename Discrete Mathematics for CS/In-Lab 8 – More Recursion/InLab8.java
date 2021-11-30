// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 8
// 10/26/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 8
// Modified:   10/26/2021
// Purpose:    This program implements recursive methods to print a
//             pyramid in the console, solve a given summation, and
//             reverse a word character-by-character.

public class InLab8 {
    
    // recursively print a pyramid of numbers with given start and end
    public static void pyramidUp( int start, int end, int spaces ) {
        
        // error cases
        if ( ( end - start ) % 2 != 0 ) {
            System.out.println("Error: Start and End must be of the same parity.");
            return;
        }
        if ( start < 1 || end < 1 ) {
            System.out.println("Error: Start and End must be positive ( x > 0 ).");
            return;
        }
        
        // base case
        if ( start == end ) {
            for ( int i = 0; i < spaces; i++ )
                System.out.print(" ");
            System.out.println( start );
            return;
        }
        
        // recursive step
        pyramidUp( start + 1, end - 1, spaces + 3 );
        for ( int i = 0; i < spaces; i++ )
            System.out.print(" ");
        
        for ( int i = start; i <= end; i++ )
            System.out.print( i + "  " );
        System.out.println();
        
    } // end pyramidUp()
    
    // recursively solve: sum( 1 / (2x-1)(2x+1) ) from x=1 to n
    public static double fractionSum( int k ) {
        
        // base case / error case
        if ( k < 1 )
            return 0;
        
        // recursive step
        return fractionSum( k - 1 ) + ( 1.0 / ( ( 2 * k - 1 ) * ( 2 * k + 1 ) ) );
        
    } // end fractionSum()
    
    // recursively reverse a string character by character
    public static String reverse( String s, int a, int b ) {
        
        // error case
        if ( a < 0 || a >= s.length()
            || b < 0 || b >= s.length()
            || b < a )
            return "";
        
        // base case
        if ( ( b - a + 1 ) < 2 )
            return s.substring( a, b + 1 );
        
        // recursive step
        int middle = -1;
                
        // if odd substring
        if ( ( b - a ) % 2 != 0 ) {
            middle = ( a + b ) / 2;
            return reverse( s, middle + 1, b ) + s.charAt( middle ) + reverse( s, a, middle - 1 );
        }
        // if even substring
        else {
            middle = ( a + b ) / 2;
            return reverse( s, middle + 1, b ) + reverse( s, a, middle );
        }
    } // end reverse()
    
    public static void main( String[] args ) {
        
        // Test pyramidUp() with 2 valid inputs and 1 with an error.
        pyramidUp( 1, 9, 0 );
        System.out.println();
        
        pyramidUp( 2, 8, 0 );
        System.out.println();
        
        pyramidUp( 3, 8, 0 );
        System.out.println();
        
        // Test fractionSum() with given terms
        System.out.println("With 1 term  = " + fractionSum(1) );
        System.out.println("With 2 terms = " + fractionSum(2) );
        System.out.println("With 3 terms = " + fractionSum(3) );
        System.out.println("With 4 terms = " + fractionSum(4) );
        System.out.println();
        
        // Test reverse() with given words
        String[] reverseTests = { "boy", "clock", "xo", "book", "Hello There World", "Hello There Worlds" };
        for ( String test : reverseTests )
            System.out.println("The reverse of " + test + " = " + reverse( test, 0, test.length() - 1 ) + ".");

        
    } // end main
    
} // end class