import java.util.*;
import java.io.*;

public class Dictionary {
    
    public static HashMap<String, String> importDictionary( String fileName ) throws IOException {

        HashMap<String, String> dictionary = new HashMap<String, String>();
        Scanner fileScan = new Scanner( new File( fileName ) );
        // StringTokenizer = new StringTokenizer( input );

        System.out.println("Dictionary contents from " + fileName + ".");
        while ( fileScan.hasNextLine() ) {

            String[] rawInput = fileScan.nextLine().split("\t");
            String word = rawInput[0];
            String definition = rawInput[1];

            System.out.println("WORD: " + word + "\n\tDEFINITION: " + definition + "\n" );
            dictionary.put( word.toLowerCase(), definition );

        }

        return dictionary;

    }
    public static void main( String[] args ) throws Exception {

        HashMap<String, String> words = importDictionary("example_words.txt");
        Scanner userInput = new Scanner( System.in );

        System.out.println("Please input a word you would like defined. Type -1 to stop.\n");
        System.out.print("WORD:       ");

        String currentWord = "";
        while( !( currentWord = userInput.nextLine().toLowerCase() ).equals("-1") ) {

            // display definition if contained, else display error
            if ( words.containsKey( currentWord ) )
                System.out.println("DEFINITION: " + words.get( currentWord ) );
            else
                System.out.println("Woah! That is not a valid word in my dictionary! Please try again!");

            System.out.print("\nWORD:       ");

        }

        System.out.println("Done! Have a wonderful day!");
        userInput.close();

    }

}
