#include <stdio.h>

struct Node {
  size_t data;
  struct Node *next;
} ;

struct StackList {
  size_t size;
  struct Node *top;
} ;

struct Stack {
  int top;
  size_t size;
  size_t *data;
};



size_t isEmpty(struct Stack *st);
size_t isFull(struct Stack *st);
void push(struct Stack *st, size_t val);
int pop(struct Stack *st) ;
int peek(struct Stack *st, size_t pos) ;
void Display(struct Stack *st) ;
struct Stack *newStack(size_t size);
void freeStack(struct Stack *st);

void pushSl(struct StackList *st, size_t val) ;
int popSl(struct StackList *st) ;
int peekSl(struct StackList *st, int pos) ;
void DisplaySl(struct StackList *st);
struct StackList *newStackSl();
void freeStackSl(struct StackList *st);
