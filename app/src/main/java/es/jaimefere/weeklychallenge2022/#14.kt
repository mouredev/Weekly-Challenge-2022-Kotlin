package es.jaimefere.weeklychallenge2022

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
    println(isArmstrong(123))   // Output: false
    println(isArmstrong(153))   // Output: true
    println(isArmstrong(371))   // Output: true
    println(isArmstrong(1080))  // Output: false
    println(isArmstrong(1634))  // Output: true
    println(isArmstrong(8208))  // Output: true
}

private fun isArmstrong(number: Int): Boolean {
    var summatory = 0.0
    number.toString().forEach {
        summatory += it.toString().toDouble().pow(number.toString().length)
    }
    return summatory.toInt() == number
}