package com.mouredev.weeklychallenge2022

import java.io.File
import kotlin.reflect.typeOf

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
    val operations = readFile("app/src/main/java/com/mouredev/weeklychallenge2022/Challenge21.txt")
    if(operations[0] != "Error") {
        print(calculator(operations))
    } else {
        print("No se han podido realizar las operaciones")
    }
}

fun readFile(fileName: String): MutableList<String> {
    val list = mutableListOf<String>()
    var error = 0
    var i = 0
    File(fileName).forEachLine {
        if (i % 2 == 0 && it != "+" && it != "-" && it != "*" && it != "/"){
            list.add(it)
            i++
        } else {
            if((i % 2 != 0) && (it == "+" || it == "-" || it == "*" || it == "/")) {
                list.add(it)
                i++
            } else {
                error = 1
            }
        }
    }
    if (error == 0){
        return list
    }
    return mutableListOf("Error")
}
fun calculator(operations: MutableList<String>): Double {
    val auxOperations = operations
    var i = 0
    while (i < auxOperations.size) {
        if (auxOperations[i] == "*") {
            auxOperations[i] = (auxOperations[i - 1].toDouble() * auxOperations[i + 1].toDouble()).toString()
            auxOperations.removeAt(i - 1)
            auxOperations.removeAt(i)
        }
        if (auxOperations[i] == "/") {
            auxOperations[i] = (auxOperations[i - 1].toDouble() / auxOperations[i + 1].toDouble()).toString()
            auxOperations.removeAt(i - 1)
            auxOperations.removeAt(i)
        }
        i += 1
    }
    var result = auxOperations[0].toDouble()
    i = 1
    while (i < auxOperations.size) {
        if (auxOperations[i] == "+") {
            result += auxOperations[i + 1].toDouble()
            i += 2
        } else {
            if (auxOperations[i] == "-") {
                result -= auxOperations[i + 1].toDouble()
                i += 2
            }
        }
    }
    return result
}
