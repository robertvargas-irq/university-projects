// CS 271 - M04 – PA 9
// Program name: WindTurbine.cpp
// Author:       Robert Vargas
// Date:         4/15/2021
// Purpose:      This cpp file contains the implementation
//               of the functions in the header file
//               WindTurbine.h, implementing functionalities
//               to set and get Power Output, Blade Speed, and
//               Orientation of a Wind Turbine defined in the
//               WindTurbine class.

#include <iostream>
#include <iomanip>
#include <string>

#include "WindTurbine.h"

using namespace std;

double powerOutput;
int bladeSpeed;
string orientation;


WindTurbine::WindTurbine() {
    WindTurbine::setPowerOutput( 100.0 );
    WindTurbine::setBladeSpeed( 0 );
    WindTurbine::setOrientation( "horizontal" );
} // end default constructor

WindTurbine::WindTurbine( double p, int b, string o ) {
    WindTurbine::setPowerOutput( p );
    WindTurbine::setBladeSpeed( b );
    WindTurbine::setOrientation( o );
} // end custom constructor

void WindTurbine::setPowerOutput( double p ) {
    if ( p >= 1.0 && p <= 10000.0 )
        powerOutput = p;
} // end setPowerOutput

void WindTurbine::setBladeSpeed( int b ) {
    if ( b >= 0 && b <= 300 )
        bladeSpeed = b;
} // end setBladeSpeed

void WindTurbine::setOrientation( string o ) {
    if ( o == "vertical" || o == "horizontal" )
        orientation = o;
} // end setOrientation

double WindTurbine::getPowerOutput() {
    return powerOutput;
} // end getPowerOutput

int WindTurbine::getBladeSpeed() {
    return bladeSpeed;
} // end getBladeSpeed

string WindTurbine::getOrientation() {
    return orientation;
} // end getOrientation

string WindTurbine::toString() {
    
    string newFormat = "";
    newFormat += "WindTurbine: powerOutput = ";
    newFormat += to_string( (int)WindTurbine::getPowerOutput() ) + " kW  ";
    newFormat += "bladeSpeed = ";
    newFormat += to_string( WindTurbine::getBladeSpeed() ) + "  ";
    newFormat += "orientation = ";
    newFormat += WindTurbine::getOrientation();
    
    return newFormat;
    
} // end toString

