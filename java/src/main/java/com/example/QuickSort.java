package com.example;

public class QuickSort {

    private int partition(int[] array, int low, int hight) {
        int pivot = array[hight];
        int pivotIndex = low;
        for (int i = low; i < hight; i++) {
            if (array[i] < pivot) {
                int tmp = array[pivotIndex];
                array[pivotIndex] = array[i];
                array[i] = tmp;
                pivotIndex++;
            }
        }

        int tmp = array[hight];
        array[hight] = array[pivotIndex];
        array[pivotIndex] = tmp;
        return pivotIndex;
    }

    private void sort(int[] array, int low, int hight) {
        if (low > hight)
            return;

        int partitionIndex = partition(array, low, hight);
        sort(array, low, partitionIndex - 1);
        sort(array, partitionIndex + 1, hight);
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
