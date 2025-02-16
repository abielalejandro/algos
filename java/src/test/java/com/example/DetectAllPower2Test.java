package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DetectAllPower2Test {
    
    static DetectAllPower2 svc;

    @BeforeAll
    public static void init() {
        svc = new DetectAllPower2();
    }

    @Test
    public void whenAllArePowerOf2() {
        int[] nums = new int[]{4,8,16};
        boolean result = svc.arePowerOf2(nums);
        assertTrue(result);
    }
}
