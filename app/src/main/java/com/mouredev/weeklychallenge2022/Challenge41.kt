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

private fun calculateOhmLayer(V: Double? = null, R: Double? = null, I: Double? = null): String {
    return if(V == null) {
        if(R == null || I == null) "Invalid values" else "%.2f".format(R!! * I!!)
    } else if(R == null) {
        if(V == null || I == null) "Invalid values" else "%.2f".format(V!! / I!!)
    } else if(I == null) {
        if(V == null || R == null) "Invalid values" else "%.2f".format(V!! / R!!)
    } else {
        if(V!! != R!! * I!!) "Invalid values" else "Right values"
    }
}

fun main() {
    println(calculateOhmLayer(5.0, 10.0, 0.5))
    println(calculateOhmLayer(null, 10.0, 0.5))
    println(calculateOhmLayer(5.0, null, 0.5))
    println(calculateOhmLayer(5.0, 10.0, null))
    println(calculateOhmLayer(null, null, 0.5))
}



