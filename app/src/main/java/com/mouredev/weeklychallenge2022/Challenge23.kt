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
    val num1 = 10
    val num2 = 15
    println("MCD de $num1 y $num2 es " + mcdCalculator(num1, num2))
    println("MCD de $num1 y $num2 recursivo es " + mcdCalculatorRecursive(num1, num2))
    println("MCM de $num1 y $num2 es " + mcmCalculator(num1, num2))
}

fun mcdCalculatorRecursive(num1: Int, num2: Int): Int {
    if (num2 == 0) return num1
    return mcdCalculatorRecursive(num2, num1 % num2);
}

fun mcdCalculator(num1: Int, num2: Int): Int {
    var aux1: Int = num1
    var aux2: Int = num2
    var temp: Int
    while (aux2 > 0) {
        temp = aux2
        aux2 = aux1 % aux2
        aux1 = temp
    }
    return aux1
}

fun mcmCalculator(a: Int, b: Int): Int {
    return a * b / mcdCalculator(a, b)
}
