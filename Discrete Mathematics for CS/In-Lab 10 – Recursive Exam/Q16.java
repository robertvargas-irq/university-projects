// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 10
// 11/09/2021
// Exam Color: YELLOW

import java.util.Scanner;

public class Q16 {
    
    public static void main( String[] args ) {
        
        System.out.println("Input a, r, and n terms for SUM( a * r^k ) from k=0 to k=(n-1)");
        
        // get user input
        Scanner scan = new Scanner( System.in );
        int a = scan.nextInt();
        int r = scan.nextInt();
        int n = scan.nextInt();
        
        // calculate the value at each term and print
        int power = 1;
        for ( int k = 0; k < n; k++ ) {
            
            System.out.print( a * power );
            if ( k < ( n - 1 ) )
                System.out.print(", ");
            
            power = power * r;
            
        } // end for loop
        
        System.out.println();
        
    } // end main
    
} // end class