// Name: Robert Vargas
// Date: 05/04/2021
// CS 273 - M80
// Input:       User input via the Serial Monitor.
// Output:      The sum of both arrays A and B from user input of length N.
// Description: This AVR routine sums up the user input from the shared variables. The user
//              first inputs N, the length of both arrays (with a maximum of 20),
//              then, the user is prompted to enter array A, then array B, in which
//              the AVR routine then sums up those shared variables, storing the result
//              of A[i] + B[i] in C[i], then returns the sum direct from the function.
//              Finally, the program displays arrays A and B, then result C, then the sum
//              calculated both in the .INO C code and the AVR routine.

.data
  .comm N, 1
  .comm A, 20
  .comm B, 20
  .comm C, 40
  .global N, A, B, C

.text
  .global sumit

.macro pushall
  push r16
  push r17
  push r18
  push r19
  push r20
  push r21
  push r22
  push r23

  push r26
  push r27
  push r28
  push r29
  push r30
  push r31
.endm ; of pushall

.macro popall
  pop r31
  pop r30
  pop r29
  pop r28
  pop r27
  pop r26
  
  pop r23
  pop r22
  pop r21
  pop r20
  pop r19
  pop r18
  pop r17
  pop r16
.endm ; of popall

sumit:

  pushall
  
  LDI R31, hi8(C) // Z will be C
  LDI R30, lo8(C)
  
  LDI R29, hi8(B) // Y will be B
  LDI R28, lo8(B)

  LDI R27, hi8(A) // X will be A
  LDI R26, lo8(A)

  // method which adds up A and be and places into C
  // it also calculates and returns the sum of A and B

  // R24 has the value of N
  MOV R20, R24

  CLR R24 // set up the return values for sumit
  CLR R25

  CLR R0  // this will be my permanent register with 0 in it

loop:
      CPI R20, 0 // if we are out of elements, go to done
      BREQ done

      LD R16, X+  // store A[i] and B[i] in R16 and R18
      LD R18, Y+
      CLR R17     // extra register for carry
      
      ADD R16, R18  // this takes care of adding up A[i] + B[i]
      ADC R17, R0 
      
      ADD R24, R16  // this stores the results into the RETURN value
      ADC R25, R17

      // R16 is low byte for C, and R17 is high byte for C
      ST Z+, R16  // store A[i] + B[i] into C[i]
      ST Z+, R17
      DEC R20     // decrement our loop
      rjmp loop   // loop

done:     // finish
  popall  // popall
  ret     // from sumit
