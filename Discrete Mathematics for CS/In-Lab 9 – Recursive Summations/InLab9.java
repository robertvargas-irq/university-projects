// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 9
// 11/02/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 9
// Modified:   11/02/2021
// Purpose:    This program compares the computation time between a recursive
//             summation solution to an iterative solution in nanoseconds.

public class InLab9 {
    
    // sum(i(i+1)) from i=1 to k recursive solution
    public static long sumRecursive( int k ) {
        
        // error case
        if ( k < 1 )
            return 0;
        
        // base case if k == 1
        if ( k == 1 )
            return 2;
        
        // recursive step
        return sumRecursive( k - 1 ) + ( k * ( k + 1 ) );
        
    } // end sumRecursive()
    
    // sum(i(i+1)) from i=1 to k iterative solution
    public static long sumIterative( int k ) {
        
        long sum = 0;
        for ( int i = 1; i <= k; i++ )
            sum = sum + ( i * ( i + 1 ) );
        
        return sum;
        
        
    } // end sumIterative()
    
    public static void main( String[] args ) {
        
        int terms = 10000;
        
        long recursiveStartTime = System.nanoTime();
        long recursiveSolution = sumRecursive( terms );
        long recursiveEndTime = System.nanoTime();
        
        long iterativeStartTime = System.nanoTime();
        long iterativeSolution = sumIterative( terms );
        long iterativeEndTime = System.nanoTime();
        
        System.out.printf("Recursive method:%,16d terms%n", terms);
        System.out.printf("Time:            %,16d nanoseconds%n", recursiveEndTime - recursiveStartTime);
        System.out.printf("Summation:       %,16d%n", recursiveSolution);
        System.out.printf("Iterative method:%,16d terms%n", terms);
        System.out.printf("Time:            %,16d nanoseconds%n", iterativeEndTime - iterativeStartTime);
        System.out.printf("Summation:       %,16d%n", iterativeSolution);
        
    } // end main
} // end class