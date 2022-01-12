// CS 271 - M04 – PA 1
// Program name: ball.c
// Author:       Robert Vargas
// Date:         2/3/2021
// Purpose:      This program calculates the amount of rubber needed for
//               a hollow rubber ball with a specified interior and exterior
//               diameter. It takes input from the user to give the diameter
//               of the interior hollow space, and the diameter of the
//               entire ball, then calculates the rubber needed for the ball.

#include <stdio.h>
#include <math.h>

int main( void ) {
    
    // Important equations
    // V = (4/3) * pi * r^3
    // pi = M_PI
    
    // declare variables
    double exterior, interior, exteriorVolume, interiorVolume, rubberVolume;
    
    // get user input
    printf("Please input the exterior diameter of the ball in inches. (Decimal values are accepted)\n");
    scanf("%lf", &exterior);
    
    printf("Please input the interior diameter of the ball in inches. (Decimal values are accepted)\n");
    scanf("%lf", &interior);
    
    // ensures that exterior is greater than the interior
    if (exterior <= interior)
        return printf("Exterior diameter must be larger than the interior diameter.\n");
    
    // evaluate the volume for both the interior and exterior
    exteriorVolume = ( 4.0 / 3.0 ) * M_PI * pow( exterior / 2.0, 3 );
    interiorVolume = ( 4.0 / 3.0 ) * M_PI * pow( interior / 2.0, 3 );
    
    rubberVolume = exteriorVolume - interiorVolume;
    
    // display results
    printf("The amount of rubber needed for the ball with the given dimensions is %.2f cubic inches.\n", rubberVolume);
    
} // end main
