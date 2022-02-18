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

    val  exampleString = "- ¡Vaya, vaya, vaya! - comentó el desarrollador - ¿Que tenemos aquí? Veo" +
            " que Brais ha puesto un nuevo reto. Cuando termine de pintar esta valla me pondré con la" +
            " resolución del mismo; al mismo tiempo veré si puedo comprar el dominio brais.com/retos. Ho.la"



    for ((key, value) in clearString(exampleString).toList().sortedBy { (key, value) -> value}.toMap()) {
        println("$key -> $value")
    }
}

private fun clearString(myString: String): Map<String,Int>{

    var wordDict = HashMap<String,Int>()
    var specialsCharacters = arrayListOf(',', '.', ';', '¿', '?', '¡', '!', '-', ' ', '/')
    var word = ""

    for (i in 0..myString.length - 1){
        if ((myString[i] !in specialsCharacters)){
            word += myString[i].lowercase()
        }
        else {
            wordInDict(word, wordDict)
            word = ""
        }
    }

    wordInDict(word, wordDict) // Hemos salido del bucle pero puede quedar una palabra aun sin almacenar en el diccionario

    return wordDict
}

private fun wordInDict(word: String, dict: HashMap<String, Int>) {
    if (word.isNotBlank()){
        if (dict.containsKey(word)) dict[word] = dict.getValue(word) + 1  else dict[word] = 1
    }
}
