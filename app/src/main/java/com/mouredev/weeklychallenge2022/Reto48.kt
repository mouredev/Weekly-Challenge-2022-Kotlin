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
import java.time.temporal.ChronoUnit
import java.util.*

private val gifts = arrayOf("Curso gratuito de Udemy", "Libro de programacion en C#", "Juego gratuito de Steam", "Juego gratuito para móvil", "Cupón de descuento en Amazon", "Escoger uno de los premios disponibles")

fun main() {
    println("Regalos disponibles: ${gifts.contentToString()}")
    println(calculateGiftDate(loadDateFrom(2022, 11, 29, 14, 23, 15)))
    println(calculateGiftDate(loadDateFrom(2022, 12, 24, 12, 59, 59)))
    println(calculateGiftDate(loadDateFrom(2022, 12, 25, 0, 0, 0)))
    println(calculateGiftDate(loadDateFrom(2024, 12, 26, 14, 55, 40)))
}
/*
Resultados:
Regalos disponibles: [Curso gratuito de Udemy, Libro de programacion en C#, Juego gratuito de Steam, Juego gratuito para móvil, Cupón de descuento en Amazon, Escoger uno de los premios disponibles]
Faltan 1d 9h 36m 45s para que empiezen los sorteos de aDEViento :D
El regalo de hoy es Curso gratuito de Udemy. Faltan 11h 1s para que acabe el evento
La fecha de sorteos de aDEViento terminó hace 1s
La fecha de sorteos de aDEViento terminó hace 2y 1d 14h 55m 41s
*/

fun calculateGiftDate(date: Date): String {
    val startDate = loadDateFrom(2022, 12, 1, 0, 0, 0)
    val endDate = loadDateFrom(2022, 12, 24, 23, 59, 59)
    val zonedDate = loadZonedDate(date)
    return when {
        date.time > endDate.time -> {
            "La fecha de sorteos de aDEViento terminó hace ${format(calculateDifference(loadZonedDate(endDate), zonedDate))}"
        }
        date.time < startDate.time -> {
            "Faltan ${format(calculateDifference(zonedDate, loadZonedDate(startDate)))} para que empiezen los sorteos de aDEViento :D"
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

fun loadZonedDate(date: Date): ZonedDateTime {
    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.time), ZoneId.systemDefault())
}

fun calculateDifference(date1: ZonedDateTime, date2: ZonedDateTime): List<Pair<Long, Char>> {
    val duration = Duration.between(date1, date2)
    val years = date1.until(date2, ChronoUnit.YEARS)
    var months = date1.until(date2, ChronoUnit.MONTHS)
    var days = duration.toDaysPart()
    // Lo que está a continuación se hace debido a que da el tiempo exacto en esa unidad. Ej: 2 años = 24 meses, 2 meses = 60 dias aprox.
    // No lo dará dentro del rango. Ej: 2 años = 0 meses, 2 meses = 0 dias aprox.
    // Debido a que el rango de fechas es exclusivo, se le resta un día al calculo final para poder ser inclusivo
    // Ej: 01-01-2023 - 31-01-2023, en realidad compara hasta el 30 de enero, por eso hay que restar un día al resultado para incluir el 31
    // Suena raro, porque se pensaría que se debería sumar en vez de restar, pero al sumar, llegas al mismo resultado que si no sumas ni restas nada
    // Es dificil trabajar con fechas :')
    if (months > 12) {
        months = Period.between(date1.toLocalDate(), date2.toLocalDate()).months.toLong()
    }
    if (days > 31) {
        days = Period.between(date1.toLocalDate(), date2.toLocalDate()).days.toLong() - 1
    }
    val hours = duration.toHoursPart().toLong()
    val minutes = duration.toMinutesPart().toLong()
    val seconds = duration.toSecondsPart().toLong()
    return listOf(years to 'y', months to 'm', days to 'd', hours to 'h', minutes to 'm', seconds to 's')
}

fun nextDay(date: ZonedDateTime): Date {
    return loadDateFrom(date.year, date.monthValue, date.dayOfMonth + 1, 0, 0, 0)
}

fun format(date: List<Pair<Long, Char>>): String {
    return date.filter { it.first > 0 }.joinToString(separator = " ") { "${it.first}${it.second}" }
}
