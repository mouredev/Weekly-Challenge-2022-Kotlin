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

    @Test
    public void testDosDigitos(){
        assertFalse(new MyMath().isArmstrongNumbber(10));
        assertFalse(new MyMath().isArmstrongNumbber(13));
        assertFalse(new MyMath().isArmstrongNumbber(15));
        assertFalse(new MyMath().isArmstrongNumbber(45));
        assertFalse(new MyMath().isArmstrongNumbber(61));
    }
}
