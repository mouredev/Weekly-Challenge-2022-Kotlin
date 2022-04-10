package com.mouredev.weeklychallenge2022
import kotlin.math.pow

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

fun main() {
    val numero1 = 370
    val numero2 = 512
    val numero3 = 153

    println(esArmstrong(numero1))
    println(esArmstrong(numero2))
    println(esArmstrong(numero3))
}

 fun esArmstrong(num: Int): Boolean {
    val length = num.toString().length
    var suma = 0
    var digito = 0

    for (c in num.toString().toCharArray()) {
        digito = Character.getNumericValue(c)
        digito = digito.toDouble().pow(length.toDouble()).toInt()
        suma += digito
    }

    return num == suma
}
