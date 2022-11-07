package com.mouredev.weeklychallenge2022

/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {

    println(numberOfBoomerangs(arrayOf(2, 1, 2, 3, 3, 4, 2, 4)))
    println(numberOfBoomerangs(arrayOf(2, 1, 2, 1, 2)))
    println(numberOfBoomerangs(arrayOf(1, 2, 3, 4, 5)))
    println(numberOfBoomerangs(arrayOf(2, 2, 2, 2, 2)))
    println(numberOfBoomerangs(arrayOf(2, -2, 2, -2, 2)))
    println(numberOfBoomerangs(arrayOf(2, -2)))
    println(numberOfBoomerangs(arrayOf(2)))
    println(numberOfBoomerangs(arrayOf()))
}

private fun numberOfBoomerangs(numbers: Array<Int>): Int {

    if (numbers.size < 3) return 0

    var boomerangs = 0

    (1 until numbers.size - 1).forEach { index ->

        val prev = numbers[index - 1]
        val current = numbers[index]
        val next = numbers[index + 1]

        if (prev == next && prev != current) {
            println("[$prev, $current, $next]")
            boomerangs += 1
        }
    }

    return boomerangs
}


