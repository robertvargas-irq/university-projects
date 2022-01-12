// Name: Robert Vargas
// Date: 02/02/2021
// CS 273 - M80
// Input:  User input via the Serial Monitor. 3 integers from 00-99.
// Output: Outputs x3 to the Serial Monitor, which is the sum of (2 * (x1 + 1) + (x2 - 1) + (x3 - 3)).
//         Once the addition function is called, the onboard pin 13 LED light turns on.
// Description: This code fully implements the addition() pseudo-code described in Lab2.ino

#
# Global data (x1, x2, and x3)
#
    .data
    .comm x1,1
    .global x1
    .comm x2,1
    .global x2
    .comm x3,1
    .global x3

#
# Program code (addition function)
#
    .text
    .global addition
    
addition:           // x3 = 2 * (x1 + 1) + (x2 - 1) + (x3 - 3)

// load registers

    lds  r18, x1  // loads x1 into r18
    lds  r19, x2  // loads x2 into r19
    lds  r20, x3  // loads x3 into r20

// perform x3 = 2 * (x1 + 1) + (x2 - 1) + (x3 - 3)

    inc  r18      // (x1 = x1 + 1)
    add  r18, r18 // (x1 = x1 + x1) or (x1 = 2 * x1)

    dec  r19      // (x2 = x2 - 1)
    
    dec  r20      // (x3 = x3 - 3)
    dec  r20
    dec  r20

                  // x3 = 2 * (x1 + 1) + (x2 - 1) + (x3 - 3)
    add  r18, r19 // adds r19 into r18 (x1 = x2 + x1)
    add  r18, r20 // adds r20 into r18 (x1 = x3 + x1)
    
    sts  x3, r18  // sets the value of x3 to r18

// turn on the light

    ldi  r18, 0x20  // assign hex 0x20 to r18
    out  0x04, r18  // outputs r18 to bit 5 address 0x04
    out  0x05, r18  // turns on the light
    
    ret             // return
    
