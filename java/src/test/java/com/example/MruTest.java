package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MruTest {

    static Mru<String, Integer> svc;

    
    @BeforeAll
    public static void beforeAll() {
        svc = new Mru<String, Integer>(3);
    }

    @Test
    public void testOK() {
        assertNull(svc.get("1234"));
        svc.update("1234", 1234);
        svc.update("12345", 12345);
        svc.update("123456", 123456);

        assertEquals(svc.get("1234"), 1234);
        assertEquals(svc.get("12345"), 12345);
        svc.update("1234567", 1234567);
        assertNull(svc.get("12345"));
    }

}
