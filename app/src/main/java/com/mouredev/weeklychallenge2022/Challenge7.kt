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
    val text = "¿Quién habría dejado un baúl en medio de la calle...? " +
            "Miles de pensamientos le vinieron a la cabeza: \"Me pregunto si se lo " +
            "habrán olvidado o lo habrán abandonado; no sé si lo estarán buscando o ya lo darán " +
            "por perdido. ¡MUERO POR SABER QUE HAY DENTRO DEL BAÚL!\". " +
            "Después de mucho meditar decidió seguir camino " +
            "(haría de cuenta que nunca lo había visto)."

    println("Frase a Analizar:\n$text\n")
    println("Listado de Palabras encontradas:")
    countWords(text)
}

private fun countWords(text: String) {

    var cleanText = ""
    for (index in 0 until text.length) {
        if (!checkPuntuationMarks(text[index].toString())) {
            cleanText += text[index]
        }
    }

    var wordsArray = cleanText.lowercase().split(" ").sorted()
    var previousWord = wordsArray[0]
    var countWord = 0

    for (index in wordsArray.indices) {
        if (previousWord == wordsArray[index]) {
            countWord++
        }
        else {
            println("$previousWord -> $countWord")
            previousWord = wordsArray[index]
            countWord = 1
        }
    }
    println("$previousWord -> $countWord")
}

private fun checkPuntuationMarks(char: String) : Boolean {
    return when (char) {
        ".", ",", ";", ":", "¿", "?", "¡", "!", "(", ")", "\"" -> true
        else -> false
    }
}