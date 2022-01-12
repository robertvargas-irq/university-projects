// CS 271 - M04 – PA 2
// Program name: pattern.c
// Author:       Robert Vargas
// Date:         2/11/2021
// Purpose:      This program prints a dynamically-growing diamond-shaped
//               design onto the console, with the size being dictated by
//               user input. The user is prompted to input the amount of
//               lines desired for the diamond shape to occupy.

#include <stdio.h>
#include <math.h>

int main( void ) {
    
    int lines;
    int row;
    int column;
    
    printf("Enter how many lines you would like for a diamond pattern:\n");
    scanf("%d", &lines);
    
    // filters out line requests less than 3
    if ( lines > 2 ) {
        
        // checks to see if the line number is ODD
        if ( lines % 2 != 0 ) {
            // handles the line number (row)
            for ( row = 0; row < lines; row++ ) {
                
                // handles the space in the line (column)
                for ( column = 0; column < lines; column++ ) {
                    // top and bottom points
                    if ( row == 0 || row == lines - 1 )
                        if ( column == lines / 2 )
                            printf("*");
                        else
                            printf(" ");
                    // midpoint
                    else if ( row == lines / 2 || row == lines - 1 / 2 )
                        if ( column == 0 || column == lines - 1 )
                            printf("*");
                        else
                            printf(" ");
                    // in-betweens
                    else {
                        // ABOVE the midpoint
                        if ( row < lines / 2 ) {
                            if ( column == ( lines / 2 - row ) || column == lines - ( lines / 2 - row ) - 1 )
                                printf("*");
                            else
                                printf(" ");
                        } // end if (above the midpoint)
                        // BELOW the midpoint
                        else {
                            if ( column == -( lines / 2 - row ) || column == lines - ( row - lines / 2 ) - 1 )
                                printf("*");
                            else
                                printf(" ");
                        } // end if (below the midpoint)
                    } // end else (in-betweens)
                } // end for (columns)
                        
                printf("\n");
                
            } // end for (rows)
        } // end if (odd number of lines)
        
        // checks to see if the entered number is EVEN
        else {
            // handles the line number (row)
            for ( row = 0; row < lines; row++ ) {
                
                // handles the space in the line (column)
                for ( column = 0; column < lines; column++ ) {
                    // top and bottom points
                    if ( row == 0 || row == lines - 1 )
                        if ( column == lines / 2 - 1 )
                            printf("*");
                        else
                            printf(" ");
                    // midpoint
                    else if ( row == lines / 2 - 1 || row == lines / 2 )
                        if ( column == 0 || column == lines - 2 )
                            printf("*");
                        else
                            printf(" ");
                    // in-betweens
                    else {
                        // ABOVE the midpoint
                        if ( row < lines / 2 - 1 ) {
                            if ( column == ( lines / 2 - row ) - 1 || column == lines - ( lines / 2 - row ) - 1 )
                                printf("*");
                            else
                                printf(" ");
                        } // end if (above midpoint)
                        // BELOW the midpoint
                        else if ( row > lines / 2 ) {
                            if ( column == -( lines / 2 - row ) || column == lines - ( row - lines / 2 ) - 2 )
                                printf("*");
                            else
                                printf(" ");
                        } // end if (below midpoint)
                    } // end else (in-betweens)
                } // end for (columns)
                        
                printf("\n");
                
            } // end for (rows)
        } // end else (even number of lines)
    } // end if (line filter)
    
} // end main
