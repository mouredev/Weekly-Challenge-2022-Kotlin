package com.mouredev.weeklychallenge2022

import java.text.Normalizer

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main() {
    testCase(words = "Retorna la vocal que más veces se repita", expectedResult = listOf("e"))
    testCase(words = "Prueba corta", expectedResult = listOf("a"))
    testCase(words = "qq ww rr", expectedResult = null)
    testCase(words = "aAáÄÁ", expectedResult = listOf("a"))
    testCase(words = "aaiio", expectedResult = listOf("a", "i"))
}

fun testCase(words: String, expectedResult: List<String>?) {
    val repeatedVowel = calculateMostRepeatedVowel(wordToEvaluate = words)

    if (repeatedVowel?.toList() != expectedResult) {
        throw Exception(
            "Case with the word '${words}', returns $repeatedVowel but it should be $expectedResult"
        )
    }
    println("Test pass '${words}' with expected $expectedResult")
}

fun calculateMostRepeatedVowel(wordToEvaluate: String): Set<String>? {

    if (wordToEvaluate.isEmpty()) {
        return null
    }

    val vowels = listOf("a", "e", "i", "o", "u")
    val repeatedVowel = mutableMapOf<String, Int>()

    val words = cleanWord(words = wordToEvaluate)

    words.forEach { char ->
        if (char.toString() in vowels) {
            val counter = repeatedVowel.getOrDefault(char.toString(), 0) + 1
            repeatedVowel[char.toString()] = counter
        }
    }

    if (repeatedVowel.isEmpty()) {
        return null
    }

    return findMaxValueFromMap(maxRepeatedVowel = repeatedVowel)?.keys
}

fun cleanWord(words: String): String {
    val cleanWord = Normalizer.normalize(words, Normalizer.Form.NFD)
    return cleanWord.lowercase()
}

fun findMaxValueFromMap(maxRepeatedVowel: Map<String, Int>): Map<String, Int>? {
    return maxRepeatedVowel.values.maxOrNull()?.let { maxValue ->
        maxRepeatedVowel.filterValues { it == maxValue }
    }
}