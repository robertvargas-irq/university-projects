// Name: Robert Vargas
// Date: 01/26/2021
// CS 273 - M80
// Description: This code turns on the LED light on pin 13 on and off 25 times
//              and fully implements the pseudo-code described in Lab1.ino
// Input: (N/A) No input from user
// Output: Onboard LED light blinks (pin 13)

    .file "test.S"

    // Start the code section(text section)
    .text
    .global testf // we are making our entry point accessable from the C side interface
testf:
      ldi    r17, 0x20 // set up number - r17 = 0x20 (0010-0000)
      out    0x04, r17 // tells the hardware that pin 13 is output
      ldi    r16, 25   // for R16 = 25..0 do the following code
      
all:  ldi    r17, 0x20 // turn on the lights
      out    0x05, r17 // light is on

      ldi    r20, 10   // for  10 times
d11a: ldi    r18, 0xff // for 255 times
dl1:  ldi    r19, 0xff // for 255 times
dl2:  nop // do nothing for 4 operations
      nop
      nop
      nop
      dec    r19  // decrement inner loop by 1
      brne   dl2  // check if not equal to zero, then jump to dl2 if so
      dec    r18  // decrement outer loop by 1
      brne   dl1  // check if not equal to zero, then jump to dl1 if so
      dec    r20  // decrement extra outer loop by 1
      brne   d11a // check if not equal to zero, then jump to d11a if so
      
      ldi    r17, 0x00  // turn off light
      out    0x05, r17  // light is off

      ldi    r20, 10    // extra loop that runs 10 times
d13a: ldi    r18, 0xff  // waits a total of 10 * 255 * 255 * 4 * nops
dl3:  ldi    r19, 0xff  
dl4:  nop // do nothing for 4 operations
      nop
      nop
      nop
      dec    r19  // decrement inner loop by 1
      brne   dl4  // check if not equal to zero, then jump to dl4 if so
      dec    r18  // decrement outer loop by 1
      brne   dl3  // check if not equal to zero, then jump to dl3 if so
      dec    r20  // decrement extra outer loop by 1
      brne   d13a // check if not equal to zero, then jump to d13a if so
      
      dec    r16 // decrement the initial "master" loop, which dictates how many times the LED turns on and off
      brne   all // if the main loop is not equal to zero, jump back to the 'all' flag and start the process again
      ret        // return
    
