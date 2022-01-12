// Name: Robert Vargas
// Date: 04/13/2021
// CS 273 - M80
// Input:       Two-digit user-inputted hexadecimal number via the Serial monitor.
// Output:      The sum of the user-inputted number of every number up to that number.
// Description: This program takes input from the Serial monitor, a two-digit hexadecimal
//              number and takes the sum of every number leading up to, and including, that
//              number that was inputted by the user. The assembly code that is LINKED to
//              this file implements the following C pseudo-code:

// Pseudo-code:
//
// int N;
// int SUM = 0;
// 
// get user input;
// store in N;
// 
// while ( N > 0 ) {
//   SUM = SUM + N;
//   N--;
// }

extern "C" {
  void SumOfN();
}

extern int SUM;
extern byte N;

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

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  N = read2DigitHexValue();
  SumOfN();
  Serial.println(SUM);
  delay(1000);
  Serial.println("*");
  
}
