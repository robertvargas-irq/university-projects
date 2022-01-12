// CS 271 - M04 – PA 7
// Program name: logTable.c
// Author:       Robert Vargas
// Date:         4/1/2021
// Purpose:      This program neatly creates a
//               table with logarithms from 1 to
//               100, giving the result of log base
//               2, base 10, and base e (natural log).


#include <iostream>
#include <iomanip>
#include <cmath>
#include <string>

using namespace std;

int main() {
    
    cout << "The following is a logarithm table from 1 to 100 with log base 2, log base 10, and log base e (natural log)." << endl << endl;
    
    // set heading
    cout << setw(5) << "Number" << setw(14) << "Log base 2" << setw(15) << "Log base 10" << setw(14) << "Log base e" << endl;
    
    // cycle through 1 to 100 with logarithms
    for ( int i = 1; i <= 100; i++ ) {
        
        float base2 = log2( i );
        float base10 = log10( i );
        float ln = log( i );
        
        cout << setw(4) << i;
        
        cout << setw(14) << setprecision(3) << fixed << base2;
        
        cout << setw(14) << setprecision(3) << fixed << base10;
        
        cout << setw(15) << setprecision(3) << fixed << ln << endl;
        
    } // end for
    
} // end main
