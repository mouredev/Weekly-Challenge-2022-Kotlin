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

    var text = "Acaso hubo búhos acá"  // True
    println("$text -> ${isPalindrome(text)}")

    text = "Ó saír ría só"  // True
    println("$text -> ${isPalindrome(text)}")

    text = "A man, a plan, a canal: Panama!" // True
    println("$text -> ${isPalindrome(text)}")

    text = "MoureDev by Brais Moure"  // False
    println("$text -> ${isPalindrome(text)}")
}

private fun isPalindrome(text: String): Boolean {

    val mapChar = mapOf(
        "á" to "a", "é" to "e", "í" to "i", "ó" to "o", "ú" to "u",
        "à" to "a", "è" to "e", "ì" to "i", "ò" to "o", "ù" to "u",
        "ä" to "a", "ë" to "e", "ï" to "i", "ö" to "o", "ü" to "u",
        "â" to "a", "ê" to "e", "î" to "i", "ô" to "o", "û" to "u",
        "ç" to "c")

    var invertedText = ""
    var convertedText = text.lowercase()

    mapChar.forEach { entry -> convertedText = convertedText.replace(entry.key, entry.value) }
    convertedText = convertedText.replace("[^a-z0-9]".toRegex(), "")
    (convertedText.lastIndex downTo 0).forEach { char -> invertedText += convertedText[char] }

    return convertedText == invertedText
}
