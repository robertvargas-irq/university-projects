// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 6
// Modified:   10/04/2021 | Re-did the program code to implement a mask boolean array.
// Purpose:    This program implements methods to print Sets, and uses a while loop to
//             verify a subset, find the difference of two sets, and find the intersect
//             of two sets. This program takes input from a file named
//             "MyData.txt" which is read in from a Scanner, each Set
//             declared by an integer, followed by that many lines of Strings
//             that belong to the Set.
//
//             This program takes input to populate Set A and Set B as long as there
//             is more data to be inputted, and repeats this process and evaluates the
//             following Set calculations as long as there are more Sets in the file:
//
//             > B is a subset of A
//             > A - B
//             > A intersect B

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class PA6 {
    
    
    // Formats a String array into Set notation, only printing true values
    //            corresponding to the mask.
    // parameter set: Set to format into a String.
    // parameter mask: The mask to apply over the set, only printing
    //                 the corresponding true values.
    // returns string: String array formatted in Set notation, only displaying
    //                 values based on the mask.
    public static void printSubset( String[] set, boolean[] mask ) {
        
        String setString = "{ ";
        for ( int i = 0; i < set.length; i++ )
            if ( mask[i] )
                setString += set[i] + ", ";
        
        // trim off excess commas and close with a curly brace
        if ( setString.length() > 2 )
            setString = setString.substring( 0, setString.length() - 2 );
        setString += " }";
        
        System.out.println( setString );
        
    } // end printSubset()
    
    
    
    public static void main( String[] args ) throws IOException {
        
        // populate Set A and Set B from file
        Scanner fileScan = new Scanner( new File("myData.txt") );
        
        // repeat as long as there are more sets (declared by integer values)
        while ( fileScan.hasNextInt() ) {
            
            // get size of Set A from line, and clear newline buffer (if any)
            String[] setA = new String[ fileScan.nextInt() ];
            boolean[] setAMask = new boolean[ setA.length ];
            if ( fileScan.hasNextLine() ) fileScan.nextLine();
            
            // populate A with each subsequent line, set all booleans to true, then print
            for ( int i = 0; i < setA.length; i++ ) {
                setA[i] = fileScan.nextLine();
                setAMask[i] = true;
            }
            Arrays.sort( setA );
            System.out.print("Set A: ");
            printSubset( setA, setAMask );
            
            
            
            // get the size of Set B from line, and clear newline buffer (if any)
            String[] setB = new String[ fileScan.nextInt() ];
            boolean[] setBMask = new boolean[ setB.length ];
            if ( fileScan.hasNextLine() ) fileScan.nextLine();
            
            // populate B with each subsequent line, set all booleans to true, then print
            for ( int i = 0; i < setB.length; i++ ) {
                setB[i] = fileScan.nextLine();
                setBMask[i] = true;
            }
            Arrays.sort( setB );
            System.out.print("Set B: ");
            printSubset( setB, setBMask );
            System.out.println();
            
            
            
            // evaluate B subset A
            boolean bIsSubset = true;
            for ( int i = 0; i < setB.length && bIsSubset; i++ )
                if ( Arrays.binarySearch( setA, setB[i] ) < 0 )
                    bIsSubset = false;
                
            if ( bIsSubset )
                System.out.println("B is a subset of A");
            else
                System.out.println("B is not a subset of A");
            
            // evaluate A - B
            for ( int i = 0; i < setA.length; i++ )
                if ( Arrays.binarySearch( setB, setA[i] ) >= 0 )
                    setAMask[i] = false;
            
            System.out.print("A - B: ");
            printSubset( setA, setAMask );
            
            // evaluate A intersect B: set setAMask[] all to false, only flip true when found
            for ( int i = 0; i < setAMask.length; i++ )
                setAMask[i] = false;
            
            for ( int i = 0; i < setA.length; i++ )
                if ( Arrays.binarySearch( setB, setA[i] ) >= 0 )
                    setAMask[i] = true;
            
            System.out.print("A \u2229 B: ");
            printSubset( setA, setAMask );
            
            
            
            System.out.println("\n\n========\n\n");
            
        } // end while
        
        
    } // end main
} // end class