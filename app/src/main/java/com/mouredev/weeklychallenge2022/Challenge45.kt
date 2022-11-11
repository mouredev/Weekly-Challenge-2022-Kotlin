package com.mouredev.weeklychallenge2022

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

private fun calculateAccumulatedWater(numbers: Array<Int>): Int {
    if (!isValidArray(numbers)) {
        return 0
    }

    var accumulatedWater = 0

    (1 until numbers.size - 1).forEach { index ->
        val current = numbers[index]
        val previousMaxNumber = findMaxNumber(numbers = numbers, index = index)

        if (previousMaxNumber > current) {
            val nextMaxNumber = findMaxNumber(numbers = numbers, index = index, previous = false)
            val contentSize =
                if (previousMaxNumber >= nextMaxNumber) nextMaxNumber else previousMaxNumber

            accumulatedWater += contentSize - current
        }
    }

    return accumulatedWater
}

// Validate that the list is greater than 3 items and that the numbers are positive.
private fun isValidArray(numbers: Array<Int>): Boolean {
    return numbers.size > 2 && checkPositivesNumbers(numbers = numbers)
}

private fun checkPositivesNumbers(numbers: Array<Int>): Boolean {
    val positivesNumbers = numbers.filter { i -> i >= 0 }
    return numbers.size == positivesNumbers.size
}

private fun findMaxNumber(numbers: Array<Int>, index: Int, previous: Boolean = true): Int {
    var maxNumber = 0

    val listFilter = if (previous) numbers.slice(0 until index)
        .reversed() else numbers.slice(index until numbers.size)

    listFilter.forEach { number ->
        if (number >= maxNumber) {
            maxNumber = number
        }
    }

    return maxNumber
}

private fun calculateWaterContainer(numbers: Array<Int>) {
    val accumulatedWater = calculateAccumulatedWater(numbers = numbers)
    println("Accumulated water: $accumulatedWater, with the water container: '${numbers.toList()}'")
}

fun main() {
    calculateWaterContainer(numbers = arrayOf(4, 0, 3, 6, 1, 3))
    calculateWaterContainer(numbers = arrayOf(4, 0))
    calculateWaterContainer(numbers = arrayOf(-4, 0, 3, -6))
    calculateWaterContainer(numbers = arrayOf(-4, 0, 3, -6))
    calculateWaterContainer(numbers = arrayOf(3, 2, 1, 0, 3))
    calculateWaterContainer(numbers = arrayOf(1, 2, 3, 4, 3, 2, 1))
}

