package com.mouredev.weeklychallenge2022

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
    try {
        println(lostNumbers(arrayListOf(1, 3, 5)))
        println(lostNumbers(arrayListOf(5, 3, 1)))
        println(lostNumbers(arrayListOf(5, 1)))
        println(lostNumbers(arrayListOf(-5, 1)))
        //println(lostNumbers(arrayListOf(1, 3, 3, 5)))
        //println(lostNumbers(arrayListOf(5, 7, 1)))
        println(lostNumbers(arrayListOf(10, 7, 7, 1)))
    } catch (e: LostNumbersException) {
        println(e.message)
    }
}

class LostNumbersException: Exception() {

    override val message: String?
        get() = "El listado no puede poseer repetidos ni estar desordenado, y debe tener mínimo 2 valores."

}

private fun lostNumbers(numbers: List<Int>): List<Int> {

    // Errors
    if (numbers.count() < 2) {
        throw LostNumbersException()
    }

    val first = numbers.first()
    val last = numbers.last()
    val asc = first < last

    var prev: Int? = null
    numbers.forEach { number ->
        prev?.let { prev ->
            if (if (asc) number <= prev else number >= prev) {
                throw LostNumbersException()
            }
        }
        prev = number
    }

    // Lost
    val lost = mutableListOf<Int>()

    for (number in (if(asc) first else last)..(if(asc) last else first)) {
        if (!numbers.contains(number)) {
            lost.add(number)
        }
    }

    return lost
}