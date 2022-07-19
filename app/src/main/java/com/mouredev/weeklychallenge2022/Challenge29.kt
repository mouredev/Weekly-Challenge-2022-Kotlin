package com.mouredev.weeklychallenge2022

/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("${arraySort(listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0), "Asc")}")
    println("${arraySort(listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0), "Desc")}")
    println("${arraySort(listOf<Int>(9, 1, 8), "Asc")}")
    println("${arraySort(listOf<Int>(9, 8, 1), "Desc")}")
    println("${arraySort(listOf<Int>(3, 9, 8, 5, 1, 8), "Asc")}")
    println("${arraySort(listOf<Int>(8), "Desc")}")
}

fun arraySort(items:List<Int>, order: String):List<Int>{
    if (items.count() < 2){
        return items
    }

    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    if (order == "Asc") {
        return arraySort(less, order) + equal + arraySort(greater, order)
    }
    else {
        return arraySort(greater, order) + equal + arraySort(less, order)
    }
}


