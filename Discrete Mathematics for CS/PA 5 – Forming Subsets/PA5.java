// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: PA 5
// Modified:   09/27/2021
// Purpose:    This program implements methods to print a given Subset of a
//             Set, aided by the help of a boolean mask, and a method to cycle
//             out the mask to provide each possible subset of a given set S.
//             Additionally, the set will be constructed with a user-defined size
//             and values. The subsets will be filtered by a user-defined sum, n,
//             and only print those subsets that add up to the desired sum, n.


import java.util.Scanner;

public class PA5 {

    public static void printSubset(int set[], boolean mask[]) {
   
        String subsetString = "{ ";
        for (int i = 0; i < set.length; i++) {
            if (mask[i]) 
                subsetString = subsetString + set[i] + ", ";
     
        } // end for   
        if (subsetString.length() > 2) {
            subsetString = subsetString.substring(0, subsetString.length() - 2);
        }
        subsetString = subsetString + " }";      
        System.out.println(subsetString);
      
    } // end method
         
    public static boolean next( boolean mask[] ) {
        int i;  
        for (i = 0; i < mask.length && mask[i]; i++)
            mask[i] = false;
        if (i < mask.length) {
            mask[i] = true;
            return true;
        }
        return false;
    } // end method
      
    public static void main ( String args[] ) {
      
        int count = 0; 
        Scanner scan = new Scanner( System.in );
      
        // input the size of the set
        System.out.println("How many numbers will set S have?");
        int size = scan.nextInt();

        // input the elements of the set      
        System.out.println("Enter " + size + " integers for the elements of set S."
                            + "\nNo duplicates.");
        int[] mySet = new int[size];
        for ( int i = 0; i < mySet.length; i++ )
           mySet[i] = scan.nextInt();
                          
        // input the desired sum
        System.out.println("Enter the sum n you would like to filter the subsets with, only printing the subsets of S that "
                            + "add up to the desired sum n.");
        int n = scan.nextInt();
      
        // create the initial mask with all false values
        boolean mask[] = new boolean[size];
        for ( int i = 0; i < mask.length; i++ )
           mask[i] = false;
      
      
      
        // Repeat until there are no more possible masks
        System.out.println("Here are the subsets of set S that add up to " + n + ":");
        while ( next( mask ) ) {
            int sum = 0;
            for ( int i = 0; i < mySet.length; i++ )
                if ( mask[i] )
                    sum += mySet[i];
          
            // check if sum matches n, then print mask if true
            if ( sum == n )
                printSubset( mySet, mask );
          
        } // end while
      
    } // end main
} // end class