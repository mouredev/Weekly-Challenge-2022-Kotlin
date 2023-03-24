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
    println(binaryToDecimal("00110"))
    println(binaryToDecimal("01100"))
    println(binaryToDecimal("000000000"))
    println(binaryToDecimal("00210"))
    println(binaryToDecimal("001101001110"))
    println(binaryToDecimal("00b10"))
    println(binaryToDecimal(""))
    println(binaryToDecimal("-00110"))
    println(binaryToDecimal(" "))
    println(binaryToDecimal(" 10011"))
    println(binaryToDecimal("1O1OO11"))
}

private fun binaryToDecimal(binary: String): Int? {

    val length = binary.length - 1

    var decimal: Int? = null

    for (index in 0..length) {
        val digitChar = binary.toCharArray()[length - index]
        if (digitChar == '0' || digitChar == '1') {
            if (decimal == null) {
                decimal = 0
            }
            decimal += digitChar.digitToInt() * 2.0.pow(index).toInt()
        } else {
            return null
        }
    }

    return decimal
}


