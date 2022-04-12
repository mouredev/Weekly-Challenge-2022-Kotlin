package dev.grubhart.challenge14;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArmstrongNumber {

    @Test
    public void testUnDigito(){

        assertTrue(new MyMath().isArmstrongNumbber(0));
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

    @Test
    public void testTresDigitosCasoNegativo(){
        assertFalse(new MyMath().isArmstrongNumbber(101));
    }

    @Test
    public void testTresDigitosCasoPositivo(){
        assertTrue(new MyMath().isArmstrongNumbber(153));
    }

    @Test
    public void testCasoGeneral(){
        assertTrue(new MyMath().isArmstrongNumbber(370));
        assertTrue(new MyMath().isArmstrongNumbber(371));
        assertTrue(new MyMath().isArmstrongNumbber(9474));
        assertFalse(new MyMath().isArmstrongNumbber(9475));
        assertFalse(new MyMath().isArmstrongNumbber(8424));
    }

    @Test
    public void testCasoNegativo(){
        assertNull(new MyMath().isArmstrongNumbber(-370));
    }
}
