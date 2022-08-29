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

fun main()
{
    lostNumbers(arrayOf(1, 3, 7, 12)) // Solucion correcta
    lostNumbers(arrayOf(1)) // Falla porque tiene un solo elemento
    lostNumbers(arrayOf(1, 1, 5)) // Falla porque tiene repetidos
    lostNumbers(arrayOf(1, 3, 2, 5)) // Falla porque no está ordenado
    lostNumbers(arrayOf(1, 5, 6, 9, 10)) // Solucion correcta

}

fun lostNumbers(array: Array<Int>)
{
    if (array.size < 2)
        throw IllegalArgumentException("Array must have at least 2 elements")
    if (array.size != array.toSet().size)
        throw IllegalArgumentException("Array must not have repeated elements")
    if (!array.isSorted())
        throw IllegalArgumentException("Array must be sorted")

    val min = array[0]
    val max = array[array.size - 1]
    val result = mutableListOf<Int>()

    for (i in min + 1 until max)
        if (!array.contains(i))
            result.add(i)

    result.forEach {
        print(it)
        print(", ")
    }
    println()
}

fun Array<Int>.isSorted(): Boolean
{
    for (i in 1 until this.size)
        if (this[i - 1] > this[i])
            return false
    return true
}