package com.mouredev.weeklychallenge2022

import kotlin.Int
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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    for (index in 1..9999) { // aprovechando que aquí si podemos hacer el for con rango XD
        armstrong(index)
    }
}

fun armstrong(x: Int) {
    var sum = 0
    var number = x
    val length = x.toString().length

    while (number > 0) {
        sum += (number % 10).toDouble().pow(length.toDouble()).toInt()
        number /= 10
    }

    if (sum == x) println("R: $x is an Armstrong number")
}