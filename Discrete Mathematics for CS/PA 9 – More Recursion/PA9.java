// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 9
// Modified:   11/08/2021 - Updated test cases to allow for more thorough testing.
// Purpose:    This program recursively computes the following:
//             - Find the GCD of two integers.
//             - Print the factors of a given integer.
//             - Print only the lowercase characters of a given String.

public class PA9 {
    
    // find the greatest common denominator
    public static int gcd( int num1, int num2 ) {
        
        // base case
        if ( num2 == 0 )
            return num1;
        
        // recursive step
        return gcd( num2, num1 % num2 );
        
    } // end gcd()
    
    // print only the factors of a given number
    public static void factors( int number, int possibleFactor ) {
        
        // error case
        if ( number < 1 || possibleFactor < 1 ) {
            System.out.print("ERROR: Number and possibleFactor must be positive.");
            return;
        }
        
        // base case
        if ( possibleFactor == 1 ) {
            System.out.print( possibleFactor );
            return;
        }
        
        // recursive step
        factors( number, possibleFactor - 1 );
        
        if ( number % possibleFactor == 0 )
            System.out.print( ", " + possibleFactor );
        
    } // end factors()
    
    // print only lowercase characters in a given string
    public static void lowercase( String sentence ) {
        
        // base case
        if ( sentence.length() == 0 )
            return;
        
        // recursive step
        if ( Character.isLowerCase( sentence.charAt(0) ) )
            System.out.print( sentence.charAt(0) );
        
        lowercase( sentence.substring(1) );
        
    } // end lowercase()
    
    public static void main( String[] args ) {
        
        int[] gcdTestA = { 6, -8, 15, 10, 10, 75, 10 };
        int[] gcdTestB = { 3,  4,  5, 10, 15, 20, 25 };
        System.out.println("Testing gcd( int, int )");
        System.out.println("===========================================");
        for ( int i = 0; i < gcdTestA.length; i++ )
            System.out.printf("Greatest common divisor of [%2d] and [%2d]: %2d%n", 
                               gcdTestA[i],
                               gcdTestB[i],
                               gcd( gcdTestA[i], gcdTestB[i] ));
        System.out.println("- - - - - END GCD TEST - - - - -\n");
        
        
        
        System.out.println("Testing factors( int, int ) from -5 to 12");
        System.out.println("===========================================");
        
        for ( int i = -5; i < 12; i++ ) {
            System.out.printf("Factors of [%2d]: ", i);
            factors( i, i );
            System.out.println();
        } // end for
        System.out.println("\n- - - - - END FACTORS TEST - - - - -\n");
        
        
        
        String[] testingStrings = { "ThIS Is lowercasE", "heLLo worlD", "thiS is 40% comPLeTe" };
        
        System.out.println("Testing lowercase( String )");
        System.out.println("===========================================");
        for ( int i = 0; i < testingStrings.length; i++ ) {
            System.out.printf( "\"%s\" but only lowercase letters: ", testingStrings[i] );
            lowercase( testingStrings[i] );
            System.out.println("\n");
        } // end for
        System.out.println("\n- - - - - END LOWERCASE TEST - - - - -");
        
    } // end main
} // end class