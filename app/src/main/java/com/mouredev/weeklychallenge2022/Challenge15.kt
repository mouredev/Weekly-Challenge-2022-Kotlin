package com.mouredev.weeklychallenge2022

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const val DATE_PATTERN = "dd/MM/yyyy"

fun main() {
    val date1 = "23/04/2022"
    val date2 = "12/04/2022"
    try {
        val daysBetween = calculateDayBetweenDates(date1, date2)
        println("La diferencia entre la fecha $date1 y la fecha $date2 es de $daysBetween dias")
    } catch (e: ParseException) {
        println("Error en el formato de las fechas => ${e.message}")
    }
}

fun calculateDayBetweenDates(dateString1: String, dateString2: String): Int {
    val simpleFormatter = SimpleDateFormat(DATE_PATTERN, Locale("ES_es"))
    val date1 = simpleFormatter.parse(dateString1)
    val date2 = simpleFormatter.parse(dateString2)
    val difference: Long = abs((date1?.time ?: 0) - (date2?.time ?: 0))
    val dayDifference = (difference / (24 * 60 * 60 * 1000))

    return dayDifference.toInt()
}