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

    println(mostCommonVowel("El ingenioso hidalgo Don Quijote de la Mancha\\\" En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor"))
    println(mostCommonVowel("sqrt"))
    println(mostCommonVowel("¿Son robos o sobornos?"))
    println(mostCommonVowel(""))

}

/**
 * Función que recibe un texto y retorna la vocal que más veces se repite y ademas la imprime en consola
 * Si no hay vocales devolverá una cadena vacia
 * @param text Texto a analizar
 * @returns Vocal que más veces se repite
 * @param text
 */

fun mostCommonVowel(text: String): String {

    val vowels = "aeiou"
    var mostCommon = ""
    var mostCommonCount = 0

    vowels.forEach { vowel ->
        val count =text.normalize().count { it == vowel }
        if (count > mostCommonCount) {
            mostCommon = vowel.toString()
            mostCommonCount = count
        }
    }

    if(mostCommonCount == 0) {
        println("No hay vocales en el texto")
    } else {
        println("La vocal más común es $mostCommon con $mostCommonCount repeticiones")
    }


    return mostCommon
}

/**
 * Función que normaliza el texto quitando los acentos y caracteres especiales
 * @param str Texto a normalizar
 * @returns Texto normalizado
 */
private fun String.normalize(): String {
    return Normalizer.normalize(this.lowercase(), Normalizer.Form.NFD)
        .replace("[^\\p{ASCII}]".toRegex(), "").lowercase()
}
