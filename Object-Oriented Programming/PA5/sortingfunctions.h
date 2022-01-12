// CS 271 - M04 – PA 5
// Program name: sortingfunctions.h
// Author:       Robert Vargas
// Date:         3/11/2021
// Purpose:      This program defines function prototypes for
//               the implemented function code in sortingfunctions.c.
//               The code manipulates dynamically-allocated arrays
//               via malloc, using pointers and pointer notation to
//               sort and print arrays created dynamically in memory.

#ifndef SORTINGFUNCTIONS_H
#define SORTINGFUNCTIONS_H

int selectionSort( int * const array, int size );
int insertionSort( int * const array, int size );
void swap( int * num1, int * num2 );
void fillArray( int * const data, int size, int min, int max );
void neatPrint( int * const data, int size, int numPerLine, int fieldSize );

#endif
