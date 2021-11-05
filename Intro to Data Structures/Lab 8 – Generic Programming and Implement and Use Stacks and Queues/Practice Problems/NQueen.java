/**
 * Solve the NQueens programming problem with Stacks
 * with N in the range of [1, 16]
 * @author Robert Vargas
 *
 */
public class NQueen {
	
	static int N;
	
	/**
	 * Checks to see if it is in the path of another queen in the stack.
	 * @param pos The position of the queen to check against others.
	 * @param stack The stack of already solidified queen positions.
	 * @return True if there is a conflict | False if there is no conflict.
	 */
	public static boolean checkConflict( int pos, StackInterface<Integer> stack ) {
		
		int[] stackData = new int[ stack.size() ];
		int rowOffset = 0;
		boolean conflict = false;
		
		// check each known queen position against the current position for conflict
		while ( !stack.isEmpty() && !conflict ) {
			
			int previousPos = stack.pop();
			if ( previousPos == pos + 1 + rowOffset || previousPos == pos - 1 - rowOffset || pos == previousPos )
				conflict = true;
			
			// cache the popped data from the stack
			stackData[ rowOffset++ ] = previousPos;
			
		}
		
		// push popped data back onto the stack
		for ( int i = rowOffset - 1; i >= 0; i-- )
			stack.push( stackData[i] );
		
		return conflict;
		
	}
	
	/**
	 * Format the stack to a chess board with Queen positions
	 * @param stack The stack of Queen positions
	 * @return Chess-formatted string to display in the console
	 */
	public static String printChess( StackInterface<Integer> stack ) {
		
		String solution = "";
		String empty = "- ";//"\u2022 ";
		
		// if stack is not empty, format to a chess layout
		if ( stack.isEmpty() )
			solution = " ! NO SOLUTION FOUND !\n\n" + ("   " + empty.repeat(N) + "\n").repeat(N);
		else
			while ( !stack.isEmpty() ) {
				int spot = stack.pop();
				int prefix = spot - 1;
				int suffix = N - spot;
				if ( prefix < 0 ) prefix = 0;
				if ( suffix < 0 ) suffix = 0;
				solution += "   " + empty.repeat( prefix ) + "Q " + empty.repeat( suffix ) + "\n";// + solution;
			}
		
		return solution;
		
	}

	public static void main(String[] args) {
		
		ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
		
		
		// test N in range [1, 16]
		for ( N = 1; N <= 16; N++ ) {
			
			int Qpos = 1;

			// while not all rows are filled
			while ( stack.size() < N ) {
				
				// while there is room to shift the current queen rightward
				while ( Qpos <= N ) {
					
					// if there is a conflict, move queen right one; else, push to stack
					boolean conflict = checkConflict( Qpos, stack );
					if ( !conflict ) {
						stack.push( Qpos );
						Qpos = 1;
						break;
					}
					else
						Qpos++;
					
				} // end while loop through columns
				
				// if not empty and checked every column
				while ( !stack.isEmpty() && Qpos > N )
					Qpos = stack.pop() + 1;
				
				if ( stack.isEmpty() && Qpos > N )
					break;
				
			} // end parent while loop for rows
			
			System.out.println("===============");
			System.out.println("Solving N = " + N + ".\n");
			System.out.println("Solution: " + ( stack.isEmpty() ? "NO SOLUTION FOUND." : stack ) + "\nSolution formatted on a chess board:\n");
			System.out.println( printChess( stack ) + "\n\n");
			
		} // end [1, 16] test

	}

}
