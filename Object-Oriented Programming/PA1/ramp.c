// CS 271 - M04 – PA 1
// Program name: ramp.c
// Author:       Robert Vargas
// Date:         2/3/2021
// Purpose:      This program calculates the dimensions of a wheelchair ramp.
//               It takes the height of the ramp in inches from the user, then
//               calculates the horizontal length of the ramp with a 1:12 ratio,
//               then finds the length of the hypotenuse, and displays the information
//               in feet to the user in a simple, meaningful way.

#include <stdio.h>
#include <math.h>

int main( void ) {
    
    // declare variables
    double rise, run, ramp;
    
    // get user input
    printf("Input the height of the ramp in inches. (Decimal values are accepted)\n");
    scanf("%lf", &rise);
    
    // rise:run = 1:12 ratio
    run = rise * 12.0;
    
    // check if a landing is required
    if ( run > 30 )
        printf("The ramp requires a landing.\n");
    
    // calculate the hypotenuse
    ramp = sqrt( rise * rise + run * run );
    
    // print information
    printf("With a vertical rise of %.1f feet, the horizontal length is %.1f feet.\n",
           rise / 12.0, run / 12.0);
    printf("The length of the ramp is %.1f feet.\n", ramp / 12.0);
    
} // end main
    
    
    
    
