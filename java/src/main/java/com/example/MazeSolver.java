package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MazeSolver {

    int[][] paths = {{0,-1},{1,0},{0,1},{-1,0}};

    private boolean resolve(
            char[][] maze,
            char wall,
            char end,
            Point current,
            Queue<Point> path,
            Map<String, Boolean> visited) {

        if (maze.length==0 || maze[0].length==0)
            return false;

        if (current.x < 0 || current.x >= maze[0].length || current.y < 0 || current.y >= maze.length) {
            return false;
        }

        if (maze[current.y][current.x] == wall)
            return false;

        String visitedKey = current.x + "," + current.y;
        if (visited.containsKey(visitedKey))
            return false;

        visited.put(visitedKey, true);
        path.add(current);

        if (maze[current.y][current.x] == end)
            return true;


        for (int i = 0; i < paths.length; i++) {
            if (resolve(maze, wall, end, new Point(current.x + paths[i][0], current.y + paths[i][1]), path, visited)) {
                return true;
            }
        }
        path.remove();

        return false;
    }

    public Queue<Point>  resolve(char[][] maze, char wall, Point start, char end) {
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        Queue<Point> path = new LinkedList<>();
        resolve(maze, wall, end, start, path, visited);

        return path;
    }

    public void printPath(Queue<Point> path) {
        while (!path.isEmpty()) {
            Point p = path.remove();
            System.out.printf(" row: %d, column: %d\n", p.y, p.x);
        }
    }
}
