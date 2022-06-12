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

fun main() {
    println("El máximo común divisor de 10 y 15 es: ${GreatestCommonFactor(10, 15)} y el mínimo común múltiplo es: ${LeastCommonMultiple(10, 15)}")
    println("El máximo común divisor de 389 y 251 es: ${GreatestCommonFactor(389, 251)} y el mínimo común múltiplo es: ${LeastCommonMultiple(389, 251)}")
    println("El máximo común divisor de 798 y 25 es: ${GreatestCommonFactor(798, 25)} y el mínimo común múltiplo es: ${LeastCommonMultiple(798, 25)}")
    println("El máximo común divisor de -520 y 21 es: ${GreatestCommonFactor(-520, 21)} y el mínimo común múltiplo es: ${LeastCommonMultiple(-520, 21)}")
}

private fun GreatestCommonFactor (a: Int, b: Int): Int {
    if (b == 0) return a
    return GreatestCommonFactor(b, a % b)
}

private fun LeastCommonMultiple(a: Int, b: Int): Int {
    return (a * b) / GreatestCommonFactor(a, b)
}