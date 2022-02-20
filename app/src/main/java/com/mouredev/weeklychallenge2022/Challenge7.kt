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
    println("Enter the text for count")
    val text = readLine()
    println(countWordRepetitions(text.toString()))
}

private fun countWordRepetitions(text: String) {
    val regex = Regex("[^a-z0-9]")
    val splitText = regex.replace(text.lowercase(), " ").split(" ").sorted()
    var lastWord = ""
    var count = 0
    splitText.forEach { word ->
        if (word == lastWord) {
            count++
        } else {
            if (lastWord != "") {
                println("$lastWord -> $count")
            }
            lastWord = word
            count = 1
        }
    }
    println("$lastWord -> $count")
}