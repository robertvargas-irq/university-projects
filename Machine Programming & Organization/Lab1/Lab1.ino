// Name: Robert Vargas
// Date: 01/26/2021
// CS 273 - M80
// Description: This code turns on the LED light on pin 13 on and off 25 times
// Input: (N/A) No input from user
// Output: Onboard LED light blinks (pin 13)
 
/* This lab implements the following pseudo code algorithm:

  for (numTimes = 25; numTimes > 0; numTimes--) {
    
    turn on LED light;

    for (extraHoldOuter = 10; extraHoldOuter > 0; extraHoldOuter--) {
      for (holdOuter = 255; holdOuter > 0; holdOuter--) {
        for (holdInner = 255; holdInner > 0; holdInner --) {
          wait 4 cycles;
        }
      }
    }

    turn off LED light;

    for (extraHoldOuter = 10; extraHoldOuter > 0; extraHoldOuter--) {
      for (holdOuter = 255; holdOuter > 0; holdOuter--) {
        for (holdInner = 255; holdInner > 0; holdInner--) {
          wait 4 cycles;
        }
      }
    }
  }

*/

extern "C" { void testf(); } // declare external global function

void setup() {
  // put your setup code here, to run once:
  testf(); // run testf() method
}

void loop() {
  // put your main code here, to run repeatedly:

}
