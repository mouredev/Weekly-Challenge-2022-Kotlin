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
    println("The second biggest number is: ${getNumber(listOf(1, 2, 4, 8, 2, 0, 3, 1, 5))}")
    println("The second biggest number is: ${getNumber(listOf(19836, 1247, 10342, 62414, 26154))}")
}

private fun getNumber(numberList: List<Int>): Int {
    val sorted = mutableListOf<Int>()

    numberList.forEach { number ->
        if (sorted.isEmpty()) {
            sorted.add(number)
            return@forEach
        }
        val sortedClone = sorted.toMutableList()
        run sort@{
            sortedClone.forEachIndexed { index, sortNumber ->
                if (sortNumber <= number) {
                    if (sortNumber < number) {
                        sorted.add(index, number)
                    }
                    return@sort
                }
                if (index == sorted.lastIndex) {
                    sorted.add(number)
                }
            }
        }
    }

    return sorted[1]
}