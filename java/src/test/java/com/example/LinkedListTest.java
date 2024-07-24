package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    static CustomLinkedList<Integer> svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new CustomLinkedList<Integer>();
    }

    @BeforeEach
    public void clear() {
        svc.clear();
    }

    @Test
    public void testSize() {
        svc.add(10);
        svc.add(25);
        svc.add(44);

        assertEquals(3, svc.size());
    }

    @Test
    public void testAddAt() {
        svc.add(10);
        svc.add(25);
        svc.add(44);

        svc.addAt(100, 2);
        assertTrue(svc.getAt(2).val.equals(100));

        svc.addLast(250);
        assertTrue(svc.getAt(4).val.equals(250));

        svc.addAt(25, 0);
        assertTrue(svc.getAt(0).val.equals(25));

        svc.addFirst(99);
        assertTrue(svc.getAt(0).val.equals(99));
    }

    @Test
    public void removeAt() {
        svc.add(10);
        svc.add(25);
        svc.add(44);

        svc.removeAt(0);
        assertTrue(svc.getAt(0).val.equals(25));
    }

    @Test
    public void removeAt2() {
        svc.add(10);
        svc.add(25);
        svc.add(44);

        svc.removeAt(1);
        assertTrue(svc.getAt(1).val.equals(44));
    }

    @Test
    public void removeAtTwo() {
        svc.add(10);
        svc.add(25);
        svc.add(44);
        svc.removeAt(2);
        assertEquals(2, svc.size());

        svc.removeAt(50);
        assertEquals(2, svc.size());
    }

    @Test
    public void removeVal() {
        svc.add(10);
        svc.add(25);
        svc.add(44);

        svc.remove(50);
        assertEquals(svc.size(), 3);

        svc.remove(25);
        assertEquals(svc.size(), 2);
        assertEquals(svc.getAt(1).val, 44);

        svc.remove(10);
        assertEquals(svc.size(), 1);
        assertEquals(svc.getAt(0).val, 44);
    }
}
