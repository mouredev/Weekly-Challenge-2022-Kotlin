package com.mouredev.weeklychallenge2022

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

fun main(args: Array<String>) {
    mostrarBinario(5)
}

private fun mostrarBinario(num: Int) {
    println("Número en decimal: $num")
    println("Numero en binario: " + decimalABinario(num))
}

private fun decimalABinario(num: Int): String {
    var binario = ""
    var decimal = num
    while (decimal >= 0) {
        binario += if (decimal % 2 == 0) {
            0
        } else {
            1
        }
        decimal = decimal / 2
        if (decimal == 0) {
            decimal--
        }
    }
    val binarioArray = binario.toCharArray()
    var aux: Char
    for (i in 0 until binarioArray.size / 2) {
        aux = binarioArray[i]
        binarioArray[i] = binarioArray[binarioArray.size - 1 - i]
        binarioArray[binarioArray.size - 1 - i] = aux
    }
    return String(binarioArray)
}
