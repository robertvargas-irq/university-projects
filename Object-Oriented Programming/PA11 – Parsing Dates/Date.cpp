// Date.cpp
// Date class member- and friend-function definitions.
#include <iostream>
#include <iomanip>
#include <string>
#include "Date.h"
using namespace std;

// initialize static member; one classwide copy
const int Date::days[] = 
   { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

// Date constructor
Date::Date( unsigned int m, unsigned int d, unsigned int y ) 
{ 
   setDate( m, d, y ); 
} // end Date constructor

// mutators

// set month, day and year
void Date::setDate( unsigned int mm, unsigned int dd, unsigned int yy )
{

   if (yy < 1980 || yy > 2100)
      throw invalid_argument( "Year is not in the valid range" );

   if (mm < 1 || mm > 12)
      throw invalid_argument( "Month must be 1 - 12" );

   if (mm == 2 && leapYear(yy) ){
       if (dd < 1 || dd > 29)
          throw invalid_argument( "Day and month aren't compatible" );
   }
   else if ( dd < 1 || dd > days[mm] )
       throw invalid_argument( "Day and month aren't compatible" );
    
    // parameters pass all validation tests
    day = dd;
    month = mm;
    year = yy;
   
} // end function setDate

// accessors
unsigned int Date::getDay( ) const {
   return day;
}
unsigned int Date::getMonth( ) const {
   return month;
}
unsigned int Date::getYear( ) const {
   return year;
}
// overloaded prefix increment operator 
Date & Date::operator++() {
   helpIncrement(); 
   
   return *this; 
   
} // end function operator++


// overloaded postfix increment operator; note that the  
// dummy integer parameter does not have a parameter name

Date Date::operator++( int ) {
   Date temp = *this; // hold current state of object
   
   helpIncrement(); 

   // return unincremented, saved, temporary object
   
   return temp;
   
} // end function operator++

const Date & Date::operator+=( unsigned int additionalDays ) {
   for ( int i = 0; i < additionalDays; i++ )
      helpIncrement();

   return *this; // enables cascading
   
} // end function operator+=

// if the year is a leap year, return true; otherwise, return false
bool Date::leapYear(int testYear ) const {
   if ( testYear % 400 == 0 || 
      ( testYear % 100 != 0 && testYear % 4 == 0 ) )
      return true;
   else
      return false; 
} // end function leapYear


// determine whether the day is the last day of the month
bool Date::endOfMonth(int testDay ) const {
   if ( month == 2 && leapYear(year) )
      return testDay == 29;
   else
      return testDay == days[ month ]; 
} // end function endOfMonth

// function to help increment the date
void Date::helpIncrement()
{
   // day is not end of month
   if ( !endOfMonth(day) )
      day++; 
   else 
      if ( month < 12 ) 
      {
         month++; 
         day = 1; 
      } 
      else // last day of year
      {
         year++; // increment year
         month = 1; // first month of new year
         day = 1; // first day of new month
      } // end else
} // end function helpIncrement

// overloaded output operator
ostream &operator<<( ostream &output, const Date &d )
{
   static string monthName[ 13 ] = { "", "January", "February",
      "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };
   output << monthName[ d.month ] << ' ' << d.day << ", " << d.year;
   return output; // enables cascading
} // end function operator<<

// overloaded input operator
istream &operator>>( istream &input, Date &d ) {

   // assume the user types the date in the format mm/dd/yyyy
   int mm, dd, yy;
   input >> setw(2) >> mm;
   input.ignore(); // skip the slash
   input >> setw(2) >> dd;
   input.ignore(); // skip the slash
   input >> setw(4) >> yy;
   d.setDate(mm, dd, yy);
   return input;
}
   
