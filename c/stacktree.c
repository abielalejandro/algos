#include "stacktree.h"
#include "binarytree.h"
#include <stdio.h>
#include <stdlib.h>

void push(struct StackList *st, struct TreeNode *val) {
  struct TreeListNode *node = malloc(sizeof(struct TreeListNode));
  if (NULL == node) {
    printf("Stack full\n");
    return;
  }

  struct TreeListNode *top = st->top;
  node->next = top;
  node->data = val;
  st->top = node;
}

struct TreeNode* pop(struct StackList *st) {
  if (NULL == st->top) {
    printf("Stack empty\n");
    return -1;
  }

  struct TreeListNode *top = st->top;
  st->top = top->next;
  return top->data;
}

struct TreeNode* peek(struct StackList *st, int pos) {
  if (NULL == st->top) {
    printf("Stack empty\n");
    return -1;
  }

  struct TreeListNode *node = st->top;
  for (int i = 0; i < pos && NULL != node; i++) {
    node = node->next;
  }

  if (NULL == node) {
    printf("Invalid position\n");
    return -1;
  }
  return node->data;
}

struct StackList *newStack() {
  struct StackList *st = (struct StackList *)malloc(sizeof(struct StackList));
  st->top = NULL;
  return st;
}

void freeStackSl(struct StackList *st) {
  free(st);
  st = NULL;
}
