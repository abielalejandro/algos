#include <stdlib.h>
typedef struct LinkNode {
   int value;
   struct LinkNode *next;
   struct LinkNode *prev;
} LinkNode ;


typedef struct LinkList {
    LinkNode *head;
    LinkNode *tail;
} LinkList ;

LinkList *createLinkList() ;
LinkNode *createNode(int value) ;
size_t Exists(LinkList *list, int value) ;
void Insert(LinkList *list,int value) ;
void InsertSorted(LinkList *list,int value);
LinkNode *Search(LinkList *list, int value) ;
void Delete(LinkList *list, int value) ;
void Print(LinkList *list) ;
void DeleteAll(LinkList *list) ;
void DeleteList(LinkList *list) ;
