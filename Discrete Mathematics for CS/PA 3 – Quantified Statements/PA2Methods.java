// PA2Methods
// Solution to Programming Assignment #2
// CS 278 - Fall 2021
//
// Written by Esther Steiner
//
public class PA2Methods {
      
   public static boolean booleanTruthValues[] = {true, false};
   
   public static char charTruthValues[] = {'T', 'F'}; 
   
   public static char booleanToChar( boolean b ) {
      return b ? 'T' : 'F';
   }
  
   public static boolean charToBoolean( char c ) {
      if (c != 'T' && c != 'F')
         throw new IllegalArgumentException("Cannot convert '" + c + "' to boolean.");
      return (c == 'T' ? true : false);
   }
   
   public static char not( char p1 ) {
       boolean p = false;
       try { 
          p = charToBoolean(p1);
       }
       catch (Exception e) {
          System.out.println( "In method not: Unable to convert '" + p1 + "' to boolean." 
                              + " Parameter must be 'T' or 'F'.");
       }
       return booleanToChar(!p);
   } // end not method
   
   public static char or( char p1, char q1 ) {
      boolean p = false, q = false;
      try { 
         p = charToBoolean(p1);
      }
      catch (Exception e) {
         System.out.println( "In method or: Unable to convert '" + p1 
             + "' to boolean.\n1st parameter must be 'T' or 'F'.");
      }
      try { 
         q = charToBoolean(q1);
      }
      catch (Exception e) {
         System.out.println( "In method or: Unable to convert '" + q1 
             + "' to boolean.\n2nd parameter must be 'T' or 'F'.");
      }

      return booleanToChar(p || q);
   } // end or

   public static char and( char p1, char q1 ) {
      boolean p = false, q = false;
      try { 
         p = charToBoolean(p1);
      }
      catch (Exception e) {
         System.out.println( "In method and: Unable to convert '" + p1 
             + "' to boolean.\n1st parameter must be 'T' or 'F'.");
      }
      try { 
         q = charToBoolean(q1);
      }
      catch (Exception e) {
         System.out.println( "In method and: Unable to convert '" + q1 
             + "' to boolean.\n2nd parameter must be 'T' or 'F'.");
      }

      return booleanToChar(p && q);   
   } // end and
   
   public static char implies( char p1, char q1 ) {
      boolean p = false, q = false;
      try { 
         p = charToBoolean(p1);
      }
      catch (Exception e) {
         System.out.println( "In method implies: Unable to convert '" + p1 
             + "' to boolean.\n1st parameter must be 'T' or 'F'.");
      }
      try { 
         q = charToBoolean(q1);
      }
      catch (Exception e) {
         System.out.println( "In method implies: Unable to convert '" + q1 
             + "' to boolean.\n2nd parameter must be 'T' or 'F'.");
      }

      return booleanToChar(!p || q);   
   } // end implies

   public static String[] buildTableRows (  ) {
   
      String tableRows[] = new String[8];
      int row = 0;
      for (char p : charTruthValues) 
          for (char q : charTruthValues) 
             for (char r : charTruthValues) {
                 tableRows[row] = p + "  " + q + "  " + r + "  ";
                 row++;
             } // end loop r

      return tableRows;
   } // end method buildTableRows
} // end class
      