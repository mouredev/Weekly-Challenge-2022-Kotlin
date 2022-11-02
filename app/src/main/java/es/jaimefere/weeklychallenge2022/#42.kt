package es.jaimefere.weeklychallenge2022

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import es.jaimefere.weeklychallenge2022.isNumber

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

private enum class TemperatureUnit(val symbol: String) {
    CELSIUS("C"),
    FAHRENHEIT("F");

    companion object {
        fun isValid(symbol: String): Boolean {
            return values().any { it.symbol == symbol }
        }
    }
}

private fun toggleTemperatureUnits(temperature: String): String {
    val temperatureParts = temperature.replace(" ", "").uppercase().split("º")
    return if(temperatureParts.size == 2 && isNumber(temperatureParts[0]) && TemperatureUnit.isValid(temperatureParts[1])) {
        val value = temperatureParts[0].toDouble()
        val units = temperatureParts[1]
        if(units == TemperatureUnit.CELSIUS.symbol) {
            "${"%.2f".format(value * 9.0 / 5.0 + 32.0)} º${TemperatureUnit.FAHRENHEIT.symbol}"
        } else {
             "${"%.2f".format((value - 32.0) * 5.0 / 9.0)} º${TemperatureUnit.CELSIUS.symbol}"
        }
    } else {
        "Incorrect input"
    }
}

fun main() {
    println(toggleTemperatureUnits("60 F"))
    println(toggleTemperatureUnits("ab ºC"))
    println(toggleTemperatureUnits("273.15ºC"))
    println(toggleTemperatureUnits("-40.0ºC"))
    println(toggleTemperatureUnits("0 ºC"))
    println(toggleTemperatureUnits("98.6ºF"))
    println(toggleTemperatureUnits("212ºF"))
}