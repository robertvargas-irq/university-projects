// Name: Robert Vargas
// Date: 04/06/2021
// CS 273 - M80
// Input:       Analog photoresistor current.
// Output:      The detected light intensity input displayed within the Serial Monitor.
// Description: This program takes input from the photoresistor on the breadboard,
//              connected to the analog input A2 on the Arduino board, and reads
//              the analog input from the photoresistor. This program parses the input
//              by instructing the Arduino board to convert the analog input into
//              digital by setting the 6th bit of ADCSRA to 1, effectively starting the
//              conversion, then taking the high byte result in ADCH, then returning that
//              to the original function call in the C code.

//
// QUESTION ANSWERS
//
// 1. What was the lowest value you saw from the photoresistor?
//    0 was the lowest value.
//
// 2. What was the highest value you saw from the photoresistor?
//    0xFA was the highest value (250) when shining a light directly atop it.
//
// 3. Our A/D conversion mechanism has the ability to create 1024 distinct values, why did your output not have 1024 values?
//    This is due to the fact that we are only using 8 bits instead of using the full 10-bit value, leaving us with only
//    a one-byte value with 256 discrete values to read from. We are rounding off from 10 bits down to 8 bits, the lower 2 bits
//    in the 10-bit value shuffled off to a second byte and ignored, then shifting our focus to using the upper 8 bits ONLY as
//    the 1-byte value.
//    This is done through the ADMUX flag, in which we set ADLAR (Left Adjust Result) to 1, causing the high 8 bits of the result
//    to be in ADCH (high byte) and the lowest 2 in ADCL (low byte).
//
    
    .equ ADCL, 0x0078
    .equ ADCH, 0x0079
    .equ ADCSRA, 0x007A
    .equ ADCSRB, 0x007B
    .equ ADMUX, 0x007C
    .equ DDIR0, 0x007E
    .equ ADSC, 6 // bit 6 on the ADCSRA
  .text
    .global initAD
    .global readAD

initAD:  // routine which initializes the A/D lines     
      push R16
      LDI R16, 0b11111111 // turns off all buffers in DDIR0
      STS DDIR0, R16
      // ADEN to 1 (turn on A/D, ADPS2-0 to 111 (divide system clock by 128, and the rest of bits to 0)
      LDI R16, 0b10000111
      STS ADCSRA, R16
      pop R16

      ret // of initAD

readAD:
    // Reading a value :
    // - In ADMUX, set REFS1-REFS0 to 01 (this selects +5V as the reference), ADLAR to 1 (left adjust the
    //   output bits), and MUX3-0 to the 4 bits that denote the desired input pin (e.g., pin 3 would be 0011);
    // - In ADCSRA, set ADSC to 1 to start a conversion;
    // - In a loop, read ADSC until it reads 0;
    // - Fetch result byte from ADCH; ignore the lowest 2 A/D bits that are in ADCL
     
    // routine which has one parameter in r24
    // and then reads the A/D signal and places the result
    // into r24, clearing r25
    // we need to set up the ADMUX and ADSCSRA and then
    // wait on ADSC
    
    push R16
    push R17
    LDI R16, 0b01100000 // set the proper ADMUX bit values as described above
    ADD R16, R24        // R24 contains the argument passed in C for readAD(byte)
    STS ADMUX, R16      // stores the new value of ADMUX
    LDS R17, ADCSRA     // fetches ADCSRA to modify
    ORI R17, 0b01000000 // sets ADSC bit to 1, starts the conversion
    STS ADCSRA, R17     // stores the new value of ADCSRA
loop:
    LDS R17, ADCSRA       // fetch ADCSRA
    ANDI R17, 0b01000000  // check if the 6th byte is 0
    BRNE loop             // if not return to loop

    LDS R24, ADCH  // store the high byte of the resulting analog value
    CLR R25        // clear R25 (high byte of the return value)

    pop R17
    pop R16
    ret            // we have our result, we are done
 
