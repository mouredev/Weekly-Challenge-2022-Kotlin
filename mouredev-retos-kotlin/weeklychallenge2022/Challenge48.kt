package com.mouredev.weeklychallenge2022

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

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

fun main() {

//    aDEViento2022(LocalDateTime.of(2022, 12, 5, 20, 27, 56).toDate())

    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
    println(aDEViento2022(LocalDateTime.parse("2022/12/05 20:27:56", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/12/01 00:00:00", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/12/24 23:59:59", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/11/30 23:59:59", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/12/25 00:00:00", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/10/30 00:00:00", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2022/12/30 04:32:12", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2020/10/30 00:00:00", formatter).toDate()))
    println(aDEViento2022(LocalDateTime.parse("2024/12/30 04:32:12", formatter).toDate()))
}

private fun LocalDateTime.toDate(): Date {
    return Date.from(this.atZone(ZoneId.systemDefault()).toInstant())
}

private fun aDEViento2022(date: Date): String {

    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
    val startDate = LocalDateTime.parse("2022/12/01 00:00:00", formatter).toDate()
    val endDate = LocalDateTime.parse("2022/12/24 23:59:59", formatter).toDate()

    if (date in startDate..endDate) {

        val gifts = arrayOf(
            "El programador pragmático",
            "while True: learn()",
            "Aprende Javascript ES9, HTML, CSS3 y NodeJS desde cero",
            "Patrones de Diseño en JavaScript y TypeScript",
            "Aprende Python en un fin de semana",
            "Regalo 6",
            "Regalo 7",
            "Regalo 8",
            "Regalo 9",
            "Regalo 10",
            "Regalo 11",
            "Regalo 12",
            "Regalo 13",
            "Regalo 14",
            "Regalo 15",
            "Regalo 16",
            "Regalo 17",
            "Regalo 18",
            "Regalo 19",
            "Regalo 20",
            "Regalo 21",
            "Regalo 22",
            "Regalo 23",
            "Regalo 24")

        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)

        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return "El regalo del día es: ${gifts[day - 1]} y el sorteo del día acaba en: ${diffTimeComponentsText(date, calendar.time)}"
    }

    val intro = if (date < startDate) "El calendario de aDEViento 2022 comenzará en:" else "El calendario de aDEViento 2022 ha finalizado hace:"
    val timeComponents = diffTimeComponentsText(if (date < startDate) date else endDate,
                                                if (date < startDate) startDate else date)
    return "$intro $timeComponents"
}

private fun diffTimeComponentsText(startDate: Date, endDate: Date): String {

    val diffInMillis = endDate.time - startDate.time

    val second = diffInMillis / 1000L % 60
    val minutes = diffInMillis / (1000L * 60) % 60
    val hours = diffInMillis / (1000L * 60 * 60) % 24
    val days = diffInMillis / (1000L * 60 * 60 * 24) % 365
    val years = diffInMillis / (1000L * 60 * 60 * 24 * 365)

    return "$years años, $days días, $hours horas, $minutes minutos, $second segundos"
}

