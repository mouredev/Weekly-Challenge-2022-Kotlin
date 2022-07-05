package com.mouredev.weeklychallenge2022

<<<<<<< HEAD
=======
import kotlin.math.absoluteValue
>>>>>>> upstream/main
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
<<<<<<< HEAD
    println(isArmstrong(153))
    println(isArmstrong(370))
    println(isArmstrong(371))
    println(isArmstrong(407))
    println(isArmstrong(8208))
    println(isArmstrong(1741725))
}


fun isArmstrong(num: Int): Boolean {
    val numString = num.toString()

    var sum = 0
    for (digit in numString) {
        sum += digit.digitToInt().toDouble().pow(numString.length).toInt()
    }

    return sum == num
=======
    println(isArmstrong(371))
    println(isArmstrong(-371))
    println(isArmstrong(372))
    println(isArmstrong(0))
}

private fun isArmstrong(number: Int): Boolean {

    return if (number < 0) {
        false
    } else {
        var sum = 0
        val powValue = number.toString().length

        number.toString().forEach { character ->
            sum += character.toString().toDouble().pow(powValue).toInt()
        }

        number == sum
    }
>>>>>>> upstream/main
}