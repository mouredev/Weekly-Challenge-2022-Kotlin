package com.mouredev.weeklychallenge2022

import java.util.regex.Pattern
import kotlin.math.abs

import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue


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

fun main (){
    myDaysBetween("10/4/2022","20/05/2022")
    myDaysBetween("-10/4/2022","50/5/2022")
    myDaysBetween("10/04/2022","20/4/2022")
    myDaysBetween("10/19/2022","20/4/2022")
}

val monthDays = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

private fun myDaysBetween(date1: String , date2: String) : Int{

    if (validateDate(date1) && validateDate(date2)){
        val splitDate1 = date1.split("/").map { it.toInt() }
        val splitDate2 = date2.split("/").map { it.toInt() }

        val difDaysInYears = abs(splitDate1[2]-splitDate2[2])*365
        val difDaysInMonths = abs(daysPassedThisYear(splitDate1[1]) - daysPassedThisYear(splitDate2[1]))
        val difDaysInDays = abs(splitDate1[0]-splitDate2[0])

        val sum = difDaysInDays+difDaysInMonths+difDaysInYears
        println("Between $date1 and $date2 have passed $sum days in total.")

        return sum
    } else {
        println("Wrong date")
    }
    return 0
}

private fun validateDate(date : String) : Boolean{

    val datePattern = Pattern.compile("([0-9]{2}|[0-9])/([0-9]{2}|[0-9])/([0-9]{4})")

    if (date.matches(datePattern.toRegex())){
        val splitDate = date.split("/").map { it.toInt() }
        if (splitDate[1] in 1..12) {
            if (splitDate[0]<= monthDays[splitDate[1]] && splitDate[0]>0){
                return true
            }
        }
    }

    return false
}

private fun daysPassedThisYear(actualMonth : Int) : Int {
    var accumulatedDays = 0
    for (i in 0 until actualMonth) {
        accumulatedDays += monthDays[i]
    }
    return accumulatedDays
}