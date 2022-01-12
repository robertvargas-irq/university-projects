// Name: Robert Vargas
// Date: 04/13/2021
// CS 273 - M80
// Input:       Two-digit user-inputted hexadecimal number via the Serial monitor.
// Output:      The sum of the user-inputted number of every number up to that number.
// Description: This program takes input from the Serial monitor, a two-digit hexadecimal
//              number and takes the sum of every number leading up to, and including, that
//              number that was inputted by the user. The assembly code in this file implements
//              the following C pseudo-code:

// Pseudo-code:
//
// int N;
// int SUM = 0;
// 
// get user input;
// store in N;
// 
// while ( N > 0 ) {
//   SUM = SUM + N;
//   N--;
// }

.data
  .comm N, 1
  .global N
  .comm SUM, 2
  .global SUM

.text
  .global SumOfN

SumOfN: // driver program
        push R16
        push R17
        push R18
        push R19
        push R20
        push R30
        push R31

        // clear registers to store summation into
        CLR R16 // this is the low-byte of our new SUM
        CLR R17 // this is the high-byte of our new SUM
        CLR R18 // clear R18 for our N input value

        // initialize our counter with user input N
        LDS R18, N  // initialize our counter with the "low byte" N
        LDI R19, 0  // set the "high byte" of N to zero to match the 2 bytes of SUM

        // initialize the Z register with pointer to SUM
        LDI R31, hi8(SUM)
        LDI R30, lo8(SUM)

loop:   // main loop
        ADD R16, R18 // add low-byte (N) to R16
        ADC R17, R19 // add 0 plus the carry (overflow) of N to R17

        CPI R18, 0   // if ( R18 == 0 ) finish and jump to finish
        BREQ finish
        DEC R18      // else decrement our N value and loop around
        rjmp loop

finish: // finish and store the values back into Z (pointer to SUM)
        ST Z+, R16  // store low-byte R16 into Z+
        ST Z, R17   // store low-byte R17 into Z

        pop R31
        pop R30
        pop R20
        pop R19
        pop R18
        pop R17
        pop R16
        
        ret
