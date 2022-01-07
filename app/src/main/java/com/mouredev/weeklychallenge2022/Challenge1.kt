package com.mouredev.weeklychallenge2022

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🗓reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val word1 = "Gloria"
    val word2 = "gorila"
    if (compareWords(word1,word2))
        println("$word1 y $word2 son anagramas")
    else
        println("$word1 y $word2 no son anagramas")
}

fun compareWords(word1: String, word2: String) : Boolean {
    return if (word1.uppercase() != word2.uppercase()) {
        val arrWord1 = Array(word1.length) { word1[it].toString().uppercase() }
        val arrWord2 = Array(word2.length) { word2[it].toString().uppercase() }
        arrWord1.sort()
        arrWord2.sort()

        arrWord1 contentEquals arrWord2

    } else
        false
}
