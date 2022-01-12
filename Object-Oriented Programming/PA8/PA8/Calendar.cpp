// CS 271 - M04 – PA 8
// Program name: Calendar.c
// Author:       Robert Vargas
// Date:         4/08/2021
// Purpose:      This program tests the functions within
//               the custom header file Date.h,
//               implementing its code which is located
//               within Date.cpp, and the custom header
//               Time.h with its code which is located
//               within Time.cpp.

#include <iostream>
#include <iomanip>
#include <string>
#include <cstdlib>
#include <ctime>

#include "Time.h"
#include "Date.h"

int main( void ) {
    
    // seed random with time
    srand(time(NULL));
    
    
    //
    // Testing Time class
    //
    
    // declare arrays
    Time times[5];
    int timesLength = 5;
    
    // fill times[] with random numbers
    cout << endl << "= = = = = = = = = = = = = = =" << endl;
    cout << "<<< Testing for the Time class >>>" << endl << endl;
    for ( int i = 0; i < timesLength; i++ ) {
        
        // HOUR
        const int MAX_HR = 23;
        int newHour = rand() % MAX_HR + 1;
        times[i].setHour( newHour );
        
        // MINUTE
        const int MAX_MIN = 59;
        int newMinute = rand() % MAX_MIN + 1;
        times[i].setMinute( newMinute );
        
        // SECOND
        const int MAX_SEC = 59;
        int newSecond = rand() % MAX_SEC + 1;
        times[i].setSecond( newSecond );
        
    } // end for loop
    
    // print the array, one element per line, 24hr format
    cout << "The following is an array of 5 random times, one per line, displayed in 24 hour time:" << endl;
    for ( int i = 0; i < timesLength; i++ ) {
        cout << "(" << i + 1 << ")  ";
        times[i].print();
    } // end for loop
    cout << endl;
    
    // print the array, one element per line, 12hr format
    cout << "The following is the same set of random times, one per line, displayed in 12 hour time:" << endl;
    for ( int i = 0; i < timesLength; i++ ) {
        cout << "(" << i + 1 << ")  ";
        times[i].print12();
    } // end for loop
    
    
    //
    // Testing Date class
    //
    
    Date dates[5];
    int datesLength = 5;
    
    cout << endl << "= = = = = = = = = = = = = = =" << endl;
    cout << "<<< Testing for the Date class >>>" << endl << endl;    
    
    // fill dates[] with random numbers
    for ( int i = 0; i < datesLength; i++ ) {
        
        // MONTH
        const int MAX_MON = 12;
        int newMonth = rand() % MAX_MON + 1;
        dates[i].setMonth( newMonth );
        
        // DATE
        const int MAX_DAY = 31;
        int newDay = rand() % MAX_DAY + 1;
        dates[i].setDay( newDay );
        
        // YEAR
        const int MAX_YEAR = 2100;
        const int MIN_YEAR = 1980;
        int newYear = rand() % ( MAX_YEAR - MIN_YEAR ) + MIN_YEAR;
        dates[i].setYear( newYear );
        
    } // end for loop
    
    // print the array, one element per line
    cout << "The following is 5 random dates from 1/1/1980 to 12/31/2100, one date per line:" << endl;
    for ( int i = 0; i < datesLength; i++ ) {
        
        cout << "(" << i + 1 << ")  ";
        dates[i].print();
        
    } // end for loop
    
    cout << endl << "= = = = = = = = = = = = = = =" << endl;

    
} // end main
