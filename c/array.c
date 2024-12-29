#include <stdio.h>
#include <stdlib.h>
#include<unistd.h>
#define N 10

struct Array {
   size_t length;
   size_t size;
   int *A;
};

void display(struct Array *arr) {
   int i =0;
   printf("Lenght=%ld, size=%ld\n*\n", arr->length, arr->size);
   for (i=0;i< (*arr).length;i++) {
        printf("%d ",(*arr).A[i]);
   }
   printf("\n*\n");
}

void append(struct Array *arr, int num) {
    if ( arr->length==arr->size ) {
        return;
    } 

    arr->A[arr->length] = num;

    arr->length+=1;
    if ( arr->length>=arr->size ) {
       arr->length=arr->size; 
    } 
   
}

void insert( struct Array *arr, int index, int num) {
    if (index>=arr->size) return;
    if (index<0) return;

    int i;
    for(i=arr->length;i>index;i--) {
        arr->A[i] = arr->A[i-1];
    }
    arr->A[index]=num;
    arr->length+=1;
    if ( arr->length>=arr->size ) {
       arr->length=arr->size; 
    }     
}

void delete( struct Array *arr, int index) {
    if (index>arr->size) return;
    if (index<0) return;

    int i;
    for (i=index; i<=arr->length-1;i++) {
        arr->A[i]=arr->A[i+1];
    }
    arr->length-=1;

    if ( arr->length<0 ) {
       arr->length=0;
    }       
}

int search(struct Array *arr, int key) {
    int i;

    for (i=0;i<arr->length;i++) {
        if (key == arr->A[i]) return i;
    }

    return -1;
}

int binarySearch(struct Array *arr,int key) {
    int low, high,middle;
    low=0;
    high= arr->length -1;
    while(low<=high) {
        middle = (low+high)/2;
        if (arr->A[middle]==key) {
          return middle; 
        }
        else if (key>arr->A[middle]) {
           low=middle+1; 
        }
        else {
           high = middle-1;
        } 
    }
    return -1;
}

void swap(int *a, int *b) {
    int tmp = *a;
    *a=*b;
    *b=tmp;
}

int searchTransposition(struct Array *arr, int key) {
    int i;

    for (i=0;i<arr->length;i++) {
        if (key == arr->A[i]) {
            if (i>0) {
                swap(&arr->A[i], &arr->A[i-1]);
                return i-1;
            }
            return i;
        }
    }

    return -1;
}

int searchMoveHead(struct Array *arr, int key) {
    int i;
    for (i=0;i<arr->length;i++) {
        if (key == arr->A[i]) {
            swap(&arr->A[0], &arr->A[i]);
            return 0;
        }
    }

    return -1;
}

int get(struct Array *arr, int index) {
    if (index>(arr->length -1) || index<0) return -1;
    return arr->A[index]; 
}

int max(struct Array *arr) {
    int max=arr->A[0];
   for (int i=0; i<arr->length;i++) {
        if (arr->A[i]>max) {
            max = arr->A[i];
        }
   }

   return max;
}

int min(struct Array *arr) {
   int min=arr->A[0];
   for (int i=0; i<arr->length;i++) {
        if (arr->A[i]<min) {
            min = arr->A[i];
        }
   }

   return min;
}

int sum(struct Array *arr) {
   int sum =0;
   for (int i=0; i<arr->length;i++) {
        sum+=arr->A[i];
   }
   
   return sum;

}

int avg(struct Array *arr) {
   int sum =0;
   for (int i=0; i<arr->length;i++) {
        sum+=arr->A[i];
   }
   
   return sum/arr->length;

}

void reverse(struct Array *arr) {
    int j,i;
    for(i=0,j=arr->length-1;i<j;i++,j--) {
        swap(&arr->A[i], &arr->A[j]);
    }

}

void shiftLeft(struct Array *arr, size_t interval) {
    int i;
    if (interval>arr->size) return;

    for(i=interval;i<arr->length;i+=1) {
        arr->A[i-interval] = arr->A[i];
    }

    arr->A[i]=0;
    arr->length-=interval;

    if ( arr->length<0 ) {
       arr->length=0;
    }       
}

void shiftRight(struct Array *arr, size_t interval) {
    int i;
    if (interval>arr->size) return;

    for(i=arr->length;i>=0;i--) {
        arr->A[i+interval] = arr->A[i];
    }

    for(i=0;i<interval;i++) {
        arr->A[i] = 0;
    }


    arr->length+=interval;

    if ( arr->length>=arr->size ) {
       arr->length=arr->size; 
    }    
}


void rotateLeft(struct Array *arr) {
    int i,tmp;
    tmp = arr->A[0];
    for(i=1;i<arr->length;i++) {
        arr->A[i-1] = arr->A[i];
        arr->A[i] = 0;
    }

    arr->A[arr->size-1]=tmp;
    arr->length=arr->size;
}

void rotateRight(struct Array *arr) {
    int i, tmp;
    tmp = arr->A[arr->size-1]; 
    for(i=arr->length-1;i>=0;i--) {
        arr->A[i+1] = arr->A[i];
    }

    arr->A[0] = tmp;
    arr->length=arr->size;
}


int main(int argc, char *argv[])
{
    struct Array arr;
    arr.size= N; 
    arr.A= malloc(N*sizeof(int));
    append(&arr,8);
    append(&arr,12);
    append(&arr,16);
    append(&arr,29);
    append(&arr,33);
    append(&arr,19);
    append(&arr,10);
    append(&arr,18);
    append(&arr,80);
    append(&arr,67);
    return 0;
}
