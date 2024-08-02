package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFSGraphAdjList<T> {
    public List<T> walk(GraphNode<T> node) {
        if (node == null)
            return Collections.emptyList();

        List<T> path = new ArrayList<>();
        Map<T, Boolean> visited = new HashMap<T,Boolean>();
        Stack<GraphNode<T>> q = new Stack<GraphNode<T>>();

        q.add(node);
        visited.put(node.val,true);

        while (!q.isEmpty()) {
            GraphNode<T> current = q.pop();
            path.add(current.val);
            //System.out.println(path);
            for (GraphNode<T> neighbor : current.getNeighbors()) {
                if (visited.containsKey(neighbor.val)) continue;
               // System.out.printf("Agregando %d from %d\n", neighbor.val, current.val);
                q.add(neighbor);
                visited.put(neighbor.val,true);
            }
        }

        return path;
    }

}
