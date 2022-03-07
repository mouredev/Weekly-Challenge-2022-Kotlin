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
    countRepeat("texto, Texto. indice, texto$, azul, pumarosa, puma-rosa - amarillo")
}

private fun countRepeat(text: String){

    val arrayText = text.lowercase().replace("[^a-z0-9]\\s".toRegex(),"/")
        .split("/")
    val mutableSet: MutableSet<String> = mutableSetOf()
    arrayText.forEach {
        mutableSet.add(it.replace("[^a-z]".toRegex(), ""))
    }
    mutableSet.forEach {
        var count = 0
        val compare = it
        arrayText.forEach {
            if (it.replace("[^a-z]".toRegex(), "") == compare)
                count++
            }
        println("$it    $count")
    }
}



