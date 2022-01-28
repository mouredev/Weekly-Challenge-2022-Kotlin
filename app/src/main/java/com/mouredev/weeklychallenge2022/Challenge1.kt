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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val word1 : String
    val word2 : String

    word1 = "hola"
    word2 = "halo"

    if (anagram(word1, word2)) println("¡$word1 y $word2 son anagramas!")
    else println("$word1 y $word2 no son anagramas")
}

private fun anagram(word1: String, word2: String): Boolean {
    val wordMayus1 = word1.uppercase()
    var wordMayus2 = word2.uppercase()
    if ((wordMayus1 == wordMayus2) || (wordMayus1.length != wordMayus2.length) ||
        wordMayus1.isEmpty() || wordMayus2.isEmpty()
    ) return false
    for (i in 0 until word1.length) {
        if (wordMayus2.contains(wordMayus1[i])) {
            wordMayus2 = wordMayus2.replaceFirst(wordMayus1[i],' ',false)
        }
    }
    if (wordMayus2.filter { !it.isWhitespace() }.isEmpty()) return true
    return false
}
