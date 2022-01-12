// CS 271 - M04 – PA 8
// Program name: Time.h
// Author:       Robert Vargas
// Date:         4/08/2021
// Purpose:      This header file defines the
//               prototypes and classes for Time.cpp.

#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Time {

   private:
      unsigned int hour;
      unsigned int minute;
      unsigned int second;

   public:
      Time();
      Time( int h, int m, int s );
      void setHour( int h );
      void setMinute( int m );
      void setSecond( int s );
      int getHour( );
      int getMinute( );
      int getSecond( );
      void print ( );
      void print12( );
};

#endif
