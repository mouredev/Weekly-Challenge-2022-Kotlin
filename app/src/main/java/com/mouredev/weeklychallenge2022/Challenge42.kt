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
    println(temperatureConversion("35ºC"))
    println(temperatureConversion("35ºF"))
    println(temperatureConversion("35ºZ"))
    println(temperatureConversion("35 Cº"))
}

fun temperatureConversion(temperature: String): String {
    val formatter = DecimalFormat("#.##")

    return if (temperature.contains("ºC") or temperature.contains("ºF")) {
        val data = temperature.split("º")
        if (data[1] == "C") {
            "$temperature = ${formatter.format((data[0].toDouble() * (9.0 / 5.0)) + 32)} ºF"
        } else {
            "$temperature = ${formatter.format((data[0].toDouble() - 32) * (5.0 / 9.0))} ºC"
        }
    } else {
        "Error! Data not sent properly!"
    }
}