package es.jaimefere.weeklychallenge2022

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

fun getMostRepeatedVowels(text: String): String {
    val cleanedText = text.unaccented().lowercase()
    val vowelOccurrences: MutableMap<Char, Int> = mutableMapOf()
    cleanedText.forEach { letter ->
        if("aeiou".contains(letter)) {
            vowelOccurrences[letter] = vowelOccurrences[letter]?.plus(1) ?: 1
        }
    }
    val maxEntry = vowelOccurrences.maxByOrNull{ it.value }
    return if(maxEntry == null) "[]" else vowelOccurrences.filter{ it.value == maxEntry.value }.keys.toString()
}

fun main() {
    println(getMostRepeatedVowels("¡Pssst!"))
    println(getMostRepeatedVowels("¡Hola Brais!"))
    println(getMostRepeatedVowels("¡Adiós Brais!"))
    println(getMostRepeatedVowels("¡Adiós Martín!"))
}

