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
    print("Mete un numero en binario: ")
    val binario:String = readLine()!!
    val dous = 2.0
    var decimal= 0
    var exp = 0
    var errorBinario = false


    for (x in binario.lastIndex downTo 0) {
        if (binario[x]== '0' || binario[x] == '1') {
            val dixito:Int = binario[x].toString().toInt()
            val paraSumar = dixito*dous.pow(exp++).toInt()
            decimal += paraSumar
        } else {
            println("O número non está en formato binario.")
            errorBinario = true
            break
        }
    }

    if (!errorBinario)  // o operador ! invierte el valor de un booleano
        println("O numero decimal é: $decimal")
}