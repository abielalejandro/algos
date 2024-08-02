package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DFSGraphAdjListTest {

    static DFSGraphAdjList<Integer> svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new DFSGraphAdjList<Integer>();
    }

    @Test
    public void testOK() {

        GraphNode<Integer> a = new GraphNode<Integer>(1);
        GraphNode<Integer> b = new GraphNode<Integer>(2);
        GraphNode<Integer> c = new GraphNode<Integer>(3);
        GraphNode<Integer> d = new GraphNode<Integer>(4);

        a.addNeighbor(b);
        a.addNeighbor(d);

        b.addNeighbor(c);
        b.addNeighbor(a);

        c.addNeighbor(b);
        c.addNeighbor(d);

        d.addNeighbor(a);
        d.addNeighbor(c);    

        List<Integer> result = Arrays.asList(1,4,3,2);
        List<Integer> path = svc.walk(a);

        assertEquals(result.size(), path.size());
        for(int i=0; i<path.size();i++) {
            assertEquals(path.get(i),result.get(i));
        }
    }

    @Test
    public void testOKTwo() {

        GraphNode<Integer> a = new GraphNode<Integer>(0);
        GraphNode<Integer> b = new GraphNode<Integer>(1);
        GraphNode<Integer> c = new GraphNode<Integer>(2);
        GraphNode<Integer> d = new GraphNode<Integer>(3);
        GraphNode<Integer> e = new GraphNode<Integer>(4);

        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);

        b.addNeighbor(a);

        c.addNeighbor(a);
        c.addNeighbor(d);
        c.addNeighbor(e);


        d.addNeighbor(a);
        d.addNeighbor(c);

        e.addNeighbor(c);


        List<Integer> result = Arrays.asList(0,3,2,4,1);
        List<Integer> path = svc.walk(a);

        assertEquals(result.size(), path.size());
        for(int i=0; i<path.size();i++) {
            assertEquals(path.get(i),result.get(i));
        }
    }

    @Test
    public void testOKThree() {

        GraphNode<Integer> a = new GraphNode<Integer>(0);
        GraphNode<Integer> b = new GraphNode<Integer>(1);
        GraphNode<Integer> c = new GraphNode<Integer>(2);
        GraphNode<Integer> d = new GraphNode<Integer>(3);
        GraphNode<Integer> e = new GraphNode<Integer>(4);

        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);

        b.addNeighbor(a);

        c.addNeighbor(a);
        c.addNeighbor(d);
        c.addNeighbor(e);


        d.addNeighbor(a);
        d.addNeighbor(c);

        e.addNeighbor(c);


        List<Integer> result = Arrays.asList(1,0,3,2,4);
        List<Integer> path = svc.walk(b);

        assertEquals(result.size(), path.size());
        for(int i=0; i<path.size();i++) {
            assertEquals(path.get(i),result.get(i));
        }
    }


    @Test
    public void testOKEmpty() {

        List<Integer> result = Collections.emptyList();
        List<Integer> path = svc.walk(null);

        assertEquals(result.size(), path.size());
    }    
}
