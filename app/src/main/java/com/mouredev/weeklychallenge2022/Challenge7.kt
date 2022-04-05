package com.mouredev.weeklychallenge2022

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
    wordCounter(
        "Existen repositorios de código tanto para Kotlin/Android como para Swift/iOS " +
                "en los que se publicarán semanalmente los mismos retos. " +
                "Así podrás elegir el que mejor se adapta a tus necesidades (o practicar en ambos)."
    )
}

fun wordCounter(text: String) {
    val wordList = splitTextIntoWords(text)

    val wordMap = mutableMapOf<String, Int>()
    for (newWord in wordList) {
        val word = newWord.lowercase()
        if (word in wordMap)
            wordMap[word] = wordMap[word]!!.inc()
        else
            wordMap[word] = 1
    }

    for ((word, count) in wordMap)
        println("$word: $count")
}

fun splitTextIntoWords(text: String): List<String> {
    val letterRegex = Regex("[\\p{L}]+")

    val wordList = mutableListOf<String>()
    var index = 0
    var wasLastCharLetter = false

    for (char in text) {
        if (letterRegex.matches("$char")) {
            wasLastCharLetter = true
            if (wordList.size > index && wordList[index].isNotEmpty())
                wordList[index] = "${wordList[index]}$char"
            else
                wordList.add("$char")
        } else if (wasLastCharLetter){
            index++
            wasLastCharLetter = false
        }
    }
