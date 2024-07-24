package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    static QuickSort svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new QuickSort();
    }

    @Test
    void sortOK() {

        int[] arr = { 10, 80, 30, 90, 40 };
        int[] expected = { 10, 30, 40, 80, 90 };
        svc.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }

    @Test
    void sortOKEmpty() {

        int[] arr = {};
        int[] expected = {};
        svc.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }

    @Test
    void sortOKTwo() {

        int[] arr = { 50, 25, 49, 2, 88, 36, 44, 109, 1, 10 };
        int[] expected = { 1, 2, 10, 25, 36, 44, 49, 50, 88, 109 };
        svc.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }
}
