package com.mouredev.weeklychallenge2022

import java.text.DecimalFormat

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
    println(ohm())
    println(ohm(v = 5.0))
    println(ohm(v = 5.0, r = 4.0))
    println(ohm(v = 5.0, i = 4.0))
    println(ohm(r = 5.0, i = 4.0))
    println(ohm(v = 5.125, r = 4.0))
    println(ohm(v = 5.0, i = 4.125))
    println(ohm(r = 5.0, i = 4.125))
    println(ohm(v = 5.0, r = 0.0))
    println(ohm(v = 5.0, i = 0.0))
    println(ohm(r = 5.0, i = 0.0))
    println(ohm(v = 5.0, r = 4.0, i = 3.0))
}

// V = R * I
private fun ohm(v: Double? = null, r: Double? = null, i: Double? = null) : String {

    val formatter = DecimalFormat("#.##")

    if (v != null && r != null && i == null) {
        return "I = ${formatter.format(v / r)}"
    } else if (v != null && i != null && r == null) {
        return "R = ${formatter.format(v / i)}"
    } else if (r != null && i != null && v == null) {
        return "V = ${formatter.format(r * i)}"
    }

    return "Invalid values"
}