// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 2
// Modified:   08/31/2021
// Purpose:    To implement logical operations such as and, or,
//             implies, and not, and building a 3-column truth
//             table in order to display and solve any given
//             proposition with custom functions to solve each
//             given logical piece of a proposition.
//             This program evaluates 4 custom propositions:
//             
//             - ( not(p) implies q ) and ( r implies p )
//             - ( p or not(q) ) and ( r or not( p implies q ) )
//             - p implies ( ( not( p or not( q ) ) ) implies ( p and q ) )
//             - ( p and ( p implies q ) ) and not(q)

public class PA2Test {
    public static void main( String args[] ) {
        
        String truthTable[] = buildTableRows();
        int trueCounter;
        return;
        //
        // Proposition 1: ( not(p) implies q ) and ( r implies p )
        //
        
        System.out.println("Truth table for ( not(p) implies q ) and ( r implies p )");
        System.out.println();
        System.out.println("p  q  r  ( not(p) implies q ) and ( r implies p )");
        System.out.println("-- -- -- ----------------------------------------");
        
        // build table and parse proposition
        trueCounter = 0;
        for ( String i : truthTable ) {
            char finalTruthValue;
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char notPImpliesQ = PA2Methods.implies( PA2Methods.not( p ), q );
            char rImpliesP = PA2Methods.implies( r, p );
            
            // test final truth value and increment truth counter if applicable
            finalTruthValue = PA2Methods.and( notPImpliesQ, rImpliesP );
            if ( PA2Methods.charToBoolean( finalTruthValue ) == true )
                trueCounter++;
                
            
            System.out.println( i + finalTruthValue );
            
        } // end proposition 1 for-loop
        System.out.println();
        
        // print stats for ( not(p) implies q ) and ( r implies p )
        System.out.println( trueCounter + " combinations result in ( not(p) implies q ) and ( r implies p ) being T.");
        System.out.println( 8 - trueCounter + " combinations result in ( not(p) implies q ) and ( r implies p ) being F.");
        
        if ( trueCounter == 8 ) System.out.println("This statement is a TAUTOLOGY");
        else if ( trueCounter == 0 ) System.out.println("This statement is a CONTRADICTION");
        else System.out.println("This statement is NEITHER a tautology or contradiction.");
        System.out.println("\n==============\n");

        
        
        //
        // Proposition 2: ( p or not(q) ) and ( r or not( p implies q ) )
        //
        
        System.out.println("Truth table for ( p or not(q) ) and ( r or not( p implies q ) )");
        System.out.println();
        System.out.println("p  q  r  ( p or not(q) ) and ( r or not( p implies q ) )");
        System.out.println("-- -- -- -----------------------------------------------");
        
        // build table and parse proposition
        trueCounter = 0;
        for ( String i : truthTable ) {
            char finalTruthValue;
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char pOrNotQ = PA2Methods.or( p, PA2Methods.not(q) );
            char rOrNotPImpliesQ = PA2Methods.or( r, PA2Methods.not( PA2Methods.implies( p, q ) ) );
            
            // test final truth value and increment truth counter if applicable
            finalTruthValue = PA2Methods.and( pOrNotQ, rOrNotPImpliesQ );
            if ( PA2Methods.charToBoolean( finalTruthValue ) == true )
                trueCounter++;
                
            
            System.out.println( i + finalTruthValue );
            
        } // end proposition 2 for-loop
        System.out.println();
        
        // print stats for ( p or not(q) ) and ( r or not( p implies q ) )
        System.out.println( trueCounter + " combinations result in ( p or not(q) ) and ( r or not( p implies q ) ) being T.");
        System.out.println( 8 - trueCounter + " combinations result in ( p or not(q) ) and ( r or not( p implies q ) ) being F.");
        
        if ( trueCounter == 8 ) System.out.println("This statement is a TAUTOLOGY");
        else if ( trueCounter == 0 ) System.out.println("This statement is a CONTRADICTION");
        else System.out.println("This statement is NEITHER a tautology or contradiction.");
        System.out.println("\n==============\n");
        
        
        
        //
        // Proposition 3: p implies ( ( not( p or not( q ) ) ) implies ( p and q ) )
        //
        
        System.out.println("Truth table for p implies ( ( not(p or not(q)) ) implies ( p and q ) )");
        System.out.println();
        System.out.println("p  q  r  p implies ( ( not(p or not(q)) ) implies ( p and q ) )");
        System.out.println("-- -- -- ------------------------------------------------------");
        
        // build table and parse proposition
        trueCounter = 0;
        for ( String i : truthTable ) {
            char finalTruthValue;
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char pAndQ = PA2Methods.and( p, q );
            char notPOrNotQ = PA2Methods.not( PA2Methods.or( p, PA2Methods.not(q) ) );
            
            // test final truth value and increment truth counter if applicable
            finalTruthValue = PA2Methods.implies( p, PA2Methods.implies( notPOrNotQ, pAndQ ) );
            if ( PA2Methods.charToBoolean( finalTruthValue ) == true )
                trueCounter++;
                
            
            System.out.println( i + finalTruthValue );
            
        } // end proposition 3 for-loop
        System.out.println();
        
        // print stats for p implies ( ( not(p or not(q)) ) implies ( p and q ) )
        System.out.println( trueCounter + " combinations result in p implies ( ( not( p or not( q ) ) ) implies ( p and q ) ) being T.");
        System.out.println( 8 - trueCounter + " combinations result in p implies ( ( not( p or not( q ) ) ) implies ( p and q ) ) being F.");
        
        if ( trueCounter == 8 ) System.out.println("This statement is a TAUTOLOGY");
        else if ( trueCounter == 0 ) System.out.println("This statement is a CONTRADICTION");
        else System.out.println("This statement is NEITHER a tautology or contradiction.");
        System.out.println("\n==============\n");
        
        
        
        //
        // Proposition 4: ( p and ( p implies q ) ) and not(q)
        //
        
        System.out.println("Truth table for ( p and ( p implies q ) ) and not(q)");
        System.out.println();
        System.out.println("p  q  r  ( p and ( p implies q ) ) and not(q)");
        System.out.println("-- -- -- ------------------------------------");
        
        // build table and parse proposition
        trueCounter = 0;
        for ( String i : truthTable ) {
            char finalTruthValue;
            char p = i.charAt(0);
            char q = i.charAt(3);
            char r = i.charAt(6);
            
            char pAndPImpliesQ = PA2Methods.and( p, PA2Methods.implies( p, q ) );
            
            // test final truth value and increment truth counter if applicable
            finalTruthValue = PA2Methods.and( pAndPImpliesQ, PA2Methods.not(q) );
            if ( PA2Methods.charToBoolean( finalTruthValue ) == true )
                trueCounter++;
                
            
            System.out.println( i + finalTruthValue );
            
        } // end proposition 4 for-loop
        System.out.println();
        
        // print stats for ( p and ( p implies q ) ) and not(q)
        System.out.println( trueCounter + " combinations result in ( p and ( p implies q ) ) and not(q) being T.");
        System.out.println( 8 - trueCounter + " combinations result in ( p and ( p implies q ) ) and not(q) being F.");
        
        if ( trueCounter == 8 ) System.out.println("This statement is a TAUTOLOGY");
        else if ( trueCounter == 0 ) System.out.println("This statement is a CONTRADICTION");
        else System.out.println("This statement is NEITHER a tautology or contradiction.");
        System.out.println("\n==============\n");
        
        
                
    } // end main
} // end class