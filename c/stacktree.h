#include <stdio.h>
#include "binarytree.h"

struct TreeListNode {
    struct TreeNode *next;
    struct TreeNode *data;
};

struct StackList {
  struct TreeListNode *top;
} ;

void push(struct StackList *st, struct TreeNode *val) ;
struct TreeNode* pop(struct StackList *st) ;
struct TreeNode* peek(struct StackList *st) ;
struct StackList *newStack();
void freeStack(struct StackList *st);
