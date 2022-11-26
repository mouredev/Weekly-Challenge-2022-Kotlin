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
    println(getVocal(""))
    println(getVocal("aeiou"))
    println(getVocal("zxcvbnm,.@#¬1353<>~¨d+"))
    println(getVocal("HOLA mundo"))
    println(getVocal("aáÄÀA"))
}

fun getVocal(text: String): String {
    val vocalsList = listOf('a', 'e', 'i', 'o', 'u')
    val mostUsedVocals = mutableListOf<Char>()
    var maxVocalCount = 0

    //se eliminan todos los acentos o marcas
    val normalizedText =
        Normalizer.normalize(text, Normalizer.Form.NFD).lowercase().replace("\\p{M}+".toRegex(), "")

    vocalsList.forEach { vocal ->
        val vocalCount = normalizedText.count { it == vocal } //para cada vocal, almacena el número de vocales que contiene texto de entrada
        if(vocalCount > maxVocalCount){
            maxVocalCount = vocalCount
            mostUsedVocals.clear()
            mostUsedVocals.add(vocal)
        }
        else if(vocalCount == maxVocalCount && vocalCount != 0){
            mostUsedVocals.add(vocal)
        }
    }

    return if(mostUsedVocals.isEmpty())
        "No hay vocales"
    else
        "Vocales más repetidas: $mostUsedVocals , repeticiones: $maxVocalCount"
}