package com.mouredev.weeklychallenge2022

import java.io.File
import java.nio.charset.Charset

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
enum class operation(val value: String){
    Sum("+"),
    Substract("-"),
    Plus("*"),
    Divide("/"),
    Error("");

    companion object{
        fun fromString(op: String) = when(op){
            "+" -> Sum
            "-" -> Substract
            "*" -> Plus
            "/" -> Divide
            else -> Error
        }
    }

}

fun readFile(path: String): List<Any> {
    return try{
        File(path).readLines(Charset.defaultCharset()).map { x ->
            x.toFloatOrNull() ?: operation.fromString(x)
        }.toList().also { x -> if (x.filterIndexed { index, value -> index % 2 == 0 && value !is Float }.any() ||
                                   x.filterIndexed { index, value -> index % 2 != 0 && value !is operation }.any()
                ) throw Exception("")}
    }catch (ex: Exception){
        listOf()
    }
}

fun operate(data: List<Any>): Float{
    if (data.isEmpty())
        return Float.MIN_VALUE
    else if (data.size == 3 && data[0] is Float){
        return when(data[1] as operation){
            operation.Sum -> data[0] as Float + data[2] as Float
            operation.Substract -> data[0] as Float - data[2] as Float
            operation.Plus -> data[0] as Float * data[2] as Float
            operation.Divide -> data[0] as Float / data[2] as Float
            else -> 0f
        }
    }else{
        val leftResult = operate(data.subList(0, data.size - 2))

        return when(data[data.size - 2] as operation){
            operation.Sum -> leftResult + data[data.size - 1] as Float
            operation.Substract -> leftResult - data[data.size - 1] as Float
            operation.Plus -> leftResult * data[data.size - 1] as Float
            operation.Divide -> leftResult / data[data.size - 1] as Float
            else -> 0f
        }
    }
}

fun main(){
    //val pathToFile = "/Poner/ruta/al/Fichero/Challenge21.txt"
    val pathToFile = "/Users/afalabarce/IdeaProjects/Weekly-Challenge-2022-Kotlin/app/src/main/java/com/mouredev/weeklychallenge2022/Challenge21.txt"
    val operationText = readFile(pathToFile).map { x -> if (x is Float) x.toString() else (x as operation).value }.joinToString(" ")
    val result = operate(readFile(pathToFile))
    if (result == Float.MIN_VALUE)
        println("No se ha podido calcular")
    else
        println("Resultado Operación: $operationText = $result")
}