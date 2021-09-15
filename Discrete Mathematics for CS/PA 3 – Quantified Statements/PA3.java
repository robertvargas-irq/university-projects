// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 3
// Modified:   09/07/2021
// Purpose:    To implement logical operations such as and, or,
//             implies, and not, and apply them to given propositions,
//             evaluating user input against the list of propositions
//             given below:
//             
//             a - for ALL of x: ( if x < 0 THEN x is even )
//             b - there EXISTS an x in which: ( if x < 0 THEN x is even )
//             c - there EXISTS an x in which: ( x < 0 AND x is even )
//             d - for ALL of x: ( ((x - 1) % 3 == 0) OR ((x - 1) % 2 == 0) )

import java.util.Scanner;

public class PA3 {
    
    
    // Evaluates user input against the proposition:
    //     for ALL of x: ( if x < 0 THEN x is even )
    // Parameter array[]: User-inputted x values to evaluate against the proposition.
    // Returns boolean: true if the proposition evaluates true | false if not
    public static boolean statementA( int[] array ) {
        
        // find counter-example for: for ALL x, ( x < 0 IMPLIES x is even )
        for ( int x : array )
            if ( !PA2Methods.charToBoolean(
                PA2Methods.implies(
                    PA2Methods.booleanToChar( x < 0 ),
                    PA2Methods.booleanToChar( x % 2 == 0 )
                )
            )) return false;
        
        // if no counter-example is found, return true
        return true;
        
        
    } // end statementA()
    
    
    
    // Evaluates user input against the proposition:
    //     there EXISTS an x in which: ( if x < 0 THEN x is even )
    // Parameter array[]: User-inputted x values to evaluate against the proposition.
    // Returns boolean: true if the proposition evaluates true | false if not
    public static boolean statementB( int[] array ) {
        
        // find proof for: there EXISTS an x, that ( x < 0 IMPLIES x is even )
        for ( int x : array )
            if ( PA2Methods.charToBoolean(
                PA2Methods.implies(
                    PA2Methods.booleanToChar( x < 0 ),
                    PA2Methods.booleanToChar( x % 2 == 0 )
                )
            )) return true;
        
        // if no proof is found, return false
        return false;
        
    } // end statementB()
    
    
    
    // Evaluates user input against the proposition:
    //     there EXISTS an x in which: ( x < 0 AND x is even )
    // Parameter array[]: User-inputted x values to evaluate against the proposition.
    // Returns boolean: true if the proposition evaluates true | false if not
    public static boolean statementC( int[] array ) {
        
        // find proof for: there EXISTS an x, that ( x < 0 AND x is even )
        for ( int x : array )
            if ( PA2Methods.charToBoolean(
                PA2Methods.and(
                    PA2Methods.booleanToChar( x < 0 ),
                    PA2Methods.booleanToChar( x % 2 == 0 )
                )
            )) return true;
            
        // if no proof is found, return false
        return false;
        
    } // end statementC()
    
    
    
    // Evaluates user input against the proposition:
    //     for ALL of x: ( ((x - 1) % 3 == 0) OR ((x - 1) % 2 == 0) )
    // Parameter array[]: User-inputted x values to evaluate against the proposition.
    // Returns boolean: true if the proposition evaluates true | false if not
    public static boolean statementD( int[] array ) {
        
        // find counter-example for: for ALL x, ( ((x - 1) % 3 == 0) OR ((x - 1) % 2 == 0) )
        for ( int x : array )
            if ( !PA2Methods.charToBoolean(
                PA2Methods.or(
                    PA2Methods.booleanToChar( (x - 1) % 3 == 0 ),
                    PA2Methods.booleanToChar( (x - 1) % 2 == 0 )
                )
            )) return false;
            
        // if no counter-example is found, return true
        return true;
        
    } // end statementD()
    
    
    public static void main( String args[] ) {
        
        Scanner scan = new Scanner( System.in );
        int userInput[] = new int[ 10 ];
        
        // collect user-input
        System.out.println("Please enter " + userInput.length + " different integers:");
        for ( int i = 0; i < userInput.length; i++ )
            userInput[i] = scan.nextInt();
        
        // evaluate the propositions with given user-data
        System.out.println();
        System.out.println("Proposition (a) is " + statementA( userInput ));
        System.out.println("Proposition (b) is " + statementB( userInput ));
        System.out.println("Proposition (c) is " + statementC( userInput ));
        System.out.println("Proposition (d) is " + statementD( userInput ));
        
    } // end main
} // end class