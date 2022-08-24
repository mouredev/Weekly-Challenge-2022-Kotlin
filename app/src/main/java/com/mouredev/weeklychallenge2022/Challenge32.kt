package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(findSecondGreater(arrayListOf(4, 6, 1, 8, 2)))
    println(findSecondGreater(arrayListOf(4, 6, 8, 8, 6)))
    println(findSecondGreater(arrayListOf(4, 4)))
    println(findSecondGreater(arrayListOf()))
}

fun findSecondGreater(numbers: List<Int>): Int? {

    val sortedNumbers = mutableListOf<Int>()

    for (number in numbers) {

        var found = false

        for ((index, sortedNumber) in sortedNumbers.withIndex()) {

            if (number >= sortedNumber) {
                if (number != sortedNumber) {
                    sortedNumbers.add(index, number)
                }
                found = true
                break
            }
        }

        if (!found) {
            sortedNumbers.add(number)
        }
    }

    return if(sortedNumbers.count() >= 2) sortedNumbers[1] else null
}