package com.mouredev.weeklychallenge2022

import kotlin.math.pow

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Armstrong  (o también llamado narcisista).
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
    isArmstrong(0) // Número de Armstrong
    isArmstrong(1) // Número de Armstrong
    isArmstrong(153) // Número de Armstrong
    isArmstrong(256) // No es Número de Armstrong
    isArmstrong(-153) // Error
    isArmstrong(8208) // Número de Armstrong
}

private fun isArmstrong(number: Int) {
    if (number < 0) {
        println("Error. El número ingresado es negativo")
    } else {

        var sum = 0

        number.toString().forEach {
            sum += it.toString().toDouble().pow(number.toString().length).toInt()
        }

        if (sum == number) {
            println("$number es un número de Armstrong")
        } else {
            println("$number no es un número de Armstrong ")
        }
    }
}