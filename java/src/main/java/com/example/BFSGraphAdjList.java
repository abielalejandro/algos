package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraphAdjList<T> {
    public List<T> walk(GraphNode<T> node) {
        if (node == null)
            return Collections.emptyList();

        List<T> path = new ArrayList<>();
        Map<T, Boolean> visited = new HashMap<T,Boolean>();
        Queue<GraphNode<T>> q = new LinkedList<>();

        q.add(node);
        visited.put(node.val,true);

        while (!q.isEmpty()) {
            GraphNode<T> current = q.poll();
            path.add(current.val);
            for (GraphNode<T> neighbor : current.getNeighbors()) {
                if (visited.containsKey(neighbor.val)) continue;
                q.add(neighbor);
                visited.put(neighbor.val,true);
            }
        }

        return path;
    }

}
