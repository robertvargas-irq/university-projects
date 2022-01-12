// CS 271 - M04 – PA 3
// Program name: pa3functions.c
// Author:       Robert Vargas
// Date:         2/18/2021
// Purpose:      The three functions (perfect(), prime(), revDigits())
//               located within return whether:
//               a number is perfect or not (1 true, 0 false), whether
//               a number is a prime or not (1 true, 0 false), and
//               one that returns the number in reverse.


#include <stdio.h>
#include <math.h>

#include "pa3functions.h"

int perfect( int number ) {
    
    // loop through each possible factor with modulo, except for number itself
    int sum = 0;
    for ( int i = 1; i < number; i++ )
        if ( number % i == 0 )
            sum += i;
        
    if ( number == sum )
        return 1;
    else
        return 0;
        
} // end perfect()

int prime( int number ) {
    
    // checks for invalid number 1
    if ( number == 1 )
        return 0;
    
    // cycles through to ensure that the number is not divisible
    for ( int i = 2; i < number / 2; i++ )
        if ( number % i  == 0 )
            return 0;
    
    // if no divisible number factor is found, then return 1 for prime
    return 1;
    
} // end prime()

int revDigits( int number ) {
    
    int reverse = 0;
    int isNegative = 0;
    
    // checks for negative
    if ( number < 0 ) {
        number = -number;
        isNegative = 1;
    } // end if

    // flips the number digit by digit by manipulating integer division
    while ( number > 0 ) {
        reverse = ( reverse * 10 ) + ( number % 10 );
        number = number / 10;
    } // end while
    
    // reapplies the negative if originally negative
    if ( isNegative == 1 )
        reverse = -reverse;
    
    return reverse;
    
    
} // end revDigits
