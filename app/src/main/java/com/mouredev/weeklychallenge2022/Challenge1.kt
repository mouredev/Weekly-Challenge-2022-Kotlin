package com.mouredev.weeklychallenge2022

import java.text.Normalizer

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
    println(isAnagram("RAIL! SAFETY!", "fairy tales"))
}

fun isAnagram(word1: String, word2: String): Boolean {
    val sequence1 = frequencyChar(word1)
    val sequence2 = frequencyChar(word2)
    return sequence1 == sequence2
}

fun frequencyChar(string: String) : Map<Char, List<Char>> =
    string.uppercase().clearAccent().filter { it.isLetter() }.groupBy { it }

fun String.clearAccent(): String {
    //source: https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette/3322174#3322174
    val stringNormalizer = Normalizer.normalize(this, Normalizer.Form.NFD)
    return stringNormalizer.replace("[^\\p{ASCII}]".toRegex(), "")
}