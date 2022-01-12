// Name: Robert Vargas
// Date: 03/04/2021
// CS 273 - M80
// Input:       User input from Lab4.ino via the Serial Monitor which is a string of binary
//              numbers each representing a different letter/number in Morse Code.
// Output:      The output is a translated Morse Code sequence that outputs to the Serial Monitor.
//              based on user input into the Serial Monitor.
// Description: This program translates the inputted string of binary numbers via the Serial
//              Monitor, decoding it back into its Roman character counterparts based on the
//              input of 1's (dashes) and 0's (dots), all by sorting through three parallel arrays
//              to find the matching binary sequence and length to the ASCII letter or number.



# MorseCode.S
# March 4, 2020

#--------------------------------------------------------------------
    .data
morse_table: # binary representation of Morse code: 0: dot; 1: dash
    .byte 0b01, 0b1000, 0b1010, 0b100, 0b0, 0b0010, 0b110, 0b0000, 0b00, 0b0111, 0b101, 0b0100, 0b11, 0b10, 0b111, 0b0110, 0b1101, 0b010, 0b000, 0b1, 0b001, 0b0001, 0b011, 0b1001, 0b1011, 0b1100, 0b01111, 0b00111, 0b00011, 0b00001, 0b00000, 0b10000, 0b11000, 0b11100, 0b11110, 0b11111
morse_width: # the number of binary digits in each character
    .byte 2, 4, 4, 3, 1, 4, 3, 4, 2, 4, 3, 4, 2, 2, 3, 4, 4, 3, 3, 1, 3, 4, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5
ascii_table: # the English symbols encoded by the above Morse code 
    .byte 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
table_length:
    .byte 36

    .comm val, 1
    .comm width, 1
    .comm ascii, 1
    .global val, ascii, width

#---------------------------------------------------------------------
    .text
    .global decode_morse

decode_morse:
    push R31
    push R30
    push R29
    push R28
    push R27
    push R26
    push R17
    push R16
    
    LDI R31, hi8(morse_table) ; initialize high byte of Z
    LDI R30, lo8(morse_table) ; initialize low byte of Z
    LDI R29, hi8(ascii_table) ; initialize high byte of Y
    LDI R28, lo8(ascii_table) ; initialize low byte of Y
    LDI R27, hi8(morse_width) ; initialize high byte of X
    LDI R26, lo8(morse_width) ; initialize low byte of X

    # ENTER YOUR CODE BELOW

loop:   // this function loops through the parallel arrays to find the
        // correct ASCII value based on the morse value and width
        
        LDS R20, val   // store val into R20
        LDS R21, width // store width into R21
        LD R16, Z+     // get a copy of morse_table[i]
        LD R17, X+     // get a copy of morse_width[i]
        LD R18, Y+     // get a copy of ascii_table[i]
        
        CP R16, R20    // if ( morse_table[i] == val ) continue
        BRNE increment // else increment R16, R17, and R18
        CP R17, R21    // if ( morse_width[i] == width ) continue
        BRNE increment // else increment R16, R17, and R18
        
        // if ( morse_table[i] == val ) && ( morse_width[i] == width )
        STS ascii, R18 // store ascii_table[i] into the global value ascii
        rjmp done      // finish and return

increment:  // increment R16, R17, and R18 to get the next values in the parallel arrays
            inc R16
            inc R17
            inc R18
            rjmp loop
    
done: // pop all and return
      pop R16
      pop R17
      pop R26
      pop R27
      pop R28
      pop R29
      pop R30
      pop R31
      RET
