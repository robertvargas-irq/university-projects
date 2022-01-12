// CS 271 - M04 – PA 11
// Program name: LongDate.cpp
// Author:       Robert Vargas
// Date:         5/06/2021
// Purpose:      This cpp file implements
//               the LongDate class and its functions,
//               the LongDate class inheriting
//               from the Date class.

#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#include "Date.h"
#include "LongDate.h"

using namespace std;



string dayOfTheWeek;
const string LongDate::daysOfTheWeek[7] =
    { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    
    
    
LongDate::LongDate( int m, int d, int y )
    : Date( m, d, y ) {
        
    LongDate::setDayOfTheWeek();
    
} // end custom constructor

void LongDate::setDayOfTheWeek() {
    
    // THE ALGORITHM USED IS ZELLER'S ALGORITHM
    // The website it is derived from is https://www.tutorialspoint.com/day-of-the-week-in-cplusplus
    
    int mon;
    int year = getYear();
    int month = getMonth();
    int day = getDay();
    
    if ( month > 2 )
        // from March to December it remains unchanged
        mon = month;
    else {
        // for January and February the month will be 13 and 14
        mon = month + 12;
        year--;
    } // end if
    
    int y = year % 100; // last two digits of the year
    int c = year / 100; // first two digits of the year
    int w = ( day + floor( ( 13 * ( mon + 1 ) ) / 5 ) + y
        + floor( y / 4 ) + floor( c / 4 ) + ( 5 * c ) );
    w = w % 7;
    
    // set day of the week
    dayOfTheWeek = daysOfTheWeek[w];
    
} // end setDayOfTheWeek()

string LongDate::getDayOfTheWeek() {
    
    return dayOfTheWeek;
    
} // end getDayOfTheWeek()

void LongDate::setDate( int m, int d, int y ) {
    
    Date::setDate( m, d, y );
    LongDate::setDayOfTheWeek();
    
} // end setDate()
