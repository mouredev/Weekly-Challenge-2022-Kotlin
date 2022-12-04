package com.mouredev.weeklychallenge2022

import java.lang.Math.abs
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

fun main() {
    println("${adventCalendar(Date(2022, 12, 4, 19, 36, 0))}")
    println("${adventCalendar(Date(2022, 6, 10, 8, 15, 0))}")
    println("${adventCalendar(Date(2022, 12, 1, 0, 1, 10))}")
    println("${adventCalendar(Date(2022, 12, 25, 0, 0, 1))}")
    println("${adventCalendar(Date(2023, 1, 5, 9, 27, 0))}")
    println("${adventCalendar(Date(2022, 12, 24, 23, 59, 58))}")
    println("${adventCalendar(Date(2022, 12, 10, 1, 36, 0))}")
}

private fun adventCalendar(date: Date): String {

    var InitialDate = Date(2022, 12, 1, 0, 0, 0)
    var FinalDate = Date(2022, 12, 24, 23, 59, 59)

    if (date.before(InitialDate)) {
        return "Faltan ${abs(InitialDate.year - date.year)} años, ${abs(InitialDate.month - date.month)} meses,  ${abs(InitialDate.day - date.day)} dias, ${abs(InitialDate.hours - date.hours)} horas, ${abs(InitialDate.minutes - date.minutes)} minutos y ${abs(InitialDate.seconds - date.seconds)} segundos  para que comience el calendario"
    } else if (date.after(FinalDate)) {
        return "Han pasado ${abs(date.year - FinalDate.year)} años, ${abs(date.month - FinalDate.month)} meses, ${abs(date.day - FinalDate.day)} dias, ${abs(date.hours - FinalDate.hours)} horas, ${abs(date.minutes - FinalDate.minutes)} minutos y ${abs(date.seconds - FinalDate.seconds)} segundos desde que finalizó el calendario"
    } else {
        return "Hoy toca el regalo número ${date.day} y faltan ${FinalDate.hours - date.hours} horas, ${FinalDate.minutes - date.minutes} minutos y ${FinalDate.seconds - date.seconds} segundos para que finalice el sorteo"
    }

    return ""

}