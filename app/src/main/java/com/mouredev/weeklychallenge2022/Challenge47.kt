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
private val REGEX_UNACCENTED = "\\p{InCombiningDiacriticalMarks}+".toRegex()

fun CharSequence.unaccented(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENTED.replace(temp, "")
}

fun getMostRepeatedVocals(text: String): String {
    val cleanedText = text.unaccented().lowercase()
    val vocalOccurrences: MutableMap<Char, Int> = mutableMapOf()
    cleanedText.forEach { letter ->
        if("aeiou".contains(letter)) {
            vocalOccurrences[letter] = vocalOccurrences[letter]?.plus(1) ?: 1
        }
    }
    val maxEntry = vocalOccurrences.maxByOrNull{ it.value }
    return if(maxEntry == null) "[]" else vocalOccurrences.filter{ it.value == maxEntry.value }.keys.toString()
}

fun main() {
    println(getMostRepeatedVocals("¡Pssst!"))
    println(getMostRepeatedVocals("¡Hola Brais!"))
    println(getMostRepeatedVocals("¡Adiós Brais!"))
    println(getMostRepeatedVocals("¡Adiós Martín!"))
}

