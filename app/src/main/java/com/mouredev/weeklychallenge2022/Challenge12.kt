package com.mouredev.weeklychallenge2022

import java.text.Normalizer

/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 *
 */

fun main(){

    println(isPalindrome("Ana lleva al oso'¡`+ç´.,,..,...´ç la avellana"))
    println(isPalindrome("Róma ni se conoce sin oro, ni se conoce sin amor."))
    println(isPalindrome("Roma ni se conoce sin oro, ni se conoce sin amor."))
}

/*
BLOQUE MARTINEZ
 */
fun isPalindrome(sentence : String) : Boolean{
    val formatSentence = formatSentence(sentence)
    val reverseFormatSentence= formatSentence.reversed()

    if (formatSentence == reverseFormatSentence){
        return true
    }
    return false
}

fun formatSentence(sentence: String): String {
    val dictionary = "abcdefghijklmnñopqrstuvwxyz0123456789"
    return sentence
        .lowercase()
        .replace('á','a')
        .replace('é','e')
        .replace('í','i')
        .replace('ó','o')
        .replace('ú','u')
        .trim()
        .filter { it != ' ' }
        .filter { dictionary.contains(it) }
}

/*
BLOQUE MOURE
 */
private fun isPalindromeAux(text: String): Boolean {

    val normalizedText = Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD)
        .replace("[^\\p{ASCII}]".toRegex(), "")
        .replace("[^a-z0-9]".toRegex(), "")
    return normalizedText == normalizedText.reversed()
}

