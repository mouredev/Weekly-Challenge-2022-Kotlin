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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(isPalindrome("Ana lleva al oso la avellana."))  // true
    println(isPalindrome("La ruta nos aportó otro paso natural."))  // true
    println(isPalindrome("¡Rápido, di par!")) // true
    println(isPalindrome("No, no soy palíndromo")) // false
}

// https://loquemeinteresadelared.wordpress.com/tag/incombiningdiacriticalmarks/
private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

fun CharSequence.unaccent(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
}

fun isPalindrome(input: String): Boolean {
    var normalized = input.unaccent().lowercase()
    normalized = normalized.replace("""[?¿!¡,.; ]""".toRegex(), "")
    var isPalindrome = true
    for (i in 0..normalized.length/2){
        if (normalized[i] != normalized[normalized.lastIndex-i]) isPalindrome = false
    }
    return isPalindrome
}