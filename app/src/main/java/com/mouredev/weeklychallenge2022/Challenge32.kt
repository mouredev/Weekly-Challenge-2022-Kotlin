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

/**
 * Funcion Principal
 */
fun main(args: Array<String>) {

    println(secondLargest(listOf(1,40,5000,51,321,5500,21)))
    println(secondLargest(emptyList()))
    println(secondLargest(listOf(1)))
}

/**
 * Funcion que retorna el segundo mayor de una lista de numeros dada
 * @param list Lista de numeros a analizar
 * @return Devuelve el segundo mayor de la lista , si no hay segundo mayor devuelve el primero y si no hay ningun numero devuelve 0
 */
private fun secondLargest(list: List<Int>): Int {

    val sortedList = list.sortedDescending()
    return when {
        sortedList.isEmpty() -> 0
        sortedList.size == 1 -> sortedList[0]
        else -> sortedList[1]
    }

}