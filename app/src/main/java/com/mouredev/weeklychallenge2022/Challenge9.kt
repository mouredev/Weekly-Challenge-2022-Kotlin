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

    val morse = Morse()

    val inputTextoNatural = "Hola soy \"goku\". Eres goku? si, lo soy."
    println("Texto natural a código Morse")
    println("Traduciendo: $inputTextoNatural")
    println("Código Morse: ${morse.translate(inputTextoNatural)}")

    val inputMorse = ".... --- .-.. .-  ... --- -.--  .-..-. --. --- -.- ..- .-..-. .-.-.-  . .-. . ...  --. --- -.- ..- ..--..  ... .. --..--  .-.. ---  ... --- -.-- .-.-.-"
    morse.mode = morse.translateModeFromCodeToText
    println("Código Morse a texto natural")
    println("Traduciendo: $inputMorse")
    println("Texto natural: ${morse.translate(inputMorse)}")

}

class Morse {

    private val alphabet: Alphabet = Alphabet()
    val translateModeFromTextToCode: Int = 0
    val translateModeFromCodeToText: Int = 1

    private var characterSeparator: String = " "
    private var currentAlphabet: Map<String, String> = alphabet.map

    var mode: Int = translateModeFromTextToCode
        set(mode) {
            if(validateMode()) {
                println("Error!: An unknown mode has setted")
            }
            field = mode
            when (mode) {
                translateModeFromTextToCode -> {
                    currentAlphabet = alphabet.map
                    characterSeparator = " "
                }
                translateModeFromCodeToText -> {
                    currentAlphabet = alphabet.reverseMap
                    characterSeparator = ""
                }
                else -> currentAlphabet = alphabet.emptyMap
            }
        }

    fun translate(input: String): String {
        var translated = ""
        val preprocessedInput: List<String> = preprocessInput(input)
        for (character in preprocessedInput) {
            translated += currentAlphabet[character] + characterSeparator
        }
        return translated
    }

    private fun validateMode(): Boolean {
        return mode != translateModeFromTextToCode && mode != translateModeFromCodeToText
    }

    private fun preprocessInput(input: String): List<String> {
        return when(mode) {
            translateModeFromTextToCode -> input.uppercase().toCharArray().map { character -> character.toString() }
            translateModeFromCodeToText -> input.split(" ")
            else -> arrayListOf()
        }
    }
}

class Alphabet {
    val map: Map<String, String> = mapOf(
        Pair("A", ".-"),
        Pair("B", "-..."),
        Pair("C", "-.-."),
        Pair("CH", "----"),
        Pair("D", "-.."),
        Pair("E", "."),
        Pair("F", "..-."),
        Pair("G", "--."),
        Pair("H", "...."),
        Pair("I", ".."),
        Pair("J", ".---"),
        Pair("K", "-.-"),
        Pair("L", ".-.."),
        Pair("M", "--"),
        Pair("N", "-."),
        Pair("Ñ", "--.--"),
        Pair("O", "---"),
        Pair("P", ".--."),
        Pair("Q", "--.-"),
        Pair("R", ".-."),
        Pair("S", "..."),
        Pair("T", "-"),
        Pair("U", "..-"),
        Pair("V", "...-"),
        Pair("W", ".--"),
        Pair("X", "-..-"),
        Pair("Y", "-.--"),
        Pair("Z", "--.."),
        Pair("0", "-----"),
        Pair("1", ".----"),
        Pair("2", "..---"),
        Pair("3", "...--"),
        Pair("4", "....-"),
        Pair("5", "....."),
        Pair("6", "-...."),
        Pair("7", "--..."),
        Pair("8", "---.."),
        Pair("9", "----."),
        Pair(".", ".-.-.-"),
        Pair(",", "--..--"),
        Pair("?", "..--.."),
        Pair("\"", ".-..-."),
        Pair("/", "-..-."),
        Pair(" ", "")
    )

    val reverseMap: Map<String, String> = mapOf(
        Pair(".-", "A"),
        Pair("-...", "B"),
        Pair("-.-.", "C"),
        Pair("----", "CH"),
        Pair("-..", "D"),
        Pair(".", "E"),
        Pair("..-.", "F"),
        Pair("--.", "G"),
        Pair("....", "H"),
        Pair("..", "I"),
        Pair(".---", "J"),
        Pair( "-.-", "K"),
        Pair(".-..", "L"),
        Pair("--", "M"),
        Pair("-.", "N"),
        Pair("--.--", "Ñ"),
        Pair("---", "O"),
        Pair(".--.", "P"),
        Pair("--.-", "Q"),
        Pair(".-.", "R"),
        Pair("...", "S"),
        Pair("-", "T"),
        Pair("..-", "U"),
        Pair("...-", "V"),
        Pair(".--", "W"),
        Pair("-..-", "X"),
        Pair("-.--", "Y"),
        Pair("--..", "Z"),
        Pair("-----", "0"),
        Pair(".----", "1"),
        Pair("..---", "2"),
        Pair("...--", "3"),
        Pair("....-", "4"),
        Pair(".....", "5"),
        Pair("-....", "6"),
        Pair("--...", "7"),
        Pair("---..", "8"),
        Pair("----.", "9"),
        Pair(".-.-.-", "."),
        Pair("--..--", ","),
        Pair("..--..", "?"),
        Pair(".-..-.", "\""),
        Pair("-..-.", "/"),
        Pair("", " ")
    )

    val emptyMap: Map<String, String> = mapOf()
}

