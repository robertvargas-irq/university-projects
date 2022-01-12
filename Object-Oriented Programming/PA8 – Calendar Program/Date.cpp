// CS 271 - M04 – PA 8
// Program name: Time.cpp
// Author:       Robert Vargas
// Date:         4/08/2021
// Purpose:      This header file implements
//               time-related functions to
//               set, get, and print formatted date
//               objects in the Date class.

#include <iostream>
#include <iomanip>
#include <string>

#include "Date.h"

using namespace std;

unsigned int month;
unsigned int day;
unsigned int year;

Date::Date() {
    Date::setMonth( 1 );
    Date::setDay( 1 );
    Date::setYear( 1980 );
} // end Date() default constructor

Date::Date( int m, int d, int y ) {
    Date::setMonth( m );
    Date::setDay( d );
    Date::setYear( y );
} // end Date() constructor

void Date::setMonth( int m ) {
    if ( m >= 1 && m <= 12 )
        month = m;
} // end setMonth()

void Date::setDay( int d ) {
    if ( d >= 1 && d <= 31 )
        day = d;
} // end setDay()

void Date::setYear( int y ) {
    if ( y >= 1980 && y <= 2100 )
        year = y;
} // end setYear()
        
int Date::getMonth( ) {
    return month;
} // end getMonth()

int Date::getDay( ) {
    return day;
} // end getDay()

int Date::getYear( ) {
    return year;
} // end getYear()

void Date::print( ) {
    cout << setfill( '0' ) << setw( 2 ) << getMonth() << "/";
    cout << setfill( '0' ) << setw( 2 ) << getDay() << "/";
    cout << setfill( '0' ) << setw( 4 ) << getYear() << endl;
} // end print()
