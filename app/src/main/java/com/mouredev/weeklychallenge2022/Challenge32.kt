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
    println("${secondHigh(listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0, 5))}")
    println("${secondHigh(listOf<Int>(8, 8, 8, 3, 8, 8))}")
    println("${secondHigh(listOf<Int>(-8, -52, -125, -3, -6, -9, -5, -1, 0, -5))}")
}

private fun secondHigh(items:List<Int>): Int {

    var clearList: List<Int> = emptyList();

    if (items.count()< 2)
        return 0;

    // Limpio posibles repetidos
    items.forEach {
        if (it !in clearList)
            clearList += it
    }

    // ordeno lista
    clearList = arraySort(clearList);

    return clearList[1];
}

fun arraySort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }

    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    return arraySort(greater) + equal + arraySort(less)
}