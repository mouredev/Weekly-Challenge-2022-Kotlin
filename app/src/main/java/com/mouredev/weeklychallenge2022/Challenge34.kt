package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    val numbers = arrayOf(3, 4, 6, 20, 100, 92);
    println(lostNumbers(numbers))
}

private fun lostNumbers(numbers: Array<Int>): String {
    val lostNumbers = mutableListOf<Int>()
    if(!inputIsValid(numbers)) return "Entrada no valida"
    var index = 1
    for (i in numbers[1] until numbers[numbers.size - 1]) {
        if(numbers[index] != i) lostNumbers.add(i)
        else index++
    }
    return lostNumbers.toString()
}

private fun inputIsValid(numbers: Array<Int>): Boolean {
    if(numbers.size < 2) return false
    if(numbers.size != numbers.distinct().count()) return false
    val numbersSorted = numbers.copyOf()
    numbersSorted.sort()
    return numbers.contentEquals(numbersSorted)
}

