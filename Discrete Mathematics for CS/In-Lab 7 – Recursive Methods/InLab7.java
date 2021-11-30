// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 7
// 10/19/2021

// Name:       Robert Vargas
// Course:     CS 278 - M01
// Assignment: In-Lab 7
// Modified:   10/19/2021
// Purpose:    This implements recursive methods to print an hourglass word,
//             the logarithm (floored), and the population of an ant colony
//             over a set amount of days, rate, and initial population.

import java.util.*;

public class InLab7 {

   public static void hourglass ( String s, int spaces ) {
      
      // base case
      if ( s.length() <= 2 ) {
         for ( int i = 0; i <= spaces * 2; i++ )
            if ( i == spaces )
               System.out.print(s);
            else
               System.out.print(" ");
         System.out.println();
         return;
      }
         
      
      // recursive steps
      for ( int i = 0; i <= spaces * 2; i++ )
         if ( i == spaces )
            System.out.print(s);
         else
            System.out.print(" ");
      System.out.println();
      
      // recursive step - increment spaces then cut ends
      hourglass( s.substring( 1, s.length() - 1 ), spaces + 1 );
      
      // print after recursion is done, thus going backwards
      for ( int i = 0; i <= spaces * 2; i++ )
         if ( i == spaces )
            System.out.print(s);
         else
            System.out.print(" ");
      System.out.println();
      return;
      
   } // end hourglass method
   
   public static int floorLog ( int number, int base ) {
      
      // base case - if cannot be divided up further
      if ( number / base <= 0 )
         return 0;
      
      // recursive step
      return 1 + floorLog( number / base, base );
      
      
   } // end floorLog method
   
   public static int population ( int p0, int n, double r ) {
   
      // p0 is the initial population
      // n is the day
      // r is the growth rate
      
      // base case
      if ( n <= 0 )
         return p0;
      
      // recursive step
      return (int)( ( 1.0 + r ) * population( p0, n - 1, r ) );

   } // end population
   
   public static void main ( String args[] ) {
      
      // test hourglass()
      System.out.println("hello in hourglass form:\n");
      hourglass("hello", 0);
      System.out.println("\nyellow in hourglass form:\n");
      hourglass("yellow", 0);
      System.out.println("\n");
      
      // test floorLog()
      System.out.println("log_4(56) = " + floorLog( 56, 4 ) );
      System.out.println("log_3(735) = " + floorLog( 735, 3 ) );
      System.out.println("\n");
      
      // test population()
      System.out.println("Ant population growth:\n"
         + "   Initial Population: 80\n"
         + "   Days: 3\n"
         + "   Rate: 0.25\n\n"
         + "   Result: " + population( 80, 3, 0.25 ) + "\n");
      System.out.println("Ant population growth:\n"
         + "   Initial Population: 100\n"
         + "   Days: 4\n"
         + "   Rate: 0.05\n\n"
         + "   Result: " + population( 100, 4, 0.05 ) + "\n");
      
   } // end main
} // end class