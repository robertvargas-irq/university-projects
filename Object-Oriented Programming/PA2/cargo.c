// CS 271 - M04 – PA 2
// Program name: cargo.c
// Author:       Robert Vargas
// Date:         2/11/2021
// Purpose:      This program calculates the max weight that a
//               cargo ship can hold based on user-defined
//               input values for both the max weight that can
//               be held, and the individual weights of the subsequent
//               containers. Once the max weight is reached, the
//               program prints how many containers were able to fit the
//               cargo ship, the weight of all the containers, and the
//               max weight inputted by the user.

#include <stdio.h>
#include <math.h>

int main( void ) {
    
    int containers;
    float currentContainer;
    float maxWeight;
    float totalWeight;
    float loadedWeight;
    
    // take user input for the ship's max weight capacity
    printf("Please input the ship's total weight capacity (in Tons):\n");
    scanf("%f", &maxWeight);
    
    // take positive user input for each individual shipping container
    totalWeight = 0;
    loadedWeight = 0;
    containers = 0;
    while (totalWeight < maxWeight) {
        
        printf("Please input the weight of the shipping container (in Tons):\n");
        scanf("%f", &currentContainer);
        
        // checks for positive number
        if ( currentContainer > 0 ) {
            
            totalWeight += currentContainer;
            
            // set the real weight in the ship if it does not overflow
            if ( totalWeight <= maxWeight ) {
                
                loadedWeight = totalWeight;
                containers++;
                
            } // end if
        } // end if
        
        
    } // end while
    
    printf("The ship is full.\n");
    printf("=================\n");
    printf("Ship's Weight Capacity: %.1f tons\n", maxWeight);
    printf("%d containers were loaded.\n", containers);
    printf("Total Weight Loaded: %.1f tons\n", loadedWeight);
    
} // end main
