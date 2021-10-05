// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 4
// 09/21/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 4
// Modified:   09/21/2021
// Purpose:    To disprove a given theorem by attempting to find a counter-
//             example, implementing two helper functions to evaluate the expression
//             with 1000 values of x from 1 to 1000. With the help of a function to build
//             an array of perfect squares, and a function to determine whether or not a
//             number is prime, the following theorem will be evaluated:
//             
//             - "For every even number n in the domain, n^2 - n + 17 is prime."
//             - "The product of any four consecutive numbers in the domain is one less than a perfect square."

import java.util.Arrays;

public class InLab4 {
    
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
        
        // rule out -1 through 1 as a prime
        if ( value <= 1 && value >= -1 ) return false;
        
        // test divisibility by each factor up to the delimiter
        double delimiter = Math.sqrt( ( value > 0 ) ? ( value ) : ( -value ) );
        
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
        
        // let the domain be all positive integers <= 1000
        int n = 1;
        int[] perfectSquares = new int[ 100 ];
        buildSquareArray( perfectSquares );
        boolean statementHolds = true;
        
        // Statement 1: for every number n in the domain, n^2 - n + 17 is prime
        while ( n <= 1000 && statementHolds ) {
            if ( !isPrime(
                (int)Math.pow( n, 2 ) - n + 17
            )) statementHolds = false;
            
            n++;
        } // end statement 1 while loop
        
        // display results for statement 1
        System.out.println("Statement 1: \"For every even number n in the domain, n^2 - n + 17 is prime.\"");
        if ( statementHolds )
            System.out.println("For Statement 1, the statement holds true for every value of n in the domain of 1 to 1000.");
        else
            System.out.println("For Statement 1, the statement does NOT hold, and a counter-example exists at n = " + n );
        System.out.println();
        
        // Statement 2: The product of any four consecutive numbers in the domain is one less than a perfect square.
        n = 1;
        statementHolds = true;
        while ( n <= ( 1000 - 3 ) && statementHolds ) {
            // stop at ( n == 997 ) so that it does not overflow, resulting in 997 998 999 1000
            int product = ( n ) * ( n + 1 ) * ( n + 2 ) * ( n + 3 );
            int searchResult = Arrays.binarySearch( perfectSquares, product + 1 );
            
            // if binarySearch >= 0 it was found
            if ( searchResult < 0 )
                statementHolds = false;
            else
                n++;
            
        } // end statement 2 while loop
        
        // display results for statement 2
        System.out.println("Statement 2: The product of any four consecutive numbers in the domain is one less than a perfect square.");
        if ( statementHolds )
            System.out.println("\tFor Statement 2, the statement holds true for every value of n in the domain of 1 to 1000.");
        else
            System.out.printf("\tFor Statement 2, the statement does NOT hold, and a counter-example exists at the the consecutive group " +
                "%d, %d, %d, %d.%n",
                n,
                n + 1,
                n + 2,
                n + 3 );
        
    } // end main
} // end class