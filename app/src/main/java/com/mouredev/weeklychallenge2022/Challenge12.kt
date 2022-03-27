package com.mouredev.weeklychallenge2022

import java.util.*

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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("Welcome to is palindrome.")
    println("Enter text to check if is palindrome: ")
    val text = readLine()
    text?.let {
        println("Is \"$it\" palindrome? -> ${it.isPalindrome()}")
    }
}

private fun String.isPalindrome(): Boolean {
    val formattedText: String = this.formatString()
    val lastIndex = formattedText.length -1
    var isPalindrome = true
    var index = 0
    while(index <= lastIndex-index && isPalindrome){
        isPalindrome = formattedText[index] == formattedText[lastIndex-index]
        index++
    }
    return isPalindrome
}

private fun String.formatString(): String = this.lowercase(Locale.getDefault()).map {
    it.removeAccent()
}.toString().replace("[^a-z0-9]".toRegex(), "")

private fun Char.removeAccent(): Char =
    when {
        this == 'á' -> 'a'
        this == 'é' -> 'e'
        this == 'í' -> 'i'
        this == 'ó' -> 'o'
        this == 'ú' -> 'u'
        else -> this
    }