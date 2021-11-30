// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 8
// Modified:   11/01/2021 - Added error cases and updated base cases.
// Purpose:    This program recursively solves the following two sums:
//             - sum( 2i ) from i=0 to k
//             - sum( i ( i + 1 ) ) from i=1 to k

import java.util.Scanner;

public class PA8 {
    
    // sum(2i) from i=0 to k
    public static int sum1( int k ) {
        
        // error case
        if ( k < 0 ) {
            System.out.println("ERROR: k cannot be less than 0. The summation sum1 begins at i=0\n");
            return -1;
        }
        
        // base case if k == 0
        if ( k == 0 )
            return 0;
        
        // recursive step
        return sum1( k - 1 ) + 2 * k;
        
    } // end sum1()
    
    // sum(i(i+1)) from i=1 to k
    public static int sum2( int k ) {
        
        // error case
        if ( k < 1 ) {
            System.out.println("ERROR: k cannot be less than 1. The summation sum2 begins at i=1\n");
            return -1;
        }
        // base case if k == 1
        if ( k == 1 )
            return 2;
        
        // recursive step
        return sum2( k - 1 ) + ( k * ( k + 1 ) );
        
    } // end sum2()
    
    
    
    public static void main( String[] args ) {
        
        Scanner scan = new Scanner( System.in );
        int userInput;
        
        // prompt user input
        System.out.print("Please enter the value of k: ");
        userInput = scan.nextInt();
        System.out.println();
        
        // display results
        System.out.println("The value of the 1st summation is " + sum1( userInput ) + ".\n");
        System.out.println("The value of the 2nd summation is " + sum2( userInput ) + ".");
        
    } // end main
    
} // end class