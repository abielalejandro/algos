#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

struct Node {
  size_t data;
  struct Node *next;
} Node;

struct StackList {
  struct Node *top;
} StackList;

struct Stack {
  int top;
  size_t size;
  size_t *data;
};

size_t isEmpty(struct Stack *st) { return st->top == -1 ? 1 : 0; }
size_t isFull(struct Stack *st) { return st->top == st->size - 1 ? 1 : 0; }

void push(struct Stack *st, size_t val) {
  if (isFull(st) == 1) {
    printf("Stack full\n");
    return;
  }
  st->top++;
  st->data[st->top] = val;
}

int pop(struct Stack *st) {
  if (isEmpty(st) == 1) {
    printf("Stack is empty\n");
    return -1;
  }
  return st->data[st->top--];
}

int peek(struct Stack *st, size_t pos) {
  if (pos >= st->size || pos > st->top) {
    printf("Invalid position\n");
    return -1;
  }
  if (isEmpty(st) == 1) {
    printf("Stack is empty\n");
    return -1;
  }

  return st->data[pos];
}

void Display(struct Stack *st) {
  printf("Values:\n");
  for (int i = 0; i <= st->top; i++) {
    printf("%lu\n", st->data[i]);
  }
}

struct Stack *newStack(size_t size) {
  struct Stack *st = malloc(sizeof(struct Stack));
  st->size = size;
  st->data = malloc(sizeof(int) * size);
  st->top = -1;
  return st;
}

void pushSl(struct StackList *st, size_t val) {
  struct Node *node = malloc(sizeof(struct Node));
  if (NULL == node) {
    printf("Stack full\n");
    return;
  }

  struct Node *top = st->top;
  node->next = top;
  node->data=val;
  st->top = node;
}

int popSl(struct StackList *st) {
  if (NULL == st->top) {
    printf("Stack empty\n");
    return -1;
  }

  struct Node *top = st->top;
  st->top = top->next;
  return top->data;
}

int peekSl(struct StackList *st, int pos) {
   if (NULL == st->top) {
    printf("Stack empty\n");
    return -1;
  }

   struct Node *node = st->top;
    for (int i = 0; i < pos && NULL!=node; i++) {
        node = node->next; 
    }

    if (NULL==node) {
        printf("Invalid position\n");
        return -1;
    }
    return node->data;
}

void DisplaySl(struct StackList *st) {
    struct Node *n = st->top;
    printf("values:\n");
    while(NULL!=n) {
        printf("%lu\n",n->data);
        n=n->next;
    }
}

struct StackList *newStackSl() {
  struct StackList *st = malloc(sizeof(struct StackList));
  st->top = NULL;
  return st;
}

int main(int argc, char *argv[]) {
  return 0;
}
