// CS 271 - M04 – PA 8
// Program name: Time.cpp
// Author:       Robert Vargas
// Date:         4/08/2021
// Purpose:      This header file implements
//               time-related functions to
//               set, get, and print 12 and 24
//               hour time objects in the Time class.

#include <iostream>
#include <iomanip>
#include <string>

#include "Time.h"

using namespace std;

unsigned int hour;
unsigned int minute;
unsigned int second;

Time::Time() {
    hour = 0;
    minute = 0;
    second = 0;
} // end Time() default constructor

Time::Time( int h, int m, int s ) {
    Time::setHour( h );
    Time::setMinute( m );
    Time::setSecond( s );
} // end Time() constructor

void Time::setHour( int h ) {
    if ( h >= 0 && h <= 23 )
        hour = h;
} // end setHour()

void Time::setMinute( int m ) {
    if ( m >= 0 && m <= 59 )
        minute = m;
} // end setMinute()

void Time::setSecond( int s ) {
    if ( s >= 0 && s <= 59 )
        second = s;
} // end setSecond()

int Time::getHour( ) {
    return hour;
} // end getHour()

int Time::getMinute( ) {
    return minute;
} // end getMinute()

int Time::getSecond( ) {
    return second;
} // end getSecond()

void Time::print ( ) {
    cout << setfill( '0' ) << setw( 2 ) << getHour() << ":";
    cout << setfill( '0' ) << setw( 2 ) << getMinute() << ":";
    cout << setfill( '0' ) << setw( 2 ) << getSecond() << endl;

} // end print()

void Time::print12( ) {
    
    // check if hour is past noon
    unsigned int hour = Time::getHour();
    bool am = true;
    if ( hour > 12 ) {
        hour -= 12;
        am = false;
    }
    
    cout << setfill( '0' ) << setw( 2 ) << hour << ":";
    cout << setfill( '0' ) << setw( 2 ) << getMinute() << ":";
    cout << setfill( '0' ) << setw( 2 ) << getSecond();
    
    // add AM/PM
    if ( am == true )
        cout << " AM" << endl;
    else
        cout << " PM" << endl;
    
} // end print12()
