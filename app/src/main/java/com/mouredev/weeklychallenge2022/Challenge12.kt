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
fun main(args: Array<String>) {
    val cadena = "Ana lleva al oso la avellana"
    println(esPalindromo(cadena))
}

fun normalizar(cadena: String): String {
    val caracteres: Map<String, String> =
        mapOf("á" to "a", "é" to "e", "í" to "i", "ó" to "o", "ú" to "u", "." to "", "," to "", " " to "")
    var natural = ""
    val frase = cadena.lowercase().split("")

    for (i in frase) {
        natural += if (caracteres.containsKey(i)) {
            caracteres[i]
        } else {
            i
        }
    }
    return natural.trim()
}

fun esPalindromo(cadena: String): Boolean {
    val original = normalizar(cadena)
    val reversed = original.reversed()
    print("entrada: ${cadena}\nnormalizada: ${original}\ninversa: ${reversed}")
    return original == reversed
}