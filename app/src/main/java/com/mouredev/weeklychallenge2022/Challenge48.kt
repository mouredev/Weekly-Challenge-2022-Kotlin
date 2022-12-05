package com.mouredev.weeklychallenge2022

import com.mouredev.weeklychallenge2022.AdventCalendar.adevientoEndDay
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.math.abs


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

/**
 * Tipo de datos que contiene los regalos de cada dia , cuando empieza y termina el Calendario de Adeviento
 */
object AdventCalendar {
    val adevientoStarDay: LocalDateTime = LocalDateTime.parse("2022-12-01T00:00:00")
    val adevientoEndDay: LocalDateTime = LocalDateTime.parse("2022-12-24T23:59:59")
    val gifts = arrayOf("🍰","🤶","🎁","🧁","🍫","🍭","🍬","🍪","🎄","🍡","🍿","🍩","🍦","🍧","🍨","🍮","🍭","🍬","🍿","🍩","🍦","🍧","🍨","🍮")
}
/**
 * Funcion principal
 */
fun main() {

    println((adevientoCalendar("2022-11-01T02:33:40")))
    println((adevientoCalendar("2022-12-28T01:00:00")))
    println((adevientoCalendar(LocalDateTime.now().toString())))
    println((adevientoCalendar("2022-12-24T00:00:00")))
    println((adevientoCalendar("2022-12-01T00:00:00")))
}
/**
 * Función que devuelve el regalo del día a partir de una fecha dada si la fecha esta dentro del calendario de aDEViento
 * Si no esta dentro del calendario de aDEViento devuelve un mensaje con los dias que se han pasado desde que finalizo el calendario o los que faltan
 * @param date Fecha que se quiere comprobar
 * @returns Regalo del día o mensaje con los dias que faltan o que se han pasado
 */
fun adevientoCalendar(date: String): String {
    val dateParsed = LocalDateTime.parse(date)
    return if(dateParsed< AdventCalendar.adevientoStarDay){
        "- Faltan ${dateDiff(dateParsed,AdventCalendar.adevientoStarDay)} para que comience el calendario de aDEViento ${AdventCalendar.adevientoStarDay.year}"
    }else if(dateParsed> AdventCalendar.adevientoEndDay) {
        "- Han pasado ${dateDiff(dateParsed,AdventCalendar.adevientoEndDay)} desde que finalizó el calendario aDEViento ${AdventCalendar.adevientoStarDay.year}"
    } else {
        "- El regalo del dia ${dateParsed.toLocalDate()} es : ${getGift(dateParsed)}.${nextGift(dateParsed)}"
    }
}
/**
 * Funcion que devuelve el regalo del dia a partir de una fecha dada
 * @param date Fecha que se quiere comprobar
 * @return Regalo del dia si esta dentro de la fecha del calendario de aDEViento
 */
fun getGift(date: LocalDateTime): String {
    val gift = daysLeft(date, AdventCalendar.adevientoStarDay)
    return if(gift>=0 && gift<AdventCalendar.gifts.size)
        AdventCalendar.gifts[date.dayOfMonth-1]
    else
        "⌚"
}
/**
 * Funcion que devuelve los dias de diferencia entre dos fechas
 * @param date1 Fecha 1 que se quiere comprobar
 * @param date2 Fecha 2 que se quiere comprobar
 * @returns Diferencia de dias entre las dos fechas dadas.Si la primera es mayor devuelve un numero positivo, si es menor devuelve un numero negativo
 */
fun daysLeft(date1: LocalDateTime, date2: LocalDateTime): Int = date1.dayOfMonth - date2.dayOfMonth
/**
 * Funcion que devuelve la diferencia en dias ,horas ,minutos y segundos de dos fechas dadas.
 * @param date1 Fecha 1 que se quiere comprobar
 * @param date2 Fecha 2 que se quiere comprobar
 * @returns Diferencia en dias ,horas ,minutos y segundos de dos fechas dadas.
 */
private fun dateDiff(date1: LocalDateTime, date2: LocalDateTime): String {

    val diff = abs(date2.toEpochSecond(ZoneOffset.UTC) - date1.toEpochSecond(ZoneOffset.UTC))
    val days = diff / (24 * 60 * 60)
    val hours = (diff - (days * 24 * 60 * 60)) / (60 * 60)
    val minutes = (diff - (days * 24 * 60 * 60) - (hours * 60 * 60)) / 60
    val seconds = diff - (days * 24 * 60 * 60) - (hours * 60 * 60) - (minutes * 60)

    return if(days>0){
        "$days días, $hours horas, $minutes minutos y $seconds segundos"
    }else if(hours>0){
        "$hours horas, $minutes minutos y $seconds segundos"
    }else if(minutes>0){
        "$minutes minutos y $seconds segundos"
    }else{
        "$seconds segundos"
    }
}
/**
 * Funcion que calcula el siguiente sorteo del calendario de aDEViento.
 * @param date Fecha que se quiere comprobar
 *
 */
private fun nextGift(date: LocalDateTime): String {
    val nextDate = LocalDateTime.of(date.year, date.month, date.dayOfMonth+1, 0, 0, 0)
    return if(nextDate<= AdventCalendar.adevientoEndDay){
        "El próximo regalo es ${AdventCalendar.gifts[nextDate.dayOfMonth-1]} y faltan ${dateDiff(date,nextDate)}"
    }else
        "Hoy es el ultimo dia del calendario de aDEViento ${AdventCalendar.adevientoStarDay.year}"
}





