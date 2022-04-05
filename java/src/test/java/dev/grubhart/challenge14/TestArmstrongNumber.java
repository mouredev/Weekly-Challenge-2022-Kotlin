package dev.grubhart.challenge14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestArmstrongNumber {

    @Test
    public void testUnDigito(){

        assertTrue(new MyMath().isArmstrongNumbber(1));
        assertTrue(new MyMath().isArmstrongNumbber(2));
        assertTrue(new MyMath().isArmstrongNumbber(7));
        assertTrue(new MyMath().isArmstrongNumbber(8));
    }
}
