// CS 271 - M04 – PA 5
// Program name: sortingfunctions.c
// Author:       Robert Vargas
// Date:         3/11/2021
// Purpose:      This program fully implements the functions
//               within the custom header file sortingfunctions.h.
//               The code manipulates dynamically-allocated arrays
//               via malloc, using pointers and pointer notation to
//               sort and print arrays created dynamically in memory.

#include <stdio.h>
#include <stdlib.h>
#include "sortingfunctions.h"

int selectionSort( int * const data, int size ) {
    
    // count comparisons made
    int opCount = 0;
    
    // iterate through the array
    for ( int i = 0; i < size; i++ ) {
        
        int smallest = i;
        
        // iterate through to find index of smallest
        for ( int j = i + 1; j < size; j++ ) {
            
            if ( *(data + j) < *(data + smallest) ) {
                smallest = j;
            } // end if
            
            opCount++;
            
        } // end for
         
        // swap i with the smallest in the list
        swap( (data + i), (data + smallest) );
        
    } // end for
        
    return opCount;
        
} // end selectionSort

int insertionSort( int * const data, int size ) {
    
    // count comparisons made
    int opCount = 0;
    
    // iterate through the array
    for ( int i = 1; i < size; i++ ) {
        int moveItem = i;
        int insert = *(data + i);
        
        // search for a place to put current element
        while ( moveItem > 0 && *(data + moveItem - 1) > insert ) {
            // shift element right one slot
            *(data + moveItem) = *(data + moveItem - 1);
            --moveItem;
            opCount++;
        } // end while
        
        // place inserted element
        *(data + moveItem) = insert;
        
    } // end for
    
    return opCount;
    
} // end insertionSort

void swap( int * num1, int * num2 ) {
    
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
    
} // end swap

void fillArray( int * const data, int size, int min, int max ) {
    
    // iterate through the array and fill with random numbers in range
    for ( int i = 0; i < size; i++ ) {
        int random = ( rand() % ( max - min + 1 ) ) + min;
        *(data + i) = random;

    } // end for

} // end fillArray

void neatPrint( int * const data, int size, int numPerLine, int fieldSize ) {
    
    char s[size];
    
    for ( int i = 0; i < size; i++ ) {
        
        sprintf(s, "%*d", fieldSize, *(data + i));
        printf("%s ", s);
        
        if ( ( i + 1 ) % numPerLine == 0 )
            printf("\n");
        
    } // end for
    
    printf("\n");
        
} // end neatPrint
