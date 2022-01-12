// Name: Robert Vargas
// Date: 05/04/2021
// CS 273 - M80
// Input:       User input via the Serial Monitor.
// Output:      The sum of both arrays A and B from user input of length N.
// Description: This program calls an AVR routine to sum up user input. The user
//              first inputs N, the length of both arrays (with a maximum of 20),
//              then, the user is prompted to enter array A, then array B, in which
//              the AVR routine then sums up those shared variables, storing the result
//              of A[i] + B[i] in C[i], then returns the sum direct from the function.
//              Finally, the program displays arrays A and B, then result C, then the sum
//              calculated both in the .INO C code and the AVR routine.
//
// Summary:
// - reads in a number
// - reads in an array of values
// - calls an AVR assembly program to calculate
// - C[i] = A[i] + B[i]
// - returns the sum of arrays A + B
// - we print the A, B, C, returned sum value, and calculate the values in C to confirm

// Lab 10 Questions -
//
// 1)  Why does C need to be two bytes (an int) while A and B are only a byte each?
//       As we are adding two values together to an int value, if we were to add two ints
//       together, there would be a risk of overflow if both added ints' sum were far too
//       big to store in an int value. Thus, we would need to go a size down in order to
//       avoid an overflow, as two bytes added together cannot surpass an int value.
//       ADDITIONALLY, since we are adding up to 20 different byte values of max 255, we need
//       a big enough variable to store all the possible inputs of 255.
// 2)  Why does the return value have to be an int?
//       The return value has to be an int as we are adding up to 20 bytes with max values of
//       255 together. With a return type of int we are free of the risk of an overflow as it
//       can handle up to the possible max input for the program of 20 255 values.
// 3)  At what value of N would require our return value to be a long instead of int. Why?
//       129, as the max value a 16-byte int can store is 65536.
//       At N = 128, [ 255 * ( 128 * 2 ) = 65280 ] which is comfortably below 65536.
//       At N = 129, [ 255 * ( 129 * 2 ) = 65790 ] which is OUTSIDE the range of an int, in
//       which case we would need a long instead of an int.

extern byte N;
extern byte A[20];
extern byte B[20];
extern int C[20];

extern "C" {
  int sumit(byte N);
};


// read in hex values return byte
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

  int i;
  int result;
  int mySum = 0;
  
  Serial.begin(9600);
  Serial.println("Enter N");
  N = read2DigitHexValue();
  if (N > 20)
    N = 20; // force to be in size of arrays

  // read in A array
  for ( i = 0; i < N; i++ ) {
    Serial.print("Enter A[");
    Serial.print("i");
    Serial.print("]: ");
    A[i] = read2DigitHexValue();
  }

  // read in B array
  for ( i = 0; i < N; i++ ) {
    Serial.print("Enter B[");
    Serial.print("i");
    Serial.print("]: ");
    B[i] = read2DigitHexValue();
  }

  // calculate the sum in assembly
  result = sumit(N);

  // now report on all of the values
  Serial.println("i\tA[i]\tB[i]\tC[i]\tConfirm C");
  for ( i = 0; i < N; i++ ) {
    Serial.print(i);
    Serial.print("\t");
    Serial.print(A[i]);
    Serial.print("\t");
    Serial.print(B[i]);
    Serial.print("\t");
    Serial.print(C[i]);
    Serial.print("\t");
    Serial.println(A[i] + B[i]);

    // verify sum in C
    mySum += A[i] + B[i];
  }

  // print sums, first .S then C
  Serial.print("Sum is: ");
  Serial.println(result);
  Serial.print("From C code sum is: ");
  Serial.println(mySum);
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println("*");
  delay(5000);
}
