package com.mouredev.weeklychallenge2022

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

import kotlin.math.pow

fun main() {
    // [1,2,3,4,5,6,7,8,9,153,370,371,407,1634,8208,9474,54748,92727,...]
    println(armstrong(153))
}

private fun armstrong(input: Int): Boolean {
    if (input < 1) return false

    val inputStr = input.toString()
    val size = inputStr.length.toDouble()

    var result = 0.0

    inputStr.forEach {
        result += it.toString().toDouble().pow(size)
    }
    return (result == input.toDouble())
}