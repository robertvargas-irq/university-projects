import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Program implementing queues to solve for palindromes.
 * @author Robert Vargas
 *
 */
public class Palindrome {
	
	public static void main( String[] args ) {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		LinkedQueue<String> queue = new LinkedQueue<String>();
		LinkStack<String> stack = new LinkStack<String>();
		boolean isPalindrome = true;
		
		System.out.print("Please enter a string you wish to check to see if it is a word-for-word palindrome.\n"
				+ "Hint: Palindromes can be read the same forwards and backwards!\n> ");
		
		// get user input, and filter out anything that is not a letter or an apostrophe
		String[] input = null;
		try {
			input = br.readLine().split("[^'A-Za-z]+");
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		System.out.println("\nCollected: " + Arrays.toString( input ) + "\n");
		
		// queue and stack each word from input
		for ( String word : input ) {
			queue.enqueue( word );
			stack.push( word );
		}
		
		
		// compare the queue and stack pops with each other, as they are opposites
		for ( int i = 0; i < input.length && isPalindrome; i++ )
			if ( !stack.pop().equalsIgnoreCase( queue.dequeue() ) )
				isPalindrome = false;
		
		// display results
		if ( isPalindrome )
			System.out.println("The given string is in fact a palindrome!");
		else
			System.out.println("The given string is NOT a palindrome.");
		
	}
	
}
