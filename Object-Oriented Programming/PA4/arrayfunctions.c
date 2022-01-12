// CS 271 - M04 – PA 4
// Program name: arrayfunctions.c
// Author:       Robert Vargas
// Date:         3/4/2021
// Purpose:      This program fully implements the
//               header prototypes located within
//               arrayfunctions.h.

#include <stdio.h>
#include <stdlib.h>
#include "arrayfunctions.h"

void fillInteger( int a[], int length, int min, int max ) {
    
    // iterate through the array and fill with random numbers in range
    for ( int i = 0; i < length; i++ ) {
        int random = ( rand() % ( max - min + 1 ) ) + min;
        a[i] = random;
    } // end for loop
    
} // end fillInteger


void fillCharacter( char c[], int length, char start, char end ) {
    
    // iterate through the array and fill with random chars in range
    for ( int i = 0; i < length; i++ ) {
        char random = ( rand() % ( end - start + 1 ) ) + start;
        c[i] = random;
    } // end for loop
    
} // end fillCharacter


void findConsecutive( int array[], int length ) {
    
    // initialize previous to the first element, then iterate from [1]
    int previous = array[0];
    for ( int i = 1; i < length; i++ ) {
        if ( ( array[i] - previous ) == 1 )
            printf("Elements [%d] and [%d] are consecutive.\n", i - 1, i);
        
        previous = array[i];
    } // end for loop
    
} // end findConsecutive


void findTriples( char c[], int length ) {
    
    for ( int i = 1; i < length - 1; i++ ) {
        if ( ( c[i] - c[i - 1] == 1 ) && ( c[i + 1] - c[i] == 1 ) )
            printf("%c%c%c\n", c[i - 1], c[i], c[i + 1]);
        
    } // end for loop
    
} // end findTriples

int countCharacter( char c[], int length, char searchChar ) {
    
    int count = 0;
    
    // iterate and find the character in the array
    for ( int i = 0; i < length; i++ )
        if ( c[i] == searchChar )
            count++;
            
    return count;

} // end countCharacter

void fillFloat( float a[], int length, float min, float max ) {
    
    // iterate through the array and fill with a random float from min-max
    int minInt = (int)min * 10;
    int maxInt = (int)max * 10;
    for ( int i = 0; i < length; i++ ) {
        float random = ( rand() % ( maxInt - minInt + 1 ) ) + min;
        random /= 10.0;
        a[i] = random;
    } // end for loop
    
} // end fillFloat

float floatMean( float array[], int length ) {
    
    float sum;
    float mean;
    
    // summate the values
    sum = 0;
    for ( int i = 0; i < length; i++ )
        sum += array[i];
    
    // calculate mean
    mean = sum / length;
    
    return mean;
    
} // end floatMean

float floatMin( float array[], int length ) {
    
    float min;
    
    // iterate through the array and find the minimum value
    min = array[0];
    for ( int i = 1; i < length; i++ )
        if ( array[i] < min )
            min = array[i];
        
    return min;
    
} // end floatMin

float floatMax( float array[], int length ) {
    
    float max;
    
    // iterate through the array and find the maximum value
    max = array[0];
    for ( int i = 1; i < length; i++ )
        if ( array[i] > max )
            max = array[i];
        
    return max;
    
} // end floatMax
