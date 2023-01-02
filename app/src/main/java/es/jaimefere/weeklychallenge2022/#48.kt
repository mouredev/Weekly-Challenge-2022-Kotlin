package es.jaimefere.weeklychallenge2022

import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
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

private fun scrapADEVientoPrizeFor(day: Int): String {
    val url = URL("https://adviento.dev")
    val urlConnection = url.openConnection() as HttpURLConnection
    try {
        val htmlText = urlConnection.inputStream.bufferedReader().readText()
        val days = htmlText.split(")</span></span></h4>")
        days.indices.forEach { index ->
            if(days[index].contains("($day/24")) {
                var prize = days[index+1].split("</div>")[0].split("\">")[1]
                if(days[index+1].startsWith("<h4")) {
                    prize = days[index+1].split("title=\"")[1].split("\">")[0]
                }
                return prize.replace("<b>", "").replace("</b>", "").replace("&quot;", "\"")
            }
        }
        return "unknown"
    } finally {
        urlConnection.disconnect()
    }
}

fun formatDateFrom(seconds: Int): String {
    val d = seconds / 86400
    val h = seconds / 3600
    val m = seconds % 3600 / 60
    val s = seconds % 60
    val sd = if (d > 0) "$d d" else ""
    val sh = (if (h in 1..23 && d > 0) "0" else "") + if (h > 0) if (d > 0 && m == 0) h.toString() else "$h h" else ""
    val sm = (if (m in 1..9 && h > 0) "0" else "") + if (m > 0) if (h > 0 && s == 0) m.toString() else "$m min" else ""
    val ss = if (s == 0 && (h > 0 || m > 0)) "" else (if (s < 10 && (h > 0 || m > 0)) "0" else "") + s.toString() + " " + "sec"
    return sd + (if (d > 0) " " else "") + sh + (if (h > 0) " " else "") + sm + (if (m > 0) " " else "") + ss
}

private fun showADEVientoInfoFor(date: Date) {
    val dateFormatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
    val calendarStartDate = dateFormatter.parse( "2022/12/01 00:00:00")
    val calendarEndDate = dateFormatter.parse("2022/12/24 23:59:59")

    if(date.before(calendarStartDate)) {
        println("El Calendario de aDEViento 2022 inicia en ${formatDateFrom((calendarStartDate.time - date.time).toInt() / 1000)}")
    } else if(date.after(calendarEndDate)) {
        println("El Calendario de aDEViento 2022 finalizó hace ${formatDateFrom((date.time - calendarEndDate.time).toInt() / 1000)}")
    } else {
        var calendar = Calendar.getInstance()
        calendar.time = date
        var dateDay = calendar[Calendar.DAY_OF_MONTH]
        val prize = scrapADEVientoPrizeFor(dateDay)
        if(prize != "unknown") {
            val todayDay = Calendar.getInstance()[Calendar.DAY_OF_MONTH]
            if(dateDay == todayDay) {
                val endDay = dateFormatter.parse("2022/12/$dateDay 23:59:59")
                println("Quedan ${formatDateFrom((endDay.time - Calendar.getInstance().timeInMillis).toInt() / 1000)} para participar en el sorteo de: $prize")
            } else {
                println("El premio fue: $prize")
            }
        } else {
            val startDay = dateFormatter.parse("2022/12/$dateDay 00:00:00")
            println("En ${formatDateFrom((startDay.time - Calendar.getInstance().timeInMillis).toInt() / 1000)} se conocerá el premio y comenzará el sorteo.")
        }
    }
}

fun main() {
    val dateFormatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
    showADEVientoInfoFor(dateFormatter.parse("2022/11/30 23:00:00"))
    showADEVientoInfoFor(dateFormatter.parse("2022/12/26 01:00:00"))
    showADEVientoInfoFor(dateFormatter.parse("2022/12/01 04:00:00"))
    showADEVientoInfoFor(dateFormatter.parse("2022/12/02 08:00:00"))
    showADEVientoInfoFor(dateFormatter.parse("2022/12/03 12:00:00"))
    showADEVientoInfoFor(dateFormatter.parse("2022/12/04 16:00:00"))
    showADEVientoInfoFor(Calendar.getInstance().time)
    showADEVientoInfoFor(dateFormatter.parse("2022/12/07 20:00:00"))
}