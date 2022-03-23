package com.mouredev.weeklychallenge2022

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
    val str = "Ana lleva al oso la avellana"
    println("¿Es palindroma la frase '$str'?: ${isPalindrome(str.lowercase())} ")
    val str2 = "Esta casa huele a nueva"
    println("¿Es palindroma la frase '$str2'?: ${isPalindrome(str2.lowercase())} ")
    val str3 = "Café y cigarro, muñequito de barro"
    println("¿Es palindroma la frase '$str3'?: ${isPalindrome(str3.lowercase())} ")
    val str4 = "11811"
    println("¿Es palindroma la frase '$str4'?: ${isPalindrome(str4.lowercase())} ")
    val str5 = "Amor azul\n" +
            "\n" +
            "Ramera, de todo te di.\n" +
            "\n" +
            "Mariposa colosal, sí,\n" +
            "\n" +
            "yo de todo te di.\n" +
            "\n" +
            "Poda la rosa, Venus.\n" +
            "\n" +
            "El átomo como tal\n" +
            "\n" +
            "es un evasor alado.\n" +
            "\n" +
            "Pide, todo te doy: isla,\n" +
            "\n" +
            "sol, ocaso, pirámide.\n" +
            "\n" +
            "Todo te daré: mar, luz, aroma"
    println("¿Es palindroma la frase '$str5'?: ${isPalindrome(str5.lowercase())} ")
}

private fun isPalindrome(str: String): Boolean {

    var clearString = ""
    var clearReverseString = ""

    val specialsChar = hashMapOf ("á" to "a", "é" to "e", "í" to "i", "ó" to "o", "ú" to "u",
                                  "ä" to "a", "ë" to "e", "ï" to "i", "ö" to "o", "ü" to "u")

    str.forEach{
        if (it.isLetterOrDigit()) {
            if (specialsChar.containsKey(it.toString())){
                clearString += specialsChar.getValue(it.toString())
                clearReverseString = specialsChar.getValue(it.toString()) + clearReverseString
            }
            else {
                clearString += it.toString()
                clearReverseString = it.toString() + clearReverseString
            }

        }
    }

    return clearString == clearReverseString
}