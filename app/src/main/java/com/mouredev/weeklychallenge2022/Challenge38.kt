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
    toDecimal("111000111")
}

fun toDecimal(number: String):Double {
    var binario = number
    var decimal = 0.0
    var exponente = number.length -1
    for (i in 0 .. number.length -1) {
        if (binario[i] == '1'){
            val n = 2.0;
            decimal += n.pow(exponente)
        }
        exponente --
    }
    println(decimal.toInt())
    return decimal
}
