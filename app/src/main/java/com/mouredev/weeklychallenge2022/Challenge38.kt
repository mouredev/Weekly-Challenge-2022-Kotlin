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

fun main() {

    /*  Porbas de testteo*/

    print(deBinarioDecimal("1100011"))
    println(" O resultado sería 99")
    println("-----------------------------")
    print(deBinarioDecimal("11000111000111000"))
    println(" O resultado sería 101944")
    println("-----------------------------")
    print(deBinarioDecimal("1050"))
    println(" O resultado sería null")

}

fun deBinarioDecimal(binario:String):Int? {

    val dous = 2.0
    var decimal= 0
    var exp = 0
    var esBinario = true

    for (x in binario.lastIndex downTo 0) {
        if (binario[x]== '0' || binario[x] == '1') {
            val dixito:Int = binario[x].toString().toInt()
            val paraSumar = dixito*dous.pow(exp++).toInt()
            decimal += paraSumar
        } else {
            esBinario = false
            break
        }
    }

    if (esBinario)  return decimal else return null
}
