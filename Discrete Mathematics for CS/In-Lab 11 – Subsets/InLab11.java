// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 11
// 11/16/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 11
// Modified:   11/16/2021
// Purpose:    This program initializes a random set of unique letters of size 7,
//             then prints out the 3 letter subsets within them.

public class InLab11 {
    
    // print a given subset
    public static void printSubset( char[] set, boolean[] mask ) {
   
        String subsetString = "";
        for ( int i = 0; i < set.length; i++ ) {
            if ( mask[i] ) 
                subsetString = subsetString + set[i];
     
        } // end for
        System.out.println( subsetString );
      
    } // end method
         
    // move to the next mask iteration
    public static boolean next( boolean[] mask ) {
        
        int i;
        for ( i = 0; i < mask.length && mask[i]; i++ )
            mask[i] = false;
        
        if ( i < mask.length ) {
            mask[i] = true;
            return true;
        } // end if
        
        return false;
        
    } // end method
    
    // search for a given key linearly in the array within a given range
    public static int search( char[] array, int fromIndex, int toIndex, char key ) {
        
        // validate input
        if ( fromIndex < 0 || toIndex >= array.length )
            return -1;
        
        // cycle through and return if key is found
        for ( int i = fromIndex; i <= toIndex; i++ )
            if ( array[i] == key )
                return i;
        
        return -1;
        
    } // end search()
    
    // fill a given array with unique random characters from 'a'-'z'
    public static void fillWithLetters( char[] array ) {
        
        for ( int i = 0; i < array.length; i++ ) {
            
            // produce the first random char
            char randomChar = (char)( (int)'a' + (int)( Math.random() * 26 ) );
            
            // keep trying until the key is not found in the array at the given constraints
            while ( search( array, 0, i, randomChar ) >= 0 )
                randomChar = (char)( 'a' + (int)( Math.random() * 26 ) );
            
            // assign
            array[i] = randomChar;
            
        } // end for loop
        
    } // end fillWithLetters()
    
    // count the occurrences of key in the boolean array
    public static int count( boolean[] array, boolean value ) {
        
        // count matching instances
        int count = 0;
        for ( boolean b : array )
            if ( b == value )
                count++;
        
        return count;
        
    } // end count
    
    public static void main( String[] args ) {
        
        // initialize maskArray
        boolean[] maskArray = new boolean[7];
        for ( int i = 0; i < maskArray.length; i++ )
            maskArray[i] = false;
        
        // initialize character array and populate
        char[] characterArray = new char[7];
        fillWithLetters( characterArray );
        
        
        
        // print values
        System.out.print("The array of letters contains: [");
        for ( int i = 0; i < characterArray.length; i++ ) {
            
            System.out.print( characterArray[i] );
            
            if ( i < characterArray.length - 1 )
                System.out.print(", ");
                
        } // end for loop
        System.out.println("]\n");
        
        
        
        // make the first check
        System.out.println("Here are the 3-letter subsets:");
        
        int count = 1;
        if ( count( maskArray, true ) == 3 ) {
            
            System.out.printf("%3d. ", count++);
            printSubset( characterArray, maskArray );
            
        } // end if statement
        
        // then, iterate through the characterArray and only printing subsets of 3
        while ( next( maskArray ) )
            if ( count( maskArray, true ) == 3 ) {
                
                System.out.printf("%3d. ", count++);
                printSubset( characterArray, maskArray );
                
            } // end if statement
        
    } // end main
   
} // end class