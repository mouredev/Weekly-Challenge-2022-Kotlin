package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("${convertToMillis(1, 2, 3, 4)} millis")
    println("${convertToMillis(5, 6, 43, 27)} millis")
    println("${convertToMillis(17, 10, 6, 47)} millis")
    println("${convertToMillis(458, 22, 52, 14)} millis")

}

private fun convertToMillis(days: Int, hours: Int, minutes: Int, seconds: Int): Long {
    return Calendar.getInstance().apply {
        timeInMillis = 0
        add(Calendar.DAY_OF_YEAR, days)
        add(Calendar.HOUR_OF_DAY, hours)
        add(Calendar.MINUTE, minutes)
        add(Calendar.SECOND, seconds)
    }.timeInMillis
}