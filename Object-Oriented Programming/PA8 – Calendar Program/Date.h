// CS 271 - M04 – PA 8
// Program name: Date.h
// Author:       Robert Vargas
// Date:         4/08/2021
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

   public:
      Date();
      Date( int m, int d, int y );
      void setMonth( int m );
      void setDay( int d );
      void setYear( int y );
      int getMonth( );
      int getDay( );
      int getYear( );
      void print ( );
};

#endif
