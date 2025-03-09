#include <stdlib.h>
#include <stdio.h>
#include "linklist.h"

LinkList *createLinkList() {
   LinkList *list =  malloc(sizeof(LinkList));
  if (list==NULL) return NULL;
   list->head = NULL;
   list->tail=NULL;
   return list;
}

LinkNode *createNode(int value) {
  LinkNode *node = malloc(sizeof(LinkNode));
  if (node==NULL) return NULL;
  node->next=NULL;
  node->prev=NULL;
  node->value=value;

  return node;
}

size_t Exists(LinkList *list, int value) {
    if (list==NULL) return 0;

    LinkNode *current = list->head;
    while (current!=NULL) {
       if (current->value==value) return 1;
       current=current->next;
    }

    return 0;
}

void Insert(LinkList *list,int value) {
    if (list==NULL) return;
    if (Exists(list, value)==1) {
        perror("Exists");
        return;
    }

    LinkNode *node = createNode(value);
    if (node==NULL) {
      perror("Overflow");
      return;
    }
    if (list->head == NULL) {
       list->tail = node;
       list->head= node;
    } 
    else {
       node->prev=list->tail; 
       list->tail->next=node;
       list->tail=node;
    }
}

void InsertSorted(LinkList *list,int value) {
    if (list==NULL) return;
    LinkNode *node = createNode(value);
    if (node==NULL) {
      perror("Overflow");
      return;
    }

    if (list->head==NULL) {
        list->head = node;
        list->tail=node;
        return;
    }
    

    LinkNode *current = list->head;
    while (current && current->value<value) {
        current = current->next;
    }

    if (current) {
        current->prev->next = node;
        current->prev=node;
        node->next = current;
    }
    else {
       list->tail->next=node;
       node->prev=list->tail;
       list->tail=node; 
    }
}

LinkNode *Search(LinkList *list, int value) {
    if (list==NULL) return NULL;

    LinkNode *current = list->head;
    while (current!=NULL) {
       if (current->value==value) return current;
       current=current->next;
    }

    return NULL;
}

void Delete(LinkList *list, int value) {
   LinkNode *node = Search(list, value); 
   if (node) {
     if (node->prev)  
        node->prev->next = node->next;
     else {
        list->head = node->next;
        list->tail = node->next;
     }
     free(node);
   }
}

void Print(LinkList *list) {
    if (list==NULL) return;
    LinkNode *current = list->head;
    while (current!=NULL) {
        printf("Value %d\n", current->value);
        current = current->next;
    }
}

void DeleteAll(LinkList *list) {
    if (list==NULL) return;
    LinkNode *current = list->head;
    while (current!=NULL) {
        list->head=current->next;
        free(current);
        current = list->head;
    }

    list->head=NULL;
    list->tail=NULL;
}

void DeleteList(LinkList *list) {
    if (list==NULL) return;
    DeleteAll(list);
    free(list);
}
