package com.mouredev.weeklychallenge2022

/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
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
    println(calculateSet(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), true))
    println(calculateSet(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), false))
}

private fun calculateSet(first: List<Int>, second: List<Int>, common: Boolean): List<Int> {

    val commonResult = mutableListOf<Int>()

    for (firstValue in first) {
        if (!commonResult.contains(firstValue)) {
            for (secondValue in second) {
                if (firstValue == secondValue && !commonResult.contains(firstValue)) {
                    commonResult.add(firstValue)
                    break
                }
            }
        }
    }

    return if (common) {
        commonResult
    } else {
        val nonCommonResult = mutableListOf<Int>()
        nonCommonResult.addAll(first)
        nonCommonResult.addAll(second)

        commonResult.forEach { commonValue ->
            nonCommonResult.removeAll { nonCommonValue ->
                commonValue == nonCommonValue
            }
        }

        nonCommonResult
    }
}