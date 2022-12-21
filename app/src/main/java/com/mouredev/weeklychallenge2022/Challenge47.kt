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
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(mostRepeatedVowel("aaaaaeeeeiiioou"))
    println(mostRepeatedVowel("AáaaaEeeeIiiOoU"))
    println(mostRepeatedVowel("eeeeiiioouaaaaa"))
    println(mostRepeatedVowel(".-Aá?aaaBbEeeweIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eEIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eEIiiOoUuuuuu:"))
    println(mostRepeatedVowel("aeiou"))
    println(mostRepeatedVowel("brp qyz"))
}

private fun mostRepeatedVowel(text: String) : List<String> {

    val vowelCount = mutableMapOf<Char, Int>()

    Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD).forEach { character ->
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
            vowelCount[character] = vowelCount[character]?.plus(1) ?: 1
        }
    }

    val mostRepeated = mutableListOf<String>()
    var maxRepeated = 0

    vowelCount.forEach { (vowel: Char, count: Int) ->
        if (count >= maxRepeated) {
            if (count > maxRepeated) {
                mostRepeated.clear()
            }
            mostRepeated.add(vowel.toString())

            maxRepeated = count
        }
    }

    return mostRepeated
}