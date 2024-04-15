package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

    @Test
    void testMinInteger() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(Integer.MIN_VALUE);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }

    @Test
    void testMaxInteger() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(Integer.MAX_VALUE);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }

    @Test
    void testNegativeNumber() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(-17);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }

    @Test
    void testZero() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(0);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }

    @Test
    void testValidNumber() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(1245);
        assertEquals("MCCXLV", result);
    }

    @Test
    void testValidNumberMin() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(1);
        assertEquals("I", result);
    }

    @Test
    void testValidNumberMax() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(3000);
        assertEquals("MMM", result);
    }

    @Test
    void testNumberOver3000() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(5429);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }
}
