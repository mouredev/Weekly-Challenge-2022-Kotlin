package com.mouredev.weeklychallenge2022

import java.util.*

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

    val word1 = "bad credit"
    val word2 = "debit card"

    if(isAnAnagram(word1, word2)) {
        print("$word1 and $word2 are anagrams")
    } else {
        print("$word1 and $word2 aren't anagrams")
    }
}

fun isAnAnagram(word1: String, word2: String) : Boolean {

    if(word1.length != word2.length || word1 == word2) return false

    var word1Sorted = word1.lowercase().toCharArray().sorted().joinToString("")
    var word2Sorted = word2.lowercase().toCharArray().sorted().joinToString("")

    if(word1Sorted == word2Sorted) return true

    return false
}
