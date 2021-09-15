// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 2
// Modified:   08/31/2021
// Purpose:    To implement logical operations such as and, or,
//             implies, and not, and building a 3-column truth
//             table in order to display and solve any given
//             proposition with custom functions to solve each
//             given logical piece of a proposition.

public class PA2Methods {

    public static char truthArray[] = { 'T', 'F' };
    public static boolean booleanArray[] = { true, false };
    
    
    // Generates a 3-column truth table
    // Parameter: void
    // Returns String[]: Formatted 3-column truth table with alternating pattern
    public static String[] buildTableRows() {
        
        String rows[] = new String[8];
        int rowCounter = 0;
        
        // nested for-each
        for ( char p : truthArray )
            for ( char q : truthArray )
                for ( char r : truthArray )
                    rows[ rowCounter++ ] = p + "  " + q + "  " + r + "  ";
        
        return rows;
        
    } // end buildTableRows()
    
    
    
    // Converts boolean input value to corresponding 'T' or 'F' character
    // Parameter bool: Boolean input of true or false to convert
    // Returns char: 'T' if true | 'F' if false
    public static char booleanToChar( boolean bool ) {
    
        if ( bool == true )
            return 'T';
        
        return 'F';
        
    } // end booleanToChar()
    
    
    
    // Converts char truth value for corresponding boolean
    // Parameter c: char 'T' or char 'F' truth value to be converted
    // Returns boolean: true for 'T' | false for 'F'
    public static boolean charToBoolean( char c ) {
    
        switch ( c ) {
            case 'T':
                return true;
            case 'F':
                return false;
            default:
                throw new IllegalArgumentException("Parameter must be 'T' or 'F'.");
        } // end switch
        
    } // end booleantoChar()
    
    
    
    // Performs a logical not, providing the inverse of a truth value
    // Parameter c: 'T' or 'F' char truth value to be inverted
    // Returns char: Inverse 'T' or 'F' of the inputted truth value
    public static char not( char c ) {
    
        boolean value = false;
        
        try {
            value = charToBoolean( c );
        }
        catch ( IllegalArgumentException e ) {
            System.out.println("An error occurred in the not method. "
                + e.getMessage()
                + " Defaulting to false.");
        }
        
        return booleanToChar( !value );
        
    } // end not()
    
    
    
    // Performs a logical and operation, checking for both to be true
    // Parameter p: First truth value character  ('T' || 'F')
    // Parameter q: Second truth value character ('T' || 'F')
    // Returns char: 'T' if both true | 'F' if both not true
    public static char and( char p, char q ) {
        
        boolean value = false;
        
        try {
            value = charToBoolean( p ) && charToBoolean( q );
        }
        catch ( IllegalArgumentException e ) {
            System.out.println("An error occurred in the not method. "
                + e.getMessage()
                + " Defaulting to false.");
        }
        
        return booleanToChar( value );
        
    } // end and()
    
    
    
    // Performs a logical or operation, checking if either or both are true
    // Parameter p: First truth value character  ('T' || 'F')
    // Parameter q: Second truth value character ('T' || 'F')
    // Returns char: 'T' if at least one value is true | 'F' if none true
    public static char or( char p, char q ) {
        
        boolean value = false;
        
        try {
            value = charToBoolean( p ) || charToBoolean( q );
        }
        catch ( IllegalArgumentException e ) {
            System.out.println("An error occurred in the not method. "
                + e.getMessage()
                + " Defaulting to false.");
        }
        
        return booleanToChar( value );
        
    } // end or()
    
    
    
    // Performs a logical "implies" operation, returning false if
    //     second value is false ( T|F -> F )
    // Parameter p: First truth value character  ('T' || 'F')
    // Parameter q: Second truth value character ('T' || 'F')
    // Returns char: 'T' if implies evaluated to true | 'F' if implies evaluated to false
    public static char implies( char p, char q ) {
        
        boolean value = false;
        boolean pBool = false;
        boolean qBool = false;
        
        // initialize boolean variants then solve
        try {
            pBool = charToBoolean( p );
            qBool = charToBoolean( q );
        }
        catch ( IllegalArgumentException e ) {
            System.out.println("An error occurred in the not method. "
                + e.getMessage()
                + " Defaulting to false.");
        }
        
        // Parses: [T T], [F T]
        if ( qBool == true )
            value = true;
        
        // Parses: [F F], qBool false is implied
        else if ( pBool == false )
            value = true;
        
        // Parses: [T F]
        else
            value = false;
        
        return booleanToChar( value );
             
    } // end implies()
    
} // end class