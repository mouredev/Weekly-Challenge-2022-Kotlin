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

fun main() {

    val naturalText = "Chocapic. Es una marca de cereales?"
    val morseText = decoder(naturalText)
    println(morseText)
    println(decoder(morseText))
}

private fun decoder(input: String): String {

    var decodedInput = ""

    val naturalDict = mapOf("A" to ".—", "N" to "—.", "0" to "—————",
        "B" to "—...", "Ñ" to "——.——", "1" to ".————",
        "C" to "—.—.", "O" to "———", "2" to "..———",
        "CH" to "————", "P" to ".——.", "3" to "...——",
        "D" to "—..", "Q" to "——.—", "4" to "....—",
        "E" to ".", "R" to ".—.", "5" to ".....",
        "F" to "..—.", "S" to "...", "6" to "—....",
        "G" to "——.", "T" to "—", "7" to "——...",
        "H" to "....", "U" to "..—", "8" to "———..",
        "I" to "..", "V" to "...—", "9" to "————.",
        "J" to ".———", "W" to ".——", "." to ".—.—.—",
        "K" to "—.—", "X" to "—..—", "," to "——..——",
        "L" to ".—..", "Y" to "—.——", "?" to "..——..",
        "M" to "——", "Z" to "——..", "\"" to ".—..—.", "/" to "—..—.")

    val morseDict = mutableMapOf<String, String>()
    naturalDict.forEach {
        morseDict[it.value] = it.key
    }

    if (input.contains("[a-zA-Z0-9]".toRegex())) {

        // Natural

        var index = 0
        var ch = false

        input.uppercase().forEach { character ->
            if (!ch && character.toString() != " ") {
                val nextIndex = index + 1
                if (character.toString() == "C" && nextIndex < input.length && input.uppercase()[nextIndex].toString() == "H") {
                    decodedInput += naturalDict["CH"]
                    ch = true
                } else {
                    decodedInput += naturalDict[character.toString()]
                }

                decodedInput += " "
            } else {
                if (!ch) {
                    decodedInput += " "
                }
                ch = false
            }

            index++
        }

    } else if (input.contains(".") || input.contains("—")) {

        // Morse

        input.split("  ").forEach { word ->
            word.split(" ").forEach { symbols ->
                if (symbols.isNotEmpty()) {
                    decodedInput += morseDict[symbols]
                }
            }
            decodedInput += " "
        }
    }

    return decodedInput
}