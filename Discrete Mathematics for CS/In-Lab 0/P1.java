// Robert Vargas
// CS 278 M1A Tuesday
// Lab 0
// 08/24/2021

import java.util.Scanner;

class P1 {
    public static void main( String args[] ) {
        
        Scanner scan = new Scanner( System.in );
        int userInput[] = new int[20];
        
        // populate userInput[] with user input
        System.out.println("Please enter 20 integers (one by one) to sort into evens and odds. Hit enter after each inputted number.");
        for ( int i = 0; i < userInput.length; i++ )
            userInput[i] = scan.nextInt();
            
        // display even numbers
        System.out.println();
        System.out.println("EVEN numbers from user input.");
        System.out.println("=============================");
        for ( int i = 0; i < userInput.length; i++ )
            if ( userInput[i] % 2 == 0 )
                System.out.printf("%d ", userInput[i]);
                
        System.out.println("\n");
            
        // display odd numbers
        System.out.println("ODD numbers from user input.");
        System.out.println("============================");
        for ( int i = 0; i < userInput.length; i++ )
            if ( userInput[i] % 2 != 0 )
                System.out.printf("%d ", userInput[i]);
                
        System.out.println("\n");
        
    } // end main
} // end class