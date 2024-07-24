package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HexColorToRgbTest {

    static HexColorToRgb svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new HexColorToRgb();
    }

    @Test
    void toRgb000() {

        RGB rgb = svc.toRgb("#000");

        assertEquals(rgb.r,0);
        assertEquals(rgb.g,0);
        assertEquals(rgb.b,0);
    }

    @Test
    void toRgb151515() {
        HexColorToRgb svc = new HexColorToRgb();
        RGB rgb = svc.toRgb("#FFF");

        assertEquals(rgb.r,15);
        assertEquals(rgb.g,15);
        assertEquals(rgb.b,15);
    }

    @Test
    void toRgb255255255() {
        HexColorToRgb svc = new HexColorToRgb();
        RGB rgb = svc.toRgb("#FFFFFF");

        assertEquals(rgb.r,255);
        assertEquals(rgb.g,255);
        assertEquals(rgb.b,255);
    }

    @Test
    void toRgbRed() {
        HexColorToRgb svc = new HexColorToRgb();
        RGB rgb = svc.toRgb("#FF0000");

        assertEquals(rgb.r,255);
        assertEquals(rgb.g,0);
        assertEquals(rgb.b,0);
    }

    @Test
    void toRgbGreen() {
        HexColorToRgb svc = new HexColorToRgb();
        RGB rgb = svc.toRgb("#00FF00");

        assertEquals(rgb.r,0);
        assertEquals(rgb.g,255);
        assertEquals(rgb.b,0);
    }

    @Test
    void toRgbBlue() {
        HexColorToRgb svc = new HexColorToRgb();
        RGB rgb = svc.toRgb("#0000FF");

        assertEquals(rgb.r,0);
        assertEquals(rgb.g,0);
        assertEquals(rgb.b,255);
    }

    @Test
    void otro() {
        int a =10;
        int b =20;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        assertEquals(b,10);
        assertEquals(a,20);

    }
}