// CS 271 - M04 – PA 5
// Program name: pa5.c
// Author:       Robert Vargas
// Date:         3/11/2021
// Purpose:      This program tests the functions within
//               the custom header file sortingfunctions.h,
//               implementing its code which is located
//               within sortingfunctions.c. The code manipulates
//               dynamically-allocated arrays via malloc, using
//               pointers and pointer notation to sort and print
//               arrays created dynamically in memory.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "sortingfunctions.h"
#define ARRAYSIZE 10

int main( void ) {
    
    // seed time for the random function
    srand(time(NULL));
    
    // dynamically allocate memory space for an array
    int * arrayPtr = (int *) malloc( ARRAYSIZE * sizeof(int) );
    
    // fill the array with random integers
    fillArray( arrayPtr, ARRAYSIZE, 1, 100 );
    
    // print the array, 10 elements per line
    printf("=   =   =   =   =\n\n");
    printf("The following is the array filled with random integers from 1 to 100:\n");
    neatPrint( arrayPtr, ARRAYSIZE, 10, 3 );
    
    // sort the array using selection sort and print the return value
    int selectSortOpCount = selectionSort( arrayPtr, ARRAYSIZE );
    
    printf("The array above has been sorted with selection sort.\n");
    printf("\tSelection Sort made [%d] comparisons.\n\n", selectSortOpCount);
    
    // print the array, 10 elements per line
    printf("The following is the sorted array:\n");
    neatPrint( arrayPtr, ARRAYSIZE, 10, 3 );
    
    
    printf("=   =   =   =   =\n\n");
    
    
    // fill the array again with random integers
    fillArray( arrayPtr, ARRAYSIZE, 5, 99 );
    
    // print the array
    printf("The following is the array filled with random integers from 5 to 99:\n");
    neatPrint( arrayPtr, ARRAYSIZE, 10, 2 );
    
    // sort with insertion sort and print the return value
    int insertionSortOpCount = insertionSort( arrayPtr, ARRAYSIZE );
    
    printf("The array above has been sorted with insertion sort.\n");
    printf("\tInsertion Sort made [%d] comparisons.\n\n", insertionSortOpCount);
    
    // print the array
    printf("The following is the sorted array:\n");
    neatPrint( arrayPtr, ARRAYSIZE, 10, 2 );
    
    
    printf("=   =   =   =   =\n\n");

    
} // end main
