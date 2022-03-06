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

val letter = arrayOf(
    "a", "b", "c", "ch", "d", "e",
    "f", "g", "h", "i", "j", "k",
    "l", "m", "n", "ñ", "o", "p",
    "q", "r", "s", "t", "u", "v",
    "w", "x", "y", "z", "0", "1",
    "2", "3", "4", "5", "6", "7",
    "8", "9", ".", ",", "?", "\"",
    " "
)

var code = arrayOf(
    ".-", "-...", "-.-.", "————", "-..", ".",
    "..-.", "--.", "....", "..", ".---",
    "-.-", ".-..", "--", "-.", "——·——", "---", ".--.",
    "--.-", ".-.", "...", "-", "..-", "...-",
    ".--", "-..-", "-.--", "--..", "-----", ".----",
    "..---", "...--", "....-", ".....", "-....", "--...",
    "---..", "----.", "·—·—·—", "——··——", "··——··", "·—··—·",
    "/"
)

fun main() {
    val word = "Terry0022 is the rockstar"
    val morse = "- . .-. .-. -.-- ----- ----- ..--- ..---    .. ...    - .... .    .-. --- -.-. -.- ... - .- .-."
    println(translate(word))
    println(translate(morse))
}

fun translate(text: String): String {
    return if (text.contains(letter)) {
        translateToMorse(text)
    } else {
        translateToText(text)
    }
}

fun translateToMorse(text: String): String {
    var morse = ""
    val letters = text.lowercase()
    for (i in letters.indices) {
        for (j in letter.indices) {
            if (letters[i].toString() == letter[j]) {
                morse = if (j == 42) {
                    morse.plus("  ")
                } else {
                    morse.plus(code[j])
                }.plus(" ")
                break
            }
        }
    }
    return morse
}

fun translateToText(morse: String): String {
    var text = ""
    val tmp = morse.replace("    ", " / ")
    val array: List<String> = tmp.split(" ")
    for (i in array.indices) {
        for (j in code.indices) {
            if (array[i] == code[j]) {
                text = if (j == 42) {
                    text.plus(" ")
                } else {
                    text.plus(letter[j])
                }
                break
            }
        }
    }
    return text
}

private fun String.contains(letter: Array<String>): Boolean {
    letter.forEach { l ->
        return this.contains(l)
    }
    return false
}