package com.mouredev.weeklychallenge2022

import java.util.*
import kotlin.collections.HashMap

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

fun main() {
    wordsCounter(sentence = "Thousands of feet march to the beat It's an army on the march Long way from home Paying the price in young men's lives Thousands of feet march to the beat It's an army in despair Knee-deep in mud Stuck in the trench with no way out")
}

fun wordsCounter(sentence: String) {

    var arrayWords = sentence.lowercase().split(" ", ",", ".", ";", ":", ignoreCase = true)
    var hashMap = HashMap<String, Int>()

    arrayWords.forEach{
        updateCounter(hashMap, it)
    }

    for((key, value) in hashMap) {
        println("The word $key has been written $value times")
    }

    println("There are ${arrayWords.size} words in the sentence")
}

fun updateCounter(dictionary: HashMap<String, Int>, value: String) : HashMap<String, Int> {

    if(!dictionary.containsKey(value)) dictionary[value] = 1 else dictionary[value] = dictionary[value]!! + 1

    return dictionary
}
