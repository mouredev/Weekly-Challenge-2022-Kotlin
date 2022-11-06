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
    Boomerang(arrayOf(2, 1, 2, 3, 3, 4, 2, 4))
    Boomerang(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    Boomerang(arrayOf(1, 2, 3))
    Boomerang(arrayOf(1, 2, 1, 2, 3, 4, 3, 5, 4, 6))
}

private fun Boomerang(array: Array<Int>) {
    var boomerangs = 0
    var boomerangList = mutableListOf<Array<Int>>()
    for (i in 0 until array.size - 2) {
        if (array[i] == array[i + 2] && array[i] != array[i + 1]) {
            boomerangs++
            boomerangList.add(arrayOf(array[i], array[i + 1], array[i + 2]))
        }
    }
    boomerangList.forEach{
        println(it.contentToString())
    }
    println("Total boomerangs: $boomerangs")
}