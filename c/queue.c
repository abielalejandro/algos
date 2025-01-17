#include <stdio.h>
#include <stdlib.h>

struct Queue {
  int capacity;
  int front;
  int rear;
  int *data;
};

struct Queue *createQueue(int capacity) {
  struct Queue *q = (struct Queue *)malloc(sizeof(struct Queue));
  q->capacity = capacity;
  q->front = q->rear = 0;
  q->data = (int *)malloc(sizeof(int) * capacity);

  return q;
}

int isEmpty(struct Queue *q) { return q->front == q->rear ? 1 : 0; }

int isFull(struct Queue *q) {
  return q->front == ((q->rear + 1) % q->capacity) ? 1 : 0;
}

void enqueue(struct Queue *q, int val) {
  if (isFull(q) == 1) {
    perror("Queue is full");
  } else {
    q->rear = (q->rear + 1) % q->capacity;
    q->data[q->rear] = val;
  }
}

int dequeue(struct Queue *q) {
  if (isEmpty(q) == 1) {
    perror("Queue is empty");
    return -1;
  }

  q->front = (q->front + 1) % q->capacity;
  return q->data[q->front];
}

int peek(struct Queue *q) {
  if (isEmpty(q) == 1) {
    perror("Queue is empty");
    return -1;
  }

  return q->data[q->front];
}

void Display(struct Queue *q) {
  if (isEmpty(q)) {
    perror("Empty Queue");
    return;
  }
  printf("Values\n");
  int i = q->front + 1;

  do {
    printf("%d\n", q->data[i]);
    i = (i + 1) % q->capacity;
  } while (i != (q->rear + 1) % q->capacity);

  printf("\n");
}

struct Node {
  int data;
  struct Node *next;
};

struct QueueLL {
  struct Node *front;
  struct Node *rear;
};

struct QueueLL *createQueueLL() {

  struct QueueLL *q = (struct QueueLL *)malloc(sizeof(struct QueueLL));
  if (q == NULL) {
    perror("Error creating the Queue");
    exit(1);
  }
  q->front = q->rear = NULL;

  return q;
}

struct Node *createNode(int val) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  if (node == NULL) {
    perror("Error creating the node");
    exit(1);
  }
  node->data = val;
  return node;
}

size_t isEmptyLL(struct QueueLL *q) { return q->front == NULL ? 1 : 0; }

void enqueueLL(struct QueueLL *q, int value) {
  struct Node *node = createNode(value);
  if (isEmptyLL(q) == 1) {
    q->front = q->rear = node;
  } else {
    q->rear->next = node;
    q->rear = node;
  }
}

int dequeueLL(struct QueueLL *q) {
  if (isEmptyLL(q) == 1) {
    perror("Queue is empty");
    return -1;
  }

  struct Node *n = q->front;
  q->front = n->next;
  int val = n->data;
  free(n);
  return val;
}

int peekLL(struct QueueLL *q) {
  if (isEmptyLL(q) == 1) {
    perror("Queue is empty");
    return -1;
  }

  return q->front->data;
}

void DisplayLL(struct QueueLL *q) {
  printf("Values:\n");
  struct Node *n = q->front;
  while (NULL != n) {
    printf("%d ", n->data);
    n = n->next;
  }
  printf("\n");
}
