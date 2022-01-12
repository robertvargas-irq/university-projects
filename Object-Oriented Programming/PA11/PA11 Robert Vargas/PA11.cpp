// CS 271 - M04 – PA 11
// Program name: PA11.cpp
// Author:       Robert Vargas
// Date:         5/06/2021
// Purpose:      This cpp file thoroughly tests the
//               functions located within LongDate.cpp,
//               a class derived from Date.cpp

#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#include "Date.h"
#include "LongDate.h"

int main( void ) {
    
    // initialize LongDate objects
    LongDate date1( 1, 1, 1980 );
    LongDate date2( 5, 6, 2021 );
    LongDate date3( 6, 23, 2001 );
    
    cout << "The following are three LongDate objects with their "
    << "corresponding day of the week to their full date." << endl
    << setw(11) << date1.getDayOfTheWeek() << ", " << date1 << endl
    << setw(11) << date2.getDayOfTheWeek() << ", " << date2 << endl
    << setw(11) << date3.getDayOfTheWeek() << ", " << date3 << endl << endl;
    
    // set the day to the next day
    try {
        date1.setDate( 1, 2, 1980 );
        date2.setDate( 5, 7, 2021 );
        date3.setDate( 6, 24, 2001 );
    }
    catch ( invalid_argument e ) {
        cout << "ERROR! " << e.what();
    } // end try/catch
    
    cout << "The dates shown above have been set to the day directly "
    << "after, as shown by the changes below:" << endl
    << setw(11) << date1.getDayOfTheWeek() << ", " << date1 << endl
    << setw(11) << date2.getDayOfTheWeek() << ", " << date2 << endl
    << setw(11) << date3.getDayOfTheWeek() << ", " << date3 << endl << endl;
    
    // test the mutator
    try {
        date1.setDayOfTheWeek();
        date2.setDayOfTheWeek();
        date3.setDayOfTheWeek();
    }
    catch ( invalid_argument e ) {
        
    } // end try/catch
    
    cout << "Let's double check to make sure the dates were set "
    << "correctly, the day of the week mutator was called once more:" << endl
    << setw(11) << date1.getDayOfTheWeek() << ", " << date1 << endl
    << setw(11) << date2.getDayOfTheWeek() << ", " << date2 << endl
    << setw(11) << date3.getDayOfTheWeek() << ", " << date3 << endl << endl;


} // end main
