package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * CountPrimesTest
 */
public class CountPrimesTest {

    static CounterPrimes svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new CounterPrimes(3, 1);
    }

    @Test
    public void testOK() {
        int total = svc.run(20);
        assertEquals(total, 8);
    }
}
