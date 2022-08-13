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
    get(listOf(23, 1, 2, 53, 14, 42, 14, 530, 21, 23, 345))
    get(listOf(14, 14, -3, 532, 124, 57, 31, 435))
}

private fun get(items: List<Int>) {
    var first = Int.MIN_VALUE
	var second = Int.MIN_VALUE
    
    for (item in items) {
        if (item > first && item > second) {
            second = first
            first = item
        } else if (item > second) {
		   second = item
        }
    }
    
    println("Result: ${second}")
}