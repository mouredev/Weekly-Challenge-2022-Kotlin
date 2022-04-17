package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.math.abs
import kotlin.time.Duration.Companion.days

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



/**
 * Funcion principal
 */
@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    val fecha1 = "08/08/1980"
    val fecha2 = "17/04/2022"

    try {
        println("Dias de diferencia entre $fecha1 - $fecha2 : ${dateDiff(fecha1, fecha2)}")
    }
    catch (e: DateTimeParseException) {
        println("Error: ${e.message}")
    }
}

/**
 * Función que calcula la diferencia entre dos fechas en dias utilizando funciones de orden superior
 * @param dateStr1 Fecha 1 en formato dd/MM/yyyy
 * @param dateStr2 Fecha 2 en formato dd/MM/yyyy
 * @see LocalDate
 * @see ChronoUnit
 * @return Int con la diferencia en dias
 */
@RequiresApi(Build.VERSION_CODES.O)
fun dateDiff(dateStr1:String, dateStr2:String):Int =
    abs(dateStr1.toDate().until(dateStr2.toDate(),ChronoUnit.DAYS).toInt())


/**
 * Funcion de extension de String que convierte una cadena de texto en una fecha
 * @return LocalDate con la fecha
 * @throws Exception si la cadena no tiene el formato correcto
 */
@RequiresApi(Build.VERSION_CODES.O)
fun String.toDate(): LocalDate {
    try {
        return LocalDate.parse(this, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }
    catch (e: DateTimeParseException){
        throw e
    }

}

