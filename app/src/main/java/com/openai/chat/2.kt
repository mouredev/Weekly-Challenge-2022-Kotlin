package com.openai.chat

import java.math.BigInteger

/*
 * Reto #2
 * LA SUCESIÓN DE FIBONACCI
 * Fecha publicación enunciado: 10/01/22
 * Fecha publicación resolución: 17/01/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Escribe un programa en Kotlin que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 *
 * Resuelto: Sí.
 * Iteracciones: 1
 * Explicación: En este programa, se declaran dos variables a y b que se inicializan con los valores 0 y 1, que son los dos primeros números de la sucesión de Fibonacci. Luego se imprime en pantalla estos valores.
 * A continuación, se itera desde el índice 2 hasta el 49 (los 50 primeros números de la sucesión menos los dos ya impresos). En cada iteración, se calcula el siguiente número de la sucesión como
 * la suma de los dos anteriores y se imprime en pantalla. Finalmente, se actualizan las variables a y b para que almacenen los valores del último y penúltimo número de la sucesión, respectivamente.
 * Este programa imprimirá en pantalla los 50 primeros números de la sucesión de Fibonacci empezando en 0, separados por comas.
 *
 */

fun main() {
    var a = 0
    var b = 1
    print("$a, $b")
    for (i in 2 until 50) {
        val c = a + b
        print(", $c")
        a = b
        b = c
    }
}