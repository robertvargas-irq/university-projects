// CS 271 - M04 – PA 3
// Program name: pa3.c
// Author:       Robert Vargas
// Date:         2/18/2021
// Purpose:      This program tests the functions within
//               the custom header file pa3functions.h, and its
//               code located within pa3functions.c.
//               The three functions located within return whether
//               a number is perfect or not (1 true, 0 false), whether
//               a number is a prime or not (1 true, 0 false), and
//               one that returns the number in reverse.


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "pa3functions.h"

int main( void ) {

    int primeCount;
    int i;
    
    // test perfect()
    printf("====================\n");
    printf("[TESTING: perfect()]\n");
    printf("The following are perfect positive numbers less than 1000:\n");
    
    // print positive perfect numbers less than 1000
    for ( i = 1; i < 1000; i++ )
        if ( perfect(i) == 1 )
            printf("%d ", i);
        
    printf("\n==================\n");
    
    
    
    // test prime() with the first 20 positive numbers
    printf("[TESTING: prime()]\n");
    printf("The following are the first 20 positive prime numbers:\n");

    // print the first 20 positive prime numbers    
    i = 1;
    primeCount = 1;
    while ( primeCount <= 20 ) {
        if ( prime(i) == 1 ) {
            printf("%d ", i);
            primeCount++;
        } // end if
        
        i++;
        
    } // end while
    
    printf("\n======================\n");
    
    
    
    // test reverse() by reversing 5 random numbers from [0, 100]
    printf("[TESTING: revDigits()]\n\n");
    
    srand(time(NULL));
    for ( i = 1; i <= 5; i++ ) {
        // seed and generate a random number
        int random = rand() % 1000 + 1;
        
        printf("[Number %d]: [%4d]\n", i, random);
        printf("(Reversed): [%4d]\n", revDigits(random));
        printf("\n");
    }
        
} // end main
