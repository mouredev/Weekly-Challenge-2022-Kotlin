package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import java.util.*

/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


@RequiresApi(Build.VERSION_CODES.S)
fun main() {
    println(adeviento(LocalDateTime.now()))
    println(adeviento(LocalDateTime.now().plusDays(1)))
    println(adeviento(LocalDateTime.of(2022, Month.NOVEMBER, 30, 0, 0, 0)))
    println(adeviento(LocalDateTime.of(2022, Month.DECEMBER, 26, 0, 0, 0)))
    println(adeviento(LocalDateTime.of(2022, Month.DECEMBER, 15, 23, 0, 0)))
}

@RequiresApi(Build.VERSION_CODES.S)
private fun adeviento(date: LocalDateTime): String {
    var result = ""
    val adevientoStartDate = LocalDateTime.of(2022, Month.DECEMBER, 1, 0, 0, 0)
    val adevientoEndDate = LocalDateTime.of(2022, Month.DECEMBER, 24, 23, 59, 59)

    if (date.isBefore(adevientoStartDate)) {
        result = "El calendario de Adeviento comenzará en ${getTimeLeft(date, adevientoStartDate)}."
    } else if (date.isAfter(adevientoEndDate)) {
        result = "El calendario de Adeviento terminó hace ${getTimeLeft(adevientoEndDate, date)}."
    } else if (date.isAfter(adevientoStartDate) && date.isBefore(adevientoEndDate)) {
        val nextDay =
            date.withDayOfMonth(date.dayOfMonth + 1).withHour(0).withMinute(0).withSecond(0)
        result =
            "El regalo de hoy es el REGALO DE ADEVIENTO #${date.dayOfMonth}. El sorteo de hoy finaliza en ${
                getTimeLeft(
                    date,
                    nextDay
                )
            }"
    }

    return result
}

@RequiresApi(Build.VERSION_CODES.S)
private fun getTimeLeft(dateBefore: LocalDateTime, dateAfter: LocalDateTime): String {
    val timeLeft = Duration.between(dateBefore, dateAfter)
    return "${timeLeft.toDaysPart()} días, ${timeLeft.toHoursPart()} horas, ${timeLeft.toMinutesPart()} minutos y ${timeLeft.toSecondsPart()} segundos"
}