package com.rengut.challenge;

/*
 * Reto #2
 * LA SUCESIÓN DE FIBONACCI
 * Fecha publicación enunciado: 10/01/22
 * Fecha publicación resolución: 17/01/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 * La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
 * 0, 1, 1, 2, 3, 5, 8, 13...
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge2 {

    /** First attempt
    public static void main(String[] args) {
        for (long i = 0; i < 50; i++) {
            System.out.println(" Nro." + (i + 1) + " -> "+ fibonacci(i));
        }
    }

    static long fibonacci(long n) {
        if (n>1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return -1;
        }
    }

     * with help **/
    public static void main(String[] args) {
        int n = 50;
        long[] fibonacciSequence = generateFibonacci(n);

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ": " + fibonacciSequence[i]);
        }
    }

    static long[] generateFibonacci(int n) {
        long[] fibonacciSequence = new long[n];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        return fibonacciSequence;
    }
}
