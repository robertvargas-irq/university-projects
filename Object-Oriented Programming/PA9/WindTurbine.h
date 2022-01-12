// CS 271 - M04 – PA 9
// Program name: WindTurbine.h
// Author:       Robert Vargas
// Date:         4/15/2021
// Purpose:      This header file defines the
//               prototypes and classes for WindTurbine.cpp.

#ifndef WINDTURBINE_H
#define WINDTURBINE_H

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class WindTurbine {

   private:
      double powerOutput;
      int bladeSpeed;
      string orientation;

   public:
      WindTurbine();
      WindTurbine( double p, int b, string o );
      void setPowerOutput( double p );
      void setBladeSpeed( int b );
      void setOrientation( string o );
      double getPowerOutput();
      int getBladeSpeed();
      string getOrientation();
      string toString();
};

#endif
