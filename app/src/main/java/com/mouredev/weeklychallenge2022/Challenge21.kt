package com.mouredev.weeklychallenge2022

import java.io.File
import java.lang.Character.isDigit

/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(BasicCalculator("G:\\Proyectos\\Weekly-Challenge-2022-Kotlin\\app\\src\\main\\java\\com\\mouredev\\weeklychallenge2022\\Challenge21.txt"))
}

private fun BasicCalculator(fileName: String): String {

    var result = 0.0
    var numLines = 1
    val operationList = listOf("+", "-", "*", "/")
    var operator = ""
    var error = false

    File(fileName).forEachLine {
        if ((numLines == 1) and (it.toDoubleOrNull() != null)){
            result = it.toDouble()
            numLines ++
        }
        else
            error = true

        if ((numLines % 2 == 0) and (it in operationList)) {
            operator = it
            numLines ++
        }
        else if ((numLines % 2 != 0) and (it.toDoubleOrNull() != null)) {
            when (operator) {
                "+" -> result += it.toDouble()
                "-" -> result -= it.toDouble()
                "*" -> result *= it.toDouble()
                "/" -> result /= it.toDouble()
            }
            numLines ++
        }
        else if (((numLines >= 2) and ((it !in operationList) or (it.toDoubleOrNull() != null)))){
            error = true
            numLines ++
        }

    }

    return if (!error) "El fichero no tiene el formato correcto" else "El resultado de la operaciones es $result"
}