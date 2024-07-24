package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class MazeResolverTest {

    static MazeSolver svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new MazeSolver();
    }

    @Test
    void testOK() {
        
        char maze[][] ={
            {'#',' ','#','E','#'},
            {'#','#',' ',' ',' '},
            {' ',' ',' ','#',' '},
            {' ',' ','#','#','#'},
            {' ',' ',' ','#',' '}
        };

        Queue<Point> expected = new LinkedList<>();
        expected.add(new Point(0,4));
        expected.add(new Point(0,3));
        expected.add(new Point(0,2));
        expected.add(new Point(1,2));
        expected.add(new Point(2,2));
        expected.add(new Point(2,1));
        expected.add(new Point(3,1));
        expected.add(new Point(3,0));

        Queue<Point> path =  svc.resolve(maze, '#', new Point(0,4), 'E');
        assertTrue(!path.isEmpty());

        while(!path.isEmpty()) {
            Point point = path.remove();
            Point pointExpected = expected.remove();
            assertEquals(point.x, pointExpected.x);
            assertEquals(point.y, pointExpected.y);

        }

    }

    @Test
    void testNoPath() {

        char maze[][] ={
                {'#',' ','#','E','#'},
                {'#','#',' ','#',' '},
                {' ',' ',' ','#',' '},
                {' ',' ','#','#','#'},
                {' ',' ',' ','#',' '}
        };

        Queue<Point> path =  svc.resolve(maze, '#', new Point(0,4), 'E');
        assertTrue(path.isEmpty());

    }

    @Test
    void testNoPathEmpty() {

        char maze[][] ={};

        Queue<Point> path =  svc.resolve(maze, '#', new Point(0,4), 'E');
        assertTrue(path.isEmpty());

    }
}
