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
    getRemainingNumbers(listOf(6, 5, 12, 8, 3, 9, 15))
    getRemainingNumbers(listOf(2,"a",5,1, 8, 9))
    getRemainingNumbers(listOf(2,true,5,1, 8, 9))
    getRemainingNumbers(listOf(5, 3, -6, -2, 10, 8, 0))
    getRemainingNumbers(listOf(1, 2, 2, 4, 15, 6, 10))
}

fun getRemainingNumbers(list: List<Any>) {

    val containsNumbers = list.all { it is Int }
    if (containsNumbers) {
        list.map { it.toString().toInt() }.sorted().apply {
            val remaining = generateSequence(first()) { it + 1 }
                .filter { !contains(it) }
                .takeWhile { it < last() }
                .toList()

            println("Remaining: $remaining")
        }
    } else {
        println("List elements aren't numbers")
    }

}
