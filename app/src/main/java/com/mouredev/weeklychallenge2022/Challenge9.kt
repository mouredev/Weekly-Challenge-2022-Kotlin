package com.mouredev.weeklychallenge2022

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

val morse: Map<String, String> = mapOf(
    "A" to ".-",
    "B" to "-...",
    "C" to "-.-.",
    "CH" to "----",
    "D" to "-..",
    "E" to ".",
    "F" to "..-.",
    "G" to "--.",
    "H" to "....",
    "I" to "..",
    "J" to ".---",
    "K" to "-.-",
    "L" to ".-..",
    "M" to "--",
    "N" to "-.",
    "Ñ" to "--.--",
    "O" to "---",
    "P" to ".--.",
    "Q" to "--.-",
    "R" to ".-.",
    "S" to "...",
    "T" to "-",
    "U" to "..--",
    "V" to "...--",
    "W" to ".--",
    "X" to "-..-",
    "Y" to "-.--",
    "Z" to "--.."
)

fun main() {

    val texto = "Debe detectar automáticamente de qué tipo se trata y realizar la conversión."
    println(toMorse(texto))


}

fun toMorse(texto: String): String {
    var morseText = ""
    texto.toCharArray().forEach { word ->
        morseText += if (word.toString() == " ") {
            "  "
        } else {
            morse.get(word.uppercase()) + " "
        }
    }
    return morseText
}

fun fromMorse() {

}