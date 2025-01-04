#include <stdio.h>
#include <stdlib.h>
#define N 10

int binarySearch(int *arr,int size, int key) {
    int low, high,middle;
    low=0;
    high= size -1;
    while(low<=high) {
        middle = (low+high)/2;
        if (arr[middle]==key) {
          return middle; 
        }
        else if (key>arr[middle]) {
           low=middle+1; 
        }
        else {
           high = middle-1;
        } 
    }
    return -1;
}

int main(int argc, char *argv[])
{
    int arr[N] = {10,20,30,40,50,60,70,80,90,100};   
    printf("Searching %d index=%d\n",4, binarySearch(arr,N, 4));
    printf("Searching %d index=%d\n",10, binarySearch(arr,N, 10));
    printf("Searching %d index=%d\n",50, binarySearch(arr,N, 50));
}
