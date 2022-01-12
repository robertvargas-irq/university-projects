// Name: Robert Vargas
// Date: 03/04/2021
// CS 273 - M80
// Input:       Two separate user input via the Serial Monitor; first a 2 digit decimal, the next
//              a string of Morse Code (0 - dot, 1 - dash).
// Output:      Blinking "GOAGGIES" in Morse Code via the PIN13 light, and a translated Morse Code
//              based on user input into the Serial Monitor.
// Description: This program takes two separate user inputs via the Serial Monitor; the first a 2
//              digit decimal which will dictate how many times the PIN13 light will flash
//              "GOAGGIES" in Morse Code, the second being a string of binary representing Morse Code,
//              in which the Arduino board will decode and return the translation of the input of 1's
//              (dashes) and 0's (dots).

//
// Declare the things that exist in our assembly code
//

extern byte val;
extern byte width;
extern byte ascii;

extern byte howmany;

extern "C" { 
  void decode_morse();
  void goaggies();
}

//
// function to read a 2-digit decimal value from user
//
byte read2DigitValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val = (inch - '0') * 10;
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val += (inch - '0');
  Serial.print("The value entered is ");
  Serial.println(val,DEC);
  return (byte) val;
}

void flashGoAggies() 
{
  // Add you code here
  // ask the user how many times
  Serial.println("Enter how many times you want GoAggies to flash: ");
  howmany = read2DigitValue();
  
  goaggies();
  // You will call the GoAggies() function from assembly file GoAggies.S
}

void decodeMorse(const String & string, char message[])
{
  // Write your code below.
  // string contains the input binary string separated by single spaces
  // message contains the decoded English characters and numbers    
  // You will call the assembly function decode_morse()
  int sindex = 0; // The current location in the string
  int mindex = 0; // The current location in the message
  val = 0;
  width = 0;
  while ( string[sindex] != NULL ) {
      if ( string[sindex] == ' ' ) {
        // process the val and width
        decode_morse();
        // we now know that ascii has been set to the corresponding value

        message[mindex] = ascii;
        mindex++;
        message[mindex] = ' ';
        mindex++;
        val = 0;
        width = 0;
      }
      else {
        // accumulate width and value
        val = val * 2 + ( string[sindex] - '0' );
        width++;
      }

      sindex++;
  }

  // what if VAL/index are non-zero, then process
  if ( width > 0 ) {
        // process the val and width
        decode_morse();
        // we now know that ascii has been set to the corresponding value

        message[mindex] = ascii;
        mindex++;
        message[mindex] = ' ';
        mindex++;
  }
  message[mindex] = NULL;
}



void decodeMorse() 
{
  Serial.println("Input a Morse code string (separate the code for characters by a space):");

  while (!Serial.available()) delay(100);
  String string = Serial.readString();

  Serial.print("The Morse code string is: ");
  Serial.println(string);

  //string = "1000 100 0"; // "01 1000";
  char message[100];

  decodeMorse(string, message);

  if(strlen(message) > 0) {
    Serial.print("The decoded message is: ");
    Serial.println(message);
  } else {
    Serial.print("Failure in decoding the input Morse code\n");
  }  
}

void setup() {
  //
  // Initialize serial communications
  //
  Serial.begin(9600);

  // Turn off the LED light
  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  
  flashGoAggies();

  decodeMorse();
  
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
