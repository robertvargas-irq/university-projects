// CS 271 - M04 – PA 10
// Program name: Date.h
// Author:       Robert Vargas
// Date:         4/29/2021
// Purpose:      This header file defines the
//               prototypes and classes for Date.cpp.

#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Date {

   private:
      unsigned int month;
      unsigned int day;
      unsigned int year;
      
      void helpIncrement();
      bool endOfMonth();
      bool leapYear();

   public:
      Date();
      Date( unsigned int m, unsigned int d, unsigned int y );
      void setDate( unsigned int m, unsigned int d, unsigned int y );
      unsigned int getMonth( ) const;
      unsigned int getDay( ) const;
      unsigned int getYear( ) const;
      Date operator++ ( int n );
      Date& operator++ ();
      Date& operator+= ( unsigned int nd );
      friend ostream& operator<< ( ostream& output, const Date& d );
      friend istream& operator>> ( istream& input, Date& d );

      
};

#endif
