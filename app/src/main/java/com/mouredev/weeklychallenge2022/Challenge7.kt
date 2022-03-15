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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    var text = "Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.\n" +
            " * - Los signos de puntuación no forman parte de la palabra.\n" +
            " * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.\n" +
            " * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.\n" +
            " *\n" +
            " * Información adicional:\n" +
            " * - Usa el canal de nuestro discord (https://mouredev.com/discord) \"\uD83D\uDD01reto-semanal\" para preguntas, dudas o prestar ayuda la acomunidad.\n" +
            " * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.\n" +
            " * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.\n" +
            " * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación."
    val hashMap : HashMap<String, Int> = HashMap()
    text = text.lowercase()
        .replace("[,.:;()\\-\\*\\/\\n\\t]".toRegex()," ")
        .replace("\\s+".toRegex(), " ")

    text.split(" ").forEach{ aux ->
        if(hashMap.contains(aux)) {
            hashMap[aux] = hashMap.getValue(aux) + 1
        } else {
            hashMap[aux] = 1
        }
    }

    val sortedMap = hashMap.toList().sortedByDescending { (k, v) -> v }.toMap()

    sortedMap.forEach{item -> println("Palabra " + item.key + ", repetido " + item.value)}
}
