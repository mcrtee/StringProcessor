package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestStringProcessor {


    @Test
    public void testIsStrongPassword() {
        StringProcessor processor = new StringProcessor();
        assertTrue(processor.isStrongPassword("StrongPassword1!"));  // Valid password
        assertFalse(processor.isStrongPassword("weakpassword"));  // No uppercase, digits, or special symbols
        assertFalse(processor.isStrongPassword("N0SpecialChar"));  // No special symbols
        assertFalse(processor.isStrongPassword("!OnlySpecial@"));  // No digits
        assertTrue(processor.isStrongPassword("ValidPassword123!"));  // Valid password
    }

    @Test
    public void testCalculateDigits() {
        StringProcessor processor = new StringProcessor();
        assertEquals(3, processor.calculateDigits("There are 123 digits."));
        assertEquals(0, processor.calculateDigits("No digits here!"));
        assertEquals(2, processor.calculateDigits("Mixed 9 and 8!"));
        assertEquals(1, processor.calculateDigits("5 is the only number."));
        assertEquals(10, processor.calculateDigits("9876543210"));
    }

    @Test
    public void testCalculateWords() {
        StringProcessor processor = new StringProcessor();
        assertEquals(2, processor.calculateWords("Hello World!"));
        assertEquals(4, processor.calculateWords("This is a test."));
        assertEquals(0, processor.calculateWords("   "));  // No words
        assertEquals(1, processor.calculateWords("OneWord"));
        assertEquals(4, processor.calculateWords("   Multiple spaces between   words  "));
    }

    @Test
    public void testCalculateExpression() {
        StringProcessor processor = new StringProcessor();
        assertEquals(10.0, processor.calculateExpression("5 + 5"), 0.001);
        assertEquals(6.0, processor.calculateExpression("10 - 4"), 0.001);
        assertEquals(6.0, processor.calculateExpression("2 * 3"), 0.001);
        assertEquals(3.0, processor.calculateExpression("12 / 4"), 0.001);
        assertEquals(16.0, processor.calculateExpression("(3 + 5) * 2"), 0.001);
    }
}
