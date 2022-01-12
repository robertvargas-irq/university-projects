// Name: Robert Vargas
// Date: 03/11/2021
// CS 273 - M80
// Input:       N/A
// Output:      LED 4x7 monitor. Display 0 through 9 on the display in different corresponding
//              segments.
// Description: This program experiments with the 4x7 LED display in order to switch between the
//              different segments, displaying the numbers 0 through 9 in choronological order
//              one segment at a time, starting at the left with 0, then the next segment at 1,
//              the following at 2, then the next at 3, then 4 starting back over at the first
//              segment.

/*
  Showing number 0-9 on a Common Anode 7-segment LED display
  Displays the numbers 0-9 on the display, with one second inbetween.
    A
   ---
F |   | B
  | G |
   ---
E |   | C
  |   |
   ---
    D
  This example code is in the public domain.
 */
 
// Pin 2-8 is connected to the 7 segments of the display.

int pinA = 2;
int pinB = 3;
int pinC = 4;
int pinD = 5;
int pinE = 6;
int pinF = 7;
int pinG = 8;
int D1 = 9;
int D2 = 10;
int D3 = 11;
int D4 = 12;

extern "C" {
  void setup_ports();
  void display_segment();
}

extern byte segment;
extern byte digit;

// the setup routine runs once when you press reset:
void setup() {                

  Serial.begin(9600);
  
  // initialize the digital pins as outputs.
  setup_ports();
}

// the loop routine runs over and over again forever:
void loop() {

  //0
  segment = 0;
  digit = 0;
  display_segment();
  delay(1000);               // wait for a second

  //1
  segment = 1;
  digit = 1;
  display_segment();
  delay(1000);               // wait for a second

  //2
  segment = 2;
  digit = 2;
  display_segment();
  delay(1000);               // wait for a second

  //3
  segment = 3;
  digit = 3;
  display_segment();
  delay(1000);               // wait for a second

  //4
  segment = 0;
  digit = 4;
  display_segment();
  delay(1000);               // wait for a second

  //5
  segment = 1;
  digit = 5;
  display_segment();
  delay(1000);               // wait for a second

  //6
  segment = 2;
  digit = 6;
  display_segment();
  delay(1000);               // wait for a second

  //7
  segment = 3;
  digit = 7;
  display_segment();
  delay(1000);               // wait for a second

  //8
  segment = 0;
  digit = 8;
  display_segment();
  delay(1000);               // wait for a second

  //9
  segment = 1;
  digit = 9;
  display_segment();
  delay(1000);               // wait for a second

}
