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
    printAnagram("tac", "tac") //iguales
    printAnagram("taco", "tac") //diferente tamaño
    printAnagram("roma", "amor") //anagrama ok
    printAnagram("Tom Marvolo Riddle", "I am Lord Voldemort") //Anagrama frases y mayusculas
}

fun printAnagram (word1: String, word2:String){
    if (isAnagram(word1, word2)) {
        println("Las palabras: $word1 y $word2 son anagramas entre ellas")
    } else {
        println("Las palabras: $word1 y $word2 NO son anagramas entre ellas")
    }
}

fun isAnagram (word1: String, word2: String): Boolean {
    val word1Sort = sortedLowerWord(word1)
    val word2Sort = sortedLowerWord(word2)
    if(word1 == word2) return false
    if(word1Sort.length != word2Sort.length) return false
    if(word1Sort.equals(word2Sort, true)) return true
    return false
}

fun sortedLowerWord(word : String): String {
    val wordSort = word.lowercase().toCharArray().sorted()
    var wordReturn = ""
    for(letter in wordSort){
        wordReturn += letter
    }
    return wordReturn.trim()
}
