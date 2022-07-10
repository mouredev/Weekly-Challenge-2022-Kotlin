package com.mouredev.weeklychallenge2022

/*
 * Reto #27
 * VECTORES ORTOGONALES
 * Fecha publicación enunciado: 07/07/22
 * Fecha publicación resolución: 11/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

 fun main() {
    val vector1 = listOf(1, 2, 0)
    val vector2 = listOf(2, -1, 2)

    if (isOrtogonal(vector1, vector2) == 0) println("Vectores ortogonales")
    else println("Los vectores NO son ortogonales")
}

fun isOrtogonal(v1: List<Int>, v2: List<Int>): Int {
    var total = 0

    (0..(v1.size - 1)).forEach {
        total += v1[it] * v2[it]
    }

    return total
}