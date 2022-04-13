package com.example.weeklychallenge2022

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

    var num: Long = 25
    println("El factorial de $num es : " + esFactorial(num))
    num = 0
    println("El factorial de $num es : " + esFactorial(num))
    num = 10
    println("El factorial de $num es : " + esFactorial(num))
    num = -1
    println("El factorial de $num es : " + esFactorial(num))
}

fun esFactorial(num: Long): Long {
    return if (num == 0L) {
        1
    } else {
        num * esFactorial(num - 1)
    }
}
