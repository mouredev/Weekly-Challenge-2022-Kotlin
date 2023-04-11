/*
Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
0, 1, 1, 2, 3, 5, 8, 13...
 */
package weeklychallenge2022;

import java.math.BigInteger;

public class Challenge2opc {

    public static void main(String[] args) {

        int n = 50;
        BigInteger[] fibonacci = new BigInteger[n];

        fibonacci[0] = BigInteger.ZERO;
        fibonacci[1] = BigInteger.ONE;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Fibonacci[" + i + "] = " + fibonacci[i]);
        }

    }
}
