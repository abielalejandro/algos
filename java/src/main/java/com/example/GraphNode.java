package com.example;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    T val;
    List<GraphNode<T>> neighbors;

    public GraphNode(T val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode<T> addNeighbor(GraphNode<T> neighbor) {
        neighbors.add(neighbor);
        return this;
    }

    public T getVal() {
        return val;
    }

    public List<GraphNode<T>> getNeighbors() {
        return neighbors;
    }
}
