// Name: Robert Vargas
// Date: 03/11/2021
// CS 273 - M80
// Input:       N/A
// Output:      LED 4x7 monitor. Display 0 through 9 on the display in different corresponding
//              segments.
// Description: This program experiments with the 4x7 LED display in order to switch between the
//              different segments, displaying the numbers 0 through 9 in choronological order
//              one segment at a time, starting at the left with 0, then the next segment at 1,
//              the following at 2, then the next at 3, then 4 starting back over at the first
//              segment.

//   The basic algorithm is to have the main loop set some shared variable values
//   we then use simulataneous arrays (vectors) to figure out which segment is desired 
//   and which sequence is needed.
//
//   Since our setup utilizes PORTB and PORTB, then we need to main
//   simulataneous vectors for all of the segment sequences that are neededed.
//
//   The main routine does setup_ports once.
// 
//   C code to do the following:
//
//   segment=0
//   digit=9
//   display_segment();; will display 9 on segment 0, for example
//
  
  .data
     .size segment_table, 4
     .size portb_table, 10
     .size portd_table, 10

// arrays
segment_table:  #binary for seting input on PORTB for segment select
    .byte 0b00011100, 0b00011010, 0b00010110, 0b00001110
    ;; 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
portb_table:  # list of binary sequences for setting port B to be ORed with segment table ite
    .byte  0, 0, 1, 1, 1, 1, 1, 0, 1, 1
portd_table: # list of binary sequences for setting port D.
    .byte  0b11111110,0b00011000,0b01101100,0b00111100,0b10011000,0b10110100,0b11110100,0b00011100,0b11111100,0b10011100
segmentv: .byte 1


  
  .comm segment, 1 ;; the common name for segment
  .comm digit, 1   ;; the digit into our sequences
  .global segment, digit

  

# --------
  .text
     .global setup_ports
     .global display_segment


setup_ports:  // routine to set the ports into output mode

   push R16
   LDI R16, 0b00011111 // set PORT B
   OUT 0x04, R16
   LDI R16, 0b11111100 // set PORT D
   OUT 0x0A, R16
   pop R16
   ret



display_segment:   // main entry point for setting the segment

   ;; the goal is the use "digit" to and "segment" to find the values that need
   ;; to be sent to PORTB and PORTD 

   push R31
   push R30
   push R29
   push R28
   push R19
   push R18
   push R17
   push R16

   LDI R31, hi8(segment_table) // Z regester has the pointer to segment_table
   LDI R30, lo8(segment_table)

   LDS R16, segment

loop:   LD R17, Z+
        CPI R16, 0
        BREQ next
        DEC R16
        rjmp loop

next:   out 0x05, R17  // we should now have PORT B set for segment selection

   LDI R31, hi8(portb_table)
   LDI R30, lo8(portb_table)  // register Z
   LDI R29, hi8(portd_table)
   LDI R28, lo8(portd_table)  // register Y

   LDS R16, digit

dloop:   LD R18, Z+  // R18 is B table
         LD R19, Y+  // R19 is D table
         CPI R16, 0
         BREQ doit
         dec R16
         rjmp dloop

doit:    // we have R17 and R18 for B, we have R19 for D
   OR R17, R18

   out 0x05, R17  // we should now have PORT B set for segment selection
   out 0x0B, R19

   pop R16
   pop R17
   pop R18
   pop R19
   pop R28
   pop R29
   pop R30
   pop R31


   ret ;; of display_segment
    
