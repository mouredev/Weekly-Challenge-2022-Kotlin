package es.jaimefere.weeklychallenge2022

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

private fun passToDecimal(binaryNumber: String): Int {
    var result = 0.0
    binaryNumber.reversed().toCharArray().forEachIndexed { index, c ->
        result += c.toString().toDouble() * 2.0.pow(index)
    }
    return result.toInt()
}

fun main() {
    val binaryNumbers = arrayOf("012", "01", "10", "10000000")
    binaryNumbers.forEach { binaryNumber ->
        if(binaryNumber.toCharArray().filter { it != '0' && it != '1' }.isEmpty()) {
            println(passToDecimal(binaryNumber))
        } else {
            println("No es un número binario correcto")
        }
    }
}