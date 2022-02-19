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
    println("Welcome to ANAGRAMA")
    println("Enter the first string: ")
    val str1 = readLine()
    println("Enter the second string: ")
    val str2 = readLine()
    val isAnagrama = isAnagrama(str1.toString(), str2.toString())
    println("These string are ANAGRAMA?")
    println("$isAnagrama")
}

private fun isAnagrama(str1: String, str2: String): Boolean {
    var result = str1.lowercase() != str2.lowercase()
    if (result) {
        result = str1.length == str2.length
        if (result) {
            str1.lowercase().forEach {
                if (result) {
                    result = numberOfOcurrence(it, str1.lowercase()) == numberOfOcurrence(it, str2.lowercase())
                }
            }
        }
    }
    return result
}

private fun numberOfOcurrence(char: Char, string: String) = string.filter {
    it == char
}.count()