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
    leyOhm(mapOf(Pair(Ohm.VOLTAGE, 5f)))
    leyOhm(mapOf(Pair(Ohm.VOLTAGE, 12f), Pair(Ohm.RESISTANCE, 150f)))
    leyOhm(mapOf(Pair(Ohm.RESISTANCE, 50f), Pair(Ohm.INTENSITY, 0.5f)))
    leyOhm(mapOf(Pair(Ohm.VOLTAGE, 50f), Pair(Ohm.INTENSITY, 2.5f)))
    leyOhm(mapOf(Pair(Ohm.VOLTAGE, 530f), Pair(Ohm.RESISTANCE, 51f), Pair(Ohm.INTENSITY, 43f)))
}

private fun leyOhm(params: Map<Ohm, Float>) {

    var v: Float? = null
    var r: Float? = null
    var i: Float? = null
    if (params.size != 2) {
        println("Invalid values")
        return
    }

    for (param in params) {
        when (param.key) {
            Ohm.VOLTAGE -> v = param.value
            Ohm.RESISTANCE -> r = param.value
            Ohm.INTENSITY -> i = param.value
        }
    }

    if (v == null && r != null && i != null) {
        println("V = ${r * i} V")
    } else if (r == null && v != null && i != null) {
        println("R = ${v / i} Ohm")
    } else if (i == null && v != null && r != null) {
        println("I = ${v / r} Amp")
    }

}

enum class Ohm {
    VOLTAGE, RESISTANCE, INTENSITY
}


