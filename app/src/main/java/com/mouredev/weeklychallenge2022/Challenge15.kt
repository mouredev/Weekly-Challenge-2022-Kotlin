package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle

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
    println("Hay ${daysBetween("15/09/1997", "26/09/1997")} días entre el 15/09/1997 y el 26/09/1997.") // 11
    println("Hay ${daysBetween("14/01/1933", "31/12/2021")} días entre el 14/01/1933 y el 31/12/2021.") // 32493
    println("Hay ${daysBetween("26/09/1997", "15/09/1997")} días entre el 26/09/1997 y el 15/09/1997.") // 11
    println("Hay ${daysBetween("14/02/2022", "30/02/2022")} días entre el 14/02/2022 y el 30/02/2022.") // exception
    //println("Hay ${daysBetween("14/01/1933", "33/12/2021")} días entre el 14/01/1933 y el 33/12/2021.") // exception
    //println("Hay ${daysBetween("14/01/1933", "3.3/12/2021")} días entre el 14/01/1933 y el 33/12/2021.") // exception
}

@RequiresApi(Build.VERSION_CODES.O)
private fun daysBetween(date_1: String, date_2: String): Int {
    // https://howtodoinjava.com/java/date-time/resolverstyle-strict-date-parsing/
    // Java 8 uses 'uuuu' for year, not 'yyyy'. In Java 8, ‘yyyy’ means “year of era” (BC or AD).
    val formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)
    val date1 = LocalDate.parse(date_1, formatter)
    val date2 = LocalDate.parse(date_2, formatter)

    val daysBetween = ChronoUnit.DAYS.between(date1, date2)
    return kotlin.math.abs(daysBetween.toInt())
}