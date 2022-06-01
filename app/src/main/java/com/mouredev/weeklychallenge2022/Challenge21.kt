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
    println(calculate("app/src/main/java/com/mouredev/weeklychallenge2022/Challenge21.txt"))
}

private fun calculate(filePath: String): String {

    var fileError = false
    var result: Double? = null
    var lastOperator: String? = null

    try {
        File(filePath).forEachLine { line ->

            line.toDoubleOrNull()?.let { number ->
                if (result == null) {
                    result = number
                } else {
                    when(lastOperator) {
                        "+"-> {
                            result = result?.plus(number)
                        }
                        "-"-> {
                            result = result?.minus(number)
                        }
                        "*"-> {
                            result = result?.times(number)
                        }
                        "/"-> {
                            result = result?.div(number)
                        }
                        else -> {
                            fileError = true
                            return@forEachLine
                        }
                    }
                    lastOperator = null
                }
            } ?: run {
                if (lastOperator == null) {
                    lastOperator = line
                } else {
                    fileError = true
                    return@forEachLine
                }
            }
        }

    } catch (e: Exception) {
        fileError = true
    }

    return if (fileError || lastOperator != null) "No se han podido resolver las operaciones" else result!!.toString()
}