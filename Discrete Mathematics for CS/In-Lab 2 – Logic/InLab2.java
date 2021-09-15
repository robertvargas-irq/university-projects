// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 2
// 09/07/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 2; In-Lab 2
// Modified:   09/07/2021
// Purpose:    To implement logical operations such as and, or,
//             implies, and not, and building a 3-column truth
//             table in order to display and solve any given
//             proposition with custom functions to solve each
//             given logical piece of a proposition.
//             This program evaluates 2 custom propositions:
//             
//             - not( ( p implies q ) and ( q implies r ) )
//             - ( p and not(q) ) or ( q and not(r) )

import java.util.Arrays;

public class InLab2 {
    public static void main( String args[] ) {
        
        String tableRows[] = PA2Methods.buildTableRows();
        char prop1[] = new char[8];
        char prop2[] = new char[8];
        int rowCounter;
        
        //
        // Proposition 1: not( ( p implies q ) and ( q implies r ) )
        //
        
        // evaluate the proposition line-by-line and store in prop1[]
        rowCounter = 0;
        for ( String i : tableRows ) {
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char pImpliesQ = PA2Methods.implies( p, q );
            char qImpliesR = PA2Methods.implies( q, r );
            char andOperation = PA2Methods.and( pImpliesQ, qImpliesR );
            
            // test final truth value and store in prop1[rowCounter]
            prop1[ rowCounter++ ] = PA2Methods.not( andOperation );
            
        } // end proposition 1 for-each loop
        
        
        
        //
        // Proposition 2: ( p and not(q) ) or ( q and not(r) )
        //
                
        // evaluate the proposition line-by-line and store in prop2[]
        rowCounter = 0;
        for ( String i : tableRows ) {
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char pAndNotQ = PA2Methods.and( p, PA2Methods.not(q) );
            char qAndNotR = PA2Methods.and( q, PA2Methods.not(r) );
            
            // test final truth value and store in prop2[rowCounter]
            prop2[ rowCounter++ ] = PA2Methods.or( pAndNotQ, qAndNotR );
            
        } // end proposition 2 for-each loop
        
        
        
        //
        // Build the truth table along with heading with truth values from prop1[] and prop2[]
        //
        
        System.out.println("Truth table for Proposition 1 and Proposition 2");
        System.out.println();
        System.out.println("p  q  r  Proposition 1 Proposition 2");
        System.out.println("-- -- -- ------------- -------------");
        
        rowCounter = 0;
        for ( String row : tableRows )
            System.out.println( row + prop1[rowCounter] + "             " + prop2[rowCounter++] );
                
        System.out.println();
        System.out.println();
        
        
        // compare prop1 and prop2 to see if they are logically equivalent
        if ( Arrays.equals( prop1, prop2 ) )
            System.out.println("Proposition 1 and Proposition 2 are logically equivalent.");
        else
            System.out.println("Proposition 1 and Proposition 2 are not logically equivalent.");
                
    } // end main
} // end class