package com.mouredev.weeklychallenge2022

import kotlin.math.pow

/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(binaryToDecimal("1010100101011"))
    println(binaryToDecimal("10111001110101001011"))
    println(binaryToDecimal("10130101"))
    println(binaryToDecimal("0110f1010"))
}

fun binaryToDecimal(binary: String): String {
    if (!Regex("^[0-1]*$").matches(binary)) return "Error! String should contain 0 and 1 only."
    var total = 0
    (binary.length - 1 downTo 0).forEachIndexed { index, num ->
        total += binary[num].digitToInt().times(2.0.pow(index)).toInt()
    }
    return "Total: $total"
}