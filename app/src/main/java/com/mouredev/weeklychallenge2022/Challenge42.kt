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
    println(degreeConverter("45.5°C"))
    println(degreeConverter("113.9°F"))
    println(degreeConverter("50.°C"))
    println(degreeConverter("122.0°F"))
    println(degreeConverter("122.0"))
    println(degreeConverter("122.0 F"))
}

private fun degreeConverter(input:String): String {
    var temp: String
    temp = input.replace("°", "")
    temp = temp.replace("C", "")
    temp = temp.replace("F", "")
    var number = temp.toDouble()

    if (!input.contains("°") || (!input.contains("C") && !input.contains("F"))) {
        return "Error datos de entrada"
    }

    if (input.contains("C")){
        return "$input -> ${celsiusToFahrenheit(number)}°F"
    }

    if (input.contains("F")){
        return "$input -> ${fahrenheitToCelsius(number)}°C"
    }

    return "Error"
}


private fun celsiusToFahrenheit(celsius:Double) : Double {
    return (1.8 * celsius) + 32.0
}

private fun fahrenheitToCelsius(fahrenheit:Double) : Double {
    return 5.0 * (fahrenheit - 32.0) / 9.0
}
