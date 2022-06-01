package com.mouredev.weeklychallenge2022

import java.io.File
import java.io.InputStream

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
    val path = "app/src/main/java/com/mouredev/weeklychallenge2022/Challenge21.txt"
    val inputStream: InputStream = File(path).inputStream()

    val lines = mutableListOf<String>()
    inputStream.bufferedReader().useLines { br -> br.forEach { lines.add(it) } }
    checkLines(lines)
}

fun checkLines(lines: List<String>) {
    var operation = "+"
    var correct = true
    var result = 0.0
    var n = 1
    lines.forEach {
        if (n % 2 == 0) {
            if (it.matches("[+\\-*/]".toRegex())) {
                operation = it
            } else {
                correct = false
            }
        } else if (it.toDoubleOrNull() != null) {
            result = defineOperation(it, operation, result)
        } else {
            correct = false
        }
        n++
    }
    correctFormat(correct, result)
}

fun defineOperation(it: String, operation: String, result: Double): Double {
    var total = result
    if (it.all { num -> !num.isLetter() }) {
        when (operation) {
            "+" -> total += it.toDouble()
            "-" -> total -= it.toDouble()
            "*" -> total *= it.toDouble()
            "/" -> total /= it.toDouble()
        }
    }
    return total
}

fun correctFormat(correct: Boolean, result: Double) {
    if (correct) {
        println("El resultado es $result")
    } else {
        println("El formato no es correcto")
    }
}