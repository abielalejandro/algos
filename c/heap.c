#include <stdio.h>
#include <stdlib.h>
#define N 20

typedef struct {
  int *A;
  int length;
} Heap;

int Parent(int index) { return (index - 1) / 2; }

int Left(int index) { return (2 * index) + 1; }

int Right(int index) { return (2 * index) + 2; }

void HeapifyUp(Heap *heap) {
  int i = heap->length;
  while (i > 0) {
    int parent = Parent(i);

    if (heap->A[parent] > heap->A[i]) {
      break;
    }

    if (heap->A[parent] < heap->A[i]) {
      int tmp = heap->A[parent];
      heap->A[parent] = heap->A[i];
      heap->A[i] = tmp;
      i = parent;
    }
  }
}

void MinHeapifyUp(Heap *heap) {
  int i = heap->length;
  while (i > 0) {
    int parent = Parent(i);

    if (heap->A[parent] < heap->A[i]) {
      break;
    }

    if (heap->A[parent] > heap->A[i]) {
      int tmp = heap->A[parent];
      heap->A[parent] = heap->A[i];
      heap->A[i] = tmp;
      i = parent;
    }
  }
}

void HeapifyDown(Heap *h) {
  int parent = 0;
  int left = Left(parent);
  int right = Right(parent);

  while (parent < h->length && left<h->length && right<h->length ) {
    int value = h->A[parent];
    int vLeft = h->A[left];
    int vRight = h->A[right];
    if (vLeft > vRight && vLeft > value) {
      h->A[parent] = vLeft;
      h->A[left] = value;
      parent=left;
    } else if (vRight > vLeft && vRight > value) {
      h->A[parent] = vRight;
      h->A[right] = value;
      parent= right;

    }else {
        break;
    }

    left = Left(parent);
    right = Right(parent);

  }
}

void MinHeapifyDown(Heap *h) {
  int parent = 0;
  int left = Left(parent);
  int right = Right(parent);

  while (parent < h->length && left<h->length && right<h->length ) {
    int value = h->A[parent];
    int vLeft = h->A[left];
    int vRight = h->A[right];
    if (vLeft < vRight && vLeft < value) {
      h->A[parent] = vLeft;
      h->A[left] = value;
      parent=left;
    } else if (vRight < vLeft && vRight < value) {
      h->A[parent] = vRight;
      h->A[right] = value;
      parent= right;
    }else {
        break;
    }
    left = Left(parent);
    right = Right(parent);
  }
}

void Insert(Heap *heap, int val) {
  heap->A[heap->length] = val;
  HeapifyUp(heap);
  heap->length++;
}

void MinInsert(Heap *heap, int val) {
  heap->A[heap->length] = val;
  MinHeapifyUp(heap);
  heap->length++;
}

int Pop(Heap *heap) {
  if (heap->length == 0)
    return -1;
  heap->length--;
  int current = heap->A[0];
  heap->A[0] = heap->A[heap->length];
  HeapifyDown(heap);
  return current;
}

int MinPop(Heap *heap) {
  if (heap->length == 0)
    return -1;
  heap->length--;
  int current = heap->A[0];
  heap->A[0] = heap->A[heap->length];
  MinHeapifyDown(heap);
  return current;
}

int Peek(Heap *heap) {
  if (heap->length == 0)
    return -1;
  return heap->A[0];
}

void Sort(Heap *h) {
   int length = h->length;
   while (h->length>0) {
      int val =Pop(h);
      h->A[h->length]=val;
   }
   h->length = length;
}

void Display(Heap *h) {
  printf("Los valores son: ");
  for (int i = 0; i < h->length; i++) {
    printf("%d ", h->A[i]);
  }
  printf("\n");
}

int main(int argc, char *argv[]) {
  Heap minHeap, maxHeap;
  minHeap.A = malloc(N * sizeof(int));
  minHeap.length = 0;
  MinInsert(&minHeap, 10);
  MinInsert(&minHeap, 20);
  MinInsert(&minHeap, 30);
  MinInsert(&minHeap, 25);
  MinInsert(&minHeap, 5);
  MinInsert(&minHeap, 40);
  MinInsert(&minHeap, 35);
  Display(&minHeap);
  MinPop(&minHeap);
  Display(&minHeap);
  free(minHeap.A);

  maxHeap.A = malloc(N * sizeof(int));
  maxHeap.length = 0;
  Insert(&maxHeap, 10);
  Insert(&maxHeap, 20);
  Insert(&maxHeap, 30);
  Insert(&maxHeap, 25);
  Insert(&maxHeap, 5);
  Insert(&maxHeap, 40);
  Insert(&maxHeap, 35);
  Display(&maxHeap);
  Pop(&maxHeap);
  Display(&maxHeap);


  return 0;
}
