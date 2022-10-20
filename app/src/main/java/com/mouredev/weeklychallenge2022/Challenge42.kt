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
    val type: String = "ºF"
    val input: Double = 0.0       
    
    println("Input: $input $type   -   Output: ${convert(type, input)}")    
}

fun convert(type:String, input: Double): Double{    
    if (type != "ºC" && type != "ºF") {
        println ("Error en el tipo a convertir")
        return 0.0
    }
    
    if (type == "ºC") return celsiusToFarenheit(input)
     
    return farenheitToCelsius(input)
}


// Formula -> °F = °C*1.80 + 32.00
fun celsiusToFarenheit (input: Double): Double{
    return String.format("%.3f", ((input * 1.80)+32.00)).toDouble()
}

// Formula -> °C = (°F-32) ÷ 1.80
fun farenheitToCelsius(input:Double): Double {
    return String.format("%.3f", ((input - 32.00) / 1.80)).toDouble()
}