// Name: Robert Vargas
// Date: 02/18/2021
// CS 273 - M80
// Input:  User input via the Serial Monitor. 3 hexadecimal integers from 00-99 for GENDER, AGE, BODY FAT PERCENTAGE.
// Output: Outputs a blinking or solid red, yellow, and/or green LED light on the breadboard based on the "healthy" body
//         fat percentage on the provided chart based on the inputed values for GENDER, AGE, and BODY FAT PERCENTAGE.
//         Once the addition function is called, the onboard pin 13 LED light turns on.
// Description: This code takes input for the a paitent's GENDER, AGE, and BODY FAT PERCENTAGE in order to correctly
//              place them in the proper spot in the body fat percentage chart provided, which states whether they are
//              UNDERWEIGHT/LOW (yellow), NORMAL (green), OVERWEIGHT/HIGH (red), or HEAVILY OVERWEIGHT/VERY HIGH (all lights solid).
//              This is done by branching if and jump statements that help guide the program to decide which lights to turn on based
//              on the patient's weight category and where they fall within it, and whether to blink the lights or not.
//
// Answers:
// Gender - Hex  | Age - Hex  | Body Fat - Hex  | Light
// ============================================================
// F      - 0x01 | 42  - 0x2a | 32       - 0x20 | GREEN (blink)
// M      - 0x02 | 25  - 0x19 | 48       - 0x30 | ALL   (solid)
// F      - 0x01 | 30  - 0x1e | 21       - 0x15 | GREEN (blink)
// M      - 0x02 | 23  - 0x17 | 17       - 0x11 | GREEN (blink)

   .data               // declare data variables
      .comm gender, 1  // handles the gender of the patient
      .global gender   
      .comm age, 1     // handles the age of the patient
      .global age
      .comm fat, 1     // handles the fat percentage of the patient
      .global fat
       
    .text                 // begin text code
      .global FatMonitor  // make FatMonitor() a global function

// Main Program
FatMonitor:

      ldi R21, 0 // no light
      ldi R22, 1 // blink by default

      lds R16, gender  // Female = 0x01, Male = 0x02
      cpi R16, 2       // jump to male
      breq male        // if R16 == 2

// Female Procedure
female:            
      lds R16, age    // load age into r16
      cpi R16, 20
      BRLT femaleu20  // if Female Age < 20
      
      // we have a female at least 20
      cpi R16, 40
      BRLT female2039 // if Female Age < 40
      
      // we have a female at least 40
      cpi R16, 60
      BRLT female4059 // if Female Age < 60
      
      // we have a female at least 60
      cpi R16, 80
      BRLT female6079 // if Female Age < 80
      
      // we have a female at least 80

// Females UNDER 20
femaleu20:  ldi R21, 0b00000000
            ldi R22, 0b00000000
            jmp lightup // no lights, bad data

// Females 20 - 39
female2039: lds R16, fat
            cpi R16, 21
            BRLT female2039low    // if Female Fat < 21
            cpi R16, 33
            BRLT female2039normal // if Female Fat < 33
            cpi R16, 39
            BRLT female2039high   // if Female Fat < 39
            jmp doall             // if Female Fat >= 39

female2039low:    jmp doyellow
female2039normal: jmp dogreen
female2039high:   jmp dored

// Females 40 - 59
female4059: lds R16, fat
            cpi R16, 23
            BRLT female4059low    // if Female Fat < 23
            cpi R16, 34
            BRLT female4059normal // if Female Fat < 34
            cpi R16, 40
            BRLT female4059high   // if Female Fat < 40
            jmp doall             // if Female Fat >= 40

female4059low:    jmp doyellow
female4059normal: jmp dogreen
female4059high:   jmp dored

// Females 60 - 79
female6079: lds R16, fat
            cpi R16, 24
            BRLT female6079low    // if Female Fat < 24
            cpi R16, 36
            BRLT female6079normal // if Female Fat < 36
            cpi R16, 42
            BRLT female6079high   // if Female Fat < 42
            jmp doall             // if Female Fat >= 42

female6079low:    jmp doyellow
female6079normal: jmp dogreen
female6079high:   jmp dored

// Male Procedure
male:
      lds R16, age // load age into r16
      cpi R16, 20
      BRLT maleu20  // if Male Age < 20
      
      // we have a male at least 20
      cpi R16, 40
      BRLT male2039 // if Male Age < 40
      
      // we have a male at least 40
      cpi R16, 60
      BRLT male4059 // if Male Age < 60
      
      // we have a male at least 60
      cpi R16, 80
      BRLT male6079 // if Male Age < 80
      
      // we have a male at least 80
      
// Males UNDER 20
maleu20:  ldi R21, 0b00000000
          ldi R22, 0b00000000
          jmp lightup // no lights, bad data

// Males 20 - 39
male2039: lds R16, fat
          cpi R16, 8
          BRLT male2039low    // if Male Fat < 8
          cpi R16, 20
          BRLT male2039normal // if Male Fat < 20
          cpi R16, 25
          BRLT male2039high   // if Male Fat < 25
          jmp doall           // if Male Fat >= 25

male2039low:    jmp doyellow
male2039normal: jmp dogreen
male2039high:   jmp dored

// Males 40 - 59
male4059: lds R16, fat
          cpi R16, 11
          BRLT male4059low    // if Male Fat < 11
          cpi R16, 22
          BRLT male4059normal // if Male Fat < 22
          cpi R16, 28
          BRLT male4059high   // if Male Fat < 28
          jmp doall           // if Male Fat >= 28

male4059low:    jmp doyellow
male4059normal: jmp dogreen
male4059high:   jmp dored

// Males 60 - 79
male6079: lds R16, fat
          cpi R16, 13
          BRLT male6079low    // if Male Fat < 13
          cpi R16, 25
          BRLT male6079normal // if Male Fat < 25
          cpi R16, 30
          BRLT male6079high   // if Male Fat < 30
          jmp doall

male6079low:    jmp doyellow
male6079normal: jmp dogreen
male6079high:   jmp dored


// Color Operations - Sets R21 to the proper colored LED's bit address
dogreen:  ldi R21, 0b00100000
          jmp lightup

doyellow: ldi R21, 0b00010000
          jmp lightup

dored:    ldi R21, 0b00000001
          jmp lightup

doall:    ldi R21, 0b00110001
          ldi R22, 0 // sets blinking to FALSE
          jmp lightup



lightup:   // Initiates LED Lighting Sequence
      ldi  r18, 0b00110001
      out  0x04, r18   ; 0x04 is I/O address of DDRB

      // we now have to decide if we are going to blink or not
      cpi  r22, 1  // if blink is TRUE
      breq doblink // do blink

      // else, stay solid
      out  0x05, r21   ; 0x05 is I/O address of PORTB
      ret

doblink:     // blink the lights on and off using r21 as the sequence

      ldi    r16, 25   // for R16 = 25..0 do the following code
all:  mov    r17, r21  // changed to allow for dynamic input
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
