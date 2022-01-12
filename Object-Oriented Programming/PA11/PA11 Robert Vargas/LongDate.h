// CS 271 - M04 – PA 11
// Program name: LongDate.cpp
// Author:       Robert Vargas
// Date:         5/06/2021
// Purpose:      This header file defines
//               the LongDate class and its
//               prototypes, the LongDate
//               class inheriting from the
//               Date class.

#ifndef LONGDATE_H
#define LONGDATE_H

#include <iostream>
#include <string>
#include "Date.h"

class LongDate : public Date {
    
public:
    LongDate( int m, int d, int y );
    void setDayOfTheWeek();
    string getDayOfTheWeek();
    void setDate( int m, int d, int y );
    
private:
    string dayOfTheWeek;
    static const string daysOfTheWeek[];
};

#endif
