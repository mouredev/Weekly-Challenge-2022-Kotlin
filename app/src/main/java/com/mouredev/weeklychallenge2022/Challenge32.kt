package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(secondLargest(numbers))
}

fun secondLargest(number:List<Int>): Int {
    var largest = number[0]
    var secondLargest = number[0]
    for (i in number){
        if (i > largest){
            secondLargest = largest
            largest = i
        } else if (i in (secondLargest + 1) until largest){
            secondLargest = i
        }
    }
    return secondLargest
}