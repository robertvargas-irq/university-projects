// Name: Robert Vargas
// Date: 02/02/2021
// CS 273 - M80
// Input:       User input via the Serial Monitor. 3 integers from 00-99.
// Output:      Outputs x3 to the Serial Monitor, which is the sum of (2 * (x1 + 1) + (x2 - 1) + (x3 - 3)).
//              Once the addition function is called, the onboard pin 13 LED light turns on.
// Description: This code accepts the input of 3 integer values from 00-99, and then
//              assigns the values to three global variables that are declared in the
//              assembly source file. This then calls the addition() function that is
//              written in assembly in add.S. Then, it prints out the value of the x3
//              variable that is set by the addition() function by the following pseudo-code:
/*
 * addition() {
 *    turn on the onboard LED light (pin 13);
 *    int x1, x2, x3; // from user input
 * 
 *    x1++;
 *    x1 = x1 + x1;
 * 
 *    x2 = x2 - 1;
 *    x3 = x3 - 3;
 * 
 *    x3 = x1 + x2 + x3;
 * 
 *    return;
 * }
 */

//
// Declare the things that exist in our assembly code
//
/*
extern "C" { 
  byte x1;
  byte x2;
  byte x3;
  void addition();
}
*/

extern byte x1, x2, x3;
extern "C" void addition(void);

//
// function to read a 2-digit decimal value from user
//
byte readHexValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  if (inch <= '9')
     val = (inch - '0') * 16;
  else if (inch > '9' && inch >= 'a') 
     val = (inch - 'a' + 10) * 16;
  else if (inch > '9' && inch >= 'A') 
     val = (inch - 'A' + 10) * 16;
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  if (inch <= '9')
     val += (inch - '0');
  else if (inch > '9' && inch >= 'a') 
     val += (inch - 'a' + 10);
  else if (inch > '9' && inch >= 'A') 
     val += (inch - 'A' + 10);
  Serial.print("The hex value you entered is 0x");
  if (val <= 0x0F)
     Serial.print('0');
  Serial.println(val,HEX);
  Serial.print("The decimal equivalent is ");
  Serial.println(val,DEC);
  return (byte) val;
}

//
// Arduino-required setup function (called once)
//
void setup()
{
  //
  // Initialize serial communications
  //
  Serial.begin(9600);
  // Turn off the LED light
  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  //
  // Read three values from user, store in global vars
  //
  x1 = readHexValue();
  x2 = readHexValue();
  x3 = readHexValue();
  //
  // Call our assembly code
  //
  addition();
  //
  // print out value of x2 variable
  Serial.println("After addition()");
  Serial.print("The value is ");
  Serial.println((int) x3,DEC);
}

//
// Arduino-required loop function (called infinitely)
//
void loop()
{
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
