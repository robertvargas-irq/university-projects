// CS 271 - M04 – PA 10
// Program name: Date.cpp
// Author:       Robert Vargas
// Date:         4/29/2021
// Purpose:      This header file implements
//               date-related functions, and
//               overloaded operator functions to
//               add to, input, and output the date in
//               a formatted manner with C++ operators.

#include <iostream>
#include <iomanip>
#include <string>
#include <stdexcept>

#include "Date.h"

using namespace std;

unsigned int month;
unsigned int day;
unsigned int year;

string monthText[12] = { "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"};


ostream& operator<< ( ostream& output, const Date& d ) {
        
    output << monthText[d.getMonth() - 1] << " " << d.getDay() << ", " << d.getYear();
    return output;
    
} // end operator<<

istream& operator>> ( istream& input, Date& d ) {
    
    input >> month >> day >> year;
    
    d.setDate( month, day, year );
    
    return input;
    
} // end operator>>

void Date::helpIncrement() {
    
    // handles end of the month
    if ( Date::endOfMonth() ) {
        
        // handles the end of the year
        if ( month == 12 ) {
            month = 1;
            day = 1;
            year++;
        }
        
        // handles in-between the year
        else {
            month++;
            day = 1;
        } // end end-of-year
    } // end if end-of-month
    
    // handles during the month
    else
        day++;
    
} // end helpIncrement()

bool Date::endOfMonth() {
    
    unsigned int m = month;
    unsigned int d = day;
    
    // February
    if ( m == 2 ) {
        
        // leap year handler (based on timeanddate.com classifications)
        if ( Date::leapYear() == true ) {
            // leap year
            if ( d == 29 )
                return true;
        }
        else {
            // common year
            if ( d == 28 )
                return true;
        } // end leap year
    }
    
    // 31 day month handler
    else if ( m == 1 || m == 3 || m == 5 || m == 7
        || m == 8 || m == 10 || m == 12 ) {
        if ( d == 31 )
            return true;
    }
    
    // 30 day month handler
    else if ( m <= 12 ) {
        if ( d == 30 )
            return true;
    } // end if tree

    // default to false
    return false;
    
} // end endOfMonth()

bool Date::leapYear() {
    
    // based on timeanddate.com classifications
    if ( ( year % 4 ) == 0 )
        if ( ( year % 100 != 0 ) || ( year % 400 == 0 ) )
            return true;
        
    // not a leap year
    return false;
    
} // end of leapYear()

Date::Date() {
    setDate( 1, 1, 1980 );
} // end Date() default constructor

Date::Date( unsigned int m, unsigned int d, unsigned int y ) {
    setDate( m, d, y );
} // end Date() constructor

void Date::setDate( unsigned int m, unsigned int d, unsigned int y ) {
    
    // verify year
    try {
        if ( y >= 1980 && y <= 2100 )
            year = y;
        else
            throw invalid_argument( to_string(y) + " is not a valid year! Year must be between 1980 and 2100!" );
    }
    catch ( invalid_argument &e ) {
        cout << "[ERROR!] " << e.what() << endl;
    } // end try-catch
    
    // verify month
    try {
        if ( m >= 1 && m <= 12 )
            month = m;
        else
            throw invalid_argument( to_string(m) + " is not a valid month! Month must be between 1 and 12!" );
    }
    catch ( invalid_argument &e ) {
        cout << "[ERROR!] " << e.what() << endl;
    } // end try-catch
        
    // verify day
    try {
        
        if ( m == 2 ) {
            
            // leap year handler (based on timeanddate.com classifications)
            if ( Date::leapYear() == true ) {
                // leap year
                if ( d >= 1 && d <= 29 )
                    day = d;
                else
                    throw invalid_argument( to_string(y) + "is a leap year, the day must land between 1 and 29 for February!" );
            }
            else {
                // common year
                if ( d >= 1 && d <= 28 )
                    day = d;
                else
                    throw invalid_argument( to_string(y) + " is a common year, the day must land between 1 and 28 for February!" );
            } // end leap year
        }
        // 31 days
        else if ( m == 1 || m == 3 || m == 5 || m == 7
            || m == 8 || m == 10 || m == 12 ) {
            if ( d >= 1 && d <= 31 )
                day = d;
            else
                throw invalid_argument( monthText[m-1] + " is a 31 day month, the day must land between 1 and 31!" );
        }
        
        // 30 days
        else if ( m <= 12 ) {
            if ( d >= 1 && d <= 30 )
                day = d;
            else
                throw invalid_argument( monthText[m-1] + " is a 30 day month, the day must land between 1 and 30!" );
        } // end if statement
    }
    catch ( invalid_argument &e ) {
        
        cout << "[ERROR!] " << d << " is not a valid day for this month! " << e.what() << endl;
        
    } // end try-catch
    
}

unsigned int Date::getMonth( ) const {
    return month;
} // end getMonth()

unsigned int Date::getDay( ) const {
    return day;
} // end getDay()

unsigned int Date::getYear( ) const {
    return year;
} // end getYear()

Date Date::operator++ ( int n ) {
    
    Date current( month, day, year );
    Date::helpIncrement();
    return current;
    
} // end operator++

Date& Date::operator++ () {
    
    Date::helpIncrement();
    return *this;
    
} // end operator++

Date& Date::operator+= ( unsigned int nd ) {
        
    // increment (nd) amount of days defined by user
    for ( int i = 0; i < nd; i++ )
        Date::helpIncrement();
    
    return *this;
    
} // end operator+=
    
