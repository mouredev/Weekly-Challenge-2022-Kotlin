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
import java.text.DecimalFormat

fun main() {
    println(TemperatureConversion("-25°C"))
    println(TemperatureConversion("+34°C"))
    println(TemperatureConversion("18 °C"))
    println(TemperatureConversion("73° F"))
    println(TemperatureConversion("86 ° F"))
    println(TemperatureConversion("- 115°F"))
    println(TemperatureConversion("22F"))
    println(TemperatureConversion("15°"))
}

private fun TemperatureConversion(originalTemperature: String): String {
    val pattern = Regex("^[-+]?[0-9]+°[FC]").matches(originalTemperature.replace("\\s".toRegex(), ""))
    val formatter = DecimalFormat("#.#")

    if (pattern) {
        val CelsiusToFahrenheit = if (originalTemperature.contains("C")) true else false
        val temperature= originalTemperature.split("°")[0].replace("\\s".toRegex(), "").toDouble()

        return if (CelsiusToFahrenheit){
            "Fahrenheit = ${formatter.format((temperature * 1.8) + 32)}°"
        }
        else {
            "Celsius = ${formatter.format((temperature - 32) / 1.8)}°"
        }
    }

    return "Formato no correcto"
}