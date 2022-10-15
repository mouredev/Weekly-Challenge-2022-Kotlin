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

    println(ohm(v = 12.0, r = 2.0, i = 0.0))
    println(ohm(v = 0.0, r = 2.0, i = 6.0))
    println(ohm(v = 12.0, r = 0.0, i = 6.0))
    println(ohm(v = 12.0, r = 2.0))
    println(ohm(r = 2.0, i = 6.0))
    println(ohm(v = 12.0, i = 6.0))
    println(ohm(v = 12.0, r = 0.0, i = 0.0))
    println(ohm(v = 0.0, r = 0.0, i = 0.0))
    println(ohm(v = 12.0, r = 2.0, i = 6.0))
}

fun ohm(v: Double? = null, r: Double? = null, i: Double? = null): String {

    val values = listOfNotNull(v, r, i)
    var count = 0

    for (value in values) {
        if (value != 0.0) {
            count++
        }
    }

    return if (count != 2) {
        return "Invalid values"
    } else if (v == 0.0 || v == null) {
        "Tenemos un voltaje de %.2f V".format(i!! * r!!)
    } else if (r == 0.0 || r == null) {
        "Tenemos una resistencia de %.2f Ohms".format(v!! / i!!)
    } else if (i == 0.0 || i == null) {
        "Tenemos una intensidad de %.2f A".format(v!! / r!!)
    } else {
        "Invalid values"
    }
}
