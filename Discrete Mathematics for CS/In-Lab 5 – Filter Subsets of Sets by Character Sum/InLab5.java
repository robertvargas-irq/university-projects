// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 5
// 09/28/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 5
// Modified:   09/28/2021
// Purpose:    This program takes user input to define a String subset
//             of user-defined length, along with a desired restricting sum
//             to filter subsets down to ONLY THOSE WHO MATCH THE DESIRED SUM
//             OF CHARACTERS, and print only those.

import java.util.Scanner;

public class InLab5 {

   public static void printSubset(String set[], boolean mask[]) {
   
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
   
   // Count the total characters in the subset
   // parameter set: The Set of Strings to count
   // parameter mask: The mask to mask over the set of Strings to get the subset
   // returns int: Total character count of all Strings in the subset
   public static int totalCharacters( String[] set, boolean[] mask ) {
      
      int characterSum = 0;
      for ( int i = 0; i < set.length; i++ )
         if ( mask[i] )
            characterSum += set[i].length();
      
      return characterSum;
      
   } // end totalCharacters()
   
   public static void main ( String args[] ) {
      
      int count = 0; 
      Scanner scan = new Scanner(System.in);
      
      // input the size of the set
      System.out.println("How many elements does your set have?");
      int n = scan.nextInt();
      scan.nextLine();

      // input the elements of the set      
      System.out.println("Enter " + n + " strings for the elements of the set."
                          + "\nNo duplicates.");
      String[] mySet = new String[n];
      for (int i = 0; i < mySet.length; i++)
         mySet[i] = scan.nextLine();
         
      // input the character limit
      System.out.println("Enter the character limit that you wish each subset to add up to.");
      int charLimit = scan.nextInt();
      
      // create the initial mask with all false values
      boolean mask[] = new boolean[n];
      for (int index = 0; index < mask.length; index++ )
         mask[index] = false;
 
      System.out.println("Here are the subsets of your set:");
      // print the first subset set (note that the first set
      // that is printed will be the empty set)
      if ( totalCharacters( mySet, mask ) == charLimit )
         printSubset( mySet, mask );

      
      // Repeat until there are no more possible masks
      while (next( mask )) {
         if ( totalCharacters( mySet, mask ) == charLimit )
            printSubset( mySet, mask );
      } // end while
      
   } // end main
} // end class
      