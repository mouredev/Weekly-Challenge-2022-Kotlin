package com.mouredev.weeklychallenge2022

import android.icu.number.IntegerWidth
import kotlin.math.pow

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    var decimal = 1023

    println(convert_manual(decimal))
    println(convert_auto(decimal))
    println(convert_manual_recursivo(decimal,  0, 1))
}

private fun convert_manual(decimal: Int) : Long {
    var decimalAux = decimal
    var binary: Long = 0
    var count = 1

    while (decimalAux != 0) {
        binary += ((decimalAux % 2) * count).toLong()
        decimalAux /= 2
        count *= 10
    }

    return binary
}

private fun convert_manual_recursivo(decimal: Int, binary: Long, count: Int) : String {
    return if (decimal != 0)
        convert_manual_recursivo(decimal / 2, binary + ((decimal % 2) * count).toLong(), count * 10)
    else
        binary.toString()
}

private fun convert_auto(decimal: Int) : String {
    return Integer.toBinaryString(decimal)
}

