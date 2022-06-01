package com.mouredev.weeklychallenge2022

import java.io.File

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
    try {
        println("Result: ${readFile()}")
    } catch (e: WrongParameterException) {
        println(e.message)
    }
}

fun readFile(): Float {
    var lastChar = -1
    val lastLines = mutableListOf<String>()
    var total = 0F
    val path =
        File("").absolutePath + "\\app\\src\\main\\java\\com\\mouredev\\weeklychallenge2022\\Challenge21.txt"
    File(path).forEachLine { line ->
        if (lastLines.isEmpty() || lastLines.size == 1) {
            lastChar = if (lastLines.isEmpty()) {
                if (line.textIsDigits()) {
                    lastLines.add(line)
                    0
                } else {
                    throw WrongParameterException()
                }
            } else {
                if (line.textIsMathSign() && lastChar == 0) {
                    lastLines.add(line)
                    1
                } else {
                    throw WrongParameterException()
                }
            }
        } else {
            if (line.textIsDigits()) {
                lastLines.add(line)
                total = calculateArray(lastLines)
                lastLines.clear()
                lastLines.add(total.toString())
                lastChar = 0
            } else {
                throw WrongParameterException()
            }
        }
    }
    return total
}

private fun String.textIsDigits(): Boolean {
    return when (this.toFloatOrNull()) {
        null -> false
        else -> true
    }
}

private fun String.textIsMathSign(): Boolean {
    return this == "+" || this == "-" || this == "*" || this == "/"
}

private fun calculateArray(lastLines: MutableList<String>): Float {
    return when (lastLines[1]) {
        "+" -> lastLines[0].toFloat().plus(lastLines[2].toFloat())
        "-" -> lastLines[0].toFloat().minus(lastLines[2].toFloat())
        "*" -> lastLines[0].toFloat().times(lastLines[2].toFloat())
        "/" -> lastLines[0].toFloat().div(lastLines[2].toFloat())
        else -> {
            throw WrongParameterException()
        }
    }
}

class WrongParameterException(message: String = "ERROR: Wrong expected char when reading file!") :
    Exception(message)