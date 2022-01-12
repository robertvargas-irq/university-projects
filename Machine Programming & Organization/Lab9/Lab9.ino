// Name: Robert Vargas
// Date: 04/27/2021
// CS 273 - M80
// Input:       Arduino Generic Ultrasonic Sensor - "echo"
// Output:      The time it took for the "echo" from the sensor to reach an object then return
//              in milliseconds.
// Description: This program calls an AVR routine to send an echo from the sensor, then record
//              the time it took for the echo flag to return back down to 0, indicating that the
//              ping has returned. The flag is checked through an interrupt routine, in which it
//              checks for when the echo flag returns back to 0, then subtracts the initial echo
//              sent time from the current time, then prints the milliseconds.

#include <avr/interrupt.h>
long start_time;
long totduration;
extern byte pinbstate;

extern "C" {
  void ultrasensor();
  void readPINBState();
}

void setup()
{
  Serial.begin(9600);
  
  /*
   * Set the bits of the appropriate PCMSKx register high
   * to enable pin change detection on PB1 (port b pin 1). 
   * PCINT1 in our case.
   */
  PCMSK0 = (1<<PCINT1);

  // Enable the corresponding vector, PCIE0 in our case.
  PCICR = (1<<PCIE0);

  // Enable the interrupt flag
  sei();
  
}

void loop()
{
  ultrasensor();
  delay(1000); // delay a second
  Serial.println("*");
}

/*
 * The interrupt service routine that would activate on 
 * a value change of PB1
 */
ISR(PCINT0_vect)
{
  /* The echo pin is changed twice
   * 1. First echo pin is set, this is when the echo is sent,
   * record start time in microseconds
   * 2. Then echo pin is cleared, this is when the echo came
   * back, record the end time now.
   */

   // Read the pin b state to know if its 0 or 1
   readPINBState();

   if(pinbstate == 1)
    start_time = micros();

   if(pinbstate == 0)
   {
     // subtract the start time from the current time to find delta time
     totduration = micros() - start_time;
     Serial.print("Total time : ");
     Serial.println(totduration, DEC);

     // 746 is roughly 5 inches by dividing 1792ms by 12, then multiplying by 5
     // also, check to ensure that the sensor is not too close
     if ( totduration <= 746 )
      Serial.println("Too close!");
     else
      Serial.println("Safe distance");
   }
}
