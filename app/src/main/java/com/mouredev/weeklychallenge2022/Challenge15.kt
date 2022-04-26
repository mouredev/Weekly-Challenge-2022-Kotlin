package com.mouredev.weeklychallenge2022

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

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
 */

fun main(){
    getDateDays("10/09/2021","21/04/2022")
}

fun getDateDays(initialDate : String, finalDate : String) : Int{

    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val firstParsedDate = formatter.parse(initialDate)
    val secondParsedDate = formatter.parse(finalDate)
    println(firstParsedDate)
    println(secondParsedDate)
    println(firstParsedDate.time)
    println(secondParsedDate.time)

  /*  val initialDateSplit = initialDate.split("/")
    val initialDateYear = initialDateSplit[2].toInt()

    val finalDateSplit = finalDate.split("/")
    val finalDateYear = finalDateSplit[2].toInt()

    if(initialDateYear != finalDateYear){
        println(getDaysToFinishYear(initialDate) + getDaysFromBeginningOfYear(finalDate) + ((finalDateYear) - (initialDateYear+1)) * 365)
    }*/
    return 1
}

fun getDaysToFinishYear(date: String): Int {

    var monthWithDays = hashMapOf(
        1 to 31, 2 to 28, 3 to 31, 4 to 30, 5 to 31, 6 to 30,
        7 to 31, 8 to 31, 9 to 30, 10 to 31, 11 to 30, 12 to 31)

    val dateSplit = date.split("/")
    val dateMonth = dateSplit[1].toInt()
    val dateDay = dateSplit[0].toInt()

    var daysOfFullMonthsToFinishYear = 0
    for (i in dateMonth + 1..12) {
        daysOfFullMonthsToFinishYear += monthWithDays.getValue(i)
    }
    return daysOfFullMonthsToFinishYear + (monthWithDays.getValue(dateMonth) - dateDay)
}

fun getDaysFromBeginningOfYear(date: String): Int {

    var monthWithDays = hashMapOf(
        1 to 31, 2 to 28, 3 to 31, 4 to 30, 5 to 31, 6 to 30,
        7 to 31, 8 to 31, 9 to 30, 10 to 31, 11 to 30, 12 to 31)

    val dateSplit = date.split("/")
    val dateMonth = dateSplit[1].toInt()
    val dateDay = dateSplit[0].toInt()

    var daysOfFullMonthsFromBeginningOfYear = 0
    for (i in 1..dateMonth - 1) {
        daysOfFullMonthsFromBeginningOfYear += monthWithDays.getValue(i)
    }
    return daysOfFullMonthsFromBeginningOfYear + dateDay
}
