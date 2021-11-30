// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 6
// 10/05/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 6
// Modified:   10/05/2021
// Purpose:    This program takes file input of two subsets A and B, and
//             prints only elements of P(A) that are elements of P(B)


import java.util.*;
import java.io.*;

public class InLab6 {

   // print a subset containing elements
   // whose mask value is true
   
   public static void printSubset(String set[], boolean mask[]) {
   
      String subsetString = "{ ";
      for (int i = 0; i < set.length; i++) {
         if (mask[i]) 
            subsetString = subsetString + "\"" + set[i] + "\", ";
     
      } // end for   
      if (subsetString.length() > 2) {
         subsetString = subsetString.substring(0, subsetString.length() - 2);
      }
      subsetString = subsetString + " }";      
      System.out.println(subsetString);
      
   } // end method
   
   // Generate the next mask in the sequence
   
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
   
   public static boolean isSubset( String setOne[], String setTwo[], boolean setTwoMask[] ) {
   
      // Returns true if the subset of setTwo (as indicated by the mask)
      // is a subset or equal to setOne.  If not, it returns false.
     
      Arrays.sort(setOne);
      for (int i = 0; i < setTwo.length; i++)
         if (setTwoMask[i] && Arrays.binarySearch( setOne, setTwo[i] ) < 0)
            return false;
      return true;
   } // end method
   
   public static void main (String args[]) throws IOException {

      Scanner fileScan = new Scanner(new File("inputFile.txt"));
      String setA[];
      String setB[];
      boolean[] setAMask;
           
      // input the size and elements of set A
      setA = new String[ fileScan.nextInt() ];
      setAMask = new boolean[ setA.length ];
      fileScan.nextLine();
      for (int i = 0; i < setA.length; i++)
          setA[i] = fileScan.nextLine();
      
      // input the size and elements of set B
      setB = new String[ fileScan.nextInt() ];
      fileScan.nextLine();
      for (int i = 0; i < setB.length; i++)
         setB[i] = fileScan.nextLine();
      
      // print elements of P(A) that are also elements of P(B)
      System.out.println("Elements of P(A) that are also elements of P(B)");
      if ( isSubset( setB, setA, setAMask ) )
          printSubset( setA, setAMask );
      while( next( setAMask ) )
          if ( isSubset( setB, setA, setAMask ) )
              printSubset( setA, setAMask );

   } // end main
} // end class        