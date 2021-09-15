// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 3
// 09/14/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 3
// Modified:   09/14/2021
// Purpose:    To evaluate Strings against quantified statements:
//             
//             - "All words in the list can be found in the sentence."
//             - "There are no words in the list longer than n characters."

import java.util.Scanner;

public class InLab3 {
    
    // This statement evaluates "All words in the list can be found in the sentence."
    // Parameter sentence: The sentence to evaluate the word list against.
    // Parameter wordList: The words to find in the sentence.
    // Returns boolean: True if all words in wordList[] found in sentence | False if all not found
    public static boolean statementOne( String sentence, String[] wordList ) {
        
        // filter out punctuation, and split at spaces
        String[] filter = { ".", ",", "!", "?" };
        for ( String f : filter )
            sentence = sentence.replace( f, "" );
        String[] split = sentence.split(" ");
        
        // go through the wordList, and return false if end is reached with no found value
        boolean found = false;
        for ( String keyword : wordList ) {
                        
            // search the sentence for the desired keyword
            found = false;
            for ( String word : split )
                if ( keyword.equalsIgnoreCase( word ) )
                    found = true;
            
            // if not found after searching the sentence, return false
            if ( found == false )
                return false;
                
        } // end for-each loop
        
        // if all tests passed, return true
        return true;
        
    } // end statementOne()
    
    // Evaluates the statement "There are no words in the list longer than 5 characters."
    // Parameter sentence: The sentence to evaluate.
    // Parameter n: The max number of letters words in the sentence can have.
    // Returns boolean: True if no words are longer than n | False if a word's length is greater than n
    public static boolean statementTwo( String sentence, int n ) {
                
        // check to see if spaces between whitespaces is greater than n
        int letterCount = 0;
        for ( int i = 0; i < sentence.length(); i++ ) {
            
            // if end of word (space) is found, reset letter counter
            if ( sentence.charAt(i) == ' ' )
                letterCount = 0;
            // else, increment letter counter
            else
                letterCount++;
            
            // if letter counter's value is greater than n, return false
            if ( letterCount > n )
                return false;
                
        } // end for loop
        
        // if no word found larger than n, return true
        return true;
        
    } // end statementTwo()
    
    public static void main( String[] args ) {
        
        Scanner scan = new Scanner( System.in );
        String statementOneSentence = "";
        String[] statementOneWords = new String[ 5 ];
        int statementTwoLimit;
                
        // test statementOne()
        System.out.print("Please enter a sentence: ");
        statementOneSentence = scan.nextLine();
        System.out.print("Please enter 5 words: ");
        for ( int i = 0; i < 5; i++ )
            statementOneWords[i] = scan.next();

        System.out.printf("\"All words in the list can be found in the sentence.\" is %s.%n",
                          statementOne( statementOneSentence, statementOneWords ));

        // test statementTwo()
        System.out.print("Please enter a word length limit (integer): ");
        statementTwoLimit = scan.nextInt();
        
        System.out.printf("\"There are no words in the list longer than %d characters.\" is %s.%n",
                          statementTwoLimit,
                          statementTwo( statementOneSentence, statementTwoLimit ));
        
    } // end main
} // end class