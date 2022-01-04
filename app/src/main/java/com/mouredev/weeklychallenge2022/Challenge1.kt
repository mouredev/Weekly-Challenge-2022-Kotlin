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
    println("Ingrese la primer palabra:")
    val word1: String = readWord()

    println("Ingrese la segunda palabra:")
    val word2: String = readWord()

    println("\nLas palabras ingresadas *${if(isAnagram(word1, word2)) "son" else "no son"}* anagramas")
}

/**
 * Lee una linea del stdin y se queda con la primer palabra antes de un espacio si lo hay.
 */
fun readWord(): String = readLine()?.split(regex = Regex("\\s"))?.first() ?: ""

/**
 * Indica si los string recibidos con anagramas.
 * Si ambos strings son exactamente iguales devuelve False.
 * Ignora si son mayusculas o minusculas.
 */
fun isAnagram(anagram: String, original: String): Boolean {
    val lowerAnagram = anagram.lowercase()
    val lowerOriginal = original.lowercase()
    if(lowerAnagram.length != lowerOriginal.length || lowerAnagram == lowerOriginal) return false
    // Uso toCharArray() para poder usar sorted()
    return lowerAnagram.toCharArray().sorted() == lowerOriginal.toCharArray().sorted()
}