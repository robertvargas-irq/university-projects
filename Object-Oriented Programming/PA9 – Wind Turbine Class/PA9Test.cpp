// CS 271 - M04 – PA 9
// Program name: WindTurbine.cpp
// Author:       Robert Vargas
// Date:         4/15/2021
// Purpose:      This cpp file thoroughly tests the
//               functions located within WindTurbine.cpp

#include <iostream>
#include <iomanip>
#include <string>

#include "WindTurbine.h"

using namespace std;

int main( void ) {
    
    WindTurbine defaultTurbine;
    WindTurbine customTurbine( 105.0, 199, "vertical" );
    
    cout << endl << "= = = = = = = = = =" << endl;
    
    //
    // Constructor Testing
    //
    
    // testing the default constructor
    cout << "The default constructor for the WindTurbine class sets the object values to 100.0 for powerOutput, 0 for bladeSpeed, and horizontal for orientation as displayed below:" << endl;
    cout << defaultTurbine.toString() << endl << endl;
    
    // testing the custom constructor
    cout << "The following is the custom constructor in action with a new turbine labeled customTurbine, which initializes with 105.0, 199, and vertical respectively:" << endl;
    cout << customTurbine.toString() << endl << endl;
    
    cout << "= = = = = = = = = =" << endl;
    
    
    
    //
    // Mutator / Accessor Testing
    //
    
    // testing (set/get)PowerOutput()
    customTurbine.setPowerOutput( 9312.4 );
    cout << "customTurbine has been assigned " << customTurbine.getPowerOutput() << " for its powerOutput." << endl;
    
    // testing (set/get)BladeSpeed()
    customTurbine.setBladeSpeed( 231 );
    cout << "customTurbine has been assigned " << customTurbine.getBladeSpeed() << " for its bladeSpeed." << endl;
    
    // testing (set/get)Orientation()
    customTurbine.setOrientation( "horizontal" );
    cout << "customTurbine has been assigned " << customTurbine.getOrientation() << " for its orientation" << endl << endl;
    
    
    
    //
    // Data Validation
    //
    
    // powerOutput > 10,000.0
    customTurbine.setPowerOutput( 414000.5 );
    cout << "customTurbine's powerOutput was attempted to be changed to 414,000.5, a value out of bounds ( 1.0 < power < 10,000.0 )" << endl;
    cout << "     The resulting powerOutput is: " << customTurbine.getPowerOutput() << endl;
    
    // bladeSpeed > 300
    customTurbine.setBladeSpeed( 414 );
    cout << "customTurbine's bladeSpeed was attempted to be changed to 414, a value out of bounds ( 0 < speed < 300 )" << endl;
    cout << "     The resulting bladeSpeed is: " << customTurbine.getBladeSpeed() << endl;
    
    // orientation other than "horizontal" or "vertical"
    customTurbine.setOrientation( "VERTICal" );
    cout << "customTurbine's orientation was attempted to be changed to \"VERTICal\", a value that does not fit into case-sensitive \"horizontal\" or \"vertical\"." << endl;
    cout << "     The resulting orientation is: " << customTurbine.getOrientation() << endl;
    
    cout << endl << "= = = = = = = = = =" << endl;

    
    
    
    
} // end main
