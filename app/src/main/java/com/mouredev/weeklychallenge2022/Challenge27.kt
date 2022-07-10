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
    val u: Array<Int> = arrayOf(2,0)
    val v: Array<Int> = arrayOf(0,50)
    print(is_ortogonal(u, v))
}


fun is_ortogonal(u: Array<Int>, v: Array<Int>): Boolean {
    if (u.size != v.size) return false
    var sum = 0
    for (i in u.indices) {
        sum += u[i] * v[i]
    }
    return sum == 0
}