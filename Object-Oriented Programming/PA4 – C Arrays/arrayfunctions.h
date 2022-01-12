// CS 271 - M04 – PA 4
// Program name: arrayfunctions.h
// Author:       Robert Vargas
// Date:         3/4/2021
// Purpose:      This program fully defines
//               header prototypes, with code
//               located in arrayfunctions.c

#ifndef ARRAYFUNCTIONS_H
#define ARRAYFUNCTIONS_H

void fillInteger( int a[], int length, int min, int max );
void fillCharacter( char c[], int length, char start, char end );
void findConsecutive( int array[], int length );
void findTriples( char c[], int length );
int countCharacter( char c[], int length, char searchChar );
void fillFloat( float a[], int length, float min, float max );
float floatMean( float array[], int length );
float floatMin( float array[], int length );
float floatMax( float array[], int length );

#endif
