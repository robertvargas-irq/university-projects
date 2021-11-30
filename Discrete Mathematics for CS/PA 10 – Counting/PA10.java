// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 10
// Modified:   11/16/2021 - Refactor a bit of code and create factorial method. 
// Purpose:    This program takes 3 unique characters,
//             permutes them, and validates them against an
//             approved list of Scrabble words. It then takes the
//             permutations, adds 'a'-'z' to each respectively, then
//             validates those against a list of Scrabble words.

import java.util.*;
import java.io.*;

public class PA10 {
    
    // read newline-separated words from a file into an array and return
    public static String[] getWordsFromFile( String fileName, int fileSize ) throws IOException {
        
        String[] input = new String[ fileSize ];
        Scanner fileScanner = new Scanner( new File( fileName ) );
        
        int lineCounter = 0;
        while( fileScanner.hasNext() )
            input[ lineCounter++ ] = fileScanner.nextLine();
        
        return input;
        
    } // end getWordsFromFile()
    
    // recursively store permutations
    public static void findPermutations( char[] s, String[] permutations, int prefix ) {
        
        // base case
        if ( s.length == prefix ) {
            
            // find the next empty spot in the array and store
            boolean found = false;
            for ( int i = 0; i < permutations.length && !found; i++ )
                if ( permutations[i] == null ) {
                    permutations[i] = new String( s );
                    found = true;
                } // end if
            return;
            
        }
        
        // recursive step
        for ( int i = prefix; i < s.length; i++ ) {
            
            char temp = s[i];
            s[i] = s[prefix];
            s[prefix] = temp;
            
            findPermutations( s, permutations, prefix + 1 );
            
            temp = s[i];
            s[i] = s[prefix];
            s[prefix] = temp;            
            
        } // end for loop
        
    } // end findPermutations()
    
    // calculate the factorial of a given number
    public static int factorial( int num ) {
        
        // error case
        if ( num < 0 )
            return -1;
        
        // calculate factorial
        int factorial = 1;
        for ( int i = 2; i <= num; i++ )
            factorial = factorial * i;
        
        return factorial;
        
    } // end factorial()
    
    public static void main( String[] args ) throws IOException {
        
        // populate acceptable words
        String[] scrabbleWords3 = getWordsFromFile("scrabble3.txt", 1065);
        String[] scrabbleWords4 = getWordsFromFile("scrabble4.txt", 3996);
        
        // get 3 character user input
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter 3 letters with no spaces in between: ");
        String userInput = scan.nextLine();
        System.out.println();
        
        // calculate permutations possible with 3 letters
        int possibleThreeLetters = factorial( 3 );
        String[] threeLetterPermutations = new String[ possibleThreeLetters ];
        String[] valid3LetterWords = new String[ possibleThreeLetters ];
        
        // find all 3-letter permutations and print afterwards
        System.out.println("There are " + possibleThreeLetters + " 3-letter permutations. They are:");
        findPermutations( userInput.toCharArray(), threeLetterPermutations, 0 );
        for ( String s : threeLetterPermutations )
            System.out.println( s );
        
        // begin validating each word against an approved 3-letter Scrabble list
        int generalCounter = 0;
        int validThreeLetterCount = 0;
        for ( String s : threeLetterPermutations )
            if ( Arrays.binarySearch( scrabbleWords3, s ) >= 0 )
                valid3LetterWords[ validThreeLetterCount++ ] = s;
        System.out.println();
        
        // print matching approved Scrabble words
        if ( validThreeLetterCount == 0 )
            System.out.println("There are no valid 3-letter Scrabble words.");
        else {
            
            System.out.println("The permutations that are valid 3-letter Scrabble words are:");
            for ( int i = 0; i < validThreeLetterCount; i++ )
                System.out.println( valid3LetterWords[i] );
            
        } // end if-else
        System.out.println();
        
        
        
        //
        // Calculate 4-Letter Permutations if a letter is added in front
        //
        
        int possibleFourLetters = 26 * possibleThreeLetters;
        String[] fourLetterPermutations = new String[ possibleFourLetters ];
        String[] valid4LetterWords = new String[ possibleFourLetters ];
        
        System.out.println("If one letter is added at the beginning, there are " +
                           possibleFourLetters +
                           " permutations.\n");
        
        // add letter to the beginning of each three letter permutation from 'a'-'z'
        generalCounter = 0;
        for ( int i = 0; i < threeLetterPermutations.length; i++ )
            for ( char letter = 'a'; letter <= 'z'; letter++ )
                fourLetterPermutations[ generalCounter++ ] = letter + threeLetterPermutations[i];
        
        // begin validating each word against an approved 4-letter Scrabble list
        int validFourLetterCount = 0;
        for ( String s : fourLetterPermutations )
            if ( Arrays.binarySearch( scrabbleWords4, s ) >= 0 )
                valid4LetterWords[ validFourLetterCount++ ] = s;
        
        // print matching approved Scrabble words
        if ( validFourLetterCount == 0 )
            System.out.println("There are no valid 4-letter Scrabble words.");
        else {
            
            System.out.println("The permutations that are valid 4-letter Scrabble words are:");
            Arrays.sort( valid4LetterWords, 0, validFourLetterCount - 1 );
            for ( int i = 0; i < validFourLetterCount; i++ )
                System.out.println( valid4LetterWords[i] );
            
        } // end if-else
        System.out.println();
        
        // print summary
        System.out.printf("Depending on the letters on the board, you have %d 3-letter moves " +
                          "and %d 4-letter moves.%n",
                          validThreeLetterCount,
                          validFourLetterCount);
        
    } // end main
    
} // end PA10