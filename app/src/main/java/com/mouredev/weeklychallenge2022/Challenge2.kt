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

    //fibonacci2(50)

    for(i in 0..50) {
        println("$i: FIBONACCI: ${fibonacci(i)}")
    }

}

fun fibonacci(n: Int) : Long {
    when {
        n > 1 -> return fibonacci(n - 1) + fibonacci(n - 2)
        n == 1 -> return 1
        n == 0 -> return 0
        else -> "You have to introduce a valid number"
    }

    return 0
}

fun fibonacci2(n: Int) {

    var index = 0
    var t0: Long = 0
    var t1: Long = 1

    while(index <= n) {
        println("$t1")

        val sum: Long = (t0 + t1)
        t0 = t1
        t1 = sum
        index ++
    }
}