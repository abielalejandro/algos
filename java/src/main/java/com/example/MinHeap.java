package com.example;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    int length;
    List<Integer> data;
    // parent (index-1)/2
    // left 2(index) +1
    // right 2(index) +2

    public MinHeap() {
        this.length = 0;
        this.data = new ArrayList<Integer>();
    }

    public void insert(Integer v) {
        data.add(v);
        this.heapyfyUp(length);
        length++;
    }

    public Integer peek() {
        if (length == 0)
            return null;
        return data.get(0);
    }

    public Integer pop() {
        if (length == 0)
            return null;

        Integer val = data.get(0);
        length -= 1;
        if (length == 0) {
            data.clear();
            return val;
        }
        data.set(0, data.get(length));
        this.heapyfyDown(0);
        data.remove(length);
        return val;
    }

    private void heapyfyDown(int idx) {
        Integer rightIdx = right(idx);
        Integer leftIdx = left(idx);
        if (idx >= length || leftIdx >= length || rightIdx >= length) {
            return;
        }

        Integer value = data.get(idx);
        Integer rightValue = data.get(rightIdx);
        Integer leftValue = data.get(leftIdx);

        if (leftValue > rightValue && value > rightValue) {
            data.set(rightIdx, value);
            data.set(idx, rightValue);
            this.heapyfyDown(rightIdx);
        } else if (rightValue > leftValue && value > leftValue) {
            data.set(leftIdx, value);
            data.set(idx, leftValue);
            this.heapyfyDown(leftIdx);
        }
    }

    private void heapyfyUp(int idx) {
        if (idx == 0)
            return;

        Integer value = data.get(idx);
        Integer parentIdx = parent(idx);
        Integer parentValue = data.get(parentIdx);

        if (parentValue > value) {
            data.set(idx, parentValue);
            data.set(parentIdx, value);
            this.heapyfyUp(parentIdx);
        }
    }

    private int parent(int idx) {
        return ((idx - 1) / 2);
    }

    private int left(int idx) {
        return ((2 * idx) + 1);
    }

    private int right(int idx) {
        return ((2 * idx) + 2);
    }

    public void print() {
        for (Integer a : data) {
            System.out.println(a);
        }
        System.out.println("***");
    }

}
