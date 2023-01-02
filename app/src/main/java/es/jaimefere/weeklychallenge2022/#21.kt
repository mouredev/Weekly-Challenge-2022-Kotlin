package es.jaimefere.weeklychallenge2022

import java.io.File
import java.lang.Double.parseDouble

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

enum class Operation {
    ADD, DIV, MUL, SUB, ERROR
}

fun isNumber(symbol: String): Boolean {
    return try {
        parseDouble(symbol)
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun getOperation(symbol: String): Operation {
    return when(symbol) {
        "+" -> Operation.ADD
        "/" -> Operation.DIV
        "*" -> Operation.MUL
        "-" -> Operation.SUB
        else -> Operation.ERROR
    }
}

fun processOperations(fileName: String): String {
    var index = 0
    var result = 0.0
    var currentOperation = Operation.ERROR
    val projectPath = System.getProperty("user.dir")
    val packageName = object{}.javaClass.`package`.name.replace(".","/")
    File("$projectPath/app/src/main/java/$packageName/$fileName.txt").forEachLine { line ->
        if((index % 2 == 0) && isNumber(line)) {
            result = if(index == 0) {
                currentOperation = Operation.ADD
                line.toDouble()
            } else {
                when(currentOperation) {
                    Operation.ADD -> result + line.toDouble()
                    Operation.DIV -> result / line.toDouble()
                    Operation.MUL -> result * line.toDouble()
                    Operation.SUB -> result - line.toDouble()
                    else -> return@forEachLine
                }
            }
        } else if(index % 2 == 1) {
            currentOperation = getOperation(line)
        }
        index++
    }
    return if((currentOperation == Operation.ERROR) || (index % 2 == 0)) {
        "Las operaciones no han podido ser resueltas."
    } else {
        "${result}"
    }
}

fun main() {
    println(processOperations("Challenge21"))   // 18.5
    println(processOperations("OneValue"))      // 5.0
    println(processOperations("TooNumbers"))    // Las operaciones no han podido ser resueltas.
    println(processOperations("TooOperators"))  // Las operaciones no han podido ser resueltas.
    println(processOperations("WithDecimals"))  // 17.7
}