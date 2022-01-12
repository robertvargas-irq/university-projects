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

//
// Declare the things that exist in our assembly code
//

extern byte gender;
extern byte age;
extern byte fat;

extern "C" {   
  void FatMonitor();
}

//
// function to read a 2-digit HEX value from user
//
byte read2DigitHexValue()
{
  byte inch; int val=0;
  Serial.println("Enter a 2-digit hex value:");
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
  Serial.print("The value entered is decimal ");
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
  //
  // Read 2 values from user, store in global vars
  //
  gender = read2DigitHexValue();
  age = read2DigitHexValue();
  fat = read2DigitHexValue();
  //
  // Call our assembly code
  //
  FatMonitor();
}

//
// Arduino-required loop function (called infinitely)
//
void loop()
{
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
