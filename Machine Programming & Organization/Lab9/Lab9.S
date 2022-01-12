// Name: Robert Vargas
// Date: 04/27/2021
// CS 273 - M80
// Input:       Arduino Generic Ultrasonic Sensor - "echo"
// Output:      The time it took for the "echo" from the sensor to reach an object then return
//              in milliseconds.
// Description: This program calls an AVR routine to send an echo from the sensor, then check
//              to see if the echo flag has returned back down to 0, indicating that the
//              ping has returned. The boolean result is then passed back through the global variable pinbstate,
//              then returns from all. This file also turns on the ultrasonic sensor by setting trigpin to output
//              and echopin to input via bit manipulation and setting each receiving pin.

//  1)  Take 5 different distance measurements noting the exact distance.  Report these values. 
//        1] 1 inch -----> 150 microseconds
//        2] 5 inches ---> 748 microseconds
//        3] 8 inches ---> 1224 microseconds
//        4] 10 inches --> 1486 microseconds
//        5] 12 inches --> 1792 microseconds
//
//  2)  Calculate how many microseconds one foot is.  Show your work
//        One foot is 1792 microseconds, given by the measured distance of a foot from the device.
//
//  3)  What is the minimum and maximum effective measuring distance of the device?  Provide a link along with your answer
//        The minimum effective measuring distance of the device is 1 inch.
//        The maximum effective measuring distance of the device is 13 feet (156 inches).
//          Source: https://www.tutorialspoint.com/arduino/arduino_ultrasonic_sensor.htm#:~:text=The%20HC%2DSR04%20ultrasonic%20sensor,or%201%E2%80%9D%20to%2013%20feet.
//  4)  Is it possible for our ISR to be interrupted with another PINB, pin 1 state change? 
//        Yes, it is possible for our ISR to be interrupted by another PINB state change, creating a nested interrupt.

// Setting constants for ultrasonic sensor 
  .set trigpin, 4; port c pin 4
  .set echopin, 1; port b pin 1
  .set PINB, 0x03
  .set DDIRB, 0x04
  .set DDIRC, 0x07
  .set PORTC, 0x08

.data

   .comm pinbstate, 1
   .global pinbstate ; used to store the current state of PINB

.macro pushall
  push r16
  push r17
  push r18
  push r19
  push r20
  push r21
  push r22
  push r23
  push r24
  push r25
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
  pop r25
  pop r24
  pop r23
  pop r22
  pop r21
  pop r20
  pop r19
  pop r18
  pop r17
  pop r16
.endm ; of popall

.text
   .global ultrasensor
   .global readPINBState
   .extern delay

// Setup the ultrasonic sensor to send an echo
ultrasensor:

 // Set trig pin to output and echo pin to input
  SBI DDIRC, trigpin
  CBI DDIRB, echopin

 // Trig pin is low for 2 microseconds
  CBI PORTC, trigpin
  CALL delay2

 // Trig pin is high for 10 microseconds
  SBI PORTC, trigpin
  CALL delay10

 // Finally set trig pin to low, this will send an echo
  CBI PORTC, trigpin

  ret  // ret from ultrasensor

readPINBState:
 // Routine to look at the echo pin and set "pinbstate" the global variable to 1 or 0 based on the pin

    pushall
    
    // Read PINB in a register, we want to see if the echo pin has been set
    IN R20, PINB
    ANDI R20, 1 << echopin 

    // If the echo pin has been set, it means that the echo has been sent, store 1 in 'pinbstate'
    CPI R20, 1 << echopin
    BREQ truelabel

    // If the echo pin has been cleared, it means that the echo might have come back, store 0 in 'pinbstate'
falselabel: // store 0, echo has returned
    LDI R20, 0
    STS pinbstate, R20
    jmp done
    
truelabel:  // store 1, echo has been sent
    LDI R20, 1
    STS pinbstate, R20

done: // return from checking the state of PINB
    popall
    ret

delay10: // call a 10 microsecond delay
      pushall
      LDI R22, 0x0A
      LDI R23, 0x00
      LDI R24, 0x00
      LDI R25, 0x00
      CALL delay    // call AVR subroutine delay
      popall
      ret

delay2:  // call a 2 microsecond delay
      pushall
      LDI R22, 0x02
      LDI R23, 0x00
      LDI R24, 0x00
      LDI R25, 0x00
      CALL delay    // call AVR subroutine delay
      popall
      ret

  
