package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit

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
fun main(){
    val date = LocalDateTime.of(2022, Month.DECEMBER,4,16,58,0)
    val date1 = LocalDateTime.of(2022, Month.OCTOBER,20,1,46,0)
    val date2 = LocalDateTime.of(2022, Month.DECEMBER,30,1,46,0)
    giftOfAdventCalendar(date)
    giftOfAdventCalendar(date1)
    giftOfAdventCalendar(date2)

}


@RequiresApi(Build.VERSION_CODES.S)
private fun giftOfAdventCalendar(date: LocalDateTime){

    val giftList= listOf(
        "Gift-1","Gift-2","Gift-3","Gift-4","Gift-5","Gift-6","Gift-7","Gift-8","Gift-9","Gift-10",
        "Gift-11","Gift-12","Gift-13","Gift-14","Gift-15","Gift-16","Gift-17","Gift-18","Gift-19","Gift-20",
        "Gift-21","Gift-22","Gift-23","Gift-24"
    )

    val calendar= Calendar.getInstance()
    val currentYear=calendar.get(Calendar.YEAR)

    //fecha inicial y final del calendario de adviento
    val initAdventCalendar= LocalDateTime.of(currentYear, Month.DECEMBER,1,0,0,0)
    val endAdventCalendar= LocalDateTime.of(currentYear, Month.DECEMBER,24,23,59,59)

    if(date.isBefore(endAdventCalendar) && date.isAfter(initAdventCalendar)){
        val endDay = date.withDayOfMonth(date.dayOfMonth + 1).withHour(0).withMinute(0).withSecond(0)
        println("El regalo de hoy es: ${giftList[date.dayOfMonth-1] }")
        val cal=getTime(endDay,date)
        println("El sorteo termina en  ${cal.get(Calendar.HOUR_OF_DAY)} horas ${cal.get(Calendar.MINUTE)} minutos  ${cal.get(
            Calendar.SECOND)} segundos")
        println()
    }
    else if(date.isBefore(initAdventCalendar)){
        val cal=getTime(initAdventCalendar,date)
        println("El sorteo comenzará en ${cal.get(Calendar.DAY_OF_YEAR)} días ${cal.get(Calendar.HOUR_OF_DAY)} horas ${cal.get(
            Calendar.MINUTE)} minutos  ${cal.get(Calendar.SECOND)} segundos")
    }
    else if(date.isAfter(endAdventCalendar)){
        val cal=getTime(date,endAdventCalendar)
        println("El sorteo terminó hace   ${cal.get(Calendar.DAY_OF_YEAR)} días  ${cal.get(Calendar.HOUR_OF_DAY)} horas ${cal.get(
            Calendar.MINUTE)} minutos  ${cal.get(Calendar.SECOND)} segundos")
    }



}
@RequiresApi(Build.VERSION_CODES.S)
private fun getTime(minDate: LocalDateTime, maxDate: LocalDateTime): Calendar {


    val diffInMillis= ChronoUnit.MILLIS.between(minDate,maxDate)

    val days= Math.abs(TimeUnit.MILLISECONDS.toDays(diffInMillis).toInt()) + 1
    val hours: Long = ((diffInMillis / (1000 * 60 * 60)) % 24) + 1
    val minutes: Long = ((diffInMillis / (1000 * 60))% 60)
    val seconds: Long = ((diffInMillis / 1000)% 60)

    val calendar= Calendar.getInstance()

    calendar.set(Calendar.DAY_OF_YEAR,days)
    calendar.set(Calendar.HOUR_OF_DAY,hours.toInt())
    calendar.set(Calendar.MINUTE,minutes.toInt())
    calendar.set(Calendar.SECOND,seconds.toInt())
    return calendar
}
