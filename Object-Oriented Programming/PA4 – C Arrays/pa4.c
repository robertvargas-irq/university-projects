// CS 271 - M04 – PA 4
// Program name: pa4.c
// Author:       Robert Vargas
// Date:         3/4/2021
// Purpose:      This program tests the functions within
//               the custom header file arrayfunctions.h,
//               implementing its code which is located
//               within arrayfunctions.c.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "arrayfunctions.h"

int main( void ) {
    
    // seed random with a null time variable
    srand(time(NULL));
    
    
    //
    // PROBLEM 1
    //
    
    printf("Problem 1\n");
    printf("=========\n");
    
    int firstArray[20];
    int firstArrayLength = 20;
    fillInteger(firstArray, firstArrayLength, -20, 20);
    
    // print the filled array with 10 numbers per line
    printf("Contents of firstArray[] after fillInteger() with range of -20 to 20:\n");
    for ( int i = 0; i < firstArrayLength; i++ ) {
        printf("%2d ", firstArray[i]);
        if ( ( i + 1 ) % 10 == 0 )
            printf("\n");
    } // end for loop
    
    // findConsecutive()
    findConsecutive( firstArray, firstArrayLength );
    printf("\n");
    
    //
    // PROBLEM 2
    //
    printf("\nProblem 2\n");
    printf("=========\n");
    
    char secondArray[50];
    int secondArrayLength = 50;
    
    fillCharacter( secondArray, secondArrayLength, 'a', 'z' );
    printf("\nContents of secondArray[] after fillCharacter() filled it with lowercase letters from 'a' to 'z':\n\n");
    for ( int i = 0; i < secondArrayLength; i++ )
        printf("%c ", secondArray[i]);
    
    printf("\n\n");
    
    // findTriples();
    printf("The following are any pair of consecutive character triplets in the array:\n");
    findTriples( secondArray, secondArrayLength );
    printf("\\\\\\ end of triplets\n");
    printf("\n");
    
    //
    // PROBLEM 3
    //
    
    // find a character in the array and count
    char findChar;
    char occurrences;
    
    printf("\nProblem 3\n");
    printf("=========\n");
    
    printf("Please input a character to find how many are within the previous array:\n");
    
    // get user input
    findChar = getchar();
    
    // verify it is a letter
    while ( !( findChar >= 'a' && findChar <= 'z' ) && !( findChar >= 'A' && findChar <= 'Z' ) ) {
        printf("%c is not a valid input! Please input a letter from A - Z:\n", findChar);
        findChar = getchar();
        printf("\n");
    }
    
    // convert to lowercase
    if ( findChar >= 'A' && findChar <= 'Z' )
        findChar += 32;
    
    // countCharacter() - find the number of times the given character is found
    occurrences = countCharacter( secondArray, secondArrayLength, findChar );
    printf("\n%c was found in secondArray[] %d times.\n", findChar, occurrences);
    printf("\n");
    
    
    //
    // PROBLEM 4
    //
    
    printf("\nProblem 4\n");
    printf("=========\n");
    
    float floatArray[10];
    int floatArrayLength = 10;
    
    float arrayMean;
    float arrayMin;
    float arrayMax;
    
    fillFloat( floatArray, floatArrayLength, 1.0, 50.0 );
    
    // print the results of filling floatArray[] with random floats from 1.0 to 50.0
    printf("Contents of floatArray[] after fillFloat() with range of 1.0 to 50.0:\n");
    for ( int i = 0; i < floatArrayLength; i++ )
        printf("%.1f  ", floatArray[i]);
    
    printf("\n");
        
    // floatMean()
    arrayMean = floatMean( floatArray, floatArrayLength );
    printf("\nThe MEAN of floatArray[] is:\n");
    printf("%.2f\n", arrayMean);
    
    // floatMin()
    arrayMin = floatMin( floatArray, floatArrayLength );
    printf("\nThe MIN of floatArray[] is:\n");
    printf("%.1f\n", arrayMin);
    
    arrayMax = floatMax( floatArray, floatArrayLength );
    printf("\nThe MAX of floatArray[] is:\n");
    printf("%.1f\n", arrayMax);
    
    printf("\n");
    
}
