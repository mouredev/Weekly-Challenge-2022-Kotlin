package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) '🔁reto-semanal' para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    wordCounter("Pepe Pecas pica papas con un pico, con un pico pica papas Pepe Pecas. " +
            "Si Pepe Pecas pica papas con un pico, ¿dónde está el pico con que Pepe Pecas pica papas?")
}

private var punctuation = arrayListOf(
    '!', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=',
    '>', '?', '@', '[', ']', '^', '_', '`', '{', '|', '}', '~', '"', '¿'
)

private fun cleanPunctuation(text: String): String {
    var cleanText = ""
    for (c: Char in text) {
        if (!punctuation.contains(c)) {
            cleanText += c
        }
    }
    return cleanText.lowercase()
}

private fun wordCounter(text: String) {
    val words = cleanPunctuation(text).split(" ")
    val map: LinkedHashMap<String, Int> = LinkedHashMap()
    for (word: String in words) {
        if (map.containsKey(word)) {
            val count = map[word]
            map[word] = count!!.plus(1)
        } else {
            map[word] = 1
        }
    }
    map.forEach { (s, i) ->
        println("$s: $i veces")
    }
}
