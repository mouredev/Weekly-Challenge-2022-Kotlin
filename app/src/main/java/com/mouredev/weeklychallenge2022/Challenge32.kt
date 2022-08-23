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
    var numbers: MutableList<Number> = mutableListOf(1.5, 6, 2, 7, 4)
    println("Numbers list: $numbers")
    var secondBiggest = getTheSecondBiggest(numbers, numbers.last())
    println("The second biggest is: $secondBiggest")
    numbers = mutableListOf(100, 3, -2, 4.5, -10)
    println("Numbers list: $numbers")
    secondBiggest = getTheSecondBiggest(numbers, numbers.last())
    println("The second biggest is: $secondBiggest")
}

private fun getTheSecondBiggest(numbers: MutableList<Number>, bigger: Number) : Number {
    if(numbers.size == 2) return if (numbers[1].toDouble() < numbers[0].toDouble()) numbers[1] else numbers[0]
    var newBigger = bigger
    val currentNumber = numbers[numbers.size - 1]
    if(currentNumber.toDouble() > bigger.toDouble()) newBigger = numbers[numbers.size - 1]
    if(numbers[0].toDouble() < currentNumber.toDouble()) {
        numbers.add(0, currentNumber)
    } else if(numbers[1].toDouble() < currentNumber.toDouble()) {
        numbers.add(1, currentNumber)
    }
    numbers.removeLast()
    return getTheSecondBiggest(numbers, newBigger)
}

