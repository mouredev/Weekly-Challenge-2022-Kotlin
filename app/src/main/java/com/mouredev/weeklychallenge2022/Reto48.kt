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
 */

package retos

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

private val gifts = arrayOf("Curso gratuito de Udemy", "Libro de programacion en C#", "Juego gratuito de Steam", "Juego gratuito para móvil", "Cupón de descuento en Amazon", "Escoger uno de los premios disponibles")

fun main() {
    println("Regalos disponibles: ${gifts.contentToString()}")
    println(calculateGiftDate(loadDateFrom(2022, 11, 29, 14, 23, 15)))
    println(calculateGiftDate(loadDateFrom(2022, 12, 24, 12, 59, 59)))
    println(calculateGiftDate(loadDateFrom(2022, 12, 11, 12, 59, 59)))
    println(calculateGiftDate(loadDateFrom(2022, 12, 25, 0, 0, 0)))
    println(calculateGiftDate(loadDateFrom(2024, 12, 26, 14, 55, 40)))
}

/*Resultados:
Regalos disponibles: [Curso gratuito de Udemy, Libro de programacion en C#, Juego gratuito de Steam, Juego gratuito para móvil, Cupón de descuento en Amazon, Escoger uno de los premios disponibles]
Faltan 1d 9h 36m 45s CST para que empiezen los sorteos de aDEViento :D
El regalo de hoy es Curso gratuito de Udemy. Faltan 11h 1s CST para que acabe el evento
El regalo de hoy es Escoger uno de los premios disponibles. Faltan 11h 1s CST para el siguiente regalo
La fecha de sorteos de aDEViento terminó hace d 1s CST
La fecha de sorteos de aDEViento terminó hace 2y 14h 55m 41s CST
*/

fun calculateGiftDate(date: Date): String {
    val calendarZone = ZoneId.of("Europe/Madrid")
    val startDate = loadZonedDate(loadDateFrom(2022, 12, 1, 0, 0, 0), calendarZone)
    val endDate = loadZonedDate(loadDateFrom(2022, 12, 24, 23, 59, 59), calendarZone)
    val zonedDate = loadZonedDate(date)
    return when {
        zonedDate > endDate -> {
            "La fecha de sorteos de aDEViento terminó hace ${format(calculateDifference(endDate, zonedDate))}"
        }
        zonedDate < startDate -> {
            "Faltan ${format(calculateDifference(zonedDate, startDate))} para que empiezen los sorteos de aDEViento :D"
        }
        else -> {
            val nextDay = nextDay(zonedDate)
            val day = zonedDate.dayOfMonth
            val gift = gifts[day % 6]
            "El regalo de hoy es ${gift}. Faltan ${format(calculateDifference(zonedDate, loadZonedDate(nextDay)))} ${if (day < 24) "para el siguiente regalo" else "para que acabe el evento"}"
        }
    }

}

fun loadDateFrom(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int): Date {
    return Date.from(
        LocalDate.of(year, month, day)
            .atTime(hour, minute, second)
            .atZone(ZoneId.systemDefault())
            .toInstant()
    )
}

fun loadZonedDate(date: Date, zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime {
    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.time), zoneId)
}

fun calculateDifference(date1: ZonedDateTime, date2: ZonedDateTime): List<Pair<Long, CharSequence>> {
    // Es dificil trabajar con fechas :')
    val duration = Duration.between(date1, date2)
    val period = Period.between(date1.toLocalDate(), date2.toLocalDate())
    val years = period.years.toLong()
    val months = period.months.toLong()
    val days = period.days - 1L
    val hours = duration.toHoursPart().toLong()
    val minutes = duration.toMinutesPart().toLong()
    val seconds = duration.toSecondsPart().toLong()
    val format = DateTimeFormatter.ofPattern("z")
    val currentTime = ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.systemDefault())
    return listOf(years to "y", months to "M", days to "d", hours to "h", minutes to "m", seconds to "s", -1L to currentTime.format(format))
}

fun nextDay(date: ZonedDateTime): Date {
    return loadDateFrom(date.year, date.monthValue, date.dayOfMonth + 1, 0, 0, 0)
}

fun format(date: List<Pair<Long, CharSequence>>): String {
    return date.filter { it.first > 0 || it.first == -1L }
        .joinToString(separator = " ") { "${if(it.first == -1L) "" else it.first}${it.second}" }
}
