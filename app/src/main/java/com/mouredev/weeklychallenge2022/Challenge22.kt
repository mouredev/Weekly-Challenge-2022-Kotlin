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
    println(checkArrays(arrayListOf(1, 2, 3, 4, 5), arrayListOf(2, 4, 5, 6, 7), true))
    println(checkArrays(arrayListOf(1, 2, 3, 4, 5), arrayListOf(2, 4, 5, 6, 7), false))
}

private fun checkArrays(
    al1: ArrayList<Int>,
    al2: ArrayList<Int>,
    checkSame: Boolean
): ArrayList<Int> {
    al1.addAll(al2)
    return if (checkSame) {
        ArrayList(al1.groupingBy { it }.eachCount().filter { it.value > 1 }.keys)
    } else {
        ArrayList(al1.groupingBy { it }.eachCount().filter { it.value == 1 }.keys)
    }
}