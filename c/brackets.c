#include "stack.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 100

short isOpeningBracket(char c) {
    return c=='(' || c=='[' ? 1: 0;
}

short isClosingBracket(char c) {
    return c==')' || c==']' ? 1: 0;
}

short isBracket(char c) {
    return isOpeningBracket(c) || isClosingBracket(c);
}

short isOperator(char c) {
    switch (c)
    {
        case '-':
        case '+':
        case '*':
        case '/':
            return 1;
    }
    return 0;
}

short precedence(char c) {
    switch (c)
    {
        case '-':
        case '+':
            return 1;
        case '*':
        case '/':
            return 2;
    }
    return 0;

}


char *infToPosf(char *infix) {
    int size = strlen(infix);
    struct Stack *st = newStack(size);
    char *postfix = (char *) malloc(sizeof(char) * (size+1));
    int i=0,j=0;
    while(infix[i]!='\0') {
        if (isBracket(infix[i])==1) {
            i++;
            continue;
        }

        if (isOperator(infix[i])==1) {
            if (precedence(infix[i])>precedence(peek(st, 0))) {
                push(st, infix[i++]);
            }
            else {
                postfix[j++] = pop(st); 
            }
        }else {
           if (isBracket(infix[i])==0) {
            postfix[j++]=infix[i++];
           }
        } 
    }

    while (isEmpty(st)==0) {
        postfix[j++]=pop(st);
    }

    freeStack(st);
    return postfix;
}

short isBalanced(char *s) {
    int size = strlen(s);
    int i=0;
    struct Stack *st = newStack(size);
    while(s[i]!='\0') {
        if (isClosingBracket(s[i])) {
            pop(st);
            i++;
        }
        else {
            if (isOpeningBracket(s[i])) {
                push(st,s[i]);
            }
            i++;
        }
    }

    int is = isEmpty(st);
    freeStack(st);
    return is;
}