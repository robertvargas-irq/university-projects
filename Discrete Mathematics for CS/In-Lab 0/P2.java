// Robert Vargas
// CS 278 M1A Tuesday
// Lab 0
// 08/24/2021

import java.util.Scanner;

class P2 {
    public static void main( String args[] ) {
        
        Scanner scan = new Scanner( System.in );
        int arraySize;
        int numCount;
        
        // prompt user for array size
        System.out.println("Please enter a size for the randomly-generated integer array.");
        System.out.print("> ");
        arraySize = scan.nextInt();
        int integerArray[] = new int[arraySize];
        System.out.println();
        
        // populate array with random numbers between -1000 and 1000
        int populateMin = -1000;
        int populateMax = 1000;
        for ( int i = 0; i < integerArray.length; i++ )
            integerArray[i] = ( int )( Math.random() * ( populateMax - populateMin + 1 ) + populateMin );
            
        // print even numbers, 10 per line, field size of 6
        numCount = 0;
        System.out.println("EVEN numbers in integerArray[]");
        System.out.println("==============================");
        for ( int i : integerArray ) {
            if ( i % 2 == 0 ) {
                System.out.printf("%6d", i);
                numCount++;
                if ( numCount % 10 == 0 )
                    System.out.println();
            } // end if
        } // end even print
        System.out.println("\n");
        
        // print odd numbers, 10 per line, field size of 6
        numCount = 0;
        System.out.println("ODD numbers in integerArray[]");
        System.out.println("=============================");
        for ( int i : integerArray ) {
            if ( i % 2 != 0 ) {
                System.out.printf("%6d", i);
                numCount++;
                if ( numCount % 10 == 0 )
                    System.out.println();
            } // end if
        } // end odd print
        System.out.println("\n");
        
    } // end main
} // end class