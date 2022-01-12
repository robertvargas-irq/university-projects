// CS 271 - M04 – PA 6
// Program name: binaryTree.c
// Author:       Robert Vargas
// Date:         3/18/2021
// Purpose:      This program fully implements the functions
//               within the custom header file binaryTree.h.
//               The code manipulates dynamically-allocated
//               binary trees, using binary tree STRUCTURES,
//               utilizing pointers and dynamic lists in order
//               to create, iterate, and summate the elements
//               (leaves) of said tree, as well as get the
//               minimum and maximum through recursive iteration.


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "binaryTree.h"

// insert node into tree
void insertNode(TreeNodePtr *treePtr, int value)
{ 
   // if tree is empty
   if (*treePtr == NULL) {   
      *treePtr = malloc(sizeof(TreeNode));

      // if memory was allocated, then assign data
      if (*treePtr != NULL) { 
         (*treePtr)->data = value;
         (*treePtr)->leftPtr = NULL;
         (*treePtr)->rightPtr = NULL;
      } 
      else {
         printf("%d not inserted. No memory available.\n", value);
      } 
   } 
   else { // tree is not empty
      // data to insert is less than data in current node
      if (value < (*treePtr)->data) {                   
         insertNode(&((*treePtr)->leftPtr), value);   
      }                                         

      // data to insert is greater than data in current node
      else if (value > (*treePtr)->data) {                 
         insertNode(&((*treePtr)->rightPtr), value);     
      }                                        
      else { // duplicate data value ignored
         printf("%s", "dup");
      } 
   } 
} 

// begin inorder traversal of tree
void inOrder(TreeNodePtr treePtr)
{ 
   // if tree is not empty, then traverse
   if (treePtr != NULL) {                
      inOrder(treePtr->leftPtr);         
      printf("%3d", treePtr->data);      
      inOrder(treePtr->rightPtr);        
   }                           
} 

// begin preorder traversal of tree
void preOrder(TreeNodePtr treePtr)
{ 
   // if tree is not empty, then traverse
   if (treePtr != NULL) {                
      printf("%3d", treePtr->data);      
      preOrder(treePtr->leftPtr);        
      preOrder(treePtr->rightPtr);       
   }                           
} 

// begin postorder traversal of tree
void postOrder(TreeNodePtr treePtr)
{ 
   // if tree is not empty, then traverse
   if (treePtr != NULL) {                
      postOrder(treePtr->leftPtr);       
      postOrder(treePtr->rightPtr);      
      printf("%3d", treePtr->data);      
   }                           
} 

int min( TreeNodePtr treePtr ) {
    
    // declare minimum value with 0 in case of a null tree
    int minimum = 0;
    
    if ( treePtr != NULL ) {
        
        minimum = treePtr->data;
        
        // use recursion in order to get the left-most point
        if ( treePtr->leftPtr != NULL )
            return min( treePtr->leftPtr );
        else
            return minimum;
    } // end if
            
    return minimum;
    
} // end min

int max( TreeNodePtr treePtr ) {

    // declare maximum value with 0 in case of a null tree
    int maximum = 0;
    
    if ( treePtr != NULL ) {
        
        maximum = treePtr->data;
        
        // use recursion in order to get the left-most point
        if ( treePtr->rightPtr != NULL )
            return max( treePtr->rightPtr );
        else
            return maximum;
    } // end if
            
    return maximum;
    
} // end max

int sum( TreeNodePtr treePtr ) {
    
    // declare summation
    int summation = 0;
    
    if ( treePtr != NULL ) {
        
        int current = treePtr->data;
        
        // recursively loop through the tree
        if ( treePtr->rightPtr != NULL )
            current = current + sum( treePtr->rightPtr );
        if ( treePtr->leftPtr != NULL )
            current = current + sum( treePtr->leftPtr );
        
        summation += current;
        return summation;
        
    } // end if
    
    return summation;
    
} // end sum


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
