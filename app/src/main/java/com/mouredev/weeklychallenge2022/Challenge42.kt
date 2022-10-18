package com.mouredev.weeklychallenge2022

/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main() {
    // Scenarios with error
    println(convertTemperature("80F"))
    println(convertTemperature("24°"))
    println(convertTemperature("53D"))
    println(convertTemperature("68"))
    println(convertTemperature(""))

    println()

    // Scenarios with success
    println(convertTemperature("25°C"))
    println(convertTemperature("34°C"))
    println(convertTemperature("18°C"))
    println(convertTemperature("73°F"))
    println(convertTemperature("86°F"))
    println(convertTemperature("115°F"))
}

private fun convertTemperature(value: String): String {
    val valueIsValid = Regex("^[0-9]+°[FC]").matches(value)

    if (valueIsValid) {
        val temperatureValue = value.split("°")[0].toInt()

        return when (value.last()) {
            'C' -> "F = ${(temperatureValue * 1.8 + 32).toInt()}°"
            'F' -> "C = ${((temperatureValue - 32) / 1.8).toInt()}°"
            else -> "Unknown unit"
        }
    }

    return "Value cannot be converted"
}
