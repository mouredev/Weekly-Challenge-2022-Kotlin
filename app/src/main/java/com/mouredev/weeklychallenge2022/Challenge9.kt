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
    println("Welcome to morse decoder.")
    println("Enter text for encode or decode: ")
    val text = readLine()
    text?.let {
        println(
            if (isNotMorse(it)) {
                encode(it)
            } else {
                decode(it)
            }
        )
    }

}

private fun isNotMorse(text: String) =
    text.any { it in 'A'..'Z' || it in 'a'..'z' || it.isDigit() || it == ',' || it == '?' || it == '\"' || it == '/' }

private fun encode(text: String): String =
    text.mapIndexed { index, c ->
        with(c.uppercase()) {
            try {
                when {
                    this == "C" && text[index + 1].uppercase() == "H" -> "CH".toMorse
                    index != 1 && this == "H" && text[index - 1].uppercase() == "C" -> EMPTY
                    this == " " -> " "
                    else -> this.toMorse
                }
            }catch (e : StringIndexOutOfBoundsException) {
                this.toMorse
            }
        }
    }.joinToString(EMPTY)

private fun decode(morse: String): String =
    morse.split(DOUBLE_SPACE).joinToString(SINGLE_SPACE) { word ->
        word.split(SINGLE_SPACE).joinToString(EMPTY) { char ->
            char.toAlphabet
        }
    }

private val String.toMorse : String
    get() =
        when (this) {
            "A" -> ".—"
            "B" -> "—..."
            "C" -> "—.—."
            "CH" -> "————"
            "D" -> "—.."
            "E" -> "."
            "F" -> "..—."
            "G" -> "——."
            "H" -> "...."
            "I" -> ".."
            "J" -> ".———"
            "K" -> "—.—"
            "L" -> ".—.."
            "M" -> "——"
            "N" -> "—."
            "Ñ" -> "——.——"
            "O" -> "———"
            "P" -> ".——."
            "Q" -> "——.—"
            "R" -> ".—."
            "S" -> "..."
            "T" -> "—"
            "U" -> "..—"
            "V" -> "...—"
            "W" -> ".——"
            "X" -> "—..—"
            "Y" -> "—.——"
            "Z" -> "——.."
            "0" -> "—————"
            "1" -> ".————"
            "2" -> "..———"
            "3" -> "...——"
            "4" -> "....—"
            "5" -> "....."
            "6" -> "—...."
            "7" -> "——..."
            "8" -> "———.."
            "9" -> "————."
            "." -> ".—.—.—"
            "," -> "——..——"
            "?" -> "..——.."
            "\"" -> ".—..—."
            "/" -> "—..—."
            else -> EMPTY
        }.plus(SINGLE_SPACE)

private val String.toAlphabet : String
    get() =
        when (this) {
            ".—" -> "A"
            "—..." -> "B"
            "—.—." -> "C"
            "————" -> "CH"
            "—.." -> "D"
            "." -> "E"
            "..—." -> "F"
            "——." -> "G"
            "...." -> "H"
            ".." -> "I"
            ".———" -> "J"
            "—.—" -> "K"
            ".—.." -> "L"
            "——" -> "M"
            "—." -> "N"
            "——.——" -> "Ñ"
            "———" -> "O"
            ".——." -> "P"
            "——.—" -> "Q"
            ".—." -> "R"
            "..." -> "S"
            "—" -> "T"
            "..—" -> "U"
            "...—" -> "V"
            ".——" -> "W"
            "—..—" -> "X"
            "—.——" -> "Y"
            "——.." -> "Z"
            "—————" -> "0"
            ".————" -> "1"
            "..———" -> "2"
            "...——" -> "3"
            "....—" -> "4"
            "....." -> "5"
            "—...." -> "6"
            "——..." -> "7"
            "———.." -> "8"
            "————." -> "9"
            ".—.—.—" -> "."
            "——..——" -> ","
            "..——.." -> "?"
            ".—..—." -> "\""
            "—..—." -> "/"
            DOUBLE_SPACE -> SINGLE_SPACE
            else -> EMPTY
        }

private const val SINGLE_SPACE = " "
private const val DOUBLE_SPACE = "  "
private const val EMPTY = ""