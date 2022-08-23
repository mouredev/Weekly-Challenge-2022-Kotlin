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
    val ar = arrayOf(3, 9, 50)
    if (hasDuplicates(ar) || isNotOrdered(ar)) {
        println("El array de entrada no es correcto")
        return
    }
    calculateNumbersBetween(ar).forEach {
        print("$it ")
    }
}

private fun calculateNumbersBetween(ar: Array<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    val firstNumber = ar[0]
    val lastNumber = ar[ar.size - 1]

    for (i in firstNumber..lastNumber) {
        result.add(i)
    }

    return result
}

private fun isNotOrdered(ar: Array<Int>): Boolean {
    val orderList = ar.sorted()
    if (orderList == ar.toCollection(ArrayList()))
        return false
    return true
}

fun hasDuplicates(ar: Array<Int>): Boolean {
    return ar.size != ar.distinct().count()
}