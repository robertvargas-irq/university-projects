// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 7
// Modified:   10/25/2021 - Restrict the main loop to 10,000 recursive calls.
// Purpose:    This program implements methods to recursively estimate the value of pi,
//             and find the amount of correct digits that it was able to estimate,
//             then test with the max amount of memory that can be used for the recursion.

public class Pi {
    
    // Estimate the value of Pi using a summation formula for n terms
    public static double valueOfPi( int n ) {
        
        // base case - if n is no longer positive
        if ( n == 0.0 )
            return 0.0;
        
        // recursive step - get -1^(n-1) sign flip then calculate and push recursive step
        double signFlip;
        if ( n % 2 == 0 )
            signFlip = -1;
        else
            signFlip = 1;
        
        double pi = ( 4.0 / ( 2.0 * n - 1.0 ) ) * signFlip;
           return pi + valueOfPi( n - 1 );
        
        
    } // end valueOfPi()
    
    
    // Check input double n against Math.PI and return how many digits are correct
    public static int correctDigits( double n ) {
        
        int count = 0;
        String pi = Double.toString( Math.PI );
        String stringified = Double.toString( n );
        
        // ensure first two characters are 3 and its subsequent period
        if ( stringified.charAt(0) == '3' && stringified.charAt(1) == '.' )
            count = 1;
        else
            return 0;
        
        // count until first incorrect is reached, or end of string 
        for ( int i = 2; i < stringified.length(); i++ )
            if ( stringified.charAt(i) != pi.charAt(i) )
                return count;
            else
                count++;
        
        return count;
        
    } // end correctDigits()
    
    public static void main( String[] args ) {
        
        // max allowed on M1 Macbook 8GB Ram: 39537
        double piEstimate = 0;
        for ( int terms = 0; terms <= 10000; terms++ ) {
            
            // due to multiple StackOverflowErrors occurring, a buffer is
            // needed to prevent an error, letting it go from 0 - 5000 before
            // jumping to the final 5000 terms > 35000 to reach 40000.
            // Terms: [ 0, 5000 ] U [ 35001, 40000 ]
            int buffer = 0;
            if ( terms > 5000 )
                buffer = 30000;
            
            // make an estimate of pi using a defined sequence via recursion
            piEstimate = valueOfPi( terms + buffer );
            System.out.printf("%05d terms: pi = %-12f %2d correct digits%n",
                terms + buffer,
                piEstimate,
                correctDigits( piEstimate ));
            
        } // end for loop
        
    } // end main
    
} // end class