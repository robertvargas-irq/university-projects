// CS 271 - M04 – PA 6
// Program name: pa6.c
// Author:       Robert Vargas
// Date:         3/18/2021
// Purpose:      This program tests the functions within
//               the custom header file binaryTree.h,
//               implementing its code which is located
//               within binaryTree.c. The code manipulates
//               dynamically-allocated binary trees, using
//               binary tree STRUCTURES, utilizing pointers
//               and dynamic lists in order to create, iterate,
//               and summate the elements (leaves) of said tree,
//               as well as get the minimum and maximum through
//               recursive iteration.


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "binaryTree.h"

// function main begins program execution
int main(void)
{
    // main tree: originally empty
    TreeNodePtr rootPtr = NULL;

    // empty tree: always empty
    TreeNodePtr emptyRootPtr = NULL;

    // single tree: only has one value which is 5
    TreeNodePtr singleRootPtr = NULL;
        insertNode(&singleRootPtr, 5);

    srand(time(NULL));
    puts("=========================================\n");
    puts("[ORIGINAL TREE] The numbers being placed in the tree are:");

    // insert random values between 0 and 14 in the ORIGINAL tree
    for (unsigned int i = 1; i <= 10; ++i) { 
        int item = rand() % 15;
        printf("%3d", item);
        insertNode(&rootPtr, item);
    } // end for

    // traverse the tree preOrder
    puts("\n\n[ORIGINAL TREE] The preOrder traversal is:");
    preOrder(rootPtr);

    // traverse the tree inOrder
    puts("\n\n[ORIGINAL TREE] The inOrder traversal is:");
    inOrder(rootPtr);

    // traverse the tree postOrder
    puts("\n\n[ORIGINAL TREE] The postOrder traversal is:");
    postOrder(rootPtr);
    printf("\n\n");
    
    
    //
    // print the contents of the extra trees
    //
    
    puts("=========================================\n");

    puts("[ORIGINAL TREE] The inOrder traversal is:");
    inOrder(rootPtr);
    printf("\n\n");
    
    puts("[EMPTY TREE]    The inOrder traversal is:");
    inOrder(emptyRootPtr);
    puts(" (it is empty)");
    printf("\n");
    
    puts("[ONE-NODE TREE] The inOrder traversal is:");
    inOrder(singleRootPtr);
    
    printf("\n\n");


    //
    // min() testing
    //
    
    puts("=========================================\n");
    puts("The following is a test of min() to find the minimum value of each individual tree:\n");
    printf("[ORIGINAL TREE] Minimum value: %d\n\n", min(rootPtr));
    printf("[EMPTY TREE]    Minimum value: %d\n\n", min(emptyRootPtr));
    printf("[ONE-NODE TREE] Minimum value: %d\n\n", min(singleRootPtr));


    //
    // max() testing
    //
    
    puts("=========================================\n");
    puts("The following is a test of max() to find the maximum value of each individual tree:\n");
    printf("[ORIGINAL TREE] Maximum value: %d\n\n", max(rootPtr));
    printf("[EMPTY TREE]    Maximum value: %d\n\n", max(emptyRootPtr));
    printf("[ONE-NODE TREE] Maximum value: %d\n\n", max(singleRootPtr));


    //
    // sum() testing
    //
    
    puts("=========================================\n");
    puts("The following is a test of the sum() function to summate the value of all the leaves/nodes in each individual tree:\n");
    printf("[ORIGINAL TREE] Summated result: %d\n\n", sum(rootPtr));
    printf("[EMPTY TREE]    Summated result: %d\n\n", sum(emptyRootPtr));
    printf("[ONE-NODE TREE] Summated result: %d\n\n", sum(singleRootPtr));

   

} // end main

