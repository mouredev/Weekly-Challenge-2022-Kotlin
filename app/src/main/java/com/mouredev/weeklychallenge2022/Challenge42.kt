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
    println(temperatureConverter("0°C"))
    println(temperatureConverter("120°F"))
    println(temperatureConverter("-120°F"))
    println(temperatureConverter("60F"))
    println(temperatureConverter("60.4F"))
    println(temperatureConverter("60.4°F"))
    println(temperatureConverter("60.4°FC"))
}

// (0 °C × 9/5) + 32 = 32 °F
private fun temperatureConverter(temperature : String) : String{

    return if (temperature.matches("""([-]?[0-9]*([.][0-9]*)?°[C|F])""".toRegex())) {
        val (tempValue, tempType) = temperature.split('°')
        val formatter = DecimalFormat("#.##")

        when (tempType) {
            "C" -> "${formatter.format((tempValue.toDouble()*9/5)+32)}°F"
            "F" -> "${formatter.format((tempValue.toDouble()-32)*5/9)}°C"
            else -> "Wrong input"
        }
    } else "Wrong input"

}