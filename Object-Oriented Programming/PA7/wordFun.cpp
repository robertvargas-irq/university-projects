// CS 271 - M04 – PA 7
// Program name: wordFun.c
// Author:       Robert Vargas
// Date:         4/1/2021
// Purpose:      This program takes user input of up
//               to 25 strings then outputs them line
//               by line, then prints the individual
//               characters that make up the word line
//               by line, repeating for each word.


#include <iostream>
#include <string>

using namespace std;

int main() {
    
    // initialize an array with 25 strings
    string words[25];
    int count = 0;
    
    cout << "Please input up to 25 words to print in a single line, then their individual characters each line." << endl;
    
    while ( !cin.eof() && count < 25 ) {
        
        string tempWord;
        cout << "Type a word (press Ctrl-D to quit): ";
        
        // assign
        cin >> tempWord;
        words[count] = tempWord;
        
        // verify eof or end of array
        if ( cin.eof() ) {
            cout << "Ctrl-D is pressed" << endl;
            continue;
        }
        if ( count >= 25 - 1 ) {
            cout << "The array is now full." << endl;
        }
        
        count++;
                
    } // end sentinel loop
        
        
    // cycle through the words
    for ( int i = 0; i < count; i++ ) {
        
        cout << words[i] << endl;
        string tempString = words[i];
        
        // print individual letters
        for ( int j = 0; j < tempString.length(); j++ )
            cout << tempString[j] << endl;
        
        cout << endl;
        
    } // end for
        
    
} // end main
