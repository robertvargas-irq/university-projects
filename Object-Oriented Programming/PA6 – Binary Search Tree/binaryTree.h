// CS 271 - M04 – PA 6
// Program name: binaryTree.h
// Author:       Robert Vargas
// Date:         3/18/2021
// Purpose:      This program defines function prototypes for
//               the implemented function code in binaryTree.c.
//               The code manipulates dynamically-allocated
//               binary trees, using binary tree STRUCTURES,
//               utilizing pointers and dynamic lists in order
//               to create, iterate, and summate the elements
//               (leaves) of said tree, as well as get the
//               minimum and maximum through recursive iteration.

//
// struct definition and prototypes for binary tree functions
// 
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#ifndef BINARY_TREE
#define BINARY_TREE

// node structure definition                            

struct treeNode {                                           
   struct treeNode *leftPtr; // pointer to left subtree 
   int data; // node value                               
   struct treeNode *rightPtr; // pointer to right subtree
}; 

// typedef statements to make it easier to declare node and tree
// variables

typedef struct treeNode TreeNode; // synonym for struct treeNode
typedef TreeNode *TreeNodePtr; // synonym for TreeNode*

// function prototypes
void insertNode(TreeNodePtr *treePtr, int value);
void inOrder(TreeNodePtr treePtr);
void preOrder(TreeNodePtr treePtr);
void postOrder(TreeNodePtr treePtr);
int min(TreeNodePtr treePtr);
int max(TreeNodePtr treePtr);
int sum(TreeNodePtr treePtr);

#endif
