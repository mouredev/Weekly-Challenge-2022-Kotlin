package com.mouredev.weeklychallenge2022

import java.text.DecimalFormat

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
    println(temperatureConverter("100°C"))
    println(temperatureConverter("100°F"))
    println(temperatureConverter("100C"))
    println(temperatureConverter("100F"))
    println(temperatureConverter("100"))
    println(temperatureConverter("100"))
    println(temperatureConverter("- 100 °C "))
    println(temperatureConverter("- 100 °F "))
    println(temperatureConverter("100A°C"))
    println(temperatureConverter("100A°F"))
    println(temperatureConverter("°C"))
    println(temperatureConverter("°F"))
}

private fun temperatureConverter(degrees: String): String? {

    val formatter = DecimalFormat("#.##")

    try {

        if (degrees.replace(" ", "").contains("°C")) {
            val celsiusDegrees = degrees.replace(" ", "")
                .replace("°C", "")
                .toDouble()
            return "${formatter.format((celsiusDegrees * 9/5) + 32)}°F"

        } else if (degrees.replace(" ", "").contains("°F")) {
            val fahrenheitDegrees = degrees.replace(" ", "")
                .replace("°F", "")
                .toDouble()
            return "${formatter.format((fahrenheitDegrees - 32) * 5/9)}°C"
        }

    } catch (e: Exception) {
        return null
    }

    return null
}