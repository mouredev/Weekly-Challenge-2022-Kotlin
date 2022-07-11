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
    try {
        println("Is orthogonal: ${checkIfOrthogonal(intArrayOf(0, 2), intArrayOf(1, 4))}")
    } catch (e: DifferentVectorSizeException) {
        println(e.message)
    }
}

fun checkIfOrthogonal(vec1: IntArray, vec2: IntArray): Boolean {
    if (vec1[0] - vec1[1] != vec2[0] - vec2[1]) {
        throw DifferentVectorSizeException()
    }
    return (vec1[0] * vec2[0]) + (vec1[1] * vec2[1]) == 0
}

class DifferentVectorSizeException(message: String = "ERROR: Both vectors must be the same size!") :
    Exception(message)