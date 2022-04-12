package com.mouredev.weeklychallenge2022

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

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

@RequiresApi(Build.VERSION_CODES.O)
fun main() {


     println(cuantosDias("25/12/2020", "20/12/2020")) //5
     println(cuantosDias("15/10/2022", "18/10/2022")) //3
     println(cuantosDias("31/11/2020", "17/11/2021")) //error (-1)

}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
fun cuantosDias(date1: String, date2: String): Int {

     val DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu")

     try {
          LocalDate.parse(date1, DATE_FORMATTER.withResolverStyle(ResolverStyle.STRICT))
          LocalDate.parse(date2, DATE_FORMATTER.withResolverStyle(ResolverStyle.STRICT))
     } catch (e: DateTimeParseException) {
          println("Fechas incorrectas: " + e.message)
          return -1
     }
     val firstDate: Date = SimpleDateFormat("dd/MM/yyyy").parse(date1) as Date
     val secondDate: Date = SimpleDateFormat("dd/MM/yyyy").parse(date2) as Date

     return TimeUnit.MILLISECONDS.toDays(abs(firstDate.time - secondDate.time)).toInt()
}

//By Osovankt
