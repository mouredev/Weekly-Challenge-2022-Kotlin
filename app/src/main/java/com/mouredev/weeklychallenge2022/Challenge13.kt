package com.mouredev.weeklychallenge2022

/*
 * Reto #13
 * FACTORIAL RECURSIVO
 * Fecha publicación enunciado: 28/03/22
 * Fecha publicación resolución: 04/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("El factorial de 0 (caso especial) es = ${Factorial(0)}")
    println("El factorial de 1 (caso extremo) es = ${Factorial(1)}")
    println("El factorial de 5 es = ${Factorial(5)}")
    println("El factorial de 100 es = ${Factorial(100)}")
}

private fun Factorial(number: Int): Double{
    return if (number < 2) 1.toDouble() else number * (Factorial(number - 1))
}