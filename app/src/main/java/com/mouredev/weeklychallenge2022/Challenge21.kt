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
    println(calculateFileOperation("C:\\Users\\jjtom\\Documents\\AndroidStudioProjects\\Weekly-Challenge-2022-Kotlin\\app\\src\\main\\java\\com\\mouredev\\weeklychallenge2022\\Challenge21.txt"))
}

private fun calculateFileOperation(fileName: String): Double{
    var operator = ""
    var result: Double? = null
    File(fileName).forEachLine {
        println(it)
        if (result == null){
            if (it.isNumber()){
                result = it.toDouble()
            }else{
                throw Exception("The file don't have the right format")
            }
        }else{
            when{
                isNotAllowedSymbol(it) -> throw Exception("Not allowed symbol $it")
                it.isNumber() && operator == "" || !it.isNumber() && operator != ""-> throw Exception("The file don't have the right format")
                !it.isNumber() && operator == "" -> operator = it
                it.isNumber() && operator != "" -> result?.let{ res ->
                    result = makeOperation(res, operator,  it.toDouble())
                    operator = ""
                }
            }
        }
    }
    result?.let{
        return it
    } ?: throw Exception("The file don't have the right format")
}

fun makeOperation(result: Double, operator: String, number: Double): Double =
    when (operator) {
        "+" -> result.plus(number)
        "-" -> result.minus(number)
        "*" -> result.times(number)
        "/" -> result.div(number)
        else -> throw Exception("The file don't have the right format")
    }


private fun isNotAllowedSymbol(it: String) =
    !it.isNumber() && it != "+" && it != "-" && it != "/" && it != "*"

private fun String.isNumber(): Boolean = toDoubleOrNull() != null
