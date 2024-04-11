package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

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
    void testNumberOver3000() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        String result = transformer.transformNumber(5429);
        assertEquals("Eingabe ausserhalb des Wertebereichs!", result);
    }
}
