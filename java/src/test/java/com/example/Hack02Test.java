package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Hack02Test {
    
    static Hack02 svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new Hack02();
    }

    @Test
    public void TestOk() {

        int[][] data = new int[][]{{1,2,3},{3,1,2},{2,3,1}};
           
        boolean expected = true;
        boolean result = svc.isValid(data);

        assertEquals(result,expected);
    }

    @Test
    public void TestOk02() {

        int[][] data = new int[][]{{1,4,2,3},{3,2,1,4},{2,3,4,1}, {4,1,3,2}};
           
        boolean expected = true;
        boolean result = svc.isValid(data);

        assertEquals(result,expected);
    }

}
