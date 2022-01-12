// Name: Robert Vargas
// Date: 03/04/2021
// CS 273 - M80
// Input:       Two digit decimal user input from the Serial Monitor from Lab4.ino stored in howmany.
// Output:      Blinking "GOAGGIES" in Morse Code via the PIN13 light the desired amount of times.
// Description: This program takes the user input from Lab4.ino via the Serial Monitor, a 2
//              digit decimal which will dictate how many times the PIN13 light will flash
//              "GOAGGIES" in Morse Code. This assembly file fully implements the goaggies()
//              function from Lab4.ino, and tells the light on PIN13 how many times to flash
//              the Morse Code sequence.


        
        .extern delay
.data
        .comm howmany, 1
        .global howmany
        
.text
        .global goaggies
        
goaggies:

        // we need to know what the value was
        push R16
        LDS R16, howmany
loop:   CPI R16, 0  // implements while ( R16 > 0 ) {
        BREQ out
        
        call G
        call O
        call A
        call G
        call G
        call I
        call E
        call S
        dec R16
        rjmp loop

out:    // ends while ( R16 > 0 )
        pop R16
        ret ;; of go aggies

G:      call LONG // Generate the G
        call LONG
        call SHORT
        call WAIT
        ret       // END LETTER G

O:      call LONG // Generate the O
        call LONG
        call LONG
        call WAIT
        ret       // END LETTER O

A:      call SHORT // Generate the A
        call LONG
        call WAIT
        ret        // END LETTER A

I:      call SHORT // Generate the I
        call SHORT
        call WAIT
        ret        // END LETTER I

E:      call SHORT // Generate the E
        call WAIT
        ret        // END LETTER E

S:      call SHORT // Generate the S
        call SHORT
        call SHORT
        call WAIT
        ret        // END LETTER S


LONG:   // long blink
        push R17
        ldi R17, 0x20  // turn on the light
        out 0x04, R17  //
        out 0x05, R17  //
        
        call WAIT
        call WAIT
        
        ldi R17, 0     // turn off the light
        out 0x05, R17  //
        
        call WAIT
        
        pop R17
        ret            // END LONG

SHORT:  // short blink
        push R17
        ldi R17, 0x20  // turn on the light
        out 0x04, R17  //
        out 0x05, R17  //

        call WAIT
        
        ldi R17, 0     // turn off the light
        out 0x05, R17  //

        call WAIT
        
        pop R17
        ret            // END SHORT

WAIT:   // calls an external method called delay, and waits 160ms
        push r22
        push r23
        push r24
        push r25
        
        ldi  r22, 0xa0 // wait 160ms
        ldi  r23, 0x00
        ldi  r24, 0x00
        ldi  r25, 0x00
        
        call delay // uses a system clock
        
        pop r25
        pop r24
        pop r23
        pop r22
        ret
