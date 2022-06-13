package com.mouredev.weeklychallenge2022

/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

private fun calculateMCD(n1: Int, n2: Int): Int {
    for(i in n1.coerceAtMost(n2) downTo 1) {
        if(n1 % i == 0 && n2 % i == 0) {
            return i
        }
    }
    return 1
}

private fun calculateMCM(n1: Int, n2: Int): Int {
    var multiplierN1 = 1
    var multiplierN2 = 1
    var result = n1 * multiplierN1
    while(n1 * multiplierN1 != n2 * multiplierN2) {
        if(n1 * multiplierN1 < n2 * multiplierN2) {
            multiplierN1++
            result = n1 * multiplierN1
        } else {
            multiplierN2++
            result = n2 * multiplierN2
        }
    }
    return result
}

fun main() {
    println(calculateMCD(6, 9))
    println(calculateMCD(24, 36))
    println(calculateMCD(8, 8))
    println(calculateMCM(8, 8))
    println(calculateMCM(51, 27))
    println(calculateMCM(180,324))
}