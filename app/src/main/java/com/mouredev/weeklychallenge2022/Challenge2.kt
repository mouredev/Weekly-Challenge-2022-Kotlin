package com.mouredev.weeklychallenge2022

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    var n = 50

    println("==> Fibonacci recursive <==")
    for (it in 0..(n-1).toLong()) {
        print(recursiveFibonacci(it))
        if (it != (n-1).toLong()) {
            print(", ")
        }
    }

    println("\n==> Fibonacci fast <==")
    for ((index, item) in fastFibonacci(n).withIndex()) {
        print(item)
        if (index != n - 1) {
            print(", ")
        }

    }
}

fun recursiveFibonacci(n: Long): Long {
    if (n <= 1) {
        return n
    }
    return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2)
}

fun fastFibonacci(n: Int): LongArray {
    var f = LongArray(n)
    if (n == 0)
        return f
    f[0] = 0
    if (n == 1)
        return f
    f[1] = 1
    if (n > 1) {
        for (it in 2..n - 1) {
            f[it] = f[it - 1] + f[it - 2]
        }
    }
    return f
}
