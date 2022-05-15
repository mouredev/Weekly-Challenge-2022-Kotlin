package com.mouredev.weeklychallenge2022

import java.util.concurrent.TimeUnit

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
    println(parseDateToMilliseconds(1, 0, 0, 0))
    println(parseDateToMilliseconds(0, 1, 0, 0))
    println(parseDateToMilliseconds(0, 0, 1, 0))
    println(parseDateToMilliseconds(0, 0, 0, 1))
    println(parseDateToMilliseconds(8, 10, 15, 1))
    println(parseDateToMilliseconds(188, 12, 25, 15))
}

private fun parseDateToMilliseconds(days: Int, hour: Int, mins: Int, secs: Int): Long {
    println("$days days, $hour hours, $mins minutes and $secs seconds in milliseconds is -> ")
    val dayInMilliseconds = TimeUnit.DAYS.toMillis(days.toLong())
    val hourInMilliseconds = TimeUnit.HOURS.toMillis(hour.toLong())
    val minutesInMilliseconds = TimeUnit.MINUTES.toMillis(mins.toLong())
    val secondsInMilliseconds = TimeUnit.SECONDS.toMillis(secs.toLong())
    return dayInMilliseconds + hourInMilliseconds + minutesInMilliseconds + secondsInMilliseconds
}
