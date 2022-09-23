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

fun main(){
    println(baseIntConvertor("00101011"))
    println(baseIntConvertor("00001011"))
    println(baseIntConvertor("10001011"))
}

private fun baseIntConvertor(baseCode : String, base : Int = 2) : Int{
    val baseCodeArray : List<Int>
    var result = 0.0

    try {
        baseCodeArray = baseCode.toCharArray().reversedArray().map { it.digitToInt() }

        baseCodeArray.forEachIndexed { index, value ->
            result += base.toFloat().pow(index) * value
        }

        print("The $base code :$baseCode is equal to ")
    } catch (e : Error){
        println(e.message)
        return 0
    }

    return result.toInt()
}