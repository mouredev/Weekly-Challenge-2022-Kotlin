package com.openai.chat

import es.jaimefere.weeklychallenge2022.translate

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa en Kotlin que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Resuelto: Sí.
 * Iteracciones: 6
 * Explicación: El programa lee un texto desde la consola y utiliza el diccionario morseAlphabet para realizar la conversión. Si el texto contiene puntos (.) o rayas
 * Conversación:
 * - Hay un error de sintaxis
 * - Se debería comparar con la letra no con la palabra.
 * - Para los casos en los que la entrada es código Morse, la salida de texto natural es una lista en lugar de una cadena
 * - En entradas de texto natural no traduce a Morse ni la letra CH ni símbolos de puntuación o interrogación.
 * - Vale, pero no escatimes, ponme todos los símbolos de interrogación, exclamación y puntuación que se te ocurran.
 *
 */

// Un diccionario que asocia cada letra del alfabeto con su código Morse
val morseAlphabet = mapOf(
    "A" to "·—",
    "B" to "—···",
    "C" to "—·—·",
    "D" to "—··",
    "E" to "·",
    "F" to "··—·",
    "G" to "——·",
    "H" to "····",
    "I" to "··",
    "J" to "·———",
    "K" to "—·—",
    "L" to "·—··",
    "M" to "——",
    "N" to "—·",
    "O" to "———",
    "P" to "·——·",
    "Q" to "——·—",
    "R" to "·—·",
    "S" to "···",
    "T" to "—",
    "U" to "··—",
    "V" to "···—",
    "W" to "·——",
    "X" to "—··—",
    "Y" to "—·——",
    "Z" to "——··",
    "0" to "—————",
    "1" to "·————",
    "2" to "··———",
    "3" to "···——",
    "4" to "····—",
    "5" to "·····",
    "6" to "—····",
    "7" to "——···",
    "8" to "———··",
    "9" to "————·",
    // Entradas anteriores omitidas para concisión
    "CH" to "————",
    "?" to "··——··",
    "¿" to "——·v——",
    "!" to "—·—·——",
    "¡" to "——···—",
    "." to "·—·—·—",
    "," to "——··——",
    ":" to "———···",
    ";" to "—·—·—·",
    "(" to "—·——·",
    ")" to "—·——·—",
    "\"" to "·—··—·",
    "'" to "·————·",
    "-" to "—····—",
    "_" to "··——·—",
    "/" to "—··—·",
    "@" to "·——·—·"
)

fun main() {
    // Brais case
    val input = "Chocapic. Es una marca de cereales?"
//    val input = "———— ——— —·—· ·— ·——· ·· —·—· ·—·—·—  · ···  ··— —· ·—  —— ·— ·—· —·—· ·—  —·· ·  —·—· · ·—· · ·— ·—·· · ··· ··——··"

    // Jaimefere case
//    val input = "De texto a Morse"  // —·· ·  — · —··— — ———  ·—  —— ——— ·—· ··· ·
//    val input = "—·· ·  —— ——— ·—· ··· ·  ·—  — · —··— — ———"    // DE MORSE A TEXTO

    // Si la entrada es un código Morse, la convertimos a texto natural
    if (input.contains("·") || input.contains("—")) {
        val words = input.split("  ")
        val result = words.map { word ->
            val letters = word.split(" ")
            letters.map { letter ->
                morseAlphabet.entries.first { it.value == letter }.key
            }.joinToString("")
        }.joinToString(" ")
        println("El texto natural es: $result")
    } else {
        // Si la entrada es un texto natural, la convertimos a código Morse
        val words = input.split(" ")
        val result = words.map { word ->
            val letters = word.toUpperCase().toCharArray()
            letters.map { morseAlphabet[it.toString()] ?: "" }.joinToString(" ")
        }.joinToString("  ")
        println("El código Morse es: $result")
    }
}

