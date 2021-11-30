// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 10
// 11/09/2021
// Exam Color: YELLOW

public class Q17 {
    
    // print a string diagonally in steps of 2
    public static void diagonal( String s, String spaces ) {
        
        // base case
        if ( spaces.length() == s.length() - 1 )
            return;
        
        // recursive step
        diagonal( s, spaces + " " );
        System.out.println( spaces + s.substring( spaces.length(), 2 + spaces.length() ) );
        
    } // end diagonal()
    
    public static void main( String[] args ) {
        
        diagonal( "people", "" );
        diagonal( "hello", "" );
        diagonal( "fun", "" );
        diagonal( "is", "" );
        diagonal( "programming", "" );

    } // end main
    
} // end class