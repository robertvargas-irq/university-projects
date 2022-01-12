// CS 271 - M04 – PA 10
// Program name: PA10.cpp
// Author:       Robert Vargas
// Date:         4/29/2021
// Purpose:      This cpp file thoroughly tests the
//               functions located within Date.cpp

#include <iostream>
#include <iomanip>
#include <string>

#include "Date.h"

using namespace std;

int main( void ) {
    
    // declare a temporary adding variable
    int temp;
    
    // declare objects
    Date defaultDate;
    Date customDate( 1, 30, 1983 );
    Date addingDate( 3, 1, 2001 );
    Date inputDate( 4, 29, 2020 );
    Date leapYear( 2, 28, 2020 );
    Date commonYear( 2, 28, 2019 );
    
    
    //
    // Testing
    //
    
    cout << "The following are the declared date objects to be tested:" << endl << endl
    << "Default Date: " << defaultDate << endl
    << "Custom Date:  " << customDate  << endl
    << "Adding Date:  " << addingDate  << endl
    << "Input Date:   " << inputDate   << endl
    << "Leap Year:    " << leapYear    << endl
    << "Common Year:  " << commonYear  << endl << endl;
    
    cout << "The customDate is now being set to February 5th, 2002, as displayed: " << endl;
    
    customDate.setDate( 2, 5, 2002 );
    cout << customDate << endl << endl;
    
    cout << "The customDate's new compenents are as follows: " << endl
    << setw(4) << customDate.getMonth() << " is the month," << endl
    << setw(4) << customDate.getDay()   << " is the day,"   << endl
    << setw(4) << customDate.getYear()  << " is the year,"  << endl << endl;
    
    
    
    cout << "The customDate is now being set to November 12th, 2025, as displayed: " << endl;
    
    customDate.setDate( 11, 12, 2025 );
    cout << customDate << endl << endl;
    
    cout << "The customDate's new compenents are as follows: " << endl
    << setw(4) << customDate.getMonth() << " is the month," << endl
    << setw(4) << customDate.getDay()   << " is the day,"   << endl
    << setw(4) << customDate.getYear()  << " is the year,"  << endl << endl;
    
    
    // incrementing
    cout << "DefaultDate is now being incremented from:" << endl
    << "   " << defaultDate << endl;
    
    defaultDate++;
    
    cout << "To:" << endl
    << "   " << defaultDate << endl << endl;
    
    cout << "And once again from:" << endl
    << "   " << defaultDate << endl;
    
    defaultDate++;
    
    cout << "To:" << endl
    << "   " << defaultDate << endl << endl;
    
    
    // leap year
    cout << "leapYear is now on February 28 as shown:" << endl
    << "   " << leapYear << endl
    << "Now, after incrementing by one day, February 29 should be allowed:" << endl;
    
    leapYear++;
    
    cout << "   " << leapYear << endl
    << "Now, let's increment once more to make it the turn of the month:" << endl;
    
    leapYear++;
    
    cout << "   " << leapYear << endl << endl;
    
    
    // non-leap year
    cout << "commonYear is currently February 28, as soon:" << endl
    << "   " << commonYear << endl
    << "Now, after incrementing by one day, since it is not a leap year, the month should turn:" << endl;
    
    commonYear++;
    
    cout << "   " << commonYear << endl << endl;
    
    
    // custom user input
    cout << "AddingDate is as follows:" << endl
    << "   " << addingDate << endl
    << "Please input a specific number of days to add to addingDate: ";
    cin >> temp;
    
    addingDate += temp;
    
    cout << "The new date " << temp << " day(s) later is: " << endl
    << "   " << addingDate << endl
    << "Please input a specific number of days to add more to the new addingDate: ";
    cin >> temp;
    
    addingDate += temp;
    
    cout << "The new date " << temp << " day(s) later is: " << endl
    << "   " << addingDate << endl << endl;
    
    
    // user-inputted date
    cout << "Please input a custom date of your choosing to modify inputDate" << endl
         << "((month day year) separated by spaces; data will be validated):" << endl;
         
    cin >> inputDate;
    
    cout << "   " << inputDate << " is the new date set to inputDate." << endl;
    
    
    cout << "Please input an **INVALID** custom date of your choosing to modify inputDate" << endl
         << "((month day year) separated by spaces; data will be validated):" << endl;
         
    cin >> inputDate;
    
    cout << "   " << inputDate << " is the new date set to inputDate." << endl << endl;
    
} // end main
