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
    var numeros = listOf(1, 19, 30, 3, 16, 25, 36)

    println("El 2.º número más grande es: " + segundoMasGrande(numeros))
}

// función que ordena la lista y retorna el penúltimo item de la lista
private fun segundoMasGrande(listaNumeros: List<Int>): Int {
    return (listaNumeros.sorted()[listaNumeros.size - 2])
}