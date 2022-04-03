package dev.gruhart.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
la idea es resolverlo primero siguiendo un enfoque tdd y llegar asi a la recursividad
 */

public class TestFactorial {

    @Test
    public void testCasoBasico(){

        CalculaFactorial calculaFactorial = new CalculaFactorial();
        assertEquals(1,calculaFactorial.calcula(1));
        assertEquals(1,calculaFactorial.calcula(0));

    }


}
