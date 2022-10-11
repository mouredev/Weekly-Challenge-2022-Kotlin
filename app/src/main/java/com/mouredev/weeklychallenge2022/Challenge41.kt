package com.mouredev.weeklychallenge2022

/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(calculateOhm(v = 2.4, i = 0.5, r = 300.0))
    println(calculateOhm(v = 2.4))
    println(calculateOhm(v = 2.4, i = 0.0))
    println(calculateOhm(v = 2.4, i = 0.5))
    println(calculateOhm(v = 8.75, r = 200.0))
    println(calculateOhm(i = 3.45, r = 65.0))
}

private fun calculateOhm(v: Double? = null, i: Double? = null, r: Double? = null): String {
    var hasValues = 0
    val items = listOf(v, i, r).onEach {
        if (it != null && it != 0.0) {
            hasValues++
        }
    }

    if (hasValues != 2) {
        return "Invalid values"
    }
    if (items[0] == null) {
        return "${String.format("%.2f", items[1]!! * items[2]!!)} V"
    }
    if (items[1] == null) {
        return "${String.format("%.2f", items[0]!! / items[2]!!)} A"
    }
    return "${String.format("%.2f", items[0]!! / items[1]!!)} Ω"
}