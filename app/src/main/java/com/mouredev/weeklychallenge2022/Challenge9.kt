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
 *
 */

fun main() {
    naturalToMorse("br                        de")
}

/*
FUNCION DE MARTINEZ DE CODIFICACIÓN
-Esta función tienen en cuenta letras, números, símbolos, letra 'Ñ' pero NO la letra 'CH'
-Eta función tienen en cuenta que pueda haber múltiples espacios entre las palabras para no tenerlos en cuenta
-Quedaría pendiente que la funcion decodificase de morse a lenguaje natural ...
 */

fun naturalToMorse(naturaltext : String) : String{

    var morseText = ""
    var myDictionary = hashMapOf(
        "a" to ".-", "b" to "-...", "c" to "-.-.", "d" to "-..", "e" to ".", "f" to "..-.",
        "g" to "--.", "h" to "....", "i" to "..", "j" to ".---", "k" to "-.-", "l" to ".-..",
        "m" to "--", "n" to "-.", "o" to "---", "p" to ".--.", "q" to "--.-", "r" to ".-.",
        "s" to "...", "t" to "-", "u" to "..-", "v" to "...-", "w" to ".--", "x" to "-..-",
        "y" to "-.--", "z" to "--..", "Ñ" to "--.--", "0" to "--..", "1" to "--..", "2" to "--..",
        "3" to "--..", "4" to "--..", "5" to "--..", "6" to "--..", "7" to "--..", "8" to "--..",
        "9" to "--..", "." to ".-.-.-", "," to "--..--", "?" to "..--..", "'" to ".----.",
        "!" to "-.-.--", "/" to "-..-.", "(" to "-.--.", ")" to "-.--.-", "&" to ".-...",
        ":" to "---...", ";" to "-.-.-.", "=" to "-...-", "+" to ".-.-.", "-" to "-....-",
        "_" to "..--.-", "\"" to ".-..-.", "$" to "...-..-", "@" to ".--.-.", "¿" to "..-.-",
        "¡" to "--...-",
        " " to "  "
    )
    var flagSpace = false //Controla las frases en las que hay más de un espacio entre las palabras.

    naturaltext.forEach {

        if(it.toString() == " " && !flagSpace){
            morseText += myDictionary[it.toString()]
            flagSpace = true

        }else if(it.toString() != " "){
            morseText += myDictionary[it.toString()] + " "
            flagSpace = false
        }
    }
    return morseText
}


/*
FUNCION DE MOURE DE CODIFICACIÓN Y DECODIFICACIÓN
-Esta función tiene en cuenta letras, símbolos, números, la 'Ñ' y la 'CH'
 */
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
