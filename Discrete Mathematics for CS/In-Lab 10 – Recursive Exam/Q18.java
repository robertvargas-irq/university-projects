// Lab-Specific Information
// Robert Vargas
// CS 278 M1A Tuesday
// Lab 10
// 11/09/2021
// Exam Color: YELLOW

public class Q18 {
    
    // find the type for a given sequence
    public static String sequenceType( int[] a ) {
        
        // counters
        int increasing = 0;
        int decreasing = 0;
        
        // check through the array for dec. or inc.
        for ( int i = 0; i < a.length - 1; i++ )
            if ( a[i] < a[i + 1] )
                increasing++;
            else if ( a[i] > a[i + 1] )
                decreasing++;
        
        // return sequence type
        if ( increasing == ( a.length - 1 ) )
            return "increasing";
        if ( decreasing == ( a.length - 1 ) )
            return "decreasing";
        
        if ( increasing == 0 )
            return "non-increasing";
        if ( decreasing == 0 )
            return "non-decreasing";
        
        return "none of these";
        
    } // end sequenceType()
    
    public static void main( String[] args ) {
        
        int[] increasing    = { 1, 2, 3, 4, 5, 6 };
        System.out.println( "[1, 2, 3, 4, 5, 6] is: " + sequenceType( increasing ) );
        
        int[] decreasing    = { 6, 5, 4, 3, 2, 1 };
        System.out.println( "[6, 5, 4, 3, 2, 1] is: " + sequenceType( decreasing ) );
        
        int[] nonDecreasing = { 1, 2, 3, 3, 4, 5 };
        System.out.println( "[1, 2, 3, 3, 4, 5] is: " + sequenceType( nonDecreasing ) );
        
        int[] nonIncreasing = { 6, 6, 4, 2, 1, 0 };
        System.out.println( "[6, 6, 4, 2, 1, 0] is: " + sequenceType( nonIncreasing ) );
        
        int[] noneOfThese   = { 1, 2, 3, 4, 3, 2 };
        System.out.println( "[1, 2, 3, 4, 3, 2] is: " + sequenceType( noneOfThese ) );
                
    } // end main
    
} // end class