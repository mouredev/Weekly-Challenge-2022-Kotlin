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
    print("Introduce a word: ")
    val word = readLine()?.lowercase(Locale.getDefault())
    print("Introduce an other word: ")
    val other = readLine()?.lowercase(Locale.getDefault())
    println("$word and $other are anagrams? " +
            if(areAnagrams(word?: "", other?: "")) "YES" else "NO"
    )
}

fun areAnagrams(word: String, other: String): Boolean {
    if(word == other || word.length != other.length) return false
    val sortedWord = word.split("").sorted().joinToString("")
    val sortedOther = other.split("").sorted().joinToString("")
    return (sortedWord == sortedOther)
}
