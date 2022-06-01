package com.mouredev.weeklychallenge2022

import kotlin.collections.ArrayList

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
    // create an array with 5 numbers and save in val
    val array1: Array<Any> = arrayOf("1", 2, 3, 4, 5)
    val array2: Array<Any> = arrayOf(1, 2, '3', 6, 5)

    val result = shared(array1, array2, true)
    println(result)
}

fun shared(array1: Array<Any>, array2: Array<Any>, common: Boolean): ArrayList<String> {
    val result = ArrayList<String>()

    if (common) {
        array1.forEach { e ->
            run {
                if (array2.indexOf(e) != -1) {
                    result.add(e.toString())
                }
            }
        }
    } else {
        array1.forEach { e ->
            run {
                if (array2.indexOf(e) == -1) {
                    result.add(e.toString())
                }
            }
        }
    }
    return result
}