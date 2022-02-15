package com.mouredev.weeklychallenge2022

import java.text.Normalizer

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(){
    println (countWordsOccurences("Lunes, mARTes: miércoLES\$JUeves *VierNes+sábado&¨^doMingo^miércoles ¡SABAdo! domingo"))
}

fun replaceSpecialChars(input: String): String {
    val out = input.replace(Regex("""[$,.:;*+_~¨"^`#&!¡¿?|°¬<>]"""), " ")
    return out
}

private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

fun CharSequence.unaccent(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
}

fun countWordsOccurences(input: String): Map<String, Int> {
    val filter = replaceSpecialChars(input).lowercase().unaccent()
    val words = filter.split(" ")
    val wordsCount = mutableMapOf<String, Int>()

    for (word in words){
        if (!wordsCount.contains(word)){
            wordsCount.put(word, 1)
        } else wordsCount[word] = wordsCount.getValue(word) + 1
    }
    wordsCount.remove("")

    return wordsCount
}